package com.motif.agot.logic.phases.challenges.challenge;

import java.util.ArrayList;

import com.motif.agot.ang.AgotText;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.logic.phases.APhaseStep;
import com.motif.agot.logic.phases.challenges.IChallengesPhaseStep;
import com.motif.agot.logic.requests.ChooseDefenderCharacterRequest;
import com.motif.agot.logic.requests.ChooseDefenderCharacterRequest.IHasChooseDefenderCharacterRequest;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.Challenge;
import com.motif.agot.state.cards.CharacterCard;

import lombok.Getter;

public class DefendingChallengeStep extends APhaseStep<IChallengesPhaseStep> implements IHasChooseDefenderCharacterRequest {

	private final Challenge challenge;
	
	public interface IHasDefendingChallengeStep extends IAgotFlowProcess { public APhaseStep<IChallengesPhaseStep> after(DefendingChallengeStep step, AgotContext context); }
	@Getter private final IHasDefendingChallengeStep parent;
	@Override public APhaseStep<IChallengesPhaseStep> next(AgotContext context) { return this.parent.after(this, context); }
	
	public DefendingChallengeStep(Challenge challenge, AgotGame game, IHasDefendingChallengeStep parent) {
		super (game);
		this.challenge = challenge;
		this.parent = parent;
	}
	
	private ArrayList<CharacterCard> availableDefenders;

	@Override
	public String getStepTitle() { return AgotText.title().defendingStep(); }
	
	@Override
	public IAgotFlowStep stepStart(AgotContext context) {
		this.availableDefenders = getAvailableDefenders ();
		return new ChooseDefenderCharacterRequest(this.availableDefenders, this.challenge.defender, this);			
	}
	
	private ArrayList<CharacterCard> getAvailableDefenders() {
		var availableDefenders = new ArrayList<CharacterCard> ();
		this.challenge.defender.characters().forEach(cha -> {
			if (cha.isStanding() && cha.hasIcon(this.challenge.type()) && !challenge.isBypassed(cha)) {
				availableDefenders.add (cha);
			}
		});
		return availableDefenders;
	}

	@Override
	public IAgotFlowStep after(ChooseDefenderCharacterRequest decision, AgotContext context) {
		if (decision.isHasPassed()) {
			this.challenge.defenders().forEach(def -> {
				def.kneel(context);
				this.game.logManager().declaresAsDefender(this.challenge.defender, def, context);			
			});
			return null;
		} else {
			var defender = decision.getChoosenModel();
			this.challenge.addDefender(defender);
			this.availableDefenders.remove(defender);
			return new ChooseDefenderCharacterRequest(this.availableDefenders, this.challenge.defender, this);			
		}
	}

}
