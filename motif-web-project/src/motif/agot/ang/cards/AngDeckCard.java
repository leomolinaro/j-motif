package motif.agot.ang.cards;

import motif.agot.ang.enums.AngFaction;
import motif.agot.ang.enums.AngType;
import motif.agot.ang.sets.AgotSetCard;
import motif.agot.ang.text.AngText;

public abstract class AngDeckCard extends AngTextCard {

	private boolean loyal;
	public boolean isLoyal () { return loyal; }
	
	public AngDeckCard (AgotSetCard setCard, int setId, String title, AngType type, AngFaction faction, boolean loyal, AngText text) {
		super (setCard, setId, title, type, faction, text);
		this.loyal = loyal;
	} // AngDeckCard

} // AngDeckCard
