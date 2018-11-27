package motif.agot.logic.round.phases.challenges;

import motif.agot.ang.AgotText;
import motif.agot.ang.enums.AngPhase;
import motif.agot.endpoint.AgotContext;
import motif.agot.logic.round.phases.StartPhaseStep;
import motif.agot.state.AgotGame;

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
