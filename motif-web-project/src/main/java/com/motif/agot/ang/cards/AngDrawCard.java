package com.motif.agot.ang.cards;

import com.motif.agot.ang.enums.AngFaction;
import com.motif.agot.ang.enums.AngType;
import com.motif.agot.ang.sets.AgotCardSeed;
import com.motif.agot.ang.sets.AgotPack;
import com.motif.agot.ang.text.AngText;

public abstract class AngDrawCard extends AngDeckCard {

	private Integer cost;
	
	public AngDrawCard (AgotCardSeed cardSeed, AgotPack setCard, int setId, String title, AngType type, AngFaction faction, boolean loyal, Integer cost, AngText text) {
		super (cardSeed, setCard, setId, title, type, faction, loyal, text);
		this.cost = cost;
	} // AngPlayCard
	
	public int getCost () { return cost; }

} // AngDrawCard
