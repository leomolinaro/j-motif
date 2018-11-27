package motif.agot.logic.round.phases.standing;

import motif.agot.ang.AgotText;
import motif.agot.ang.enums.AngPhase;
import motif.agot.logic.round.phases.EndPhaseStep;
import motif.agot.state.AgotGame;

public class EndStandingPhaseStep extends EndPhaseStep<IStandingPhaseStep> {

	public EndStandingPhaseStep (AgotGame game) {
		super (AngPhase.STANDING, game);
	} // EndStandingPhaseStep

	@Override
	public String getStepTitle () { return AgotText.title ().endStandingPhaseStep (); }
	
} // EndStandingPhaseStep
