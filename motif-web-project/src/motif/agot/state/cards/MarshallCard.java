package motif.agot.state.cards;

import java.util.ArrayList;
import java.util.stream.Stream;

import com.google.gson.annotations.Expose;

import motif.agot.ang.cards.AngMarshallCard;
import motif.agot.ang.enums.AngToken;
import motif.agot.endpoint.AgotContext;
import motif.agot.state.AgotPlayer;
import motif.agot.state.cards.AttachmentCard.AttachmentCardVisitor;
import motif.agot.state.cards.CharacterCard.CharacterCardVisitor;
import motif.agot.state.cards.LocationCard.LocationCardVisitor;

public abstract class MarshallCard<A extends AngMarshallCard> extends DrawCard<A> {

	private ArrayList<AttachmentCard> attachments = null;
	@Expose private ArrayList<Long> attachmentIds = null;
	public Stream<AttachmentCard> attachments () { return attachments == null ? Stream.empty () : attachments.stream (); }
	public void removeAttachment (AttachmentCard card) {
		attachments.remove (card);
		attachmentIds.remove (card.getId ());
		if (attachments.isEmpty ()) { attachments = null; attachmentIds = null; }
	} // removeAttachment
	public boolean hasAttachment (AttachmentCard card) { return attachments != null && attachments.contains (card); }
	public boolean hasAttachments () { return attachments != null && !attachments.isEmpty (); }
	public void addAttachment (AttachmentCard card) {
		if (attachments == null) { attachments = new ArrayList<AttachmentCard> (); }
		attachments.add (card);
		if (attachmentIds == null) { attachmentIds = new ArrayList<Long> (); }
		attachmentIds.add (card.getId ());
	} // addAttachment

	private ArrayList<MarshallCard<?>> duplicates = null;
	@Expose private ArrayList<Long> duplicateIds = null;
	public Stream<MarshallCard<?>> duplicates () { return duplicates == null ? Stream.empty () : duplicates.stream (); }
	public void removeDuplicate (MarshallCard<?> card) {
		duplicates.remove (card);
		duplicateIds.remove (card.getId ());
		if (duplicates.isEmpty ()) { duplicates = null; duplicateIds = null; }
	} // removeDuplicate
	public boolean hasDuplicate (MarshallCard<?> card) { return duplicates != null && duplicates.contains (card); }
	public boolean hasduplicates () { return duplicates != null && !duplicates.isEmpty (); }
	public void addDuplicate (MarshallCard<?> card) {
		if (duplicates == null) { duplicates = new ArrayList<MarshallCard<?>> (); }
		duplicates.add (card);
		if (duplicateIds == null) { duplicateIds = new ArrayList<Long> (); }
		duplicateIds.add (card.getId ());
	} // addDuplicate
	
	private ArrayList<AngToken> tokens = null;
	public void addToken (AngToken token, AgotContext context) {
		if (tokens == null) { tokens = new ArrayList<AngToken> (); }
		tokens.add (token);
	} // addToken
	public void removeToken (AngToken token, AgotContext context) {
		tokens.remove (token);
		if (tokens.isEmpty ()) { tokens = null; }
	} // removeToken
	public boolean hasToken (AngToken token) {
		return tokens != null && tokens.contains (token);
	} // hasToken
	
	public MarshallCard (A ang, AgotPlayer owner) {
		super (ang, owner);
	} // MarshallCard

	public boolean isDuplicate (MarshallCard<?> card) {
		return isUnique () && getTitle ().equals (card.getTitle ());
	} // isDuplicate
	
	public final boolean isUnique () { return ang.isUnique (); }
	
	public abstract void accept (MarshallCardVisitor visitor);
	
	public interface MarshallCardVisitor extends AttachmentCardVisitor, LocationCardVisitor, CharacterCardVisitor {
	} // MarshallCardVisitor
	
	private boolean saved;
	public void setSaved () { saved = true; }
	public void unsetSaved () { saved = false; }
	public boolean isSaved () { return saved; }
	
	public boolean isLimited () { return ang.isLimited (); }
	
} // MarshallCard
