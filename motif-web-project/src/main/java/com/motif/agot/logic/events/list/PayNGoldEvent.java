package com.motif.agot.logic.events.list;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.flow.task.IAgotTask;
import com.motif.agot.logic.events.Event;
import com.motif.agot.logic.events.IEventVisitor;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;

public class PayNGoldEvent extends Event {

	private int n;
	private AgotPlayer player;

	public PayNGoldEvent (int n, AgotPlayer player, AgotGame game) {
		super (game);
		this.n = n;
		this.player = player;
	} // StandEvent

	@Override
	public IAgotTask resolveEffect (AgotContext context) {
		player.payGold (n, context);
		game.log ().paysNGold (player, n, context);
		return null;
	} // resolveEffect
	
	@Override public boolean accept (IEventVisitor visitor) { return visitor.visit (this); }

} // PayNGoldEvent