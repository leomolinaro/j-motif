package motif.agot.logic.events.list;

import motif.agot.endpoint.AgotContext;
import motif.agot.flow.task.IAgotTask;
import motif.agot.logic.events.Event;
import motif.agot.logic.events.IEventVisitor;
import motif.agot.state.AgotGame;
import motif.agot.state.cards.Card;

public class KneelEvent extends Event {

	private Card<?> card;

	public KneelEvent (Card<?> cards, AgotGame game) {
		super (game);
		this.card = cards;
	} // KneelEvent

	@Override
	public IAgotTask resolveEffect (AgotContext context) {
		card.kneel (context);
		game.log ().kneelsCard (card, context);			
		return null;
	} // resolveEffect

	@Override public boolean accept (IEventVisitor visitor) { return visitor.visit (this); }

} // StandEvent
