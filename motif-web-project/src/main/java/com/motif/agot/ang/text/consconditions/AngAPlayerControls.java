package com.motif.agot.ang.text.consconditions;

import com.motif.agot.ang.text.filters.AngCardFilter;

public class AngAPlayerControls implements IAngWhileCondition, IAngIfCondition {

	private Boolean you;
	public boolean youControl () { return you != null && you; }
	public boolean anOpponentControls () { return you != null && !you; }
	
	private AngCardFilter cardFilter;
	public AngCardFilter getCardFilter () { return cardFilter; }

	public AngAPlayerControls (Boolean you, AngCardFilter cardFilter) {
		this.you = you;
		this.cardFilter = cardFilter;
	} // AngAPlayerHasCard

	@Override public boolean accept (IAngWhileConditionVisitor visitor) { return visitor.visit (this); }
	@Override public boolean accept (IAngIfConditionVisitor visitor) { return visitor.visit (this); }

} // AngAPlayerHasCard
