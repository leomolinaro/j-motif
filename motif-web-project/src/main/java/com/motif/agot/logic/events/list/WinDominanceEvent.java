package com.motif.agot.logic.events.list;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.flow.task.IAgotTask;
import com.motif.agot.logic.events.Event;
import com.motif.agot.logic.events.IEventVisitor;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;

import lombok.Getter;

public class WinDominanceEvent extends Event {

	@Getter private AgotPlayer winner;

	public WinDominanceEvent (AgotPlayer winner, AgotGame game) {
		super (game);
		this.winner = winner;
	} // WinDominanceEvent

	@Override
	public IAgotTask resolveEffect (AgotContext context) {
		game.log ().winsDominance (winner, context);
		winner.gainPowerOnTheFactionCard (context);
		game.log ().dominanceGainPower (winner, context);
		return null;
	} // resolveEffect

	@Override public boolean accept (IEventVisitor visitor) { return visitor.visit (this); }

} // WinDominanceEvent
