package motif.agot.state.cards;

import motif.agot.ang.cards.AngFactionCard;
import motif.agot.state.AgotPlayer;

public class FactionCard extends Card<AngFactionCard> {

	public FactionCard (AngFactionCard ang, AgotPlayer controller) {
		super (ang, controller);
		controller.setFaction (this);
	} // FactionCard
	
} // FactionCard
