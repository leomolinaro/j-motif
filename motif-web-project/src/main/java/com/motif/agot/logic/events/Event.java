package com.motif.agot.logic.events;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.flow.task.IAgotTask;
import com.motif.agot.state.AgotGame;

public abstract class Event {

	protected AgotGame game;
	
	public Event (AgotGame game) {
		this.game = game;
	} // Event
	
	public abstract IAgotTask resolveEffect (AgotContext context);

	public abstract boolean accept (IEventVisitor visitor);
	
} // Event
