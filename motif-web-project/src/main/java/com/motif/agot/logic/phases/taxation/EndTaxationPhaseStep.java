package com.motif.agot.logic.phases.taxation;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.phases.AEndPhaseStep;
import com.motif.agot.logic.phases.APhaseStep;
import com.motif.agot.state.AgotGame;

import lombok.Getter;

public class EndTaxationPhaseStep extends AEndPhaseStep<ITaxationPhaseStep> {

	public interface IHasEndTaxationPhaseStep extends IAgotFlowProcess { public APhaseStep<ITaxationPhaseStep> after(EndTaxationPhaseStep step, AgotContext context); }
	@Getter private final IHasEndTaxationPhaseStep parent; 
	@Override public APhaseStep<ITaxationPhaseStep> next(AgotContext context) { return this.parent.after(this, context); }
	
	public EndTaxationPhaseStep (AgotGame game, IHasEndTaxationPhaseStep parent) {
		super(AngPhase.TAXATION, game);
		this.parent = parent;
	}

	@Override
	public String getStepTitle() { return AgotText.title().endTaxationPhaseStep(); }
	
}
