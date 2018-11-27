package motif.agot.ang.text.consconditions;

import motif.agot.ang.text.filters.AngCardFilter;

public class AngAttachedIs implements IAngWhileCondition {

	private AngCardFilter cardFilter;
	public AngCardFilter getCardFilter () { return cardFilter; }
	
	public AngAttachedIs (AngCardFilter cardFilter) {
		this.cardFilter = cardFilter;
	} // AngAttachedIs
	
	@Override public boolean accept (IAngWhileConditionVisitor visitor) { return visitor.visit (this); }

} // AngAttachedIs
