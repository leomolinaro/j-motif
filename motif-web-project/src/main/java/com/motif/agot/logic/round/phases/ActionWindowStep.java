package com.motif.agot.logic.round.phases;

import java.util.stream.Stream;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.flow.request.AgotRequest;
import com.motif.agot.flow.request.AgotResponse;
import com.motif.agot.flow.request.AgotRequest.AgotChoice;
import com.motif.agot.flow.request.AgotRequest.AgotRequestCod;
import com.motif.agot.flow.task.AgotComplexTask;
import com.motif.agot.flow.task.AgotHumanTask;
import com.motif.agot.flow.task.IAgotTask;
import com.motif.agot.logic.act.Act;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;

public abstract class ActionWindowStep<S extends IStep, A extends Act> extends Step<S> {
	
	private int nPasses = 0;
	protected AngPhase phase;
	
	public ActionWindowStep (AngPhase phase, AgotGame game) {
		super (game);
		this.phase = phase;
	} // ActionWindowStep

	@Override
	public final ActionWindowPlayerStep getStartTask (AgotContext context) {
		return getPlayerStep (game, game.getFirstPlayer ());
	} // getStartTask
	
	protected abstract ActionWindowPlayerStep getPlayerStep (AgotGame game, AgotPlayer player);
	
	public abstract class ActionWindowPlayerStep extends AgotComplexTask {

		public ActionWindowPlayerStep (AgotGame game, AgotPlayer player) {
			this.game = game;
			this.player = player;
		} // ActionWindowStep
		
		protected AgotGame game;
		protected AgotPlayer player;
		private boolean hasPassed;
		
		@Override
		public final ActionWindowPlayerStep getNextTask (AgotContext context) {
			if (hasPassed) {
				nPasses++;
				if (nPasses == game.getNumPlayers ()) { return null; }
			} else {
				nPasses = 0;
			} // if - else
			return getPlayerStep (game, player.getNextPlayer ());
		} // getNextTask
		
		public final class PlayerActionRequest extends AgotHumanTask {

			private Stream<A> availableActions;
			private AgotRequest<A> pendingRequest;
			
			public PlayerActionRequest (Stream<A> availableActions) {
				this.availableActions = availableActions;
			} // PlayerActionRequest

			@Override
			public IAgotTask receiveResponse (AgotResponse response, AgotContext context) {
				AgotChoice<A> choice = pendingRequest.getChoice (response);
				if (choice.isPass ()) {
					hasPassed = true; 
					return null;
				} else {
					hasPassed = false;
					return choice.getModel ();
				} // if - else
			} // receiveResponse

			@Override
			public AgotRequest<?> getRequest (AgotContext context) {
				pendingRequest = AgotRequest.createRequest (AgotRequestCod.SELECT_ACTION_TO_PERFORM, player, availableActions, AgotText.request ().selectActionToPerform (player));
				pendingRequest.addPassOption ();
				return pendingRequest;
			} // getRequest
			
		} // PlayerActionRequest
		
	} // ActionWindowPlayerStep

} // ActionWindowStep
