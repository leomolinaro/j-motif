package com.motif.agot.logic.events.list;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.events.AgotEvent;
import com.motif.agot.logic.events.IEventVisitor;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.state.AgotGame;

import lombok.Getter;

public class RoundEndsEvent extends AgotEvent {

	@Getter private final int roundNumber;
	
	public RoundEndsEvent (int roundNumber, AgotGame game) {
		super (game);
		this.roundNumber = roundNumber;
	} // RoundEndsEvent

	@Override
	public IAgotFlowStep start (AgotContext context) {
		return null;
	} // start
	
	@Override public boolean accept (IEventVisitor visitor) { return visitor.visit (this); }

} // RoundEndsEvent
