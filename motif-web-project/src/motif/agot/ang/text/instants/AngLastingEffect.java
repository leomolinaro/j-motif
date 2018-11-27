package motif.agot.ang.text.instants;

import lombok.Getter;
import motif.agot.ang.text.conseffects.IAngConsEffect;
import motif.agot.ang.text.effects.IAngEffect;
import motif.agot.ang.text.effects.IAngEffectVisitor;
import motif.agot.ang.text.untilconditions.IAngUntilCondition;

public class AngLastingEffect implements IAngEffect {

	@Getter private IAngUntilCondition until;
	@Getter private IAngConsEffect consEffect;
	
	public AngLastingEffect (IAngConsEffect consEffect, IAngUntilCondition until) {
		this.consEffect = consEffect;
		this.until = until;
	} // AngLastingEffect

	@Override public boolean accept (IAngEffectVisitor visitor) { return visitor.visit (this); }
	
} // IAngLastingEffect
