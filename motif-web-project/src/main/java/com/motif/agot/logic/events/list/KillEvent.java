package com.motif.agot.logic.events.list;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.flow.task.IAgotTask;
import com.motif.agot.logic.events.Event;
import com.motif.agot.logic.events.IEventVisitor;
import com.motif.agot.logic.other.ExitGameProcedure;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.cards.CharacterCard;

import lombok.Getter;

public class KillEvent extends Event {

	private CharacterCard card;
	@Getter private boolean saved;

	public KillEvent (CharacterCard card, AgotGame game) {
		super (game);
		this.card = card;
	} // KillEvent

	@Override
	public IAgotTask resolveEffect (AgotContext context) {
		if (card.isSaved ()) {
			this.saved = true;
			card.unsetSaved ();
		} else {
			ExitGameProcedure.killCharacter (card, game, context);
			game.log ().killsCharacter (card, context);			
		} // if - else
		return null;
	} // resolveEffect

	@Override public boolean accept (IEventVisitor visitor) { return visitor.visit (this); }

	public boolean doesKill (CharacterCard card) { return this.card == card; }
	
} // KillEvent
