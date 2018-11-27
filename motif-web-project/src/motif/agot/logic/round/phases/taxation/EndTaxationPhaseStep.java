package motif.agot.logic.round.phases.taxation;

import motif.agot.ang.AgotText;
import motif.agot.ang.enums.AngPhase;
import motif.agot.logic.round.phases.EndPhaseStep;
import motif.agot.state.AgotGame;

public class EndTaxationPhaseStep extends EndPhaseStep<ITaxationPhaseStep> {

	public EndTaxationPhaseStep (AgotGame game) {
		super (AngPhase.TAXATION, game);
	} // EndTaxationPhaseStep

	@Override
	public String getStepTitle () { return AgotText.title ().endTaxationPhaseStep (); }
	
} // EndTaxationPhaseStep
