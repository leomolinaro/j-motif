package motif.agot.ang.text.triggeringconditions;

public class AngYouWinDominance implements IAngTriggeringCondition {

	@Override public boolean accept (IAngTriggeringConditionVisitor visitor) { return visitor.visit (this); }

} // AngYouWinDominance
