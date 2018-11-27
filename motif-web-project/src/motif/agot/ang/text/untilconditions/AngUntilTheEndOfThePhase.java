package motif.agot.ang.text.untilconditions;

public class AngUntilTheEndOfThePhase implements IAngUntilCondition {

	@Override public boolean accept (IAngUntilConditionVisitor visitor) { return visitor.visit (this); }

} // AngUntilTheEndOfThePhase
