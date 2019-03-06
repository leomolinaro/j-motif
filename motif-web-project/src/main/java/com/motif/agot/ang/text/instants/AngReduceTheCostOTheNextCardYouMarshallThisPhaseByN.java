package com.motif.agot.ang.text.instants;

import com.motif.agot.ang.text.effects.IAngEffect;
import com.motif.agot.ang.text.effects.IAngEffectVisitor;
import com.motif.agot.ang.text.filters.AngCardFilter;

public class AngReduceTheCostOTheNextCardYouMarshallThisPhaseByN implements IAngEffect {

	private AngCardFilter cardFilter;
	public AngCardFilter getCardFilter () { return cardFilter; }

	private int n;
	public int getN () { return n; }

	public AngReduceTheCostOTheNextCardYouMarshallThisPhaseByN (AngCardFilter cardFilter, int n) {
		this.cardFilter = cardFilter;
		this.n = n;
	} // AngReduceTheCostOTheNextCardYouMarshallThisPhaseByN

	@Override public boolean accept (IAngEffectVisitor visitor) { return visitor.visit (this); }

} // AngReduceTheCostOTheNextCardYouMarshallThisPhaseByN
