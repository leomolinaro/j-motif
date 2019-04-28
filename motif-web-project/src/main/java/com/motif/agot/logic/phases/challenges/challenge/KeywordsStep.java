package com.motif.agot.logic.phases.challenges.challenge;

import com.motif.agot.ang.AgotText;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.logic.phases.APhaseStep;
import com.motif.agot.logic.phases.challenges.IChallengesPhaseStep;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.Challenge;

import lombok.Getter;

public class KeywordsStep extends APhaseStep<IChallengesPhaseStep> {

	private final Challenge challenge;

	public interface IHasKeywordsStep extends IAgotFlowProcess { public APhaseStep<IChallengesPhaseStep> after(KeywordsStep step, AgotContext context); }
	@Getter private final IHasKeywordsStep parent; 
	@Override public APhaseStep<IChallengesPhaseStep> next(AgotContext context) { return this.parent.after(this, context); }
	
	public KeywordsStep(Challenge challenge, AgotGame game, IHasKeywordsStep parent) {
		super (game);
		this.challenge = challenge;
		this.parent = parent;
	}
	
	@Override
	public String getStepTitle() { return AgotText.title().keywordsStep(); }

	@Override
	public IAgotFlowStep stepStart(AgotContext context) {
		resolveRenown(context);
		return null;
	}

	private void resolveRenown(AgotContext context) {
		if (this.challenge.attackWins()) {
			this.challenge.attackers()
			.filter(att -> att.hasRenown())
			.forEach(att -> att.gainPower(context));
		} else if (this.challenge.defenseWins()) {
			this.challenge.defenders()
			.filter(def -> def.hasRenown())
			.forEach(def -> def.gainPower(context));
		}
	}
	
}
