package motif.agot.logic.events.list;

import motif.agot.endpoint.AgotContext;
import motif.agot.flow.task.IAgotTask;
import motif.agot.logic.events.Event;
import motif.agot.logic.events.IEventVisitor;
import motif.agot.state.AgotGame;
import motif.agot.state.AgotPlayer;

public class GainNGoldEvent extends Event {

	private AgotPlayer player;
	private int goldGained;

	public GainNGoldEvent (int goldGained, AgotPlayer player, AgotGame game) {
		super (game);
		this.player = player;
		this.goldGained = goldGained;
	} // GainNGoldEvent

	@Override
	public IAgotTask resolveEffect (AgotContext context) {
		player.gainGold (goldGained, context);
		game.log ().gainsNGolds (player, goldGained, context);
		return null;
	} // resolveEffect

	@Override public boolean accept (IEventVisitor visitor) { return visitor.visit (this); }

} // GainNGoldEvent
