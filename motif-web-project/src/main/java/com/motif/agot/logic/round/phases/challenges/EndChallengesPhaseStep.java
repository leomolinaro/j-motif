package com.motif.agot.logic.round.phases.challenges;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.logic.round.phases.EndPhaseStep;
import com.motif.agot.state.AgotGame;

public class EndChallengesPhaseStep extends EndPhaseStep<IChallengesPhaseStep> {

	public EndChallengesPhaseStep (AgotGame game) {
		super (AngPhase.CHALLENGES, game);
	} // EndChallengesPhaseStep

	@Override
	public String getStepTitle () { return AgotText.title ().endChallengesPhaseStep (); }

} // EndChallengesPhaseStep
