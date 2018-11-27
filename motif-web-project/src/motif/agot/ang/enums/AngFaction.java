package motif.agot.ang.enums;

import motif.agot.ang.cards.AngFactionCard;

public enum AngFaction {
	NEUTRAL ("neutral"),
	STARK ("stark"),
	THENIGHTSWATCH ("thenightswatch"),
	LANNISTER ("lannister"),
	TYRELL ("tyrell"),
	TARGARYEN ("targaryen"),
	GREYJOY ("greyjoy"),
	MARTELL ("martell"),
	BARATHEON ("baratheon");
	
	private String factionCode;
	public String getFactionCode () { return factionCode; }

	private AngFaction (String factionCode) {
		this.factionCode = factionCode;
	} // AngFaction
	
	public static AngFactionCard init (AngFaction faction) {
		switch (faction) {
			case BARATHEON: 		return new AngFactionCard ("House Baratheon", 	AngType.FACTION, AngFaction.BARATHEON);
			case GREYJOY: 			return new AngFactionCard ("House Greyjoy", 	AngType.FACTION, AngFaction.GREYJOY);
			case LANNISTER: 		return new AngFactionCard ("House Lannister", 	AngType.FACTION, AngFaction.LANNISTER);
			case MARTELL: 			return new AngFactionCard ("House Martell", 	AngType.FACTION, AngFaction.MARTELL);
			case STARK: 			return new AngFactionCard ("House Stark", 		AngType.FACTION, AngFaction.STARK);
			case TARGARYEN: 		return new AngFactionCard ("House Targaryen", 	AngType.FACTION, AngFaction.TARGARYEN);
			case TYRELL: 			return new AngFactionCard ("House Tyrell", 		AngType.FACTION, AngFaction.TYRELL);
			case THENIGHTSWATCH: 	return new AngFactionCard ("The Night's Watch", AngType.FACTION, AngFaction.THENIGHTSWATCH);
			default: return null;
		} // switch - case
	} // AngFactionCard
	
} // AngFaction
