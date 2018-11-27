package motif.agot.ang.text.untilconditions;

public class AngUntilTheEndOfTheChallenge implements IAngUntilCondition {

	@Override public boolean accept (IAngUntilConditionVisitor visitor) { return visitor.visit (this); }

} // AngUntilTheEndOfThePhase
