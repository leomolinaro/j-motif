package com.motif.agot.state.abilities;

import com.motif.agot.ang.text.AngConsAbility;
import com.motif.agot.ang.text.consconditions.IAngWhileCondition;
import com.motif.agot.ang.text.conseffects.IAngConsEffect;
import com.motif.agot.logic.other.AbilityContext;

import lombok.Getter;

public class ConsAbility {

	@Getter private boolean active;
	public void activate () { this.active = true; }
	public void deactivate () { this.active = false; }

	@Getter private AngConsAbility ang;
	public IAngConsEffect getConsEffect () { return ang.getConsEffect (); }
	public IAngWhileCondition getWhileCond () { return ang.getWhileCond (); }
	public boolean hasWhileCond () { return ang.hasWhileCond (); }

//	public TextCard<?> getCard () { return card; }
//	public AgotPlayer getCardController () { return card.getController (); }
	@Getter private AbilityContext abilityContext;
	
	public ConsAbility (AngConsAbility ang, AbilityContext ac) {
		super ();
		this.ang = ang;
		this.abilityContext = ac;
	} // ConsAbility
	
} // ConsAbility
