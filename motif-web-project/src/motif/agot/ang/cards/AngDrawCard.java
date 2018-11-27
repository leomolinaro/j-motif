package motif.agot.ang.cards;

import motif.agot.ang.enums.AngFaction;
import motif.agot.ang.enums.AngType;
import motif.agot.ang.sets.AgotSetCard;
import motif.agot.ang.text.AngText;

public abstract class AngDrawCard extends AngDeckCard {

	private Integer cost;
	
	public AngDrawCard (AgotSetCard setCard, int setId, String title, AngType type, AngFaction faction, boolean loyal, Integer cost, AngText text) {
		super (setCard, setId, title, type, faction, loyal, text);
		this.cost = cost;
	} // AngPlayCard
	
	public int getCost () { return cost; }

} // AngDrawCard
