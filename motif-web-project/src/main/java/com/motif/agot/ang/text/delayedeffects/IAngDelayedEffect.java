package com.motif.agot.ang.text.delayedeffects;

import com.motif.agot.ang.text.effects.IAngEffect;

public interface IAngDelayedEffect extends IAngEffect {

	public void accept (IAngDelayedEffectVisitor visitor);
	
} // AngDelayedEffect
