package com.motif.agot.logic.round.phases.taxation;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.round.phases.Phase;
import com.motif.agot.logic.round.phases.StartPhaseStep;
import com.motif.agot.state.AgotGame;

public class TaxationPhase extends Phase<ITaxationPhaseStep> {

	public TaxationPhase (AgotGame game) {
		super (AngPhase.TAXATION, game);
	} // TaxationPhase
	
	@Override public String getPhaseTitle () { return AgotText.title ().taxationPhase (); }

	@Override public StartPhaseStep<ITaxationPhaseStep> getStartPhaseStep () { return new StartTaxationPhaseStep (game); }

	@Override public Phase<?> getNextTask (AgotContext context) { return null; }

} // TaxationPhase
