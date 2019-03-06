package com.motif.agot.logic.round.phases.plot;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.round.phases.Phase;
import com.motif.agot.logic.round.phases.StartPhaseStep;
import com.motif.agot.logic.round.phases.draw.DrawPhase;
import com.motif.agot.state.AgotGame;

public class PlotPhase extends Phase<IPlotPhaseStep> {

	public PlotPhase (AgotGame game) {
		super (AngPhase.PLOT, game);
	} // PlotPhase
	
	@Override public String getPhaseTitle () { return AgotText.title ().plotPhase (); }

	@Override public StartPhaseStep<IPlotPhaseStep> getStartPhaseStep () { return new StartPlotPhaseStep (game); }

	@Override public DrawPhase getNextTask (AgotContext context) { return new DrawPhase (game); }
	
} // PlotPhase
