package com.motif.agot.logic.phases;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.events.AgotEventProcess;
import com.motif.agot.logic.events.IAgotHasEventProcess;
import com.motif.agot.logic.events.list.PhaseEndsEvent;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.logic.requests.ContinueRequest;
import com.motif.agot.logic.requests.ContinueRequest.IHasContinueRequest;
import com.motif.agot.state.AgotGame;

public abstract class AEndPhaseStep<S extends IStep> extends APhaseStep<S> implements IAgotHasEventProcess, IHasContinueRequest {

	private final AngPhase phase;
	
	public AEndPhaseStep(AngPhase phase, AgotGame game) {
		super(game);
		this.phase = phase;
	}

	@Override
	protected IAgotFlowStep stepStart(AgotContext context) {
		var event = new PhaseEndsEvent(this.phase, this.game);
		return new AgotEventProcess(event, this.game, this);
	}

	@Override
	public IAgotFlowStep after(AgotEventProcess round, AgotContext context) {
		var firstPlayer = this.game.firstPlayer();
		return new ContinueRequest(AgotText.request().endPhase(phase, firstPlayer), firstPlayer, this);
	}

	@Override
	public IAgotFlowStep after(ContinueRequest continueDecision, AgotContext context) {
		return null;
	}
	
}
