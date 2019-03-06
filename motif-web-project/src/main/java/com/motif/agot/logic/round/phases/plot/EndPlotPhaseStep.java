package com.motif.agot.logic.round.phases.plot;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.logic.round.phases.EndPhaseStep;
import com.motif.agot.state.AgotGame;

public class EndPlotPhaseStep extends EndPhaseStep<IPlotPhaseStep> {

	public EndPlotPhaseStep (AgotGame game) {
		super (AngPhase.PLOT, game);
	} // EndPlotPhaseStep

	@Override
	public String getStepTitle () { return AgotText.title ().endPlotPhaseStep (); }

} // EndPlotPhaseStep
