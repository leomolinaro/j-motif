package motif.agot.ang.text.triggeringconditions;

import motif.agot.ang.enums.AngSubject;
import motif.agot.ang.text.filters.AngCardFilter;

public class AngACardIsDiscardedFromPlay extends AngACard {

	public AngACardIsDiscardedFromPlay (AngSubject subject, AngCardFilter cardFilter) {
		super (subject, cardFilter);
	} // AngACardIsKilled
	
	@Override public boolean accept (IAngTriggeringConditionVisitor visitor) { return visitor.visit (this); }

} // AngACardIsDiscardedFromPlay
