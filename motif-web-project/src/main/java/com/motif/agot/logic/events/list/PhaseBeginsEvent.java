package com.motif.agot.logic.events.list;

import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.events.AgotEvent;
import com.motif.agot.logic.events.IEventVisitor;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.state.AgotGame;

import lombok.Getter;

public class PhaseBeginsEvent extends AgotEvent {

	@Getter private final AngPhase phase;

	public PhaseBeginsEvent (AngPhase phase, AgotGame game) {
		super (game);
		this.phase = phase;
	}

	@Override
	public IAgotFlowStep start (AgotContext context) {
		game.initPhaseCounters ();
		return null;
	}

	@Override public boolean accept (IEventVisitor visitor) { return visitor.visit (this); }

}
