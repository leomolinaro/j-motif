package com.motif.agot.logic.events;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import com.motif.agot.ang.text.AngInterrupt;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.act.InterruptAct;
import com.motif.agot.logic.act.InterruptAct.IHasInterruptAct;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.logic.requests.InterruptRequest;
import com.motif.agot.logic.requests.InterruptRequest.IHasInterruptRequest;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AgotInterruptWindow implements IHasInterruptRequest, IHasInterruptAct {

	private final AgotEvent event;
	private final AgotGame game;
	private int nPasses = 0;
	private AgotPlayer player;
	
	private HashMap<Long, HashSet<AngInterrupt>> interruptsDoneByCard = new HashMap<Long, HashSet<AngInterrupt>>();
	
	public interface IAgotHasInterruptWindow extends IAgotFlowProcess { public IAgotFlowStep after(AgotInterruptWindow interruptWindow, AgotContext context); }
	@Getter private final IAgotHasInterruptWindow parent;
	@Override public IAgotFlowStep next(AgotContext context) { return this.parent.after(this, context); }
	
	@Override
	public IAgotFlowStep start(AgotContext context) {
		this.player = this.game.firstPlayer();
		var availableInterrupts = getAvailableInterrupts();
		return new InterruptRequest(availableInterrupts, this.player, this);			
	}
	
	private List<InterruptAct> getAvailableInterrupts() {
		return this.player.interactingCards().filter(card -> card.hasInterrupt())
        .filter(card -> {
	        var interruptsDone = this.interruptsDoneByCard.get(card.id());
	        var interrupt = card.getInterrupt();
	        return interruptsDone == null || !interruptsDone.contains(interrupt);
        })
        .map(card -> new InterruptAct(this.event, card.getInterrupt(), card, this.player, this.game, this))
        .filter(interruptAct -> interruptAct.canBeInitiated() && interruptAct.canBePaid())
        .collect(Collectors.toList());
	}
	
	@Override
	public IAgotFlowStep after(InterruptRequest decision, AgotContext context) {
		var hasPassed = decision.isHasPassed();
		if (hasPassed) {
			this.nPasses++;
			if (this.nPasses == this.game.getNumPlayers()) {
				return null;
			} else {
				this.player = this.player.getNextPlayer();
				var availableInterrupts = getAvailableInterrupts();
				return new InterruptRequest(availableInterrupts, this.player, this);
			}
		} else {
			var interruptAct = decision.getChoosenModel();
			var interruptingCard = interruptAct.getTrigCard();
			var interrupt = interruptAct.getTrigAbility();
			var interruptsDone = this.interruptsDoneByCard.get(interruptingCard.id());
			if (interruptsDone == null) {
				interruptsDone = new HashSet<AngInterrupt>();
				this.interruptsDoneByCard.put(interruptingCard.id(), interruptsDone);
			}
			interruptsDone.add(interrupt);
			this.nPasses = 0;
			return interruptAct;
		}
	}

	@Override
	public IAgotFlowStep after(InterruptAct interruptAct, AgotContext context) {
		this.player = this.player.getNextPlayer();
		var availableInterrupts = getAvailableInterrupts();
		return new InterruptRequest(availableInterrupts, this.player, this);
	}
	
}
