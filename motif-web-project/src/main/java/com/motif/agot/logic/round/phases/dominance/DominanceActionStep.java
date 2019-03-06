package com.motif.agot.logic.round.phases.dominance;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.round.phases.StandardActionWindowStep;
import com.motif.agot.state.AgotGame;

public class DominanceActionStep extends StandardActionWindowStep<IDominancePhaseStep> {

	public DominanceActionStep (AgotGame game) {
		super (AngPhase.DOMINANCE, game);
	} // DominanceActionStep

	@Override
	public String getStepTitle () { return AgotText.title ().actionWindow (); }

	@Override
	public EndDominancePhaseStep getNextTask (AgotContext context) {
		return new EndDominancePhaseStep (game);
	} // getNextTask
	
} // DominanceActionStep
