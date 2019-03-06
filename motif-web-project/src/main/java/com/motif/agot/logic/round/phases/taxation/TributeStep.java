package com.motif.agot.logic.round.phases.taxation;

import com.motif.agot.ang.AgotText;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.flow.task.IAgotTask;
import com.motif.agot.logic.round.phases.Step;
import com.motif.agot.logic.round.phases.taxation.reserve.ReserveStep;
import com.motif.agot.state.AgotGame;

public class TributeStep extends Step<ITaxationPhaseStep> {

	public TributeStep (AgotGame game) {
		super (game);
	} // TributeStep

	@Override
	public String getStepTitle () { return AgotText.title ().tributeStep (); }

	@Override
	public IAgotTask getStartTask (AgotContext context) {
		game.forEachPlayer (player -> {
			int unspent = player.resetGold (context);
			game.log ().tributeDiscardGold (player, unspent, context);			
		});
		return null;
	} // getStartTask

	@Override
	public ReserveStep getNextTask (AgotContext context) {
		return new ReserveStep (game);
	} // getNextTask

} // TributeStep
