package com.motif.agot.state;

import com.motif.agot.ang.text.instants.AngLastingEffect;
import com.motif.agot.state.cards.TextCard;

public class CardLastModifier<C extends AngLastingEffect> {
	
	public final TextCard<?> card;
	public final C consAbility;
	
	public CardLastModifier (TextCard<?> card, C consAbility) {
		this.card = card;
		this.consAbility = consAbility;
	} // CardLastModifier
	
} // CardLastModifier
