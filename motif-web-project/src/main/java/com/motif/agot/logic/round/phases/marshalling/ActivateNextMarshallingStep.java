package com.motif.agot.logic.round.phases.marshalling;

import com.motif.agot.ang.AgotText;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.round.phases.ActivateNextStep;
import com.motif.agot.logic.round.phases.Step;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;

public class ActivateNextMarshallingStep extends ActivateNextStep<IMarshallingPhaseStep> {

	public ActivateNextMarshallingStep (AgotPlayer activePlayer, AgotGame game) {
		super (activePlayer, game);
	} // ActivateNextMarshallingStep

	@Override
	public String getStepTitle () { return AgotText.title ().activateNextMarhsallingStep (); }

	@Override
	public Step<IMarshallingPhaseStep> getNextTask (AgotContext context) {
		AgotPlayer nextPlayer = getNextPlayer ();
		if (nextPlayer == null) {
			return new EndMarshallingPhaseStep (game);
		} else {
			return new CollectIncomeStep (nextPlayer, game);
		} // if - else
	} // getNextTask
	
} // ActivateNextMarshallingStep
