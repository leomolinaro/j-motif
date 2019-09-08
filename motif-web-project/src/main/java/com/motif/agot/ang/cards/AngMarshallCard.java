package com.motif.agot.ang.cards;

import com.motif.agot.ang.enums.AngFaction;
import com.motif.agot.ang.enums.AngType;
import com.motif.agot.ang.sets.AgotCardSeed;
import com.motif.agot.ang.sets.AgotPack;
import com.motif.agot.ang.text.AngText;

public abstract class AngMarshallCard extends AngDrawCard {

	private boolean unique;
	public boolean isUnique () { return unique; }
	
	public AngMarshallCard (AgotCardSeed cardSeed, AgotPack setCard, int setId, String title, AngType type, AngFaction faction, boolean loyal, Integer cost,
			boolean unique, AngText text) {
		super (cardSeed, setCard, setId, title, type, faction, loyal, cost, text);
		this.unique = unique;
	} // AngMarshallCard
	
} // AngMarshallCard
