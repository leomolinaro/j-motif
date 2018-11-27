package motif.agot.ang.text.triggeringconditions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class AngOr implements IAngTriggeringCondition, IAngWouldTriggeringCondition {

	private List<IAngTriggeringCondition> trigConds;
	public Stream<IAngTriggeringCondition> trigConds () { return trigConds.stream (); }

	public AngOr (IAngTriggeringCondition...trigConds) {
		this.trigConds = Arrays.asList (trigConds);
	} // AngPhaseBegins
	
	@Override public boolean accept (IAngTriggeringConditionVisitor visitor) { return visitor.visit (this); }
	@Override public <R> R accept (IAngWouldTriggeringConditionVisitor<R> visitor) { return visitor.visit (this); }
	
} // AngOr
