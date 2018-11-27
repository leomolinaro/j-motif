package motif.agot.logic.round.phases.dominance;

import motif.agot.ang.AgotText;
import motif.agot.ang.enums.AngPhase;
import motif.agot.endpoint.AgotContext;
import motif.agot.logic.round.phases.StartPhaseStep;
import motif.agot.state.AgotGame;

public class StartDominancePhaseStep extends StartPhaseStep<IDominancePhaseStep> {

	public StartDominancePhaseStep (AgotGame game) {
		super (AngPhase.DOMINANCE, game);
	} // StartDominancePhaseStep

	@Override
	public String getStepTitle () { return AgotText.title ().startDominancePhaseStep (); }

	@Override
	public DetermineDominanceStep getNextTask (AgotContext context) {
		return new DetermineDominanceStep (game);
	} // getNextTask
	
} // StartDominancePhaseStep
