package com.motif.agot.ang.text.triggeringconditions;

import com.motif.agot.ang.enums.AngSubject;
import com.motif.agot.ang.text.filters.AngCardFilter;

public class AngACardGainsOneOrMorePower extends AngACard {

	public AngACardGainsOneOrMorePower (AngSubject subject, AngCardFilter cardFilter) {
		super (subject, cardFilter);
	} // AngACardGainsOneOrMorePower

	@Override public boolean accept (IAngTriggeringConditionVisitor visitor) { return visitor.visit (this); }

} // AngAttachedGainsOneOrMorePower
