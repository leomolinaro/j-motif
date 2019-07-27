package com.motif.agot.logic.events.list;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.events.AgotEvent;
import com.motif.agot.logic.events.IEventVisitor;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.logic.other.ExitGameProcedure;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.cards.MarshallCard;

import lombok.Getter;

public class DiscardFromPlayEvent extends AgotEvent {

	@Getter private final MarshallCard<?> card;
	@Getter private boolean saved;
	
	public DiscardFromPlayEvent(MarshallCard<?> card, AgotGame game) {
		super(game);
		this.card = card;
	}

	@Override
	public IAgotFlowStep start(AgotContext context) {
		if (this.card.isSaved()) {
			this.saved = true;
			card.unsetSaved();
		} else {
			ExitGameProcedure.discardCard(card, game, context);
			game.logManager().discardsCard(card, context);
		}
		return null;
	}

	@Override public boolean accept(IEventVisitor visitor) { return visitor.visit(this); }

}
