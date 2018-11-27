package motif.agot.logic.round.phases.taxation.reserve;

import motif.agot.ang.AgotText;
import motif.agot.endpoint.AgotContext;
import motif.agot.flow.task.IAgotTask;
import motif.agot.logic.round.phases.Step;
import motif.agot.logic.round.phases.taxation.ITaxationPhaseStep;
import motif.agot.logic.round.phases.taxation.TaxationActionStep;
import motif.agot.state.AgotGame;

public class ReserveStep extends Step<ITaxationPhaseStep> {

	public ReserveStep (AgotGame game) {
		super (game);
	} // ReserveStep

	@Override
	public String getStepTitle () { return AgotText.title ().reserveStep (); }

	@Override
	public IAgotTask getStartTask (AgotContext context) {
		return new CheckPlayerReserve (game.getFirstPlayer (), game);
	} // getStartTask

	@Override
	public TaxationActionStep getNextTask (AgotContext context) {
		return new TaxationActionStep (game);
	} // getNextTask

} // ReserveStep
