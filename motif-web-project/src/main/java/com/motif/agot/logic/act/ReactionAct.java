package com.motif.agot.logic.act;

import com.motif.agot.ang.text.AngReaction;
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

public final class ReactionAct extends TrigAbilityAct<AngReaction> {

	private final AgotEvent event;
	
	public interface IHasReactionAct extends IAgotFlowProcess { public IAgotFlowStep after(ReactionAct reactionAct, AgotContext context); }
	@Getter private final IHasReactionAct parent;
	@Override public IAgotFlowStep next(AgotContext context) { return this.parent.after(this, context); }

	public ReactionAct(AgotEvent event, AngReaction reaction, TextCard<?> reactingCard, AgotPlayer reactingPlayer,
	        AgotGame game, IHasReactionAct parent) {
		super(reaction, new AbilityContext(reactingCard, reactingPlayer), game);
		this.event = event;
		this.parent = parent;
	} // ReactionStep

	@Override
	public String toString() { return MotifConsole.format ("Reaction {0}", ac.thisCard.getTitle ()); }

	@Override
	public boolean canBeInitiated () {
		boolean canBeInitiated = super.canBeInitiated ();
		if (!canBeInitiated) { return false; }
		if (!TriggerChecker.canTrigger (event, trigAbility.getAfter (), ac.thisCard, ac.you, game)) { return false; }
		return true;
	}
	
	@Override
	public AgotChoice getChoice() {
		return AgotChoice.selectCardActionChoice(this.getTrigCard(), AgotChoiceCardAction.REACTION);
	}

} // ReactionAct
