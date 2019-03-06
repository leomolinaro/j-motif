package com.motif.agot.ang.text.triggeringconditions;

import com.motif.agot.ang.enums.AngSubject;
import com.motif.agot.ang.text.filters.AngCardFilter;

public class AngACardLosesOneOrMorePower extends AngACard {

	public AngACardLosesOneOrMorePower (AngSubject subject, AngCardFilter cardFilter) {
		super (subject, cardFilter);
	} // AngACardLosesOneOrMorePower

	@Override public boolean accept (IAngTriggeringConditionVisitor visitor) { return visitor.visit (this); }

} // AngACardLosesOneOrMorePower
