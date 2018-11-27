package motif.agot.logic.round.phases.plot;

import motif.agot.ang.AgotText;
import motif.agot.ang.enums.AngPhase;
import motif.agot.endpoint.AgotContext;
import motif.agot.logic.round.phases.StandardActionWindowStep;
import motif.agot.state.AgotGame;

public class PlotActionStep extends StandardActionWindowStep<IPlotPhaseStep> {

	public PlotActionStep (AgotGame game) {
		super (AngPhase.PLOT, game);
	} // PlotActionStep

	@Override
	public String getStepTitle () { return AgotText.title ().actionWindow (); }

	@Override
	public EndPlotPhaseStep getNextTask (AgotContext context) {
		return new EndPlotPhaseStep (game);
	} // getNextTask
	
} // PlotActionStep
