package com.motif.agot.logic.events.list;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.events.AgotEvent;
import com.motif.agot.logic.events.IEventVisitor;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.cards.DrawCard;

import lombok.Getter;

public class ReturnToYourHandEvent extends AgotEvent {
	
	@Getter private final DrawCard<?> card;
	
	public ReturnToYourHandEvent (DrawCard<?> card, AgotGame game) {
		super (game);
		this.card = card;
	}

	@Override
	public IAgotFlowStep start (AgotContext context) {
		// TODO return to your hand
		return null;
	}
	
	@Override public boolean accept (IEventVisitor visitor) { return visitor.visit (this); }

}
