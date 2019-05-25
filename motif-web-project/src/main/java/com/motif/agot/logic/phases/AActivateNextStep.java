package com.motif.agot.logic.phases;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;

import lombok.Getter;

public abstract class AActivateNextStep<S extends IStep> extends APhaseStep<S> {

	@Getter private AgotPlayer activePlayer;
	
	public AActivateNextStep(AgotPlayer activePlayer, AgotGame game) {
		super(game);
		this.activePlayer = activePlayer;
	}

	@Override
	public final IAgotFlowStep stepStart(AgotContext context) {
		var prevPlayer = this.activePlayer;
		if (prevPlayer == null) {
			this.activePlayer = this.game.getFirstPlayer();
			this.activePlayer.setActive();
			this.game.log().becomesActivePlayer(this.activePlayer, context);
		} else {
			var nextPlayer = this.game.getNextPlayer(prevPlayer);
			if (nextPlayer == this.game.getFirstPlayer()) {
				this.activePlayer = null;
			} else {
				nextPlayer.setActive();
				this.game.log().becomesActivePlayer(nextPlayer, context);
				this.activePlayer = nextPlayer;
			}
			prevPlayer.setInactive();
		}
		return null;
	}
	
}
