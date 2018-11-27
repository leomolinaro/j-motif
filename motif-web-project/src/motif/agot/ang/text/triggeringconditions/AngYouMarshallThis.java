package motif.agot.ang.text.triggeringconditions;

public class AngYouMarshallThis implements IAngTriggeringCondition {

	@Override public boolean accept (IAngTriggeringConditionVisitor visitor) { return visitor.visit (this); }
	
} // AngYouMarshallThis
