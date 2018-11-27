package motif.agot.logic.round.phases.challenges;

import motif.agot.ang.AgotText;
import motif.agot.ang.enums.AngPhase;
import motif.agot.endpoint.AgotContext;
import motif.agot.logic.round.phases.Phase;
import motif.agot.logic.round.phases.StartPhaseStep;
import motif.agot.logic.round.phases.dominance.DominancePhase;
import motif.agot.state.AgotGame;

public class ChallengesPhase extends Phase<IChallengesPhaseStep> {

	public ChallengesPhase (AgotGame game) {
		super (AngPhase.CHALLENGES, game);
	} // ChallengesPhase
	
	@Override public String getPhaseTitle () { return AgotText.title ().challengesPhase (); }

	@Override public StartPhaseStep<IChallengesPhaseStep> getStartPhaseStep () { return new StartChallengesPhaseStep (game); }

	@Override public DominancePhase getNextTask (AgotContext context) { return new DominancePhase (game); }

} // ChallengesPhase
