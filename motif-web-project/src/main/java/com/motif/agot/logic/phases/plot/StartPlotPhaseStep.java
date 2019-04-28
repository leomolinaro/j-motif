package com.motif.agot.logic.phases.plot;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.phases.APhaseStep;
import com.motif.agot.logic.phases.AStartPhaseStep;
import com.motif.agot.state.AgotGame;

import lombok.Getter;

public class StartPlotPhaseStep extends AStartPhaseStep<IPlotPhaseStep> {

	public interface IAgotHasStartPlotPhaseStep extends IAgotFlowProcess { public APhaseStep<IPlotPhaseStep> after(StartPlotPhaseStep startPhaseStep, AgotContext context); }
	@Getter private final IAgotHasStartPlotPhaseStep parent; 
	@Override public APhaseStep<IPlotPhaseStep> next(AgotContext context) { return this.parent.after(this, context); }
	
	public StartPlotPhaseStep (AgotGame game, IAgotHasStartPlotPhaseStep parent) {
		super (AngPhase.PLOT, game);
		this.parent = parent;
	} // StartPlotPhaseStep

	@Override
	public String getStepTitle() {
		return AgotText.title().startPlotPhaseStep();
	}

}
