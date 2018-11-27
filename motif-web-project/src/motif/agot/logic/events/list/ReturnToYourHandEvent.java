package motif.agot.logic.events.list;

import lombok.Getter;
import motif.agot.endpoint.AgotContext;
import motif.agot.flow.task.IAgotTask;
import motif.agot.logic.events.Event;
import motif.agot.logic.events.IEventVisitor;
import motif.agot.state.AgotGame;
import motif.agot.state.cards.DrawCard;

public class ReturnToYourHandEvent extends Event {
	
	@Getter private DrawCard<?> card;
	
	public ReturnToYourHandEvent (DrawCard<?> card, AgotGame game) {
		super (game);
		this.card = card;
	} // ReturnToYourHandEvent

	@Override
	public IAgotTask resolveEffect (AgotContext context) {
		// TODO return to your hand
		return null;
	} // resolveEffect
	
	@Override public boolean accept (IEventVisitor visitor) { return visitor.visit (this); }

} // ReturnToYourHandEvent
