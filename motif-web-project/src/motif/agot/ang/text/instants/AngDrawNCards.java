package motif.agot.ang.text.instants;

import motif.agot.ang.text.effects.IAngEffect;
import motif.agot.ang.text.effects.IAngEffectVisitor;

public class AngDrawNCards implements IAngEffect {

	private int n;
	public int getN () { return n; }	
	
	public AngDrawNCards (int n) {
		this.n = n;
	} // AngDrawNCards
	
	@Override public boolean accept (IAngEffectVisitor visitor) { return visitor.visit (this); }

} // AngDrawNCards
