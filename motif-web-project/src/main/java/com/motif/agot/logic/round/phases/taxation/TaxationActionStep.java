package com.motif.agot.logic.round.phases.taxation;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.round.phases.StandardActionWindowStep;
import com.motif.agot.state.AgotGame;

public class TaxationActionStep extends StandardActionWindowStep<ITaxationPhaseStep> {

	public TaxationActionStep (AgotGame game) {
		super (AngPhase.TAXATION, game);
	} // TaxationActionStep

	@Override
	public String getStepTitle () { return AgotText.title ().actionWindow (); }

	@Override
	public EndTaxationPhaseStep getNextTask (AgotContext context) {
		return new EndTaxationPhaseStep (game);
	} // getNextTask

} // TaxationActionStep
