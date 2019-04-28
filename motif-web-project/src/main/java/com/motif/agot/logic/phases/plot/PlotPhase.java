package com.motif.agot.logic.phases.plot;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.logic.phases.APhase;
import com.motif.agot.logic.phases.APhaseStep;
import com.motif.agot.logic.phases.AStartPhaseStep;
import com.motif.agot.logic.phases.plot.ChoosePlotStep.IAgotHasChoosePlotStep;
import com.motif.agot.logic.phases.plot.EndPlotPhaseStep.IAgotHasEndPlotPhaseStep;
import com.motif.agot.logic.phases.plot.PlotActionStep.IAgotHasPlotActionStep;
import com.motif.agot.logic.phases.plot.RevealPlotStep.IAgotHasRevealPlotStep;
import com.motif.agot.logic.phases.plot.StartPlotPhaseStep.IAgotHasStartPlotPhaseStep;
import com.motif.agot.state.AgotGame;

import lombok.Getter;

public class PlotPhase extends APhase<IPlotPhaseStep> implements 
		IAgotHasStartPlotPhaseStep,
		IAgotHasChoosePlotStep,
        IAgotHasRevealPlotStep,
        IAgotHasPlotActionStep,
        IAgotHasEndPlotPhaseStep {

	public interface IAgotHasPlotPhase extends IAgotFlowProcess { public IAgotFlowStep after(PlotPhase phase, AgotContext context); }
	@Getter private final IAgotHasPlotPhase parent;
	@Override public IAgotFlowStep next(AgotContext context) { return this.parent.after(this, context); }

	public PlotPhase(AgotGame game, IAgotHasPlotPhase parent) {
		super(AngPhase.PLOT, game);
		this.parent = parent;
	} // PlotPhase

	@Override
	public String getPhaseTitle() { return AgotText.title().plotPhase(); }

	@Override
	public AStartPhaseStep<IPlotPhaseStep> startPhaseStep() { return new StartPlotPhaseStep(game, this); }
	@Override
	public APhaseStep<IPlotPhaseStep> after(StartPlotPhaseStep startPhaseStep, AgotContext context) { return new ChoosePlotStep(game, this); }
	@Override
	public APhaseStep<IPlotPhaseStep> after(EndPlotPhaseStep endPhaseStep, AgotContext context) { return null; }
	@Override
	public APhaseStep<IPlotPhaseStep> after(PlotActionStep plotActionStep, AgotContext context) { return new EndPlotPhaseStep(game, this); }
	@Override
	public APhaseStep<IPlotPhaseStep> after(RevealPlotStep revealPlotStep, AgotContext context) { return new PlotActionStep(game, this); }
	@Override
	public APhaseStep<IPlotPhaseStep> after(ChoosePlotStep choosePlotStep, AgotContext context) { return new RevealPlotStep(game, this); }

} // PlotPhase
