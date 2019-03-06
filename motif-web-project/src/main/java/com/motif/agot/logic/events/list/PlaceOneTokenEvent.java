package com.motif.agot.logic.events.list;

import com.motif.agot.ang.enums.AngToken;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.flow.task.IAgotTask;
import com.motif.agot.logic.events.Event;
import com.motif.agot.logic.events.IEventVisitor;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.cards.MarshallCard;

public class PlaceOneTokenEvent extends Event {

	private AngToken token;
	private MarshallCard<?> card;

	public PlaceOneTokenEvent (AngToken token, MarshallCard<?> card, AgotGame game) {
		super (game);
		this.token = token;
		this.card = card;
	} // PlaceOneTokenEvent

	@Override
	public IAgotTask resolveEffect (AgotContext context) {
		card.addToken (token, context);
		game.log ().placeOneToken (token, card, context);
		return null;
	} // resolveEffect

	@Override public boolean accept (IEventVisitor visitor) { return visitor.visit (this); }

} // PlaceOneTokenEvent
