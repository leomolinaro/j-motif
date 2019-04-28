package com.motif.agot.logic.phases.standing;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.phases.APhaseStep;
import com.motif.agot.logic.phases.AStartPhaseStep;
import com.motif.agot.state.AgotGame;

import lombok.Getter;

public class StartStandingPhaseStep extends AStartPhaseStep<IStandingPhaseStep> {

	public interface IHasStartStandingPhaseStep extends IAgotFlowProcess { public APhaseStep<IStandingPhaseStep> after(StartStandingPhaseStep step, AgotContext context); }
	@Getter private final IHasStartStandingPhaseStep parent; 
	@Override public APhaseStep<IStandingPhaseStep> next(AgotContext context) { return this.parent.after(this, context); }
	
	public StartStandingPhaseStep (AgotGame game, IHasStartStandingPhaseStep parent) {
		super (AngPhase.STANDING, game);
		this.parent = parent;
	}

	@Override
	public String getStepTitle() { return AgotText.title().startStandingPhaseStep(); }

}
