package motif.agot.state.cards;

import motif.agot.ang.cards.AngAttachmentCard;
import motif.agot.ang.text.filters.AngCardFilter;
import motif.agot.state.AgotPlayer;

public class AttachmentCard extends MarshallCard<AngAttachmentCard> {

	public AttachmentCard (AngAttachmentCard ang, AgotPlayer owner) {
		super (ang, owner);
	} // AttachmentCard

	public void accept (MarshallCardVisitor visitor) { visitor.visit (this); }
	
	public interface AttachmentCardVisitor {
		public void visit (AttachmentCard card);
	} // AttachmentCardVisitor

	private MarshallCard<?> attachTo;
	public void setAttachTo (MarshallCard<?> attachTo) { this.attachTo = attachTo; }
	public MarshallCard<?> getAttachTo () { return attachTo; }

	public boolean hasRestriction () { return ang.hasAttachmentRestriction (); }
	public AngCardFilter getRestriction () { return ang.getAttachmentRestriction (); }

	public boolean isTerminal () { return ang.isTerminal (); }
	
} // AttachmentCard
