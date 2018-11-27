package motif.agot.ang.text.consconditions;

public class AngYouAreTheFirstPlayer implements IAngWhileCondition, IAngIfCondition {

	public AngYouAreTheFirstPlayer (boolean affermative) {
		// TODO Auto-generated constructor stub
	}

	@Override public boolean accept (IAngWhileConditionVisitor visitor) { return visitor.visit (this); }
	@Override public boolean accept (IAngIfConditionVisitor visitor) { return visitor.visit (this); }

} // AngYouAreTheFirstPlayer
