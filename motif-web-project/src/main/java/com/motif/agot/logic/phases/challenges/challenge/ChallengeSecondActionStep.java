package com.motif.agot.logic.phases.challenges.challenge;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.phases.APhaseStep;
import com.motif.agot.logic.phases.AStandardActionPhaseStep;
import com.motif.agot.logic.phases.challenges.IChallengesPhaseStep;
import com.motif.agot.state.AgotGame;

import lombok.Getter;

public class ChallengeSecondActionStep extends AStandardActionPhaseStep<IChallengesPhaseStep> {

	public interface IHasChallengeSecondActionStep extends IAgotFlowProcess { public APhaseStep<IChallengesPhaseStep> after(ChallengeSecondActionStep step, AgotContext context); }
	@Getter private final IHasChallengeSecondActionStep parent; 
	@Override public APhaseStep<IChallengesPhaseStep> next(AgotContext context) { return this.parent.after(this, context); }
	
	public ChallengeSecondActionStep(AgotGame game, IHasChallengeSecondActionStep parent) {
		super(AngPhase.CHALLENGES, game);
		this.parent = parent;
	}

	@Override
	public String getStepTitle() { return AgotText.title().actionWindow(); }

}
