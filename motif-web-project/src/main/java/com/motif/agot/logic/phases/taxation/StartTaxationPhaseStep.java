package com.motif.agot.logic.phases.taxation;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.phases.APhaseStep;
import com.motif.agot.logic.phases.AStartPhaseStep;
import com.motif.agot.state.AgotGame;

import lombok.Getter;

public class StartTaxationPhaseStep extends AStartPhaseStep<ITaxationPhaseStep> {

	public interface IHasStartTaxationPhaseStep extends IAgotFlowProcess { public APhaseStep<ITaxationPhaseStep> after(StartTaxationPhaseStep step, AgotContext context); }
	@Getter private final IHasStartTaxationPhaseStep parent; 
	@Override public APhaseStep<ITaxationPhaseStep> next(AgotContext context) { return this.parent.after(this, context); }
	
	public StartTaxationPhaseStep (AgotGame game, IHasStartTaxationPhaseStep parent) {
		super (AngPhase.TAXATION, game);
		this.parent = parent;
	}

	@Override
	public String getStepTitle() { return AgotText.title().startTaxationPhaseStep(); }

}
