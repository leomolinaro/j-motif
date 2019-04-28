package com.motif.agot.logic.phases.standing;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.phases.APhaseStep;
import com.motif.agot.logic.phases.AStandardActionPhaseStep;
import com.motif.agot.state.AgotGame;

import lombok.Getter;

public class StandingActionStep extends AStandardActionPhaseStep<IStandingPhaseStep> {

	public interface IHasStandingActionStep extends IAgotFlowProcess { public APhaseStep<IStandingPhaseStep> after(StandingActionStep step, AgotContext context); }
	@Getter private final IHasStandingActionStep parent; 
	@Override public APhaseStep<IStandingPhaseStep> next(AgotContext context) { return this.parent.after(this, context); }
	
	public StandingActionStep (AgotGame game, IHasStandingActionStep parent) {
		super (AngPhase.STANDING, game);
		this.parent = parent;
	}

	@Override
	public String getStepTitle() { return AgotText.title().actionWindow(); }

}
