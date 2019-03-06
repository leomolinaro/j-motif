package com.motif.agot.logic.events;

import com.motif.agot.flow.task.IAgotTask;
import com.motif.agot.state.AgotGame;

public class EventTrigger {

	public static IAgotTask execute (Event event, AgotGame game) {
		return new InterruptWindow (event, game); // new WouldInterruptWindow (event, game);
	} // trigger
	
} // EventTrigger
