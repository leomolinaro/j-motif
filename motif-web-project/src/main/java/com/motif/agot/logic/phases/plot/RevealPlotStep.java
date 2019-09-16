package com.motif.agot.logic.phases.plot;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import com.motif.agot.ang.AgotText;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.act.WhenRevealedAct;
import com.motif.agot.logic.act.WhenRevealedAct.IHasWhenRevealedAct;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.logic.other.EnterGameProcedure;
import com.motif.agot.logic.phases.APhaseStep;
import com.motif.agot.logic.requests.FirstPlayerRequest;
import com.motif.agot.logic.requests.FirstPlayerRequest.IHasFirstPlayerRequest;
import com.motif.agot.logic.requests.SelectWhenRevealedToPerformRequest;
import com.motif.agot.logic.requests.SelectWhenRevealedToPerformRequest.IHasSelectWhenRevealedToPerformRequest;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;
import com.motif.shared.util.ComparatorUtil;
import com.motif.shared.util.RandomUtil;

import lombok.Getter;

public class RevealPlotStep extends APhaseStep<IPlotPhaseStep> implements IHasFirstPlayerRequest, IHasWhenRevealedAct, IHasSelectWhenRevealedToPerformRequest {
	
	public interface IAgotHasRevealPlotStep extends IAgotFlowProcess { public APhaseStep<IPlotPhaseStep> after(RevealPlotStep revealPlotStep, AgotContext context); }
	@Getter private final IAgotHasRevealPlotStep parent; 
	@Override public APhaseStep<IPlotPhaseStep> next(AgotContext context) { return this.parent.after(this, context); }
	
	public RevealPlotStep(AgotGame game, IAgotHasRevealPlotStep parent) {
		super(game);
		this.parent = parent;
	}

	@Override
	public String getStepTitle() {
		return AgotText.title().revealPlotStep();
	}

	@Override
	public FirstPlayerRequest stepStart(AgotContext context) {
		game.forEachPlayer (player -> {
			EnterGameProcedure.reveal (player.revealedPlot ().get (), player, game, context);
			if (player.emptyPlotDeck ()) {
				player.resetPlotDeck (context);
			}
		});

		ArrayList<AgotPlayer> initiativeWinners = ComparatorUtil.getMax (this.game.players (), new Comparator<AgotPlayer>() {
			@Override
			public int compare(AgotPlayer p1, AgotPlayer p2) {
				var initiative1 = p1.getInitiative ();
				var initiative2 = p2.getInitiative ();
				initiative1 += p1.inPlayTextCards ()
						.collect (Collectors.summingInt (card -> card.getInitiativeModifier ()));
				initiative2 += p2.inPlayTextCards ()
						.collect (Collectors.summingInt (card -> card.getInitiativeModifier ()));
				int comparison = Integer.compare (initiative1, initiative2);
				if (comparison < 0) {
					game.logManager().hasMoreInitiativeThan (p2, p1, context);
				} else if (comparison > 0) {
					game.logManager().hasMoreInitiativeThan (p1, p2, context);
				} else {
					comparison = -1 * Integer.compare (p1.getPower(), p2.getPower());
					if (comparison < 0) {
						game.logManager().hasTheSameInitiativeButLessPowerThan (p2, p1, context);
					} else if (comparison > 0) {
						game.logManager().hasTheSameInitiativeButLessPowerThan (p1, p2, context);
					} else {
						game.logManager().hasTheSameInitiativeAndTheSamePowerOf (p1, p2, context);
					}
				}
				return comparison;
			}
		});

		AgotPlayer initiativeWinner;
		if (initiativeWinners.size() > 1) {
			initiativeWinner = RandomUtil.getFrom(initiativeWinners);
			game.logManager().initiativeTieBrokenByRandomlySelect(initiativeWinner, context);
		} else {
			initiativeWinner = initiativeWinners.get(0);
		}

		game.logManager().winsInitiative(initiativeWinner, context);

		return new FirstPlayerRequest(this.game.players().collect(Collectors.toList()), initiativeWinner, this);
	}

	@Override
	public IAgotFlowStep after (FirstPlayerRequest firstPlayerRequest, AgotContext context) {
		var firstPlayer = firstPlayerRequest.getChoosenModel ();
		game.setFirstPlayer (firstPlayer, context);
		this.game.logManager ().becomesFirstPlayer (firstPlayer, context);
		return resolveWhenRevealedActs ();
	} // after

	private List<WhenRevealedAct> getWhenRevealedActs (boolean implicit) {
		return this.game.players ()
				.map (p -> p.revealedPlot ().get ())
				.filter (card -> card.hasWhenRevealed (implicit) && !this.whenRevealedCardIdsDone.contains (card.id ()))
				.map (card -> new WhenRevealedAct (card.getWhenRevealed (), card, card.getController (), this.game, this))
				.filter (whenRevealedAct -> whenRevealedAct.canBeInitiated () && whenRevealedAct.canBePaid ())
				.collect (Collectors.toList ());
	} // getWhenRevealedActs
	
	private boolean implicitWhenRevealedDone = false;
	private HashSet<Long> whenRevealedCardIdsDone = new HashSet<Long> ();
	
	private IAgotFlowStep resolveWhenRevealedActs () {
		if (this.implicitWhenRevealedDone) {
			var whenRevealedActs = getWhenRevealedActs (false);
			if (whenRevealedActs.size () > 0) {
				return new SelectWhenRevealedToPerformRequest (whenRevealedActs, this.game.firstPlayer (), this);
			} else {
				return null;			
			} // if - else
		} else {
			var whenRevealedImplicitActs = getWhenRevealedActs (true);
			if (whenRevealedImplicitActs.size () > 0) {
				return whenRevealedImplicitActs.get (0);
			} else {
				this.implicitWhenRevealedDone = true;
				return resolveWhenRevealedActs ();
			} // if - else
		} // if - else
	} // resolveWhenRevealedActs
	
	@Override
	public IAgotFlowStep after (SelectWhenRevealedToPerformRequest decision, AgotContext context) {
		var whenRevealed = decision.getChoosenModel ();
		return whenRevealed;
	} // after
	
	@Override
	public IAgotFlowStep after (WhenRevealedAct act, AgotContext context) {
		this.whenRevealedCardIdsDone.add (act.getTrigCard ().id ());
		return resolveWhenRevealedActs ();
	} // after

} // RevealPlotStep
