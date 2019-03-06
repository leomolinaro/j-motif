package com.motif.agot.logic.events.list;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.flow.task.IAgotTask;
import com.motif.agot.logic.events.Event;
import com.motif.agot.logic.events.IEventVisitor;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.cards.DrawCard;

import lombok.Getter;

public class ReturnToYourHandEvent extends Event {
	
	@Getter private DrawCard<?> card;
	
	public ReturnToYourHandEvent (DrawCard<?> card, AgotGame game) {
		super (game);
		this.card = card;
	} // ReturnToYourHandEvent

	@Override
	public IAgotTask resolveEffect (AgotContext context) {
		// TODO return to your hand
		return null;
	} // resolveEffect
	
	@Override public boolean accept (IEventVisitor visitor) { return visitor.visit (this); }

} // ReturnToYourHandEvent
