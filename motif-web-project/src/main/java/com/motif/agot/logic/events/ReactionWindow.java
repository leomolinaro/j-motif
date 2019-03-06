package com.motif.agot.logic.events;

import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Stream;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.text.AngReaction;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.flow.request.AgotRequest;
import com.motif.agot.flow.request.AgotResponse;
import com.motif.agot.flow.request.AgotRequest.AgotChoice;
import com.motif.agot.flow.request.AgotRequest.AgotRequestCod;
import com.motif.agot.flow.task.AgotComplexTask;
import com.motif.agot.flow.task.AgotHumanTask;
import com.motif.agot.flow.task.IAgotTask;
import com.motif.agot.logic.act.ReactionAct;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;
import com.motif.agot.state.cards.TextCard;

public class ReactionWindow extends AgotComplexTask {

	private Event event;
	private AgotGame game;
	private int nPasses = 0;

	private HashMap<Long, HashSet<AngReaction>> reactionsDoneByCard = new HashMap<Long, HashSet<AngReaction>> ();
	
	public ReactionWindow (Event event, AgotGame game) {
		this.event = event;
		this.game = game;
	} // ReactionWindow

	@Override
	public IAgotTask getStart (AgotContext context) {
		return new PlayerReactionWindow (game.getFirstPlayer ());
	} // getStart

	@Override
	public IAgotTask getNextTask (AgotContext context) {
		return null;
	} // getNextTask
	
	public class PlayerReactionWindow extends AgotComplexTask {

		public PlayerReactionWindow (AgotPlayer player) {
			this.player = player;
		} // PlayerReactionWindow
		
		private AgotPlayer player;
		private boolean hasPassed;
		
		@Override
		public IAgotTask getStart (AgotContext context) {
			Stream<ReactionAct> availableReactions = player.interactingCards ()
			.filter (card -> card.hasReaction ())
			.filter (card -> {
				HashSet<AngReaction> reactionsDone = reactionsDoneByCard.get (card.getId ());
				AngReaction reaction = card.getReaction ();
				return reactionsDone == null || !reactionsDone.contains (reaction);
			})
			.map (card -> new ReactionAct (event, card.getReaction (), card, player, game))
			.filter (reactionStep -> reactionStep.canBeInitiated () && reactionStep.canBePaid ());
			return new PlayerReactionRequest (availableReactions);
		} // getStart
		
		@Override
		public PlayerReactionWindow getNextTask (AgotContext context) {
			if (hasPassed) {
				nPasses++;
				if (nPasses == game.getNumPlayers ()) { return null; }
			} else {
				nPasses = 0;
			} // if - else
			return new PlayerReactionWindow (player.getNextPlayer ());
		} // getNextTask

		public class PlayerReactionRequest extends AgotHumanTask {

			private Stream<ReactionAct> availableReactions;
			private AgotRequest<ReactionAct> pendingRequest;
			
			public PlayerReactionRequest (Stream<ReactionAct> availableReactions) {
				this.availableReactions = availableReactions;
			} // PlayerReactionRequest

			@Override
			public IAgotTask receiveResponse (AgotResponse response, AgotContext context) {
				AgotChoice<ReactionAct> choice = pendingRequest.getChoice (response);
				if (choice.isPass ()) {
					hasPassed = true; 
					return null;
				} else {
					hasPassed = false;
					ReactionAct reactingStep = choice.getModel ();
					TextCard<?> reactingCard = reactingStep.getTrigCard ();
					AngReaction reaction = reactingStep.getTrigAbility ();
					HashSet<AngReaction> reactionsDone = reactionsDoneByCard.get (reactingCard.getId ());
					if (reactionsDone == null) { reactionsDone = new HashSet<AngReaction> (); reactionsDoneByCard.put (reactingCard.getId (), reactionsDone); }
					reactionsDone.add (reaction);
					return reactingStep;
				} // if - else
			} // receiveResponse

			@Override
			public AgotRequest<?> getRequest (AgotContext context) {
				pendingRequest = AgotRequest.createRequest (AgotRequestCod.SELECT_REACTION_TO_PERFORM, player, availableReactions, AgotText.request ().selectReactionToPerform (player));
				pendingRequest.addPassOption ();
				return pendingRequest;
			} // getRequest
			
		} // PlayerReactionRequest
		
	} // PlayerReactionWindow

} // ReactionWindow
