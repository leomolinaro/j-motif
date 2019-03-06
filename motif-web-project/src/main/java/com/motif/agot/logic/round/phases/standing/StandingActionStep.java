package com.motif.agot.logic.round.phases.standing;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.round.phases.StandardActionWindowStep;
import com.motif.agot.state.AgotGame;

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
