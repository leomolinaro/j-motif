package com.motif.agot.state;

import com.motif.agot.ang.text.conseffects.AngConsEffects.AngReduceTheCostOfTheNextCardYouMarshallByN;
import com.motif.agot.logic.other.AbilityContext;

import lombok.Getter;
import lombok.Setter;

public class MarshallModifier {

	@Getter @Setter boolean consumed = false;
	
	@Getter private AngReduceTheCostOfTheNextCardYouMarshallByN ang;

	@Getter private AbilityContext abilityContext;

	public MarshallModifier (AngReduceTheCostOfTheNextCardYouMarshallByN ang, AbilityContext abilityContext) {
		this.ang = ang;
		this.abilityContext = abilityContext;
	} // CostModifier
	
} // CostModifier
