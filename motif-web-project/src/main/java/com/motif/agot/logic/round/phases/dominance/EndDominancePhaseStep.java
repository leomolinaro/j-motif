package com.motif.agot.logic.round.phases.dominance;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.logic.round.phases.EndPhaseStep;
import com.motif.agot.state.AgotGame;

public class EndDominancePhaseStep extends EndPhaseStep<IDominancePhaseStep> {

	public EndDominancePhaseStep (AgotGame game) {
		super (AngPhase.DOMINANCE, game);
	} // EndDominancePhaseStep

	@Override
	public String getStepTitle () { return AgotText.title ().endDominancePhaseStep (); }
	
} // EndMarshallingPhaseStep
