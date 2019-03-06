package com.motif.agot.state.cards;

import com.motif.agot.ang.cards.AngDeckCard;
import com.motif.agot.state.AgotPlayer;

public abstract class DeckCard<A extends AngDeckCard> extends TextCard<A> {

	public DeckCard (A ang, AgotPlayer owner) {
		super (ang, owner);
	} // DeckCard
	
} // DeckCard
