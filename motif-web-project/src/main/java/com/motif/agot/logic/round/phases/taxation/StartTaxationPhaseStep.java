package com.motif.agot.logic.round.phases.taxation;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.round.phases.StartPhaseStep;
import com.motif.agot.state.AgotGame;

public class StartTaxationPhaseStep extends StartPhaseStep<ITaxationPhaseStep> {

	public StartTaxationPhaseStep (AgotGame game) {
		super (AngPhase.TAXATION, game);
	} // StartTaxationPhaseStep

	@Override
	public String getStepTitle () { return AgotText.title ().startTaxationPhaseStep (); }

	@Override
	public TributeStep getNextTask (AgotContext context) {
		return new TributeStep (game);
	} // getNextTask
	
} // StartTaxationPhaseStep
