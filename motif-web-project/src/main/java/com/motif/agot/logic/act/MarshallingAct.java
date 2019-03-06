package com.motif.agot.logic.act;

import java.util.stream.Stream;

import com.motif.agot.ang.enums.AngType;
import com.motif.agot.ang.text.instants.AngPayNGold;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.flow.request.IAgotModelVisitor;
import com.motif.agot.flow.task.IAgotTask;
import com.motif.agot.logic.events.Event;
import com.motif.agot.logic.events.list.MarshallEvent;
import com.motif.agot.logic.other.AbilityContext;
import com.motif.agot.logic.other.FilterMatcher;
import com.motif.agot.logic.visitors.CardEventCreator;
import com.motif.agot.logic.visitors.CostPayTester;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;
import com.motif.agot.state.cards.AttachmentCard;
import com.motif.agot.state.cards.MarshallCard;
import com.motif.shared.util.MotifConsole;

import lombok.Getter;

public class MarshallingAct extends Act {

	@Getter private MarshallCard<?> card;
	
	private AgotPlayer player;
	
	public MarshallingAct (MarshallCard<?> card, AgotPlayer player, AgotGame game) {
		super (game);
		this.card = card;
		this.player = player;
	} // MarshallingTrigger

	@Override
	public boolean canBeInitiated () {
		if (!card.isControlledBy (player)) { return false; }
		if (!card.isInHand ()) { return false; }
		if (card.isLimited ()) {
			if (player.getMarshalledLimited () > 0) { return false; }
		} // if
		if (card.isType (AngType.ATTACHMENT)) { if (!canBeAttached ()) { return false; } }
		return true;
	} // canBeInitiated

	private boolean canBeAttached () {
		return attachableTo ().findAny ().isPresent ();
	} // canBeAttached
	
	private Stream<MarshallCard<?>> attachableTo () {
		AttachmentCard att = (AttachmentCard) card;
		Stream<MarshallCard<?>> attachable = game.players ().flatMap (p -> p.characters ());
		if (att.hasRestriction ()) {
			attachable = attachable.filter (card -> FilterMatcher.doesMatch (card, player, att.getRestriction ()));
		} // if
		return attachable;
	} // attachableTo
	
	@Override
	public boolean canBePaid () {
		AngPayNGold cost = determineCost ().finalCost;
		return CostPayTester.canBePaid (cost, card, player, game);
	} // canBePaid
	
	private MarshallingCost determineCost () {
		MarshallingCost mCost = new MarshallingCost ();
		if (enterAsDuplicate ()) {
			mCost.finalCost = new AngPayNGold (0);
		} else {
			int cost = card.getCost ();
//			ArrayList<DelayedEffect> appliedModifiers = new ArrayList<DelayedEffect> ();
//			CostModifier modifier = new CostModifier ();
//			for (DelayedEffect delayedEffect : game.getDelayedEffects ()) {
//				if (delayedEffect.accept (modifier)) { appliedModifiers.add (delayedEffect); }
//			} // for
//			cost += modifier.costModifier;
			mCost.finalCost = new AngPayNGold (cost);
//			mCost.appliedModifiers = appliedModifiers;
		} // if - else
		return mCost;
	} // determineCost
	
	private boolean enterAsDuplicate () {
		return getDuplicate () != null;
	} // enterAsDuplicate
	
	private MarshallCard<?> getDuplicate () {
		return player.charactersLocationsAndAttachments ()
		.filter (c -> c.isDuplicate (card))
		.findFirst ()
		.orElse (null);
	} // getDuplicate

	@Override
	public String getLabel () { return MotifConsole.format ("Marshall {0}", card.getTitle ()); }

	private class MarshallingCost {
		// private ArrayList<DelayedEffect> appliedModifiers = new ArrayList<DelayedEffect> ();
		private AngPayNGold finalCost;
	} // MarshallingCost
	
//	@SuppressWarnings("unused")
//	private class CostModifier implements IAngDelayedEffectVisitor {
//
//		private int costModifier = 0;
//		
//		@Override
//		public void visit (AngReduceTheCostOTheNextCardYouMarshallByN effect) {
//			boolean applied = false;
//			AngCardFilter cardFilter = effect.getCardFilter ();
//			if (CardMatcher.doesMatch (card, player, cardFilter)) {
//				costModifier -= effect.getN ();
//				applied = true;
//			} // if
//		} // visit
//		
//	} // CostModifier

	@Override
	protected ActPayCostStep getPayCostStep (AgotContext context) {
		return new MarshallingPayCostStep ();
	} // getPayCostStep

	@Override
	protected Event getEvent () {
		Stream<MarshallCard<?>> attachableTo = card.isType (AngType.ATTACHMENT) ? attachableTo () : null;
		Event event = new MarshallEvent (card, player, getDuplicate (), attachableTo, game); 
		return event;
	} // getEvent
	
	protected final class MarshallingPayCostStep extends ActPayCostStep {

		@Override
		public IAgotTask getStart (AgotContext context) {
			MarshallingCost mCost = determineCost ();
			
			AbilityContext ac = new AbilityContext (card, player);
			Event event = CardEventCreator.getEvent (mCost.finalCost, ac, game);
			return event.resolveEffect (context);
			// if (mCost.appliedModifiers != null) {
			// 	 for (DelayedEffect delEff : mCost.appliedModifiers) {
			// 	   game.removeDelayedEffect (delEff);
			// 	   DebugUtil.todo ("print used modifiers");
			// 	 } // for			
			// } // if
		} // getStart
		
	} // MarshallingPayCostStep
	
	

	@Override public void accept (IAgotModelVisitor visitor) { visitor.visit (this); }

	@Override
	protected ActChooseTargetStep getChooseTargetStep (AgotContext context) { return null; }

} // MarshallingTrigger
