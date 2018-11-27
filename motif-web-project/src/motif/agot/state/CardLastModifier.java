package motif.agot.state;

import motif.agot.ang.text.instants.AngLastingEffect;
import motif.agot.state.cards.TextCard;

public class CardLastModifier<C extends AngLastingEffect> {
	
	public final TextCard<?> card;
	public final C consAbility;
	
	public CardLastModifier (TextCard<?> card, C consAbility) {
		this.card = card;
		this.consAbility = consAbility;
	} // CardLastModifier
	
} // CardLastModifier
