package com.motif.agot.logic.phases.plot;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.phases.APhaseStep;
import com.motif.agot.logic.phases.AEndPhaseStep;
import com.motif.agot.state.AgotGame;

import lombok.Getter;

public class EndPlotPhaseStep extends AEndPhaseStep<IPlotPhaseStep> {

	public interface IAgotHasEndPlotPhaseStep extends IAgotFlowProcess { public APhaseStep<IPlotPhaseStep> after(EndPlotPhaseStep endPhaseStep, AgotContext context); }
	@Getter private final IAgotHasEndPlotPhaseStep parent; 
	@Override public APhaseStep<IPlotPhaseStep> next(AgotContext context) { return this.parent.after(this, context); }
	
	public EndPlotPhaseStep(AgotGame game, IAgotHasEndPlotPhaseStep parent) {
		super(AngPhase.PLOT, game);
		this.parent = parent;
	}

	@Override
	public String getStepTitle() { return AgotText.title().endPlotPhaseStep(); }

}