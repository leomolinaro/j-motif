package com.motif.agot.logic.events.list;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.flow.task.IAgotTask;
import com.motif.agot.logic.events.Event;
import com.motif.agot.logic.events.IEventVisitor;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.cards.Card;

public class DiscardNPowerFromEvent extends Event {
	
	private int n;
	private Card<?> card;

	public DiscardNPowerFromEvent (int n, Card<?> card, AgotGame game) {
		super (game);
		this.n = n;
		this.card = card;
	} // DiscardNPowerFromEvent

	@Override
	public IAgotTask resolveEffect (AgotContext context) {
		int toDiscard = Math.max (card.getPower (), n);
		card.losePower (toDiscard, context);
		game.log ().losePower (card, toDiscard, context);
		return null;
	} // resolveEffect

	@Override public boolean accept (IEventVisitor visitor) { return visitor.visit (this); }

} // DiscardNPowerFromEvent