package motif.agot.logic.events.list;

import lombok.Getter;
import motif.agot.endpoint.AgotContext;
import motif.agot.flow.task.IAgotTask;
import motif.agot.logic.events.Event;
import motif.agot.logic.events.IEventVisitor;
import motif.agot.state.AgotGame;
import motif.agot.state.cards.Card;

public class MoveNPowerEvent extends Event {

	private int nPower;
	@Getter private Card<?> fromCard;
	@Getter private Card<?> toCard;
	
	public MoveNPowerEvent (int nPower, Card<?> fromCard, Card<?> toCard, AgotGame game) {
		super (game);
		this.nPower = nPower;
		this.fromCard = fromCard;
		this.toCard = toCard;
	} // MoveNPowerEvent

	@Override
	public IAgotTask resolveEffect (AgotContext context) {
		fromCard.losePower (nPower, context);
		game.log ().losePower (fromCard, nPower, context);
		toCard.gainPower (nPower, context);
		game.log ().gainPower (toCard, nPower, context);
		return null;
	} // resolveEffect

	@Override public boolean accept (IEventVisitor visitor) { return visitor.visit (this); }

} // MoveNPowerEvent
