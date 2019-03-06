package com.motif.agot.logic.events;

import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Stream;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.text.AngInterrupt;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.flow.request.AgotRequest;
import com.motif.agot.flow.request.AgotResponse;
import com.motif.agot.flow.request.AgotRequest.AgotChoice;
import com.motif.agot.flow.request.AgotRequest.AgotRequestCod;
import com.motif.agot.flow.task.AgotComplexTask;
import com.motif.agot.flow.task.AgotHumanTask;
import com.motif.agot.flow.task.IAgotTask;
import com.motif.agot.logic.act.InterruptAct;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;
import com.motif.agot.state.cards.TextCard;

public class InterruptWindow extends AgotComplexTask {

	private Event event;
	private AgotGame game;
	private int nPasses = 0;

	private HashMap<Long, HashSet<AngInterrupt>> interruptsDoneByCard = new HashMap<Long, HashSet<AngInterrupt>> ();
	
	public InterruptWindow (Event event, AgotGame game) {
		this.event = event;
		this.game = game;
	} // InterruptWindow

	@Override
	public IAgotTask getStart (AgotContext context) {
		return new PlayerInterruptWindow (game.getFirstPlayer ());
	} // getStart

	@Override
	public IAgotTask getNextTask (AgotContext context) {
		return new EffectWindow (event, game);
	} // getNextTask
	
	private class PlayerInterruptWindow extends AgotComplexTask {

		public PlayerInterruptWindow (AgotPlayer player) {
			this.player = player;
		} // PlayerInterruptWindow
		
		private AgotPlayer player;
		private boolean hasPassed;
		
		@Override
		public IAgotTask getStart (AgotContext context) {
			Stream<InterruptAct> availableInterrupts = player.interactingCards ()
			.filter (card -> card.hasInterrupt ())
			.filter (card -> {
				HashSet<AngInterrupt> interruptsDone = interruptsDoneByCard.get (card.getId ());
				AngInterrupt interrupt = card.getInterrupt ();
				return interruptsDone == null || !interruptsDone.contains (interrupt);
			})
			.map (card -> new InterruptAct (event, card.getInterrupt (), card, player, game))
			.filter (interruptAct -> interruptAct.canBeInitiated () && interruptAct.canBePaid ());
			return new PlayerInterruptRequest (availableInterrupts);
		} // getStart
		
		@Override
		public PlayerInterruptWindow getNextTask (AgotContext context) {
			if (hasPassed) {
				nPasses++;
				if (nPasses == game.getNumPlayers ()) { return null; }
			} else {
				nPasses = 0;
			} // if - else
			return new PlayerInterruptWindow (player.getNextPlayer ());
		} // getNextTask

		public class PlayerInterruptRequest extends AgotHumanTask {

			private Stream<InterruptAct> availableInterrupts;
			private AgotRequest<InterruptAct> pendingRequest;
			
			public PlayerInterruptRequest (Stream<InterruptAct> availableInterrupts) {
				this.availableInterrupts = availableInterrupts;
			} // PlayerInterruptRequest

			@Override
			public IAgotTask receiveResponse (AgotResponse response, AgotContext context) {
				AgotChoice<InterruptAct> choice = pendingRequest.getChoice (response);
				if (choice.isPass ()) {
					hasPassed = true; 
					return null;
				} else {
					hasPassed = false;
					InterruptAct interruptAct = choice.getModel ();
					TextCard<?> interruptingCard = interruptAct.getTrigCard ();
					AngInterrupt interrupt = interruptAct.getTrigAbility ();
					HashSet<AngInterrupt> interruptsDone = interruptsDoneByCard.get (interruptingCard.getId ());
					if (interruptsDone == null) { interruptsDone = new HashSet<AngInterrupt> (); interruptsDoneByCard.put (interruptingCard.getId (), interruptsDone); }
					interruptsDone.add (interrupt);
					return interruptAct;
				} // if - else
			} // receiveResponse

			@Override
			public AgotRequest<?> getRequest (AgotContext context) {
				pendingRequest = AgotRequest.createRequest (AgotRequestCod.SELECT_INTERRUPT_TO_PERFORM, player, availableInterrupts, AgotText.request ().selectInterruptToPerform (player));
				pendingRequest.addPassOption ();
				return pendingRequest;
			} // getRequest
			
		} // PlayerInterruptRequest
		
	} // PlayerInterruptWindow

} // InterruptWindow
