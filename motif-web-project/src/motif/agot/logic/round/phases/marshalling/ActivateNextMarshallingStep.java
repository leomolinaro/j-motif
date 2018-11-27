package motif.agot.logic.round.phases.marshalling;

import motif.agot.ang.AgotText;
import motif.agot.endpoint.AgotContext;
import motif.agot.logic.round.phases.ActivateNextStep;
import motif.agot.logic.round.phases.Step;
import motif.agot.state.AgotGame;
import motif.agot.state.AgotPlayer;

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
