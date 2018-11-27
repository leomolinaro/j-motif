package motif.agot.logic.round.phases.plot;

import motif.agot.ang.AgotText;
import motif.agot.ang.enums.AngPhase;
import motif.agot.endpoint.AgotContext;
import motif.agot.logic.round.phases.StartPhaseStep;
import motif.agot.state.AgotGame;

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
