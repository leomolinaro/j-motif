package motif.agot.logic.events.list;

import motif.agot.endpoint.AgotContext;
import motif.agot.flow.task.IAgotTask;
import motif.agot.logic.events.Event;
import motif.agot.logic.events.IEventVisitor;
import motif.agot.state.AgotGame;
import motif.agot.state.AgotPlayer;

public class DrawNCardsEvent extends Event {

	private int n;
	private AgotPlayer player;

	public DrawNCardsEvent (int n, AgotPlayer player, AgotGame game) {
		super (game);
		this.n = n;
		this.player = player;
	} // DrawNCardsEvent

	@Override
	public IAgotTask resolveEffect (AgotContext context) {
		int nCards = Math.min (player.drawDeckSize (), n);
		for (int i = 0; i < nCards; i++) { player.draw (context); }
		game.log ().drawsNCards (player, nCards, context);
		return null;
	} // resolveEffect

	@Override public boolean accept (IEventVisitor visitor) { return visitor.visit (this); }

} // DrawNCardsEvent
