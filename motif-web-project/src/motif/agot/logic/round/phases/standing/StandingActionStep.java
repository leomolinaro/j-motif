package motif.agot.logic.round.phases.standing;

import motif.agot.ang.AgotText;
import motif.agot.ang.enums.AngPhase;
import motif.agot.endpoint.AgotContext;
import motif.agot.logic.round.phases.StandardActionWindowStep;
import motif.agot.state.AgotGame;

public class StandingActionStep extends StandardActionWindowStep<IStandingPhaseStep> {

	public StandingActionStep (AgotGame game) {
		super (AngPhase.STANDING, game);
	} // StandingActionStep

	@Override
	public String getStepTitle () { return AgotText.title ().actionWindow (); }

	@Override
	public EndStandingPhaseStep getNextTask (AgotContext context) {
		return new EndStandingPhaseStep (game);
	} // getNextTask
	
} // StandingActionStep
