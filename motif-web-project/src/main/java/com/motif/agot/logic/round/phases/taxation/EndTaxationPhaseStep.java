package com.motif.agot.logic.round.phases.taxation;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.logic.round.phases.EndPhaseStep;
import com.motif.agot.state.AgotGame;

public class EndTaxationPhaseStep extends EndPhaseStep<ITaxationPhaseStep> {

	public EndTaxationPhaseStep (AgotGame game) {
		super (AngPhase.TAXATION, game);
	} // EndTaxationPhaseStep

	@Override
	public String getStepTitle () { return AgotText.title ().endTaxationPhaseStep (); }
	
} // EndTaxationPhaseStep
