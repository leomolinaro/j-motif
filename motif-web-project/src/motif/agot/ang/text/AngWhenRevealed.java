package motif.agot.ang.text;

import motif.agot.ang.text.effects.IAngEffect;
import motif.agot.ang.text.limit.AngTrigLimit;

public class AngWhenRevealed extends AngTrigAbility {

	public AngWhenRevealed (IAngEffect effect, AngTrigLimit limit) {
		super (null, effect, limit);
	} // AngAction
	
	public String getLabel () { return "When revealed"; }
	
	public static class WRB extends TAB<WRB> {
		
		@Override protected WRB getThis () { return this; }
		
		public static EB i () {
			WRB wrb = new WRB ();
			return wrb.new EB ();
		} // i
		
		public AngWhenRevealed build () {
			AngWhenRevealed whenRevealed = new AngWhenRevealed (effect, limit);
			return whenRevealed;
		} // build
		
	} // WRB

} // AngAction
