package motif.agot.logic.round.phases.challenges;

import motif.agot.ang.AgotText;
import motif.agot.endpoint.AgotContext;
import motif.agot.logic.round.phases.ActivateNextStep;
import motif.agot.logic.round.phases.Step;
import motif.agot.state.AgotGame;
import motif.agot.state.AgotPlayer;

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
