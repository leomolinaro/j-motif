package com.motif.agot.ang.cards;

import com.motif.agot.ang.enums.AngFaction;
import com.motif.agot.ang.enums.AngType;
import com.motif.agot.ang.sets.AgotCardSeed;
import com.motif.agot.ang.sets.AgotPack;
import com.motif.agot.ang.text.AngText;

public abstract class AngDeckCard extends AngTextCard {

	private boolean loyal;
	public boolean isLoyal () { return loyal; }
	
	public AngDeckCard (AgotCardSeed cardSeed, AgotPack pack, int setId, String title, AngType type, AngFaction faction, boolean loyal, AngText text) {
		super (cardSeed, pack, setId, title, type, faction, text);
		this.loyal = loyal;
	} // AngDeckCard

} // AngDeckCard
