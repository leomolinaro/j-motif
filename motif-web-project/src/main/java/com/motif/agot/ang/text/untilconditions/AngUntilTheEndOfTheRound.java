package com.motif.agot.ang.text.untilconditions;

public class AngUntilTheEndOfTheRound implements IAngUntilCondition {

	@Override public boolean accept (IAngUntilConditionVisitor visitor) { return visitor.visit (this); }

} // AngUntilTheEndOfTheRound
