package com.motif.agot.logic.events.list;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.events.AgotEvent;
import com.motif.agot.logic.events.IEventVisitor;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.logic.other.ExitGameProcedure;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.cards.CharacterCard;

import lombok.Getter;

public class KillEvent extends AgotEvent {

	private final CharacterCard card;
	@Getter private boolean saved;

	public KillEvent(CharacterCard card, AgotGame game) {
		super(game);
		this.card = card;
	}

	@Override
	public IAgotFlowStep start(AgotContext context) {
		if (card.isSaved()) {
			this.saved = true;
			this.card.unsetSaved();
		} else {
			ExitGameProcedure.killCharacter(this.card, this.game, context);
			this.game.log().killsCharacter(this.card, context);
		}
		return null;
	}

	@Override
	public boolean accept(IEventVisitor visitor) {
		return visitor.visit(this);
	}

	public boolean doesKill(CharacterCard card) {
		return this.card == card;
	}

}
