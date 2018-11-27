package motif.agot.ang.text.triggeringconditions;

import motif.agot.ang.enums.AngSubject;
import motif.agot.ang.text.filters.AngCardFilter;

public class AngACardIsSacrificed extends AngACard {

	public AngACardIsSacrificed (AngSubject subject, AngCardFilter cardFilter) {
		super (subject, cardFilter);
	} // AngACardIsKilled
	
	@Override public boolean accept (IAngTriggeringConditionVisitor visitor) { return visitor.visit (this); }

} // AngThisIsKilled
