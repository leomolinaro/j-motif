package com.motif.agot.logic.phases.plot;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.phases.APhaseStep;
import com.motif.agot.logic.phases.AStandardActionPhaseStep;
import com.motif.agot.state.AgotGame;

import lombok.Getter;

public class PlotActionStep extends AStandardActionPhaseStep<IPlotPhaseStep> {

	public interface IAgotHasPlotActionStep extends IAgotFlowProcess { public APhaseStep<IPlotPhaseStep> after(PlotActionStep plotActionStep, AgotContext context); }
	@Getter private final IAgotHasPlotActionStep parent; 
	@Override public APhaseStep<IPlotPhaseStep> next(AgotContext context) { return this.parent.after(this, context); }
	
	public PlotActionStep(AgotGame game, IAgotHasPlotActionStep parent) {
		super(AngPhase.PLOT, game);
		this.parent = parent;
	}

	@Override
	public String getStepTitle() {
		return AgotText.title().actionWindow();
	}

}
