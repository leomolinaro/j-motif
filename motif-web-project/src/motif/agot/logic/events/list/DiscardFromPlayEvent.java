package motif.agot.logic.events.list;

import lombok.Getter;
import motif.agot.endpoint.AgotContext;
import motif.agot.flow.task.IAgotTask;
import motif.agot.logic.events.Event;
import motif.agot.logic.events.IEventVisitor;
import motif.agot.logic.other.ExitGameProcedure;
import motif.agot.state.AgotGame;
import motif.agot.state.cards.MarshallCard;

public class DiscardFromPlayEvent extends Event {

	@Getter private MarshallCard<?> card;
	@Getter private boolean saved;
	
	public DiscardFromPlayEvent (MarshallCard<?> card, AgotGame game) {
		super (game);
		this.card = card;
	} // DiscardFromPlayEvent

	@Override
	public IAgotTask resolveEffect (AgotContext context) {
		if (card.isSaved ()) {
			this.saved = true;
			card.unsetSaved ();
		} else {
			ExitGameProcedure.discardCard (card, game, context);
			game.log ().discardsCard (card, context);			
		} // if - else
		return null;
	} // resolveEffect

	@Override public boolean accept (IEventVisitor visitor) { return visitor.visit (this); }

} // DiscardFromPlayEvent
