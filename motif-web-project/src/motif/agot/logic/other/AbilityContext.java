package motif.agot.logic.other;

import java.util.ArrayList;

import motif.agot.state.AgotPlayer;
import motif.agot.state.cards.Card;
import motif.agot.state.cards.TextCard;

public class AbilityContext {

	public TextCard<?> thisCard;
	public AgotPlayer you;
	public Card<?> thatCard;
	public ArrayList<Card<?>> thoseCards;
	
	public AbilityContext (TextCard<?> thisCard, AgotPlayer you) {
		this.thisCard = thisCard;
		this.you = you;
	} // AbilityContext
	
	public AbilityContext setThatCard (Card<?> thatCard) { this.thatCard = thatCard; return this; }
	
} // AbilityContext
