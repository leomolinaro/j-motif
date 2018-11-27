package motif.agot.ang.text.triggeringconditions;

public interface IAngTriggeringConditionVisitor {

	public boolean visit (AngYouMarshallThis trigCond);
	public boolean visit (AngPhaseBegins trigCond);
	public boolean visit (AngPhaseEnds trigCond);
	public boolean visit (AngYouMarshallOrPlayACard trigCond);
	public boolean visit (AngACardIsDiscardedFromPlay trigCond);
	public boolean visit (AngACardIsKilled trigCond);
	public boolean visit (AngACardLeavesPlay trigCond);
	public boolean visit (AngACardIsSacrificed trigCond);
	public boolean visit (AngAChallengeIsInitiated trigCond);
	public boolean visit (AngAChallengeIsWon trigCond);
	public boolean visit (AngAChallengeIsLost trigCond);
	public boolean visit (AngACardGainsOneOrMorePower trigCond);
	public boolean visit (AngACardLosesOneOrMorePower trigCond);
	public boolean visit (AngACardEntersPlay trigCond);
	public boolean visit (AngYouWinDominance trigCond);
	public boolean visit (AngOr trigCond);
	
} // IAngTriggeringConditionVisitor
