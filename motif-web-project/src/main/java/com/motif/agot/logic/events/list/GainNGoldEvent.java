package com.motif.agot.logic.events.list;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.events.AgotEvent;
import com.motif.agot.logic.events.IEventVisitor;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;

public class GainNGoldEvent extends AgotEvent {

	private final AgotPlayer player;
	private final int goldGained;

	public GainNGoldEvent(int goldGained, AgotPlayer player, AgotGame game) {
		super(game);
		this.player = player;
		this.goldGained = goldGained;
	}

	@Override
	public IAgotFlowStep start(AgotContext context) {
		this.player.gainGold(this.goldGained, context);
		this.game.logManager().gainsNGolds(this.player, this.goldGained, context);
		return null;
	}

	@Override public boolean accept (IEventVisitor visitor) { return visitor.visit (this); }

}
