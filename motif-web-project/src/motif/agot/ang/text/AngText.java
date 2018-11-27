package motif.agot.ang.text;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import motif.agot.ang.enums.AngKeyword;
import motif.agot.ang.enums.AngPlotValueModifier;
import motif.agot.ang.enums.AngTrait;
import motif.agot.ang.text.AngAction.AB;
import motif.agot.ang.text.AngAction.AngActionType;
import motif.agot.ang.text.AngConsAbility.CAB;
import motif.agot.ang.text.AngInterrupt.IB;
import motif.agot.ang.text.AngReaction.RB;
import motif.agot.ang.text.AngWhenRevealed.WRB;
import motif.agot.ang.text.filters.AngCardFilter;
import motif.agot.ang.text.filters.AngCardFilter.CFB;

public class AngText {

	private ArrayList<AngTrait> traits = new ArrayList<AngTrait> ();
	public boolean hasTrait (AngTrait trait) { return traits.contains (trait); }
	
	private AngAction action = null;
	public boolean hasAction () { return action != null; }
	public AngAction getAction () { return action; }

	private AngReaction reaction = null;
	public boolean hasReaction () { return reaction != null; }
	public AngReaction getReaction () { return reaction; }

	private AngInterrupt interrupt = null;
	public boolean hasInterrupt () { return interrupt != null; }
	public AngInterrupt getInterrupt () { return interrupt; }

	private AngReaction forcedReaction = null;
	public boolean hasForcedReaction () { return forcedReaction != null; }
	public AngReaction getForcedReaction () { return forcedReaction; }
	
	private AngInterrupt forcedInterrupt = null;
	public boolean hasForcedInterrupt () { return forcedInterrupt != null; }
	public AngInterrupt getForcedInterrupt () { return forcedInterrupt; }

	private AngWhenRevealed whenRevealed = null;
	public boolean hasWhenRevealed () { return whenRevealed != null; }
	public AngWhenRevealed getWhenRevealed  () { return whenRevealed; }
	
	private ArrayList<AngConsAbility> consAbilities = null;
	public boolean hasConsAbilities () { return consAbilities != null; }
	public Stream<AngConsAbility> consAbilities () { return consAbilities.stream (); }
	
	private ArrayList<AngTextKeyword> keywords = new ArrayList<AngTextKeyword> ();
	public boolean hasKeyword (AngKeyword keyword) { return keywords.stream ().map (txtKey -> txtKey.getKeyword ()).anyMatch (key -> key.equals (keyword)); }
	
	private AngCardFilter attachmentRestriction;
	public boolean hasAttachmentRestriction () { return attachmentRestriction != null; }
	public AngCardFilter getAttachmentRestriction () { return attachmentRestriction; }
	
	private ArrayList<AngTextPlotValueModifier> plotValueModifiers = new ArrayList<AngTextPlotValueModifier> ();
	public int getGoldModifier () { return getModifierValue (AngPlotValueModifier.GOLD); }
	public int getReserveModifier () { return getModifierValue (AngPlotValueModifier.RESERVE); }
	public int getInitiativeModifier () { return getModifierValue (AngPlotValueModifier.INITIATIVE); }
	private int getModifierValue (AngPlotValueModifier plotModifier) {
		int value = plotValueModifiers.stream ()
		.filter (modifier -> modifier.isModifier (plotModifier))
		.collect (Collectors.summingInt (modifier -> modifier.getValue ()));
		return value;
	} // getModifierValue
	
	private Integer ambushCost = null;
	
	public Integer getAmbushCost () { return this.ambushCost; }
	
	public static class TB {

		public static TB i () { return new TB (); }
		
		private TB () {}
		
		private AngText text = new AngText ();
		
		public TB ambush (Integer ambushCost) { text.keywords.add (AngTextKeyword.ambush (ambushCost)); return this; }
		public TB insight () { text.keywords.add (AngTextKeyword.insight ()); return this; }
		public TB intimidate () { text.keywords.add (AngTextKeyword.intimidate ()); return this; }
		public TB limited () { text.keywords.add (AngTextKeyword.limited ()); return this; }
		public TB noAttachments () { text.keywords.add (AngTextKeyword.noAttachments (null)); return this; }
		public TB noAttachmentsExcept (AngTrait trait) { text.keywords.add (AngTextKeyword.noAttachments (trait)); return this; }
		public TB pillage () { text.keywords.add (AngTextKeyword.pillage ()); return this; }
		public TB renown () { text.keywords.add (AngTextKeyword.renown ()); return this; }
		public TB stealth () { text.keywords.add (AngTextKeyword.stealth ()); return this; }
		public TB terminal () { text.keywords.add (AngTextKeyword.terminal ()); return this; }
		
		public TB gold (int value) { text.plotValueModifiers.add (AngTextPlotValueModifier.gold (value)); return this; }
		public TB initiative (int value) { text.plotValueModifiers.add (AngTextPlotValueModifier.initiative (value)); return this; }
		public TB reserve (int value) { text.plotValueModifiers.add (AngTextPlotValueModifier.reserve (value)); return this; }
		
		public TB only (CFB cardFilterBuilder) { text.attachmentRestriction = cardFilterBuilder.build (); return this; }
		
		public AngText build () { return text; }
		
		public TB plotAction (AB actionBuilder) { text.action = actionBuilder.build (AngActionType.PLOT_ACTION); return this; }
		public TB drawAction (AB actionBuilder) { text.action = actionBuilder.build (AngActionType.DRAW_ACTION); return this; }
		public TB marshallingAction (AB actionBuilder) { text.action = actionBuilder.build (AngActionType.MARSHALLING_ACTION); return this; }
		public TB challengesAction (AB actionBuilder) { text.action = actionBuilder.build (AngActionType.CHALLENGES_ACTION); return this; }
		public TB dominanceAction (AB actionBuilder) { text.action = actionBuilder.build (AngActionType.DOMINANCE_ACTION); return this; }
		public TB standingAction (AB actionBuilder) { text.action = actionBuilder.build (AngActionType.STANDING_ACTION); return this; }
		public TB taxationAction (AB actionBuilder) { text.action = actionBuilder.build (AngActionType.TAXATION_ACTION); return this; }
		public TB action (AB actionBuilder) { text.action = actionBuilder.build (AngActionType.ACTION); return this; }

		public TB traits (AngTrait...traits) { for (AngTrait trait : traits) { text.traits.add (trait); } return this; }
		public TB reaction (RB reactionBuilder) { text.reaction = reactionBuilder.build (); return this; }
		public TB forcedReaction (RB reactionBuilder) { text.forcedReaction = reactionBuilder.build (); return this; }
		public TB interrupt (IB interruptBuilder) { text.interrupt = interruptBuilder.build (); return this; }
		public TB forcedInterrupt (IB interruptBuilder) { text.forcedInterrupt = interruptBuilder.build (); return this; }
		public TB whenRevealed (WRB whenRevealedBuilder) { text.whenRevealed = whenRevealedBuilder.build (); return this; }
		public TB consAbility (CAB consAbilityBuilder) {
			 if (text.consAbilities == null) { text.consAbilities = new ArrayList<AngConsAbility> (); }
			 text.consAbilities.add (consAbilityBuilder.build ());
			 return this;
		} // consAbility
		
	} // TB

} // AngText
