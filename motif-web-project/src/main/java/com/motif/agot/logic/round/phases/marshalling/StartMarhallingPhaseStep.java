package com.motif.agot.logic.round.phases.marshalling;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.round.phases.StartPhaseStep;
import com.motif.agot.state.AgotGame;

public class StartMarhallingPhaseStep extends StartPhaseStep<IMarshallingPhaseStep> {

	public StartMarhallingPhaseStep (AgotGame game) {
		super (AngPhase.MARSHALLING, game);
	} // StartMarhallingPhaseStep

	@Override
	public String getStepTitle () { return AgotText.title ().startMarshallingPhaseStep (); }

	@Override
	public CollectIncomeStep getNextTask (AgotContext context) {
		return new CollectIncomeStep (game.getFirstPlayer (), game);
	} // getNextTask
	
} // StartMarhallingPhaseStep
