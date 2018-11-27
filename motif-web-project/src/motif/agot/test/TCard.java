package motif.agot.test;

import java.util.ArrayList;

import motif.agot.state.cards.TextCard;

@Deprecated
public class TCard {
	
	private ArrayList<TextCard<?>> cards = new ArrayList<TextCard<?>> ();
	public void addCard (TextCard<?> card) { cards.add (card); }

} // TCard
