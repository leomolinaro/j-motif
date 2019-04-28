package com.motif.agot.logic.events.list;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.events.AgotEvent;
import com.motif.agot.logic.events.IEventVisitor;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.Challenge;

import lombok.Getter;

public class InitiateAChallengeEvent extends AgotEvent {

	@Getter private final Challenge challenge;
	
	public InitiateAChallengeEvent(Challenge challenge, AgotGame game) {
		super(game);
		this.challenge = challenge;
	}
	
	@Override public boolean accept (IEventVisitor visitor) { return visitor.visit (this); }

	@Override
	public IAgotFlowStep start(AgotContext context) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
