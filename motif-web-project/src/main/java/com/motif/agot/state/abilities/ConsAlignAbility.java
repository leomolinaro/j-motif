package com.motif.agot.state.abilities;

import com.motif.agot.ang.text.AngConsAbility;
import com.motif.agot.ang.text.conseffects.IAngConsAlignEffect;
import com.motif.agot.logic.other.AbilityContext;

public class ConsAlignAbility extends ConsAbility {

	public ConsAlignAbility (AngConsAbility ang, AbilityContext ac) {
		super (ang, ac);
	} // ConsAlignAbility

	@Override
	public IAngConsAlignEffect getConsEffect () { return (IAngConsAlignEffect) super.getConsEffect (); }
	
} // ConsAlignAbility
