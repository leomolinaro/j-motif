package com.motif.agot.ang.text.consconditions;

import com.motif.agot.ang.text.filters.AngChallengeFilter;

public class AngDuringAChallenge implements IAngWhileCondition {

	private AngChallengeFilter challFilter;
	public AngChallengeFilter getChallFilter () { return challFilter; }

	public AngDuringAChallenge (AngChallengeFilter challFilter) {
		this.challFilter = challFilter;
	} // AngThisIsPartecipating

	@Override public boolean accept (IAngWhileConditionVisitor visitor) { return visitor.visit (this); }

} // AngThisIsPartecipating
