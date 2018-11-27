package motif.agot.ang.cards;

import motif.agot.ang.enums.AngFaction;
import motif.agot.ang.enums.AngType;
import motif.agot.ang.sets.AgotSetCard;
import motif.agot.ang.text.AngText.TB;

public class AngLocationCard extends AngMarshallCard {

	public AngLocationCard (AgotSetCard setCard, int setId, String title, AngFaction faction, boolean loyal, int cost, boolean unique, TB text) {
		super (setCard, setId, title, AngType.LOCATION, faction, loyal, cost, unique, text.build ());
	} // AngLocationCard

	@Override public void accept (AngTextCardVisitor visitor) { visitor.visit (this); }
	
} // AngLocationCard
