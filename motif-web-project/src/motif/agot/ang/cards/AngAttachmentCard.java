package motif.agot.ang.cards;

import motif.agot.ang.enums.AngFaction;
import motif.agot.ang.enums.AngType;
import motif.agot.ang.sets.AgotSetCard;
import motif.agot.ang.text.AngText.TB;

public class AngAttachmentCard extends AngMarshallCard {

	public AngAttachmentCard (AgotSetCard setCard, int setId, String title, AngFaction faction, boolean loyal, int cost, boolean unique, TB text) {
		super (setCard, setId, title, AngType.ATTACHMENT, faction, loyal, cost, unique, text.build ());
	} // AngAttachmentCard

	@Override public void accept (AngTextCardVisitor visitor) { visitor.visit (this); }

} // AngAttachmentCard
