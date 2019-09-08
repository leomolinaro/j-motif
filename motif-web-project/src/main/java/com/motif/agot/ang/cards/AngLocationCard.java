package com.motif.agot.ang.cards;

import com.motif.agot.ang.enums.AngFaction;
import com.motif.agot.ang.enums.AngType;
import com.motif.agot.ang.sets.AgotCardSeed;
import com.motif.agot.ang.sets.AgotPack;
import com.motif.agot.ang.text.AngText.TB;

public class AngLocationCard extends AngMarshallCard {

	public AngLocationCard (AgotCardSeed cardSeed, AgotPack setCard, int setId, String title, AngFaction faction, boolean loyal, int cost, boolean unique, TB text) {
		super (cardSeed, setCard, setId, title, AngType.LOCATION, faction, loyal, cost, unique, text.build ());
	} // AngLocationCard

	@Override public void accept (AngTextCardVisitor visitor) { visitor.visit (this); }
	
} // AngLocationCard
