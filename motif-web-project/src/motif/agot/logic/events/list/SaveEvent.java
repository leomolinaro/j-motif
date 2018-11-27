package motif.agot.logic.events.list;

import motif.agot.endpoint.AgotContext;
import motif.agot.flow.task.IAgotTask;
import motif.agot.logic.events.Event;
import motif.agot.logic.events.IEventVisitor;
import motif.agot.state.AgotGame;
import motif.agot.state.cards.MarshallCard;

public class SaveEvent extends Event {
	
	private MarshallCard<?> card;

	public SaveEvent (MarshallCard<?> card, AgotGame game) {
		super (game);
		this.card = card;
	} // SaveEvent

	@Override
	public IAgotTask resolveEffect (AgotContext context) {
		card.setSaved ();
		game.log ().savesCard (card, context);
		return null;
	} // resolveEffect

	@Override public boolean accept (IEventVisitor visitor) { return visitor.visit (this); }

} // SaveEvent
