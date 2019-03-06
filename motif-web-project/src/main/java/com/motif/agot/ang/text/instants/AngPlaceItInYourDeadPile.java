package com.motif.agot.ang.text.instants;

import com.motif.agot.ang.text.effects.replacedeffects.IAngReplacedEffect;
import com.motif.agot.ang.text.effects.replacedeffects.IAngReplacedEffectVisitor;

public class AngPlaceItInYourDeadPile implements IAngReplacedEffect {

	@Override public void accept (IAngReplacedEffectVisitor visitor) { visitor.visit (this); }

} // AngPlaceItInYourDeadPile
