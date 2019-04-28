package com.motif.agot.logic.events.list;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.events.AgotEvent;
import com.motif.agot.logic.events.IEventVisitor;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.cards.Card;

public class KneelEvent extends AgotEvent {

	private final Card<?> card;

	public KneelEvent(Card<?> cards, AgotGame game) {
		super(game);
		this.card = cards;
	}

	@Override
	public IAgotFlowStep start(AgotContext context) {
		this.card.kneel(context);
		this.game.log().kneelsCard(this.card, context);
		return null;
	}

	@Override public boolean accept (IEventVisitor visitor) { return visitor.visit (this); }

}
