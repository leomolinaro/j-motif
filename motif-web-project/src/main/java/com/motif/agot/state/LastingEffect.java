package com.motif.agot.state;

import com.motif.agot.ang.text.conseffects.IAngConsEffect;
import com.motif.agot.ang.text.instants.AngLastingEffect;
import com.motif.agot.ang.text.untilconditions.IAngUntilCondition;
import com.motif.agot.logic.other.AbilityContext;

import lombok.Getter;

public class LastingEffect {

	@Getter private AngLastingEffect ang;
	public IAngUntilCondition getUntil () { return ang.getUntil (); }
	public IAngConsEffect getConsEffect () { return ang.getConsEffect (); }

	@Getter private AbilityContext abilityContext;

	public LastingEffect (AngLastingEffect ang, AbilityContext abilityContext) {
		this.ang = ang;
		this.abilityContext = abilityContext;
	}
	
} // LastingEffect
