package com.motif.agot.logic.act;

import com.motif.agot.ang.text.AngInterrupt;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.events.AgotEvent;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.logic.other.AbilityContext;
import com.motif.agot.logic.requests.AgotChoice;
import com.motif.agot.logic.requests.AgotChoice.AgotChoiceCardAction;
import com.motif.agot.logic.visitors.TriggerChecker;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;
import com.motif.agot.state.cards.TextCard;
import com.motif.shared.util.MotifConsole;

import lombok.Getter;

public final class InterruptAct extends TrigAbilityAct<AngInterrupt> {

	private AgotEvent event;

	public InterruptAct(AgotEvent event, AngInterrupt interrupt, TextCard<?> interruptingCard,
	        AgotPlayer interruptingPlayer, AgotGame game, IHasInterruptAct parent) {
		super(interrupt, new AbilityContext(interruptingCard, interruptingPlayer), game);
		this.event = event;
		this.parent = parent;
	}
	
	public interface IHasInterruptAct extends IAgotFlowProcess { public IAgotFlowStep after(InterruptAct interruptAct, AgotContext context); }
	@Getter private final IHasInterruptAct parent;
	@Override public IAgotFlowStep next(AgotContext context) { return this.parent.after(this, context); }

	@Override
	public String toString() { return MotifConsole.format ("Interrupt {0}", ac.thisCard.getTitle ()); }

	@Override
	public boolean canBeInitiated() {
		boolean canBeInitiated = super.canBeInitiated();
		if (!canBeInitiated) {
			return false;
		}
		if (!TriggerChecker.canTrigger(event, trigAbility.getWhen(), ac.thisCard, ac.you, game)) {
			return false;
		}
		return true;
	}

	@Override
	public AgotChoice getChoice() {
		return AgotChoice.selectCardActionChoice(this.getTrigCard(), AgotChoiceCardAction.INTERRUPT);
	}
	
}
