package com.motif.agot.state;

import com.motif.agot.ang.text.conseffects.AngConsEffects.AngReduceTheCostOfTheNextCardYouMarshallByN;
import com.motif.agot.logic.other.AbilityContext;

import lombok.Getter;

public class ConsModifier {

	@Getter private AngReduceTheCostOfTheNextCardYouMarshallByN ang;
//	public IAngUntilCondition getUntil () { return ang.getUntil (); }
//	public IAngConsEffect getConsEffect () { return ang.getConsEffect (); }

	@Getter private AbilityContext abilityContext;

	public ConsModifier (AngReduceTheCostOfTheNextCardYouMarshallByN ang, AbilityContext abilityContext) {
		this.ang = ang;
		this.abilityContext = abilityContext;
	} // CostModifier
	
} // CostModifier
