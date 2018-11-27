package motif.agot.ang.text.triggeringconditions;

import motif.agot.ang.enums.AngSubject;
import motif.agot.ang.text.filters.AngCardFilter;

public abstract class AngACard implements IAngTriggeringCondition {

	private AngSubject subject;
	public AngSubject getSubject () { return subject; }

	private AngCardFilter cardFilter;
	public AngCardFilter getCardFilter () { return cardFilter; }

	public AngACard (AngSubject subject, AngCardFilter cardFilter) {
		this.subject = subject;
		this.cardFilter = cardFilter;
	} // AngACardEntersPlay
	
} // AngACard
