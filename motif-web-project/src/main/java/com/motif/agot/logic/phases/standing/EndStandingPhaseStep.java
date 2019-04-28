package com.motif.agot.logic.phases.standing;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.phases.AEndPhaseStep;
import com.motif.agot.logic.phases.APhaseStep;
import com.motif.agot.state.AgotGame;

import lombok.Getter;

public class EndStandingPhaseStep extends AEndPhaseStep<IStandingPhaseStep> {

	public interface IHasEndStandingPhaseStep extends IAgotFlowProcess { public APhaseStep<IStandingPhaseStep> after(EndStandingPhaseStep step, AgotContext context); }
	@Getter private final IHasEndStandingPhaseStep parent; 
	@Override public APhaseStep<IStandingPhaseStep> next(AgotContext context) { return this.parent.after(this, context); }
	
	public EndStandingPhaseStep (AgotGame game, IHasEndStandingPhaseStep parent) {
		super (AngPhase.STANDING, game);
		this.parent = parent;
	}

	@Override
	public String getStepTitle() { return AgotText.title().endStandingPhaseStep(); }
	
}
