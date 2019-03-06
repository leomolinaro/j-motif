package com.motif.agot.logic.round.phases.plot;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.round.phases.StartPhaseStep;
import com.motif.agot.state.AgotGame;

public class StartPlotPhaseStep extends StartPhaseStep<IPlotPhaseStep> {

	public StartPlotPhaseStep (AgotGame game) {
		super (AngPhase.PLOT, game);
	} // StartPlotPhaseStep

	@Override
	public String getStepTitle () { return AgotText.title ().startPlotPhaseStep (); }

	@Override
	public ChoosePlotStep getNextTask (AgotContext context) {
		return new ChoosePlotStep (game);
	} // getNextTask
	
} // StartPlotPhaseStep
