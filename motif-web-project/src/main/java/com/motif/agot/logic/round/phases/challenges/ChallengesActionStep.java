package com.motif.agot.logic.round.phases.challenges;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.round.phases.StandardActionWindowStep;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;

public class ChallengesActionStep extends StandardActionWindowStep<IChallengesPhaseStep> {

	private AgotPlayer activePlayer;
	
	public ChallengesActionStep (AgotPlayer activePlayer, AgotGame game) {
		super (AngPhase.CHALLENGES, game);
		this.activePlayer = activePlayer;
	} // ChallengesActionStep

	@Override
	public String getStepTitle () { return AgotText.title ().actionWindow (); }

	@Override
	public InitiateChallengeStep getNextTask (AgotContext context) {
		return new InitiateChallengeStep (activePlayer, game);
	} // getNextTask
	
} // ChallengesActionStep
