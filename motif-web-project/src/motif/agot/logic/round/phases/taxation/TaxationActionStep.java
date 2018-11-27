package motif.agot.logic.round.phases.taxation;

import motif.agot.ang.AgotText;
import motif.agot.ang.enums.AngPhase;
import motif.agot.endpoint.AgotContext;
import motif.agot.logic.round.phases.StandardActionWindowStep;
import motif.agot.state.AgotGame;

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
