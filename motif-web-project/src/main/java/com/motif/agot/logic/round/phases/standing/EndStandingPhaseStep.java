package com.motif.agot.logic.round.phases.standing;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.logic.round.phases.EndPhaseStep;
import com.motif.agot.state.AgotGame;

public class EndStandingPhaseStep extends EndPhaseStep<IStandingPhaseStep> {

	public EndStandingPhaseStep (AgotGame game) {
		super (AngPhase.STANDING, game);
	} // EndStandingPhaseStep

	@Override
	public String getStepTitle () { return AgotText.title ().endStandingPhaseStep (); }
	
} // EndStandingPhaseStep
