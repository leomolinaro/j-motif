package com.motif.agot.logic.round.phases.challenges.challenge;

import java.util.stream.Stream;

import com.motif.agot.ang.AgotText;
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
import com.motif.agot.logic.events.list.ChallengeEndEvent;
import com.motif.agot.logic.round.phases.Step;
import com.motif.agot.logic.round.phases.challenges.ChallengesActionStep;
import com.motif.agot.logic.round.phases.challenges.IChallengesPhaseStep;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.Challenge;

public class EndChallengeStep extends Step<IChallengesPhaseStep> {

	private Challenge data;

	public EndChallengeStep (Challenge data, AgotGame game) {
		super (game);
		this.data = data;
	} // EndChallengeStep

	@Override
	public String getStepTitle () { return AgotText.title ().endChallengeStep (); }

	@Override
	public IAgotTask getStartTask (AgotContext context) {
		return new EndEvent ();
	} // getStartTask

	@Override
	public Step<IChallengesPhaseStep> getNextTask (AgotContext context) {
		game.setChallenge (null);
		return new ChallengesActionStep (data.attacker (), game);
	} // getNextTask

	private class EndEvent extends AgotComplexTask {

		@Override
		public IAgotTask getStart (AgotContext context) {
			Event event = new ChallengeEndEvent (game);
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
			pendingRequest = AgotRequest.createRequest (AgotRequestCod.CONTINUE, game.getFirstPlayer (), Stream.empty (), AgotText.request ().endChallenge (data.attacker ()));
			pendingRequest.addContinueOption ();
			return pendingRequest;
		} // getRequest
		
	} // ContinueRequest
	
} // EndChallengeStep
