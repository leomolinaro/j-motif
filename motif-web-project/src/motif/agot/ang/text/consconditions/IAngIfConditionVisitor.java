package motif.agot.ang.text.consconditions;

public interface IAngIfConditionVisitor {

	public boolean visit (AngYouAreTheFirstPlayer whileCond);
	public boolean visit (AngAPlayerControls whileCond);

} // IAngWhileConditionVisitor
