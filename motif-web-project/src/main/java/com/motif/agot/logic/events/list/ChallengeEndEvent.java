package com.motif.agot.logic.events.list;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.flow.task.IAgotTask;
import com.motif.agot.logic.events.Event;
import com.motif.agot.logic.events.IEventVisitor;
import com.motif.agot.state.AgotGame;

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
