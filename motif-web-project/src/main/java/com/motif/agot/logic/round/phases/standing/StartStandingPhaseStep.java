package com.motif.agot.logic.round.phases.standing;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.round.phases.StartPhaseStep;
import com.motif.agot.state.AgotGame;

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
