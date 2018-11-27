package motif.agot.logic.round.phases;

import motif.agot.endpoint.AgotContext;
import motif.agot.flow.task.IAgotTask;
import motif.agot.state.AgotGame;
import motif.agot.state.AgotPlayer;

public abstract class ActivateNextStep<S extends IStep> extends Step<S> {

	private AgotPlayer activePlayer;
	
	private AgotPlayer nextPlayer;
	protected AgotPlayer getNextPlayer () { return this.nextPlayer; }
	
	public ActivateNextStep (AgotPlayer activePlayer, AgotGame game) {
		super (game);
		this.activePlayer = activePlayer;
	} // ActivateNextStep

	@Override
	public final IAgotTask getStartTask (AgotContext context) {
		nextPlayer = game.getNextPlayer (activePlayer);
		if (nextPlayer == game.getFirstPlayer ()) { nextPlayer = null; }
		if (nextPlayer != null) { game.log ().becomesActivePlayer (nextPlayer, context); }
		return null;
	} // getStartTask
	
} // ActivateNextStep
