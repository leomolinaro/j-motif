package motif.agot.state.cards;

import motif.agot.ang.cards.AngDrawCard;
import motif.agot.state.AgotPlayer;

public abstract class DrawCard<A extends AngDrawCard> extends DeckCard<A> {
	
	public DrawCard (A ang, AgotPlayer controller) {
		super (ang, controller);
		controller.addDrawCard (this);
	} // DrawCard

	public final boolean isInHand () { return controller.hasInHand (this); }
	
	public final int getCost () { return ang.getCost (); }
		
} // DrawCard
