package motif.agot.ang.text.triggeringconditions;

import motif.agot.ang.text.filters.AngChallengeFilter;

public abstract class AngAChallenge implements IAngTriggeringCondition {

	private AngChallengeFilter challengeFilter;
	public AngChallengeFilter getChallengeFilter () { return challengeFilter; }

	public AngAChallenge (AngChallengeFilter challengeFilter) {
		this.challengeFilter = challengeFilter;
	} // AngAChallenge
	
} // AngAChallenge