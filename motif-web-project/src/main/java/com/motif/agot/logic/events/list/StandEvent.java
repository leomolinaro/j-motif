package com.motif.agot.logic.events.list;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.events.AgotEvent;
import com.motif.agot.logic.events.IEventVisitor;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.cards.Card;

import lombok.Getter;

public class StandEvent extends AgotEvent {

	@Getter private final Card<?> card;

	public StandEvent(Card<?> card, AgotGame game) {
		super(game);
		this.card = card;
	}

	@Override
	public IAgotFlowStep start(AgotContext context) {
		card.stand(context);
		game.log().standsCard(card, context);
		return null;
	}
	
	@Override public boolean accept(IEventVisitor visitor) { return visitor.visit(this); }

}
