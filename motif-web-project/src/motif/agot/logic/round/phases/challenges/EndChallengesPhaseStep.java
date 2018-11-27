package motif.agot.logic.round.phases.challenges;

import motif.agot.ang.AgotText;
import motif.agot.ang.enums.AngPhase;
import motif.agot.logic.round.phases.EndPhaseStep;
import motif.agot.state.AgotGame;

public class EndChallengesPhaseStep extends EndPhaseStep<IChallengesPhaseStep> {

	public EndChallengesPhaseStep (AgotGame game) {
		super (AngPhase.CHALLENGES, game);
	} // EndChallengesPhaseStep

	@Override
	public String getStepTitle () { return AgotText.title ().endChallengesPhaseStep (); }

} // EndChallengesPhaseStep
