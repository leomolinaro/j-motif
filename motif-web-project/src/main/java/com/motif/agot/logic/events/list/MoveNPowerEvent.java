package com.motif.agot.logic.events.list;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.events.AgotEvent;
import com.motif.agot.logic.events.IEventVisitor;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.cards.Card;

import lombok.Getter;

public class MoveNPowerEvent extends AgotEvent {

	private final int nPower;
	@Getter final private Card<?> fromCard;
	@Getter final private Card<?> toCard;
	
	public MoveNPowerEvent(int nPower, Card<?> fromCard, Card<?> toCard, AgotGame game) {
		super(game);
		this.nPower = nPower;
		this.fromCard = fromCard;
		this.toCard = toCard;
	}

	@Override
	public IAgotFlowStep start(AgotContext context) {
		this.fromCard.losePower(this.nPower, context);
		this.game.logManager().losePower(this.fromCard, this.nPower, context);
		this.toCard.gainPower(this.nPower, context);
		this.game.logManager().gainPower(this.toCard, this.nPower, context);
		return null;
	}

	@Override public boolean accept (IEventVisitor visitor) { return visitor.visit (this); }

}
