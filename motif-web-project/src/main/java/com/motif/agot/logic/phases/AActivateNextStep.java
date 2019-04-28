package com.motif.agot.logic.phases;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;

import lombok.Getter;

public abstract class AActivateNextStep<S extends IStep> extends APhaseStep<S> {

	private AgotPlayer activePlayer;
	
	@Getter private AgotPlayer nextPlayer;
	
	public AActivateNextStep (AgotPlayer activePlayer, AgotGame game) {
		super (game);
		this.activePlayer = activePlayer;
	}

	@Override
	public final IAgotFlowStep stepStart(AgotContext context) {
		this.nextPlayer = this.game.getNextPlayer(this.activePlayer);
		if (this.nextPlayer == this.game.getFirstPlayer()) { this.nextPlayer = null; }
		if (this.nextPlayer != null) { this.game.log().becomesActivePlayer(this.nextPlayer, context); }
		return null;
	}
	
}
