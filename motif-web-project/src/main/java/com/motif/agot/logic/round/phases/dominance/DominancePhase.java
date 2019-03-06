package com.motif.agot.logic.round.phases.dominance;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.round.phases.Phase;
import com.motif.agot.logic.round.phases.StartPhaseStep;
import com.motif.agot.logic.round.phases.standing.StandingPhase;
import com.motif.agot.state.AgotGame;

public class DominancePhase extends Phase<IDominancePhaseStep> {
	
	public DominancePhase (AgotGame game) {
		super (AngPhase.DOMINANCE, game);
	} // DominancePhase
	
	@Override public String getPhaseTitle () { return AgotText.title ().dominancePhase (); }

	@Override public StartPhaseStep<IDominancePhaseStep> getStartPhaseStep () { return new StartDominancePhaseStep (game); }

	@Override public StandingPhase getNextTask (AgotContext context) { return new StandingPhase (game); }
	
} // DominancePhase
