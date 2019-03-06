package com.motif.agot.logic.round.phases;

import java.util.stream.Stream;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.flow.request.AgotRequest;
import com.motif.agot.flow.request.AgotResponse;
import com.motif.agot.flow.request.IAgotModel;
import com.motif.agot.flow.request.AgotRequest.AgotRequestCod;
import com.motif.agot.flow.task.AgotComplexTask;
import com.motif.agot.flow.task.AgotHumanTask;
import com.motif.agot.flow.task.IAgotTask;
import com.motif.agot.logic.events.Event;
import com.motif.agot.logic.events.EventTrigger;
import com.motif.agot.logic.events.list.PhaseEndsEvent;
import com.motif.agot.state.AgotGame;

public abstract class EndPhaseStep<S extends IStep> extends Step<S> {

	private AngPhase phase;
	
	public EndPhaseStep (AngPhase phase, AgotGame game) {
		super (game);
		this.phase = phase;
	} // EndPhaseStep

	@Override
	public IAgotTask getStartTask (AgotContext context) {
		return new EndEvent ();
	} // getStartTask

	@Override
	public Step<S> getNextTask (AgotContext context) { return null; }
	
	private class EndEvent extends AgotComplexTask {

		@Override
		public IAgotTask getStart (AgotContext context) {
			Event event = new PhaseEndsEvent (phase, game);
			return EventTrigger.execute (event, game);
		} // getStart

		@Override
		public IAgotTask getNextTask (AgotContext context) {
			return new ContinueRequest ();
		} // getNextTask
		
	} // EndEvent
	
	private class ContinueRequest extends AgotHumanTask {

		private AgotRequest<IAgotModel> pendingRequest;

		@Override
		public IAgotTask receiveResponse (AgotResponse response, AgotContext context) {
			return null;
		} // receiveResponse

		@Override
		public AgotRequest<IAgotModel> getRequest (AgotContext context) {
			pendingRequest = AgotRequest.createRequest (AgotRequestCod.CONTINUE, game.getFirstPlayer (), Stream.empty (), AgotText.request ().endPhase (phase, game.getFirstPlayer ()));
			pendingRequest.addContinueOption ();
			return pendingRequest;
		} // getRequest
		
	} // ContinueRequest
	
} // EndPhaseStep
