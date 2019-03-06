package com.motif.agot.logic.events.list;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.flow.task.IAgotTask;
import com.motif.agot.logic.events.Event;
import com.motif.agot.logic.events.IEventVisitor;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.cards.Card;

import lombok.Getter;

public class StandEvent extends Event {

	@Getter private Card<?> card;

	public StandEvent (Card<?> card, AgotGame game) {
		super (game);
		this.card = card;
	} // StandEvent

	@Override
	public IAgotTask resolveEffect (AgotContext context) {
		card.stand (context);
		game.log ().standsCard (card, context);			
		return null;
	} // resolveEffect
	
	@Override public boolean accept (IEventVisitor visitor) { return visitor.visit (this); }

} // StandEvent
