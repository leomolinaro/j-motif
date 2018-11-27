package motif.agot.logic.events.list;

import lombok.Getter;
import motif.agot.endpoint.AgotContext;
import motif.agot.flow.task.IAgotTask;
import motif.agot.logic.events.Event;
import motif.agot.logic.events.IEventVisitor;
import motif.agot.state.AgotGame;
import motif.agot.state.cards.Card;

public class GainNPowerOnEvent extends Event {

	private int n;
	@Getter private Card<?> card;

	public GainNPowerOnEvent (int n, Card<?> card, AgotGame game) {
		super (game);
		this.n = n;
		this.card = card;
	} // GainNPowerOnEvent

	@Override
	public IAgotTask resolveEffect (AgotContext context) {
		card.gainPower (n, context);
		game.log ().gainPower (card, n, context);
		return null;
	} // resolveEffect

	@Override public boolean accept (IEventVisitor visitor) { return visitor.visit (this); }

} // GainNPowerOnEvent
