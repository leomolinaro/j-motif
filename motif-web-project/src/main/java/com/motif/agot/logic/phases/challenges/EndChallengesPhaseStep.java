package com.motif.agot.logic.phases.challenges;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.phases.AEndPhaseStep;
import com.motif.agot.logic.phases.APhaseStep;
import com.motif.agot.state.AgotGame;

import lombok.Getter;

public class EndChallengesPhaseStep extends AEndPhaseStep<IChallengesPhaseStep> {

	public interface IHasEndChallengesPhaseStep extends IAgotFlowProcess { public APhaseStep<IChallengesPhaseStep> after(EndChallengesPhaseStep step, AgotContext context); }
	@Getter private final IHasEndChallengesPhaseStep parent; 
	@Override public APhaseStep<IChallengesPhaseStep> next(AgotContext context) { return this.parent.after(this, context); }
	
	public EndChallengesPhaseStep(AgotGame game, IHasEndChallengesPhaseStep parent) {
		super(AngPhase.CHALLENGES, game);
		this.parent = parent;
	}

	@Override
	public String getStepTitle() { return AgotText.title().endChallengesPhaseStep(); }

}
