package motif.agot.ang.text.triggeringconditions;

import motif.agot.ang.enums.AngSubject;
import motif.agot.ang.text.filters.AngCardFilter;

public class AngACardEntersPlay extends AngACard {

	public AngACardEntersPlay (AngSubject subject, AngCardFilter cardFilter) {
		super (subject, cardFilter);
	} // AngACardEntersPlay
	
	@Override public boolean accept (IAngTriggeringConditionVisitor visitor) { return visitor.visit (this); }

} // AngACardEntersPlay
