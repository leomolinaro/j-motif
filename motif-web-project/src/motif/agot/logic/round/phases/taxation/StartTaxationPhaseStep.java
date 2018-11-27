package motif.agot.logic.round.phases.taxation;

import motif.agot.ang.AgotText;
import motif.agot.ang.enums.AngPhase;
import motif.agot.endpoint.AgotContext;
import motif.agot.logic.round.phases.StartPhaseStep;
import motif.agot.state.AgotGame;

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
