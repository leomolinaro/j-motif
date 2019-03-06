package com.motif.agot.logic.round.phases.challenges;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.round.phases.StartPhaseStep;
import com.motif.agot.state.AgotGame;

public class StartChallengesPhaseStep extends StartPhaseStep<IChallengesPhaseStep> {

	public StartChallengesPhaseStep (AgotGame game) {
		super (AngPhase.CHALLENGES, game);
	} // StartChallengesPhaseStep

	@Override
	public String getStepTitle () { return AgotText.title ().startChallengesPhaseStep (); }

	@Override
	public ChallengesActionStep getNextTask (AgotContext context) {
		game.setRemainingChallenges (null);
		return new ChallengesActionStep (game.getFirstPlayer (), game);
	} // getNextTask
	
} // StartChallengesPhaseStep
