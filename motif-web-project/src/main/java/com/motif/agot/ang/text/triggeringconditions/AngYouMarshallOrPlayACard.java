package com.motif.agot.ang.text.triggeringconditions;

import com.motif.agot.ang.text.filters.AngCardFilter;

public class AngYouMarshallOrPlayACard implements IAngTriggeringCondition {

	private AngCardFilter cardFilter;
	public AngCardFilter getCardFilter () { return cardFilter; }

	public AngYouMarshallOrPlayACard (AngCardFilter cardFilter) {
		this.cardFilter = cardFilter;
	} // AngYouMarshallOrPlay

	@Override public boolean accept (IAngTriggeringConditionVisitor visitor) { return visitor.visit (this); }

} // AngYouMarshallOrPlay
