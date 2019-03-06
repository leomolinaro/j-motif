package com.motif.agot.logic.round.phases.plot;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.round.phases.StandardActionWindowStep;
import com.motif.agot.state.AgotGame;

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
