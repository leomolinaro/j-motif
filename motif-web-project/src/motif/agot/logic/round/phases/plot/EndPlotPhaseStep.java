package motif.agot.logic.round.phases.plot;

import motif.agot.ang.AgotText;
import motif.agot.ang.enums.AngPhase;
import motif.agot.logic.round.phases.EndPhaseStep;
import motif.agot.state.AgotGame;

public class EndPlotPhaseStep extends EndPhaseStep<IPlotPhaseStep> {

	public EndPlotPhaseStep (AgotGame game) {
		super (AngPhase.PLOT, game);
	} // EndPlotPhaseStep

	@Override
	public String getStepTitle () { return AgotText.title ().endPlotPhaseStep (); }

} // EndPlotPhaseStep
