package motif.agot.logic.events.list;

import lombok.Getter;
import motif.agot.endpoint.AgotContext;
import motif.agot.flow.task.IAgotTask;
import motif.agot.logic.events.Event;
import motif.agot.logic.events.IEventVisitor;
import motif.agot.logic.other.ExitGameProcedure;
import motif.agot.state.AgotGame;
import motif.agot.state.cards.CharacterCard;

public class KillEvent extends Event {

	private CharacterCard card;
	@Getter private boolean saved;

	public KillEvent (CharacterCard card, AgotGame game) {
		super (game);
		this.card = card;
	} // KillEvent

	@Override
	public IAgotTask resolveEffect (AgotContext context) {
		if (card.isSaved ()) {
			this.saved = true;
			card.unsetSaved ();
		} else {
			ExitGameProcedure.killCharacter (card, game, context);
			game.log ().killsCharacter (card, context);			
		} // if - else
		return null;
	} // resolveEffect

	@Override public boolean accept (IEventVisitor visitor) { return visitor.visit (this); }

	public boolean doesKill (CharacterCard card) { return this.card == card; }
	
} // KillEvent
