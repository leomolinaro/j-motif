package motif.agot.ang.text;

import motif.agot.ang.text.costs.IAngCost;
import motif.agot.ang.text.effects.IAngEffect;
import motif.agot.ang.text.limit.AngTrigLimit;

public class AngAction extends AngTrigAbility {

	public enum AngActionType {
		ACTION, MARSHALLING_ACTION, PLOT_ACTION, DRAW_ACTION, CHALLENGES_ACTION, DOMINANCE_ACTION, TAXATION_ACTION, STANDING_ACTION
	} // AngActionType

	private AngActionType type;
	public AngActionType getType () { return type; }
	
	public AngAction (AngActionType type, IAngCost cost, IAngEffect effect, AngTrigLimit limit) {
		super (cost, effect, limit);
		this.type = type;
	} // AngAction
	
	public boolean isType (AngActionType type) { return type == this.type; }

	public String getLabel () { return "Action"; }
	
	public static class AB extends TAB<AB> {
		
		public static EB i () { return new AB ().new EB (); }

		private AB () {}
		
		@Override protected AB getThis () { return this; }
		
		public AngAction build (AngActionType actionType) {
			AngAction action = new AngAction (actionType, cost, effect, limit);
			return action;
		} // build
		
	} // AB

} // AngAction
