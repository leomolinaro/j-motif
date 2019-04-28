package com.motif.agot.logic.phases;

import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.events.AgotEventProcess;
import com.motif.agot.logic.events.IAgotHasEventProcess;
import com.motif.agot.logic.events.AgotEvent;
import com.motif.agot.logic.events.list.PhaseBeginsEvent;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.state.AgotGame;

public abstract class AStartPhaseStep<S extends IStep> extends APhaseStep<S> implements IAgotHasEventProcess {

	private final AngPhase phase;
	
	public AStartPhaseStep(AngPhase phase, AgotGame game) {
		super(game);
		this.phase = phase;
	}

	@Override
	public final IAgotFlowStep stepStart(AgotContext context) {
		AgotEvent event = new PhaseBeginsEvent(phase, game);
		return new AgotEventProcess(event, game, this);
	}
	
	@Override
	public final IAgotFlowStep after(AgotEventProcess eventProcess, AgotContext context) {
		return null;
	}
	
}
