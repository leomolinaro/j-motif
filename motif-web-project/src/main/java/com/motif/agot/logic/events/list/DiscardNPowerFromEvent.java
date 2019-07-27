package com.motif.agot.logic.events.list;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.events.AgotEvent;
import com.motif.agot.logic.events.IEventVisitor;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.cards.Card;

public class DiscardNPowerFromEvent extends AgotEvent {
	
	private final int n;
	private final Card<?> card;

	public DiscardNPowerFromEvent(int n, Card<?> card, AgotGame game) {
		super(game);
		this.n = n;
		this.card = card;
	}

	@Override
	public IAgotFlowStep start(AgotContext context) {
		var toDiscard = Math.max(this.card.power(), this.n);
		this.card.losePower(toDiscard, context);
		this.game.logManager().losePower(this.card, toDiscard, context);
		return null;
	}

	@Override public boolean accept (IEventVisitor visitor) { return visitor.visit(this); }

}
