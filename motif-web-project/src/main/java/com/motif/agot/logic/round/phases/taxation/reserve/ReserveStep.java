package com.motif.agot.logic.round.phases.taxation.reserve;

import com.motif.agot.ang.AgotText;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.flow.task.IAgotTask;
import com.motif.agot.logic.round.phases.Step;
import com.motif.agot.logic.round.phases.taxation.ITaxationPhaseStep;
import com.motif.agot.logic.round.phases.taxation.TaxationActionStep;
import com.motif.agot.state.AgotGame;

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
