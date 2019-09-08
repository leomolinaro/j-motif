package com.motif.agot.logic;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.AgotRound.IHasAgotRound;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.logic.setup.AgotSetup;
import com.motif.agot.logic.setup.AgotSetup.IHasAgotSetup;
import com.motif.agot.state.AgotGame;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AgotPlay implements IHasAgotSetup, IHasAgotRound {

	private final AgotGame game;

	@Override
	public AgotSetup start (AgotContext context) {
		this.game.prepare (context);
		return new AgotSetup (this.game, this);
	} // start

	@Override
	public IAgotFlowStep after (AgotSetup setup, AgotContext context) {
		return new AgotRound (1, this.game, this);
	} // after
	
	@Override
	public IAgotFlowStep after (AgotRound round, AgotContext context) {
		if (round.getRoundNumber () < 20) {
			resetRoundCounters ();
			return new AgotRound (round.getRoundNumber () + 1, this.game, this);
		} else {
			return null;
		} // if - else
	} // after

	private void resetRoundCounters () {
		this.game.resetRoundAbilityCounter ();
		this.game.resetRoundEventCounter ();
		this.game.players ().forEach (p -> p.resetLimitedCounter ());
	} // resetRoundCounters

	@Override
	public IAgotFlowProcess getParent () {
		return null;
	} // getParent

	@Override
	public IAgotFlowStep next (AgotContext context) {
		return null;
	} // next

} // AgotPlay
