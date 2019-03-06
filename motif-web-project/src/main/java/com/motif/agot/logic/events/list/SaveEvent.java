package com.motif.agot.logic.events.list;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.flow.task.IAgotTask;
import com.motif.agot.logic.events.Event;
import com.motif.agot.logic.events.IEventVisitor;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.cards.MarshallCard;

public class SaveEvent extends Event {
	
	private MarshallCard<?> card;

	public SaveEvent (MarshallCard<?> card, AgotGame game) {
		super (game);
		this.card = card;
	} // SaveEvent

	@Override
	public IAgotTask resolveEffect (AgotContext context) {
		card.setSaved ();
		game.log ().savesCard (card, context);
		return null;
	} // resolveEffect

	@Override public boolean accept (IEventVisitor visitor) { return visitor.visit (this); }

} // SaveEvent
