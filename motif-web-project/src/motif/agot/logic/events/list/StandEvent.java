package motif.agot.logic.events.list;

import lombok.Getter;
import motif.agot.endpoint.AgotContext;
import motif.agot.flow.task.IAgotTask;
import motif.agot.logic.events.Event;
import motif.agot.logic.events.IEventVisitor;
import motif.agot.state.AgotGame;
import motif.agot.state.cards.Card;

public class StandEvent extends Event {

	@Getter private Card<?> card;

	public StandEvent (Card<?> card, AgotGame game) {
		super (game);
		this.card = card;
	} // StandEvent

	@Override
	public IAgotTask resolveEffect (AgotContext context) {
		card.stand (context);
		game.log ().standsCard (card, context);			
		return null;
	} // resolveEffect
	
	@Override public boolean accept (IEventVisitor visitor) { return visitor.visit (this); }

} // StandEvent
