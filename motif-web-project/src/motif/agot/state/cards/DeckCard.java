package motif.agot.state.cards;

import motif.agot.ang.cards.AngDeckCard;
import motif.agot.state.AgotPlayer;

public abstract class DeckCard<A extends AngDeckCard> extends TextCard<A> {

	public DeckCard (A ang, AgotPlayer owner) {
		super (ang, owner);
	} // DeckCard
	
} // DeckCard
