package com.motif.agot.ang.text.triggeringconditions;

import com.motif.agot.ang.enums.AngSubject;
import com.motif.agot.ang.text.filters.AngCardFilter;

public class AngACardIsKilled extends AngACard implements IAngWouldTriggeringCondition {

	public AngACardIsKilled (AngSubject subject, AngCardFilter cardFilter) {
		super (subject, cardFilter);
	} // AngACardIsKilled
	
	@Override public boolean accept (IAngTriggeringConditionVisitor visitor) { return visitor.visit (this); }
	@Override public <R> R accept (IAngWouldTriggeringConditionVisitor<R> visitor) { return visitor.visit (this); }

} // AngThisIsKilled
