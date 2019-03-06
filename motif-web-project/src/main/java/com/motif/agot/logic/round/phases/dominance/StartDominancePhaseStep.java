package com.motif.agot.logic.round.phases.dominance;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.round.phases.StartPhaseStep;
import com.motif.agot.state.AgotGame;

public class StartDominancePhaseStep extends StartPhaseStep<IDominancePhaseStep> {

	public StartDominancePhaseStep (AgotGame game) {
		super (AngPhase.DOMINANCE, game);
	} // StartDominancePhaseStep

	@Override
	public String getStepTitle () { return AgotText.title ().startDominancePhaseStep (); }

	@Override
	public DetermineDominanceStep getNextTask (AgotContext context) {
		return new DetermineDominanceStep (game);
	} // getNextTask
	
} // StartDominancePhaseStep
