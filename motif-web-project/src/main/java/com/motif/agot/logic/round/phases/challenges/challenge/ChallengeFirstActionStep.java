package com.motif.agot.logic.round.phases.challenges.challenge;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.round.phases.StandardActionWindowStep;
import com.motif.agot.logic.round.phases.challenges.IChallengesPhaseStep;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.Challenge;

public class ChallengeFirstActionStep extends StandardActionWindowStep<IChallengesPhaseStep> {

	private Challenge data;
	
	public ChallengeFirstActionStep (Challenge data, AgotGame game) {
		super (AngPhase.CHALLENGES, game);
		this.data = data;
	} // ChallengeFirstActionStep

	@Override
	public String getStepTitle () { return AgotText.title ().actionWindow (); }

	@Override
	public DefendingChallengeStep getNextTask (AgotContext context) {
		return new DefendingChallengeStep (data, game);
	} // getNextTask
	
} // ChallengeFirstActionStep
