package motif.agot.logic.round.phases.plot;

import motif.agot.ang.AgotText;
import motif.agot.ang.enums.AngPhase;
import motif.agot.endpoint.AgotContext;
import motif.agot.logic.round.phases.Phase;
import motif.agot.logic.round.phases.StartPhaseStep;
import motif.agot.logic.round.phases.draw.DrawPhase;
import motif.agot.state.AgotGame;

public class PlotPhase extends Phase<IPlotPhaseStep> {

	public PlotPhase (AgotGame game) {
		super (AngPhase.PLOT, game);
	} // PlotPhase
	
	@Override public String getPhaseTitle () { return AgotText.title ().plotPhase (); }

	@Override public StartPhaseStep<IPlotPhaseStep> getStartPhaseStep () { return new StartPlotPhaseStep (game); }

	@Override public DrawPhase getNextTask (AgotContext context) { return new DrawPhase (game); }
	
} // PlotPhase
