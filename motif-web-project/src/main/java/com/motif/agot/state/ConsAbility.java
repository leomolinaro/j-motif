package com.motif.agot.state;

import com.motif.agot.ang.text.AngConsAbility;
import com.motif.agot.ang.text.consconditions.IAngWhileCondition;
import com.motif.agot.ang.text.conseffects.IAngConsEffect;
import com.motif.agot.state.cards.TextCard;

import lombok.Getter;

public class ConsAbility {

	@Getter private boolean active;
	public void activate () { this.active = true; }
	public void deactivate () { this.active = false; }

	@Getter private AngConsAbility ang;
	public IAngConsEffect getConsEffect () { return ang.getConsEffect (); }
	public IAngWhileCondition getWhileCond () { return ang.getWhileCond (); }
	public boolean hasWhileCond () { return ang.hasWhileCond (); }

	public TextCard<?> getCard () { return card; }
	public AgotPlayer getCardController () { return card.getController (); }
	private TextCard<?> card;
	
	public ConsAbility (AngConsAbility ang, TextCard<?> card) {
		super ();
		this.ang = ang;
		this.card = card;
	} // ConsAbility
	
} // ConsAbility
