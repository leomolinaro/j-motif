package com.motif.agot.ang.text.instants;

import com.motif.agot.ang.text.conseffects.IAngConsEffect;
import com.motif.agot.ang.text.effects.IAngEffect;
import com.motif.agot.ang.text.effects.IAngEffectVisitor;
import com.motif.agot.ang.text.untilconditions.IAngUntilCondition;

import lombok.Getter;

public class AngLastingEffect implements IAngEffect {

	@Getter private IAngUntilCondition until;
	@Getter private IAngConsEffect consEffect;
	
	public AngLastingEffect (IAngConsEffect consEffect, IAngUntilCondition until) {
		this.consEffect = consEffect;
		this.until = until;
	} // AngLastingEffect

	@Override public boolean accept (IAngEffectVisitor visitor) { return visitor.visit (this); }
	
} // IAngLastingEffect
