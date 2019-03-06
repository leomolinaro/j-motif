package com.motif.agot.ang.text.triggeringconditions;

import com.motif.agot.ang.text.filters.AngChallengeFilter;

public class AngAChallengeIsWon extends AngAChallenge {

	private Boolean byYou;
	public boolean byYou () { return byYou != null && byYou; }
	public boolean againstYou () { return byYou != null && !byYou; }

	public AngAChallengeIsWon (AngChallengeFilter challengeFilter, Boolean byYou) {
		super (challengeFilter);
		this.byYou = byYou;
	} // AngAChallengeIsWon

	@Override public boolean accept (IAngTriggeringConditionVisitor visitor) { return visitor.visit (this); }

} // AngAChallengeIsWon
