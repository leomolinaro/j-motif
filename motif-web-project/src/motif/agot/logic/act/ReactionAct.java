package motif.agot.logic.act;

import motif.agot.ang.text.AngReaction;
import motif.agot.flow.request.IAgotModelVisitor;
import motif.agot.logic.events.Event;
import motif.agot.logic.other.AbilityContext;
import motif.agot.logic.visitors.TriggerChecker;
import motif.agot.state.AgotGame;
import motif.agot.state.AgotPlayer;
import motif.agot.state.cards.TextCard;
import motif.shared.util.MotifConsole;

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
