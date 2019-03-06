package com.motif.agot.logic.round.phases.challenges;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.round.phases.Phase;
import com.motif.agot.logic.round.phases.StartPhaseStep;
import com.motif.agot.logic.round.phases.dominance.DominancePhase;
import com.motif.agot.state.AgotGame;

public class ChallengesPhase extends Phase<IChallengesPhaseStep> {

	public ChallengesPhase (AgotGame game) {
		super (AngPhase.CHALLENGES, game);
	} // ChallengesPhase
	
	@Override public String getPhaseTitle () { return AgotText.title ().challengesPhase (); }

	@Override public StartPhaseStep<IChallengesPhaseStep> getStartPhaseStep () { return new StartChallengesPhaseStep (game); }

	@Override public DominancePhase getNextTask (AgotContext context) { return new DominancePhase (game); }

} // ChallengesPhase
