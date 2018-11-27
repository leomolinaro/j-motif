package motif.agot.ang.text.instants;

import lombok.Getter;
import motif.agot.ang.text.effects.IAngEffect;
import motif.agot.ang.text.effects.IAngEffectVisitor;
import motif.agot.ang.text.filters.AngCardFilter;

public class AngGainNGold implements IAngEffect {

	@Getter private int n;
	@Getter private AngCardFilter forEach;
	
	public AngGainNGold (int n, AngCardFilter forEach) {
		this.n = n;
		this.forEach = forEach;
	} // AngGainNGold
	
	@Override public boolean accept (IAngEffectVisitor visitor) { return visitor.visit (this); }

} // AngGainNGold
