package motif.agot.logic.round.phases;

import java.util.stream.Stream;

import motif.agot.ang.AgotText;
import motif.agot.ang.enums.AngPhase;
import motif.agot.endpoint.AgotContext;
import motif.agot.flow.request.AgotRequest;
import motif.agot.flow.request.AgotRequest.AgotRequestCod;
import motif.agot.flow.request.AgotResponse;
import motif.agot.flow.request.IAgotModel;
import motif.agot.flow.task.AgotComplexTask;
import motif.agot.flow.task.AgotHumanTask;
import motif.agot.flow.task.IAgotTask;
import motif.agot.logic.events.Event;
import motif.agot.logic.events.EventTrigger;
import motif.agot.logic.events.list.PhaseEndsEvent;
import motif.agot.state.AgotGame;

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
