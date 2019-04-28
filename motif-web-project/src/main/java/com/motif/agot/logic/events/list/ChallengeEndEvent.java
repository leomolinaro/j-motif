package com.motif.agot.logic.events.list;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.events.AgotEvent;
import com.motif.agot.logic.events.IEventVisitor;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.state.AgotGame;

public class ChallengeEndEvent extends AgotEvent {

	public ChallengeEndEvent(AgotGame game) {
		super(game);
	}

	@Override
	public IAgotFlowStep start(AgotContext context) {
		return null;
	}

	@Override public boolean accept (IEventVisitor visitor) { return visitor.visit (this); }

}
