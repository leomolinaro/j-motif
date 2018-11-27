package motif.agot.logic.events;

import motif.agot.flow.task.IAgotTask;
import motif.agot.state.AgotGame;

public class EventTrigger {

	public static IAgotTask execute (Event event, AgotGame game) {
		return new InterruptWindow (event, game); // new WouldInterruptWindow (event, game);
	} // trigger
	
} // EventTrigger
