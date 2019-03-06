package com.motif.agot.logic.events.list;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.flow.task.IAgotTask;
import com.motif.agot.logic.events.Event;
import com.motif.agot.logic.events.IEventVisitor;
import com.motif.agot.logic.other.ExitGameProcedure;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.cards.MarshallCard;

import lombok.Getter;

public class DiscardFromPlayEvent extends Event {

	@Getter private MarshallCard<?> card;
	@Getter private boolean saved;
	
	public DiscardFromPlayEvent (MarshallCard<?> card, AgotGame game) {
		super (game);
		this.card = card;
	} // DiscardFromPlayEvent

	@Override
	public IAgotTask resolveEffect (AgotContext context) {
		if (card.isSaved ()) {
			this.saved = true;
			card.unsetSaved ();
		} else {
			ExitGameProcedure.discardCard (card, game, context);
			game.log ().discardsCard (card, context);			
		} // if - else
		return null;
	} // resolveEffect

	@Override public boolean accept (IEventVisitor visitor) { return visitor.visit (this); }

} // DiscardFromPlayEvent
