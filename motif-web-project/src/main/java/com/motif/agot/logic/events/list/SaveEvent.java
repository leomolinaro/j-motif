package com.motif.agot.logic.events.list;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.events.AgotEvent;
import com.motif.agot.logic.events.IEventVisitor;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.cards.MarshallCard;

public class SaveEvent extends AgotEvent {
	
	private final MarshallCard<?> card;

	public SaveEvent(MarshallCard<?> card, AgotGame game) {
		super(game);
		this.card = card;
	}

	@Override
	public IAgotFlowStep start(AgotContext context) {
		this.card.setSaved();
		this.game.logManager().savesCard(this.card, context);
		return null;
	}

	@Override public boolean accept(IEventVisitor visitor) { return visitor.visit(this); }

}
