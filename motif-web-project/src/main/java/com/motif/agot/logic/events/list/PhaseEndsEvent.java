package com.motif.agot.logic.events.list;

import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.events.AgotEvent;
import com.motif.agot.logic.events.IEventVisitor;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.state.AgotGame;

import lombok.Getter;

public class PhaseEndsEvent extends AgotEvent {

	@Getter private final AngPhase phase;
	
	public PhaseEndsEvent (AngPhase phase, AgotGame game) {
		super (game);
		this.phase = phase;
	}

	@Override
	public IAgotFlowStep start (AgotContext context) {
		game.removeDelayedEffects ();
		return null;
	}
	
	@Override public boolean accept (IEventVisitor visitor) { return visitor.visit (this); }

}
