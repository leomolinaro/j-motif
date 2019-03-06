package com.motif.agot.ang.cards;

import com.motif.agot.ang.enums.AngFaction;
import com.motif.agot.ang.enums.AngType;
import com.motif.agot.ang.sets.AgotSetCard;
import com.motif.agot.ang.text.AngText.TB;

public class AngEventCard extends AngDrawCard {

	public AngEventCard (AgotSetCard setCard, int setId, String title, AngFaction faction, boolean loyal, Integer cost, TB text) {
		super (setCard, setId, title, AngType.EVENT, faction, loyal, cost, text.build ());
	} // AngEvent

	@Override public void accept (AngTextCardVisitor visitor) { visitor.visit (this); }
	
} // AngEventCard
