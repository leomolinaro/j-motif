package com.motif.agot.ang.text.consconditions;

public interface IAngWhileConditionVisitor {

	public boolean visit (AngAttachedIs whileCond);
	public boolean visit (AngAPlayerControls whileCond);
	public boolean visit (AngDuringAChallenge whileCond);
	public boolean visit (AngYouAreTheFirstPlayer whileCond);
	public boolean visit (AngThisHasADuplicate whileCond);

} // IAngWhileConditionVisitor
