package com.motif.agot.logic.events.list;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.flow.task.IAgotTask;
import com.motif.agot.logic.events.Event;
import com.motif.agot.logic.events.IEventVisitor;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.Challenge;

public class InitiateAChallengeEvent extends Event {

	private Challenge challenge;
	public Challenge getChallenge () { return challenge; }
	
	public InitiateAChallengeEvent (Challenge challenge, AgotGame game) {
		super (game);
		this.challenge = challenge;	
	} // InitiateAChallengeEvent
	
	@Override public boolean accept (IEventVisitor visitor) { return visitor.visit (this); }

	@Override
	public IAgotTask resolveEffect (AgotContext context) {
		// TODO Auto-generated method stub
		return null;
	}
	
} // InitiateAChallengeEvent
