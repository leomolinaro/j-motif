package com.motif.agot.logic.phases.taxation;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.phases.APhaseStep;
import com.motif.agot.logic.phases.AStandardActionPhaseStep;
import com.motif.agot.state.AgotGame;

import lombok.Getter;

public class TaxationActionStep extends AStandardActionPhaseStep<ITaxationPhaseStep> {

	public interface IHasTaxationActionStep extends IAgotFlowProcess { public APhaseStep<ITaxationPhaseStep> after(TaxationActionStep step, AgotContext context); }
	@Getter private final IHasTaxationActionStep parent; 
	@Override public APhaseStep<ITaxationPhaseStep> next(AgotContext context) { return this.parent.after(this, context); }
	
	public TaxationActionStep(AgotGame game, IHasTaxationActionStep parent) {
		super(AngPhase.TAXATION, game);
		this.parent = parent;
	}

	@Override
	public String getStepTitle() { return AgotText.title().actionWindow(); }

}
