package com.motif.agot.logic.round.phases.standing;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.round.phases.Phase;
import com.motif.agot.logic.round.phases.StartPhaseStep;
import com.motif.agot.logic.round.phases.taxation.TaxationPhase;
import com.motif.agot.state.AgotGame;

public class StandingPhase extends Phase<IStandingPhaseStep> {

	public StandingPhase (AgotGame game) {
		super (AngPhase.STANDING, game);
	} // StandingPhase
	
	@Override public String getPhaseTitle () { return AgotText.title ().standingPhase (); }

	@Override public StartPhaseStep<IStandingPhaseStep> getStartPhaseStep () { return new StartStandingPhaseStep (game); }

	@Override public TaxationPhase getNextTask (AgotContext context) { return new TaxationPhase (game); }

} // StandingPhase
