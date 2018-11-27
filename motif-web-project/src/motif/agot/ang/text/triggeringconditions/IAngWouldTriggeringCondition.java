package motif.agot.ang.text.triggeringconditions;

public interface IAngWouldTriggeringCondition extends IAngTriggeringCondition {
	
	public <R> R accept (IAngWouldTriggeringConditionVisitor<R> visitor);
	
} // IAngWouldTriggeringCondition
