package com.motif.agot.logic.events.list;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.flow.task.IAgotTask;
import com.motif.agot.logic.events.Event;
import com.motif.agot.logic.events.IEventVisitor;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;

public class GainNGoldEvent extends Event {

	private AgotPlayer player;
	private int goldGained;

	public GainNGoldEvent (int goldGained, AgotPlayer player, AgotGame game) {
		super (game);
		this.player = player;
		this.goldGained = goldGained;
	} // GainNGoldEvent

	@Override
	public IAgotTask resolveEffect (AgotContext context) {
		player.gainGold (goldGained, context);
		game.log ().gainsNGolds (player, goldGained, context);
		return null;
	} // resolveEffect

	@Override public boolean accept (IEventVisitor visitor) { return visitor.visit (this); }

} // GainNGoldEvent
