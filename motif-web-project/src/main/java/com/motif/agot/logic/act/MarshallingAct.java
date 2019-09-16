package com.motif.agot.logic.act;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.motif.agot.ang.enums.AngType;
import com.motif.agot.ang.text.instants.AngPayNGold;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.act.MarshallingPayCostStep.IAgotHasMarshallingPayCostStep;
import com.motif.agot.logic.events.AgotEventProcess;
import com.motif.agot.logic.events.list.MarshallEvent;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.logic.other.AbilityContext;
import com.motif.agot.logic.other.FilterMatcher;
import com.motif.agot.logic.phases.marshalling.IMarshallingPhaseStep;
import com.motif.agot.logic.requests.AAgotRequest.AgotRequestType;
import com.motif.agot.logic.requests.AgotChoice;
import com.motif.agot.logic.requests.AgotChoice.AgotChoiceCardAction;
import com.motif.agot.logic.visitors.CostPayTester;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;
import com.motif.agot.state.MarshallModifier;
import com.motif.agot.state.cards.AttachmentCard;
import com.motif.agot.state.cards.MarshallCard;
import com.motif.shared.util.MotifConsole;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MarshallingAct extends Act implements IPhaseAct, IMarshallingPhaseStep, IAgotHasMarshallingPayCostStep {

	@Getter private final MarshallCard<?> card;
	private final AgotPlayer player;
	private final AgotGame game;
	
	@Getter private final IHasPhaseAct parent;
	@Override public IAgotFlowStep next(AgotContext context) { return this.parent.after(this, context); }
	
	@Override
	public final IAgotFlowStep start(AgotContext context) {
		var cost = determineCost (true);
		var ac = new AbilityContext(this.card /*or null?*/, this.player);
		var payCostStep = new MarshallingPayCostStep(cost, ac, this.game, this);
		return payCostStep;
	}

	@Override
	public IAgotFlowStep after(MarshallingPayCostStep actPayCostStep, AgotContext context) {
		Stream<MarshallCard<?>> attachableTo = this.card.isType(AngType.ATTACHMENT) ? attachableTo () : null;
		var event = new MarshallEvent(this.card, this.player, getDuplicate (), attachableTo, this.game); 
		return new AgotEventProcess(event, this.game, this);
	}
	
	@Override
	public boolean canBeInitiated () {
		if (!this.card.isControlledBy (this.player)) { return false; }
		if (!this.card.isInHand ()) { return false; }
		if (this.card.isLimited ()) {
			if (this.player.getMarshalledLimited () > 0) { return false; }
		} // if
		if (this.card.isType (AngType.ATTACHMENT)) { if (!canBeAttached ()) { return false; } }
		return true;
	} // canBeInitiated

	private boolean canBeAttached () {
		return attachableTo ().findAny ().isPresent ();
	}
	
	private Stream<MarshallCard<?>> attachableTo () {
		var att = (AttachmentCard) this.card;
		Stream<MarshallCard<?>> attachable = this.game.players ().flatMap (p -> p.characters ());
		if (att.hasRestriction ()) {
			attachable = attachable.filter (card -> FilterMatcher.doesMatch (card, new AbilityContext (this.card, this.player), att.getRestriction ()));
		} // if
		return attachable;
	} // attachableTo
	
	@Override
	public boolean canBePaid () {
		AngPayNGold cost = determineCost (false);
		return CostPayTester.canBePaid (cost, card, player, game);
	} // canBePaid
	
	private AngPayNGold determineCost (boolean removeUsedModifiers) {
		if (enterAsDuplicate ()) {
			return new AngPayNGold (0);
		} else {
			var cost = card.getCost ();
			var usedModifiers = new ArrayList<MarshallModifier> ();
			int modifiers = this.player.marshallModifers ()
			.filter (marshallModifier -> !marshallModifier.isConsumed ())
	        .filter (marshallModifier -> FilterMatcher.doesMatch (card, marshallModifier.getAbilityContext (), marshallModifier.getAng ().getCardFilter ()))
	        .peek (marshallModifier -> usedModifiers.add (marshallModifier))
	        .map (marshallModifier -> marshallModifier.getAng ().getN ())
	        .collect (Collectors.summingInt (Integer::intValue));
			if (removeUsedModifiers) {
				usedModifiers.forEach (m -> m.setConsumed (true));
			} // if
			int finalCost = Math.max (cost - modifiers, 0);
			return new AngPayNGold (finalCost);
		} // if - else
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
	public String toString() { return MotifConsole.format ("Marshall {0}", card.getTitle ()); }

	@Override
	public long getCardId() {
		return this.card.id();
	}
	
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
	public AgotChoice getChoice (AgotRequestType requestType) {
		return AgotChoice.selectCardActionChoice (requestType, this.card, AgotChoiceCardAction.MARSHALL);
	}
	
}
