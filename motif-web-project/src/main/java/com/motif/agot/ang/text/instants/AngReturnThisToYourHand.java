package com.motif.agot.ang.text.instants;

import com.motif.agot.ang.text.costs.IAngCost;
import com.motif.agot.ang.text.costs.IAngCostVisitor;
import com.motif.agot.ang.text.effects.IAngEffect;
import com.motif.agot.ang.text.effects.IAngEffectVisitor;

public class AngReturnThisToYourHand implements IAngEffect, IAngCost {

	@Override public boolean accept (IAngEffectVisitor visitor) { return visitor.visit (this); }
	@Override public boolean accept (IAngCostVisitor visitor) { return visitor.visit (this); }

} // AngReturnToYourHand
