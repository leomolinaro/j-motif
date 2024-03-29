package com.motif.agot.state;

import com.motif.agot.ang.text.AngConsAbility;
import com.motif.agot.state.cards.TextCard;

public class CardConsModifier<C extends AngConsAbility> {
	
	public final TextCard<?> card;
	public final C consAbility;
	
	public CardConsModifier (TextCard<?> card, C consAbility) {
		this.card = card;
		this.consAbility = consAbility;
	} // StrengthModifier
	
} // CardConsModifier
