package motif.agot.ang.text.triggeringconditions;

import motif.agot.ang.text.filters.AngChallengeFilter;

public class AngAChallengeIsInitiated extends AngAChallenge {

	private Boolean byYou;
	public boolean byYou () { return byYou != null && byYou; }
	public boolean againstYou () { return byYou != null && !byYou; }

	public AngAChallengeIsInitiated (AngChallengeFilter challengeFilter, Boolean byYou) {
		super (challengeFilter);
		this.byYou = byYou;
	} // AngAChallengeIsInitiated

	@Override public boolean accept (IAngTriggeringConditionVisitor visitor) { return visitor.visit (this); }

} // AngAChallengeIsInitiated
