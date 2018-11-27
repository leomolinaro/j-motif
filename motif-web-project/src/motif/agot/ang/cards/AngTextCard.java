package motif.agot.ang.cards;

import java.util.stream.Stream;

import motif.agot.ang.enums.AngFaction;
import motif.agot.ang.enums.AngKeyword;
import motif.agot.ang.enums.AngTrait;
import motif.agot.ang.enums.AngType;
import motif.agot.ang.sets.AgotSetCard;
import motif.agot.ang.text.AngAction;
import motif.agot.ang.text.AngConsAbility;
import motif.agot.ang.text.AngInterrupt;
import motif.agot.ang.text.AngReaction;
import motif.agot.ang.text.AngText;
import motif.agot.ang.text.filters.AngCardFilter;

public abstract class AngTextCard extends AngCard {

	private static String buildImageSource (AgotSetCard setCard, int setId) {		
		String setSource = "";
		switch (setCard.getCardSet ()) {
			case CORE_SET: setSource = "GT01";break;
			default: break;
		} // switch
		StringBuilder s = new StringBuilder ("http://lcg-cdn.fantasyflightgames.com/got2nd/");
		s.append (setSource).append ("_").append (setId).append (".jpg");
		return s.toString ();
	} // buildImageSource
	
//	private AgotSet set;
//	private int setId;
	
	private AngText text;
	public AngAction getAction () { return text.getAction (); }
	public boolean hasAction () { return text.hasAction (); }
	public AngInterrupt getInterrupt () { return text.getInterrupt (); }
	public boolean hasInterrupt () { return text.hasInterrupt (); }
	public AngReaction getReaction () { return text.getReaction (); }
	public boolean hasReaction () { return text.hasReaction (); }
	public int getGoldModifier () { return text.getGoldModifier (); }
	public int getReserveModifier () { return text.getReserveModifier (); }
	public int getInitiativeModifier () { return text.getInitiativeModifier (); }
	public boolean hasTrait (AngTrait trait) { return text.hasTrait (trait); }
	public boolean hasAttachmentRestriction () { return text.hasAttachmentRestriction (); }
	public AngCardFilter getAttachmentRestriction () { return text.getAttachmentRestriction (); }
	public boolean isTerminal () { return hasKeyword (AngKeyword.TERMINAL); }
	public boolean isLimited () { return hasKeyword (AngKeyword.LIMITED); }
	public boolean hasKeyword (AngKeyword keyword) { return text.hasKeyword (keyword); }
	public boolean hasConsAbilities () { return text.hasConsAbilities (); }
	public Stream<AngConsAbility> consAbilities () { return text.consAbilities (); }
	
	public AngTextCard (AgotSetCard setCard, int setId, String title, AngType type, AngFaction faction, AngText text) {
		super (title, type, faction, buildImageSource (setCard, setId));
//		this.set = set;
//		this.setId = setId;
		this.text = text;
	} // AngTextCard

	public abstract void accept (AngTextCardVisitor visitor);
	
	public interface AngTextCardVisitor {
		public void visit (AngCharacterCard card);
		public void visit (AngLocationCard card);
		public void visit (AngAttachmentCard card);
		public void visit (AngEventCard card);
		public void visit (AngAgendaCard card);
		public void visit (AngPlotCard card);
	} // AngTextCardVisitor
	
} // AngTextCard
