package motif.agot.ang.text.triggeringconditions;

import motif.agot.ang.enums.AngSubject;
import motif.agot.ang.text.filters.AngCardFilter;

public class AngACardLeavesPlay extends AngACard implements IAngTriggeringCondition {

	public AngACardLeavesPlay (AngSubject subject, AngCardFilter cardFilter) {
		super (subject, cardFilter);
	} // AngACardLeavesPlay
	
	@Override public boolean accept (IAngTriggeringConditionVisitor visitor) { return visitor.visit (this); }

} // AngACardLeavesPlay
