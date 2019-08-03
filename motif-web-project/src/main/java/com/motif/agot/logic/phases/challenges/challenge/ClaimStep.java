package com.motif.agot.logic.phases.challenges.challenge;

import java.util.ArrayList;
import java.util.stream.Collectors;

import com.motif.agot.ang.AgotText;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.events.AgotEventProcess;
import com.motif.agot.logic.events.IAgotHasEventProcess;
import com.motif.agot.logic.events.list.KillEvent;
import com.motif.agot.logic.events.list.MultiEvent;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.logic.phases.APhaseStep;
import com.motif.agot.logic.phases.challenges.IChallengesPhaseStep;
import com.motif.agot.logic.requests.MilitartyClaimRequest;
import com.motif.agot.logic.requests.MilitartyClaimRequest.IHasMilitartyClaimRequest;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.Challenge;
import com.motif.agot.state.cards.CharacterCard;
import com.motif.agot.state.cards.DrawCard;

import lombok.Getter;

public class ClaimStep extends APhaseStep<IChallengesPhaseStep> implements IHasMilitartyClaimRequest, IAgotHasEventProcess {

	private final Challenge data;

	public interface IHasClaimStep extends IAgotFlowProcess { public APhaseStep<IChallengesPhaseStep> after(ClaimStep step, AgotContext context); }
	@Getter private final IHasClaimStep parent; 
	@Override public APhaseStep<IChallengesPhaseStep> next(AgotContext context) { return this.parent.after(this, context); }
	
	public ClaimStep(Challenge data, AgotGame game, IHasClaimStep parent) {
		super (game);
		this.data = data;
		this.parent = parent;
	}

	private ArrayList<CharacterCard> toKill = new ArrayList<CharacterCard>();
	private int nKills;
	
	@Override
	public String getStepTitle() { return AgotText.title().claimStep(); }

	@Override
	public IAgotFlowStep stepStart(AgotContext context) {
		if (this.data.attackWins()) {
			var claim = this.data.attacker.revealedPlot().getClaim();
			switch (this.data.type()) {
				case INTRIGUE:
					var nCards = Math.min(this.data.defender.handSize(), claim);
					var lostCards = new ArrayList<DrawCard<?>> (); 
					for (var i = 0; i < nCards; i++) { lostCards.add (this.data.defender.randomDiscardFromHand(context)); }
					for (var lostCard : lostCards) {
						this.game.logManager().discards(this.data.defender, lostCard, context);
					}
					return null;
				case MILITARY:
					this.nKills = Math.min(this.data.defender.charactersSize(), claim);
					if (this.nKills > 0) {
						var available = this.data.defender.characters().collect(Collectors.toList());
						return new MilitartyClaimRequest(available, this.data.defender, this);
					} else {
						return null;
					}
				case POWER:
					var defFacCard = this.data.defender.faction ();
					var lostPower = Math.min(defFacCard.power (), claim);
					defFacCard.losePower(lostPower, context);
					this.data.attacker.gainPowerOnTheFactionCard(lostPower, context);
					this.game.logManager().losesPowerTokens (this.data.defender, lostPower, context);
					this.game.logManager().gainsPowerTokens(this.data.attacker, lostPower, context);
					return null;
				default: return null;
			}
		} else {
			return null;
		}
	}
	
	@Override
	public IAgotFlowStep after(MilitartyClaimRequest decision, AgotContext context) {
		var toKill = decision.getChoosenModel();
		this.toKill.add(toKill);
		this.nKills--;
		if (this.nKills > 0) {
			var available = this.data.defender.characters().filter(cha -> !this.toKill.contains (cha)).collect(Collectors.toList());
			return new MilitartyClaimRequest(available, this.data.attacker, this);
		} else {
			var events = this.toKill.stream().map(c -> new KillEvent(c, this.game)).collect (Collectors.toList());
			var event = new MultiEvent(events, this.game);
			return new AgotEventProcess(event, this.game, this);
		}
	}

	@Override
	public IAgotFlowStep after(AgotEventProcess eventProcess, AgotContext context) {
		return null;
	}

}
