package com.motif.agot.logic.act;

import com.motif.agot.ang.text.AngReaction;
import com.motif.agot.flow.request.IAgotModelVisitor;
import com.motif.agot.logic.events.Event;
import com.motif.agot.logic.other.AbilityContext;
import com.motif.agot.logic.visitors.TriggerChecker;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;
import com.motif.agot.state.cards.TextCard;
import com.motif.shared.util.MotifConsole;

public final class ReactionAct extends TrigAbilityAct<AngReaction> {

	private Event event;
	
	public ReactionAct (Event event, AngReaction reaction, TextCard<?> reactingCard, AgotPlayer reactingPlayer, AgotGame game) {
		super (reaction, new AbilityContext (reactingCard, reactingPlayer), game);
		this.event = event;
	} // ReactionStep

	@Override
	public String getLabel () { return MotifConsole.format ("Reaction {0}", ac.thisCard.getTitle ()); }

	@Override
	public void accept (IAgotModelVisitor visitor) { visitor.visit (this); }

	@Override
	public boolean canBeInitiated () {
		boolean canBeInitiated = super.canBeInitiated ();
		if (!canBeInitiated) { return false; }
		if (!TriggerChecker.canTrigger (event, trigAbility.getAfter (), ac.thisCard, ac.you, game)) { return false; }
		return true;
	} // canBeInitiated

} // ReactionAct
