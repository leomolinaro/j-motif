package com.motif.agot.logic.phases.challenges.challenge;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.phases.APhaseStep;
import com.motif.agot.logic.phases.AStandardActionPhaseStep;
import com.motif.agot.logic.phases.challenges.IChallengesPhaseStep;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.Challenge;

import lombok.Getter;

public class ChallengeFirstActionStep extends AStandardActionPhaseStep<IChallengesPhaseStep> {

	public interface IHasChallengeFirstActionStep extends IAgotFlowProcess { public APhaseStep<IChallengesPhaseStep> after(ChallengeFirstActionStep step, AgotContext context); }
	@Getter private final IHasChallengeFirstActionStep parent; 
	@Override public APhaseStep<IChallengesPhaseStep> next(AgotContext context) { return this.parent.after(this, context); }
	
	public ChallengeFirstActionStep (Challenge data, AgotGame game, IHasChallengeFirstActionStep parent) {
		super (AngPhase.CHALLENGES, game);
		this.parent = parent;
	}

	@Override
	public String getStepTitle() { return AgotText.title().actionWindow(); }

}
