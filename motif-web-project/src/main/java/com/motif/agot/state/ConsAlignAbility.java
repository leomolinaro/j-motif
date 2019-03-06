package com.motif.agot.state;

import com.motif.agot.ang.text.AngConsAbility;
import com.motif.agot.ang.text.conseffects.IAngConsAlignEffect;
import com.motif.agot.state.cards.TextCard;

public class ConsAlignAbility extends ConsAbility {

	public ConsAlignAbility (AngConsAbility ang, TextCard<?> card) {
		super (ang, card);
	} // ConsAlignAbility

	@Override
	public IAngConsAlignEffect getConsEffect () { return (IAngConsAlignEffect) super.getConsEffect (); }
	
} // ConsAlignAbility
