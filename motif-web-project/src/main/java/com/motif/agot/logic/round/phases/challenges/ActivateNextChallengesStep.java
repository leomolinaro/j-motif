package com.motif.agot.logic.round.phases.challenges;

import com.motif.agot.ang.AgotText;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.round.phases.ActivateNextStep;
import com.motif.agot.logic.round.phases.Step;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;

public class ActivateNextChallengesStep extends ActivateNextStep<IChallengesPhaseStep> {

	public ActivateNextChallengesStep (AgotPlayer activePlayer, AgotGame game) {
		super (activePlayer, game);
	} // ActivateNextChallengesStep

	@Override
	public String getStepTitle () { return AgotText.title ().activateNextChallengesStep (); }

	@Override
	public Step<IChallengesPhaseStep> getNextTask (AgotContext context) {
		AgotPlayer nextPlayer = getNextPlayer ();
		if (nextPlayer == null) {
			return new EndChallengesPhaseStep (game);
		} else {
			game.setRemainingChallenges (null);
			return new ChallengesActionStep (nextPlayer, game);
		} // if - else
	} // getNextTask
	
} // ActivateNextChallengesStep
