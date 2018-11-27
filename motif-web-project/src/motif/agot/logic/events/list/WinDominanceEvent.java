package motif.agot.logic.events.list;

import lombok.Getter;
import motif.agot.endpoint.AgotContext;
import motif.agot.flow.task.IAgotTask;
import motif.agot.logic.events.Event;
import motif.agot.logic.events.IEventVisitor;
import motif.agot.state.AgotGame;
import motif.agot.state.AgotPlayer;

public class WinDominanceEvent extends Event {

	@Getter private AgotPlayer winner;

	public WinDominanceEvent (AgotPlayer winner, AgotGame game) {
		super (game);
		this.winner = winner;
	} // WinDominanceEvent

	@Override
	public IAgotTask resolveEffect (AgotContext context) {
		game.log ().winsDominance (winner, context);
		winner.gainPowerOnTheFactionCard (context);
		game.log ().dominanceGainPower (winner, context);
		return null;
	} // resolveEffect

	@Override public boolean accept (IEventVisitor visitor) { return visitor.visit (this); }

} // WinDominanceEvent
