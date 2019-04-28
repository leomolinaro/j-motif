package com.motif.agot.logic.events.list;

import com.motif.agot.ang.enums.AngToken;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.events.AgotEvent;
import com.motif.agot.logic.events.IEventVisitor;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.cards.MarshallCard;

public class PlaceOneTokenEvent extends AgotEvent {

	private final AngToken token;
	private final MarshallCard<?> card;

	public PlaceOneTokenEvent (AngToken token, MarshallCard<?> card, AgotGame game) {
		super (game);
		this.token = token;
		this.card = card;
	}

	@Override
	public IAgotFlowStep start (AgotContext context) {
		card.addToken (token, context);
		game.log ().placeOneToken (token, card, context);
		return null;
	}

	@Override public boolean accept (IEventVisitor visitor) { return visitor.visit (this); }

}
