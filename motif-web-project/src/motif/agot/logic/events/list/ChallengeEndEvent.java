package motif.agot.logic.events.list;

import motif.agot.endpoint.AgotContext;
import motif.agot.flow.task.IAgotTask;
import motif.agot.logic.events.Event;
import motif.agot.logic.events.IEventVisitor;
import motif.agot.state.AgotGame;

public class ChallengeEndEvent extends Event {

	public ChallengeEndEvent (AgotGame game) {
		super (game);
	} // ChallengeEndEvent

	@Override
	public IAgotTask resolveEffect (AgotContext context) {
		return null;
	} // resolveEffect

	@Override public boolean accept (IEventVisitor visitor) { return visitor.visit (this); }

} // ChallengeEndEvent
