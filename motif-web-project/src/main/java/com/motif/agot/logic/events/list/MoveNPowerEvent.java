package com.motif.agot.logic.events.list;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.flow.task.IAgotTask;
import com.motif.agot.logic.events.Event;
import com.motif.agot.logic.events.IEventVisitor;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.cards.Card;

import lombok.Getter;

public class MoveNPowerEvent extends Event {

	private int nPower;
	@Getter private Card<?> fromCard;
	@Getter private Card<?> toCard;
	
	public MoveNPowerEvent (int nPower, Card<?> fromCard, Card<?> toCard, AgotGame game) {
		super (game);
		this.nPower = nPower;
		this.fromCard = fromCard;
		this.toCard = toCard;
	} // MoveNPowerEvent

	@Override
	public IAgotTask resolveEffect (AgotContext context) {
		fromCard.losePower (nPower, context);
		game.log ().losePower (fromCard, nPower, context);
		toCard.gainPower (nPower, context);
		game.log ().gainPower (toCard, nPower, context);
		return null;
	} // resolveEffect

	@Override public boolean accept (IEventVisitor visitor) { return visitor.visit (this); }

} // MoveNPowerEvent
