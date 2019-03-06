package com.motif.agot.ang.cards;

import com.motif.agot.ang.enums.AngFaction;
import com.motif.agot.ang.enums.AngType;
import com.motif.agot.ang.sets.AgotSetCard;
import com.motif.agot.ang.text.AngText;

public abstract class AngDeckCard extends AngTextCard {

	private boolean loyal;
	public boolean isLoyal () { return loyal; }
	
	public AngDeckCard (AgotSetCard setCard, int setId, String title, AngType type, AngFaction faction, boolean loyal, AngText text) {
		super (setCard, setId, title, type, faction, text);
		this.loyal = loyal;
	} // AngDeckCard

} // AngDeckCard
