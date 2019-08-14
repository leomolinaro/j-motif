package com.motif.agot.state.cards;

import java.util.ArrayList;
import java.util.stream.Stream;

import com.google.gson.annotations.Expose;
import com.motif.agot.ang.cards.AngMarshallCard;
import com.motif.agot.state.AgotPlayer;
import com.motif.agot.state.cards.AttachmentCard.AttachmentCardVisitor;
import com.motif.agot.state.cards.CharacterCard.CharacterCardVisitor;
import com.motif.agot.state.cards.LocationCard.LocationCardVisitor;

public abstract class MarshallCard<A extends AngMarshallCard> extends DrawCard<A> {

	private ArrayList<AttachmentCard> attachments = null;
	@Expose private ArrayList<Long> attachmentIds = null;
	@Override public ArrayList<Long> attachmentIds() { return this.attachmentIds; }
	public Stream<AttachmentCard> attachments () { return attachments == null ? Stream.empty () : attachments.stream (); }
	public void removeAttachment (AttachmentCard card) {
		attachments.remove (card);
		attachmentIds.remove (card.id());
		if (attachments.isEmpty ()) { attachments = null; attachmentIds = null; }
	}
	public boolean hasAttachment (AttachmentCard card) { return attachments != null && attachments.contains (card); }
	public boolean hasAttachments () { return attachments != null && !attachments.isEmpty (); }
	public void addAttachment (AttachmentCard card) {
		if (attachments == null) { attachments = new ArrayList<AttachmentCard> (); }
		attachments.add (card);
		if (attachmentIds == null) { attachmentIds = new ArrayList<Long> (); }
		attachmentIds.add (card.id());
	}

	private ArrayList<MarshallCard<?>> duplicates = null;
	@Expose private ArrayList<Long> duplicateIds = null;
	@Override public ArrayList<Long> duplicateIds() { return this.duplicateIds; }
	public Stream<MarshallCard<?>> duplicates () { return duplicates == null ? Stream.empty () : duplicates.stream (); }
	public void removeDuplicate (MarshallCard<?> card) {
		duplicates.remove (card);
		duplicateIds.remove (card.id());
		if (duplicates.isEmpty ()) { duplicates = null; duplicateIds = null; }
	}
	public boolean hasDuplicate (MarshallCard<?> card) { return duplicates != null && duplicates.contains (card); }
	public boolean hasduplicates () { return duplicates != null && !duplicates.isEmpty (); }
	public void addDuplicate (MarshallCard<?> card) {
		if (duplicates == null) { duplicates = new ArrayList<MarshallCard<?>> (); }
		duplicates.add (card);
		if (duplicateIds == null) { duplicateIds = new ArrayList<Long> (); }
		duplicateIds.add (card.id());
	}
	
	public MarshallCard (A ang, AgotPlayer owner) {
		super (ang, owner);
	}

	public boolean isDuplicate (MarshallCard<?> card) {
		return isUnique () && getTitle ().equals (card.getTitle ());
	}
	
	public final boolean isUnique () { return ang.isUnique (); }
	
	public abstract void accept (MarshallCardVisitor visitor);
	
	public interface MarshallCardVisitor extends AttachmentCardVisitor, LocationCardVisitor, CharacterCardVisitor {
	}
	
	private boolean saved;
	public void setSaved () { saved = true; }
	public void unsetSaved () { saved = false; }
	public boolean isSaved () { return saved; }
	
	public boolean isLimited () { return ang.isLimited (); }
	
}
