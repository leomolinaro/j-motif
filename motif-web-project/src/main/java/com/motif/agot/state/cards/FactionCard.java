package com.motif.agot.state.cards;

import com.motif.agot.ang.cards.AngFactionCard;
import com.motif.agot.ang.sets.AgotCardSeed;
import com.motif.agot.state.AgotPlayer;

public class FactionCard extends Card<AngFactionCard> {

	public FactionCard (AngFactionCard ang, AgotPlayer controller) {
		super (ang, controller);
		controller.setFaction (this);
	} // FactionCard

	@Override
	public AgotCardSeed seed () { return null; }
	
} // FactionCard
