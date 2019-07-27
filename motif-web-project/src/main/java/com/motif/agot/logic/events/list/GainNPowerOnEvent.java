package com.motif.agot.logic.events.list;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.events.AgotEvent;
import com.motif.agot.logic.events.IEventVisitor;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.cards.Card;

import lombok.Getter;

public class GainNPowerOnEvent extends AgotEvent {

	private final int n;
	@Getter final private Card<?> card;

	public GainNPowerOnEvent (int n, Card<?> card, AgotGame game) {
		super (game);
		this.n = n;
		this.card = card;
	}

	@Override
	public IAgotFlowStep start(AgotContext context) {
		this.card.gainPower(this.n, context);
		this.game.logManager().gainPower(this.card, this.n, context);
		return null;
	}

	@Override public boolean accept (IEventVisitor visitor) { return visitor.visit (this); }

}
