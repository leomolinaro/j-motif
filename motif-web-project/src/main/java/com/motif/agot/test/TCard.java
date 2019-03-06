package com.motif.agot.test;

import java.util.ArrayList;

import com.motif.agot.state.cards.TextCard;

@Deprecated
public class TCard {
	
	private ArrayList<TextCard<?>> cards = new ArrayList<TextCard<?>> ();
	public void addCard (TextCard<?> card) { cards.add (card); }

} // TCard
