package motif.agot.ang.text.untilconditions;

public interface IAngUntilConditionVisitor {

	public boolean visit (AngUntilTheEndOfThePhase untilCondition);
	public boolean visit (AngUntilTheEndOfTheChallenge untilCondition);

} // IAngUntilConditionVisitor
