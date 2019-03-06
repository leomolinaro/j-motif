package com.motif.agot.logic.round.phases;

import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.flow.task.IAgotTask;
import com.motif.agot.logic.events.Event;
import com.motif.agot.logic.events.EventTrigger;
import com.motif.agot.logic.events.list.PhaseBeginsEvent;
import com.motif.agot.state.AgotGame;

public abstract class StartPhaseStep<S extends IStep> extends Step<S> {

	private AngPhase phase;
	
	public StartPhaseStep (AngPhase phase, AgotGame game) {
		super (game);
		this.phase = phase;
	} // StartPhaseStep

	@Override
	public final IAgotTask getStartTask (AgotContext context) {
		Event event = new PhaseBeginsEvent (phase, game);
		return EventTrigger.execute (event, game);
	} // getStartTask
	
} // StartPhaseStep
