package com.motif.agot.logic.act;

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
import com.motif.agot.logic.visitors.CostPayTester;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;
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
		var cost = determineCost();
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
		if (!this.card.isControlledBy(this.player)) { return false; }
		if (!this.card.isInHand()) { return false; }
		if (this.card.isLimited()) {
			if (this.player.getMarshalledLimited() > 0) { return false; }
		}
		if (this.card.isType(AngType.ATTACHMENT)) { if (!canBeAttached()) { return false; } }
		return true;
	}

	private boolean canBeAttached() {
		return attachableTo().findAny().isPresent();
	}
	
	private Stream<MarshallCard<?>> attachableTo() {
		AttachmentCard att = (AttachmentCard) card;
		Stream<MarshallCard<?>> attachable = game.players ().flatMap (p -> p.characters ());
		if (att.hasRestriction ()) {
			attachable = attachable.filter (card -> FilterMatcher.doesMatch (card, player, att.getRestriction ()));
		}
		return attachable;
	}
	
	@Override
	public boolean canBePaid () {
		AngPayNGold cost = determineCost();
		return CostPayTester.canBePaid (cost, card, player, game);
	}
	
	private AngPayNGold determineCost() {
		if (enterAsDuplicate()) {
			return new AngPayNGold(0);
		} else {
			int cost = card.getCost ();
//			ArrayList<DelayedEffect> appliedModifiers = new ArrayList<DelayedEffect> ();
//			CostModifier modifier = new CostModifier ();
//			for (DelayedEffect delayedEffect : game.getDelayedEffects ()) {
//				if (delayedEffect.accept (modifier)) { appliedModifiers.add (delayedEffect); }
//			} // for
//			cost += modifier.costModifier;
			return new AngPayNGold (cost);
//			mCost.appliedModifiers = appliedModifiers;
		} // if - else
	}
	
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

	@Override
	public long getCardId() {
		return this.card.getId();
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

}
