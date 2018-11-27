package motif.agot.ang.text.consconditions;

public class AngThisHasADuplicate implements IAngWhileCondition {

	@Override public boolean accept (IAngWhileConditionVisitor visitor) { return visitor.visit (this); }

} // AngThisHasADuplicate
