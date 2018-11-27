package motif.agot.logic.events;

import motif.agot.endpoint.AgotContext;
import motif.agot.flow.task.IAgotTask;
import motif.agot.state.AgotGame;

public abstract class Event {

	protected AgotGame game;
	
	public Event (AgotGame game) {
		this.game = game;
	} // Event
	
	public abstract IAgotTask resolveEffect (AgotContext context);

	public abstract boolean accept (IEventVisitor visitor);
	
} // Event
