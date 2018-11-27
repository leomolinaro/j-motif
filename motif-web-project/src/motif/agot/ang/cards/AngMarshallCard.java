package motif.agot.ang.cards;

import motif.agot.ang.enums.AngFaction;
import motif.agot.ang.enums.AngType;
import motif.agot.ang.sets.AgotSetCard;
import motif.agot.ang.text.AngText;

public abstract class AngMarshallCard extends AngDrawCard {

	private boolean unique;
	public boolean isUnique () { return unique; }
	
	public AngMarshallCard (AgotSetCard setCard, int setId, String title, AngType type, AngFaction faction, boolean loyal, Integer cost,
			boolean unique, AngText text) {
		super (setCard, setId, title, type, faction, loyal, cost, text);
		this.unique = unique;
	} // AngMarshallCard
	
} // AngMarshallCard
