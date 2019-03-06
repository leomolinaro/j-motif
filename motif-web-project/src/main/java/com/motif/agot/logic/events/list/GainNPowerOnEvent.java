package com.motif.agot.logic.events.list;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.flow.task.IAgotTask;
import com.motif.agot.logic.events.Event;
import com.motif.agot.logic.events.IEventVisitor;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.cards.Card;

import lombok.Getter;

public class GainNPowerOnEvent extends Event {

	private int n;
	@Getter private Card<?> card;

	public GainNPowerOnEvent (int n, Card<?> card, AgotGame game) {
		super (game);
		this.n = n;
		this.card = card;
	} // GainNPowerOnEvent

	@Override
	public IAgotTask resolveEffect (AgotContext context) {
		card.gainPower (n, context);
		game.log ().gainPower (card, n, context);
		return null;
	} // resolveEffect

	@Override public boolean accept (IEventVisitor visitor) { return visitor.visit (this); }

} // GainNPowerOnEvent
