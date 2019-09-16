package com.motif.agot.logic.act;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.motif.agot.ang.enums.AngType;
import com.motif.agot.ang.text.AngTrigAbility;
import com.motif.agot.ang.text.effects.IAngEffect;
import com.motif.agot.ang.text.filters.AngCardFilter;
import com.motif.agot.ang.text.instants.AngChooseACard;
import com.motif.agot.ang.text.limit.AngTrigLimit;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.act.TrigAbilityPayCostStep.IAgotHasTrigAbilityPayCostStep;
import com.motif.agot.logic.events.AgotEventProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.logic.other.AbilityContext;
import com.motif.agot.logic.other.ExitGameProcedure;
import com.motif.agot.logic.other.FilterMatcher;
import com.motif.agot.logic.requests.ChooseATargetCardRequest;
import com.motif.agot.logic.requests.ChooseATargetCardRequest.IAgotHasChooseATargetCardRequest;
import com.motif.agot.logic.visitors.CardEventCreator;
import com.motif.agot.logic.visitors.CostPayTester;
import com.motif.agot.logic.visitors.EffectChangeTester;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.cards.Card;
import com.motif.agot.state.cards.EventCard;
import com.motif.agot.state.cards.MarshallCard;
import com.motif.agot.state.cards.TextCard;
import com.motif.shared.exceptions.MotifUnexpectedError;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class TrigAbilityAct<T extends AngTrigAbility> extends Act implements IAgotHasTrigAbilityPayCostStep, IAgotHasChooseATargetCardRequest {

	@Getter protected final T trigAbility;
	public TextCard<?> getTrigCard() { return ac.thisCard; }
	protected final AbilityContext ac;
	protected final AgotGame game;
	
	@Override
	public final IAgotFlowStep start (AgotContext context) {
		if (this.trigAbility.hasCost ()) {
			return new TrigAbilityPayCostStep (this.trigAbility.getCost (), this.ac, this.game, this);
		} else {
			return after ((TrigAbilityPayCostStep) null, context);
		} // if - else
	} // start

	@Override
	public IAgotFlowStep after (TrigAbilityPayCostStep actPayCostStep, AgotContext context) {
		ChooseATargetCardRequest chooseTargetStep = chooseTargetStep (context);
		if (chooseTargetStep == null) {
			return actEventStep (this.trigAbility.getEffect (), context);
		} else {
			return chooseTargetStep;
		} // if - else
	} // after
	
	private ChooseATargetCardRequest chooseTargetStep (AgotContext context) {
		if (this.trigAbility.getEffect () instanceof AngChooseACard) {
			AngChooseACard chooseEffect = (AngChooseACard) this.trigAbility.getEffect ();
			List<Card<?>> targettableCards = this.getTargettableCards (chooseEffect).collect (Collectors.toList ());
			return new ChooseATargetCardRequest (targettableCards, this.ac.you, this);
		} else {
			return null;
		} // if - else
	} // chooseTargetStep
	
	@Override
	public IAgotFlowStep after (ChooseATargetCardRequest decision, AgotContext context) {
		var targetCard = decision.getChoosenModel ();
		this.ac.setThatCard (targetCard);
		var chooseEffect = (AngChooseACard) this.trigAbility.getEffect ();
		var targetEffect = chooseEffect.getTargetEffect ();
		return actEventStep (targetEffect, context);
	} // after
	
	private AgotEventProcess actEventStep (IAngEffect effect, AgotContext context) {
		if (trigAbility.hasTrigLimit ()) {
			game.registerAbility (trigAbility, (MarshallCard<?>) ac.thisCard);
		}
		if (ac.thisCard.isType (AngType.EVENT)) {
			ExitGameProcedure.playEvent ((EventCard) ac.thisCard, ac.you, game, context);
		}
		var event = CardEventCreator.getEvent (effect, this.ac, this.game);
		return new AgotEventProcess (event, this.game, this);
	} // actEventStep
	
	@Override
	public boolean canBeInitiated () {
		if (!this.ac.thisCard.isControlledBy (this.ac.you)) { return false; }
		if (!this.ac.thisCard.isInteracting ()) { return false; }
		if (this.trigAbility.hasTrigLimit ()) {
			AngTrigLimit limit = this.trigAbility.getTrigLimit ();
			int triggeredTimes;
			switch (limit.getPer ()) {
				case GAME: throw new MotifUnexpectedError();
				case PHASE: triggeredTimes = this.game.getPhaseCounter(this.trigAbility, (MarshallCard<?>) this.ac.thisCard); break;
				case ROUND: triggeredTimes = this.game.getRoundCounter(this.trigAbility, (MarshallCard<?>) this.ac.thisCard); break;
				default: throw new MotifUnexpectedError();
			}
			if (triggeredTimes >= limit.getTimes ()) { return false; }
		}
		if (this.trigAbility.hasTrigMax ()) {
			AngTrigLimit max = this.trigAbility.getTrigMax ();
			int triggeredTimes;
			switch (max.getPer ()) {
				case GAME: throw new MotifUnexpectedError ();
				case PHASE: triggeredTimes = this.game.getPhaseCounter (((EventCard) this.ac.thisCard).getAngCard (), this.ac.you); break;
				case ROUND: triggeredTimes = this.game.getRoundCounter (((EventCard) this.ac.thisCard).getAngCard (), this.ac.you); break;
				default: throw new MotifUnexpectedError ();
			} // switch
			if (triggeredTimes >= max.getTimes()) { return false; }
		}
		// In caso di bersagli, verifico l'esistenza di almeno un bersaglio valido.
		if (this.trigAbility.getEffect () instanceof AngChooseACard) {
			AngChooseACard chooseEffect = (AngChooseACard) this.trigAbility.getEffect ();
			var nTargettableCards = this.getTargettableCards (chooseEffect).collect (Collectors.counting ());
			if (nTargettableCards <= 0) { return false; }
		} // if
		boolean doesChangeState = EffectChangeTester.doesChangeState (this.trigAbility.getEffect (), this.ac, this.game);
		if (!doesChangeState) { return false; }
		return true;
	} // canBeInitiated
	
	private Stream<Card<?>> getTargettableCards (AngChooseACard chooseEffect) {
		AngCardFilter cardFilter = chooseEffect.getCardFilter ();
		IAngEffect targetEffect = chooseEffect.getTargetEffect ();
		return this.game.inPlayCards ()
		        .filter (card -> FilterMatcher.doesMatch (card, this.ac, cardFilter))
		        .filter (targetCard -> {
			        this.ac.setThatCard (targetCard);
			        var doesChangeState = EffectChangeTester.doesChangeState (targetEffect, this.ac, this.game);
			        this.ac.setThatCard (null);
			        return doesChangeState;
		        });
	} // getTargettableCards
	
	@Override
	public final boolean canBePaid () {
		if (trigAbility.hasCost ()) {
			boolean canBePaid = CostPayTester.canBePaid (trigAbility.getCost (), ac.thisCard, ac.you, game);
			return canBePaid;
		} else {
			return true;
		} // if - else
	} // canBePaid
	
} // TrigAbilityAct
