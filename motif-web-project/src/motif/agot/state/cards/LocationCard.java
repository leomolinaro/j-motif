package motif.agot.state.cards;

import motif.agot.ang.cards.AngLocationCard;
import motif.agot.state.AgotPlayer;

public class LocationCard extends MarshallCard<AngLocationCard> {

	public LocationCard (AngLocationCard ang, AgotPlayer owner) {
		super (ang, owner);
	} // LocationCard

	public void accept (MarshallCardVisitor visitor) { visitor.visit (this); }
	
	public interface LocationCardVisitor {
		public void visit (LocationCard card);
	} // LocationCardVisitor
	
} // LocationCard
