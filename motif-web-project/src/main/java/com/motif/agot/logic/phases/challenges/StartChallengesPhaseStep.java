package com.motif.agot.logic.phases.challenges;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.phases.APhaseStep;
import com.motif.agot.logic.phases.AStartPhaseStep;
import com.motif.agot.state.AgotGame;

import lombok.Getter;

public class StartChallengesPhaseStep extends AStartPhaseStep<IChallengesPhaseStep> {

	public interface IHasStartChallengesPhaseStep extends IAgotFlowProcess { public APhaseStep<IChallengesPhaseStep> after(StartChallengesPhaseStep step, AgotContext context); }
	@Getter private final IHasStartChallengesPhaseStep parent; 
	@Override public APhaseStep<IChallengesPhaseStep> next(AgotContext context) { return this.parent.after(this, context); }
	
	public StartChallengesPhaseStep(AgotGame game, IHasStartChallengesPhaseStep parent) {
		super(AngPhase.CHALLENGES, game);
		this.parent = parent;
	}

	@Override
	public String getStepTitle() { return AgotText.title().startChallengesPhaseStep(); }

}
