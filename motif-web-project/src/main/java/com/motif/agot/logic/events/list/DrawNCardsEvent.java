package com.motif.agot.logic.events.list;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.events.AgotEvent;
import com.motif.agot.logic.events.IEventVisitor;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;

public class DrawNCardsEvent extends AgotEvent {

	private final int n;
	private final AgotPlayer player;

	public DrawNCardsEvent(int n, AgotPlayer player, AgotGame game) {
		super(game);
		this.n = n;
		this.player = player;
	}

	@Override
	public IAgotFlowStep start(AgotContext context) {
		int nCards = Math.min(this.player.drawDeckSize(), this.n);
		for (int i = 0; i < nCards; i++) {
			this.player.draw(context);
		}
		this.game.log().drawsNCards(this.player, nCards, context);
		return null;
	}

	@Override public boolean accept (IEventVisitor visitor) { return visitor.visit (this); }

}
