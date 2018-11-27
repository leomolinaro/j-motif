package motif.agot.logic.round.phases.standing;

import motif.agot.ang.AgotText;
import motif.agot.ang.enums.AngPhase;
import motif.agot.endpoint.AgotContext;
import motif.agot.logic.round.phases.StartPhaseStep;
import motif.agot.state.AgotGame;

public class StartStandingPhaseStep extends StartPhaseStep<IStandingPhaseStep> {

	public StartStandingPhaseStep (AgotGame game) {
		super (AngPhase.STANDING, game);
	} // StartStandingPhaseStep

	@Override
	public String getStepTitle () { return AgotText.title ().startStandingPhaseStep (); }

	@Override
	public StandingStep getNextTask (AgotContext context) {
		return new StandingStep (game);
	} // getNextTask
	
} // StartStandingPhaseStep
