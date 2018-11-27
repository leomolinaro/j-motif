package motif.agot.ang.cards;

import motif.agot.ang.enums.AngFaction;
import motif.agot.ang.enums.AngType;

public class AngFactionCard extends AngCard {

	private static String buildImageSource (AngFaction faction) {
		return "https://thronesdb.com/bundles/app/images/factions/" + faction.getFactionCode () + ".png";
	} // buildImageSource
	
	public AngFactionCard (String title, AngType type, AngFaction faction) {
		super (title, type, faction, buildImageSource (faction));
	} // AngFactionCard

} // AngFactionCard
