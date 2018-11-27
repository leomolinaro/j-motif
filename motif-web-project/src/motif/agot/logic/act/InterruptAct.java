package motif.agot.logic.act;

import motif.agot.ang.text.AngInterrupt;
import motif.agot.flow.request.IAgotModelVisitor;
import motif.agot.logic.events.Event;
import motif.agot.logic.other.AbilityContext;
import motif.agot.logic.visitors.TriggerChecker;
import motif.agot.state.AgotGame;
import motif.agot.state.AgotPlayer;
import motif.agot.state.cards.TextCard;
import motif.shared.util.MotifConsole;

public final class InterruptAct extends TrigAbilityAct<AngInterrupt> {

	private Event event;
	
	public InterruptAct (Event event, AngInterrupt interrupt, TextCard<?> interruptingCard, AgotPlayer interruptingPlayer, AgotGame game) {
		super (interrupt, new AbilityContext (interruptingCard, interruptingPlayer), game);
		this.event = event;
	} // InterruptAct

	@Override
	public String getLabel () { return MotifConsole.format ("Interrupt {0}", ac.thisCard.getTitle ()); }

	@Override
	public void accept (IAgotModelVisitor visitor) { visitor.visit (this); }

	@Override
	public boolean canBeInitiated () {
		boolean canBeInitiated = super.canBeInitiated ();
		if (!canBeInitiated) { return false; }
		if (!TriggerChecker.canTrigger (event, trigAbility.getWhen (), ac.thisCard, ac.you, game)) { return false; }
		return true;
	} // canBeInitiated

} // InterruptAct
