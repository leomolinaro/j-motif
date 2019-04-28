package com.motif.agot.logic.phases.plot;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

import com.motif.agot.ang.AgotText;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.logic.phases.APhaseStep;
import com.motif.agot.logic.requests.FirstPlayerRequest;
import com.motif.agot.logic.requests.FirstPlayerRequest.IHasFirstPlayerRequest;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;
import com.motif.shared.util.ComparatorUtil;
import com.motif.shared.util.RandomUtil;

import lombok.Getter;

public class RevealPlotStep extends APhaseStep<IPlotPhaseStep> implements IHasFirstPlayerRequest {
	
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
		game.forEachPlayer(player -> {
			player.revealedPlot().reveal(context);
			if (player.emptyPlotDeck()) {
				player.resetPlotDeck(context);
			}
		});

		ArrayList<AgotPlayer> initiativeWinners = ComparatorUtil.getMax(game.players(), new Comparator<AgotPlayer>() {
			@Override
			public int compare(AgotPlayer p1, AgotPlayer p2) {
				int comparison = Integer.compare(p1.getInitiative(), p2.getInitiative());
				if (comparison < 0) {
					game.log().hasMoreInitiativeThan(p2, p1, context);
				} else if (comparison > 0) {
					game.log().hasMoreInitiativeThan(p1, p2, context);
				} else {
					comparison = -1 * Integer.compare(p1.getPower(), p2.getPower());
					if (comparison < 0) {
						game.log().hasTheSameInitiativeButLessPowerThan(p2, p1, context);
					} else if (comparison > 0) {
						game.log().hasTheSameInitiativeButLessPowerThan(p1, p2, context);
					} else {
						game.log().hasTheSameInitiativeAndTheSamePowerOf(p1, p2, context);
					}
				}
				return comparison;
			}
		});

		AgotPlayer initiativeWinner;
		if (initiativeWinners.size() > 1) {
			initiativeWinner = RandomUtil.getFrom(initiativeWinners);
			game.log().initiativeTieBrokenByRandomlySelect(initiativeWinner, context);
		} else {
			initiativeWinner = initiativeWinners.get(0);
		}

		game.log().winsInitiative(initiativeWinner, context);

		return new FirstPlayerRequest(this.game.players().collect(Collectors.toList()), initiativeWinner, this);
	}

	@Override
	public IAgotFlowStep after(FirstPlayerRequest firstPlayerRequest, AgotContext context) {
		var firstPlayer = firstPlayerRequest.getChoosenModel();
		game.setFirstPlayer(firstPlayer, context);
		game.log().becomesFirstPlayer(firstPlayer, context);
		return null;
	}

}
