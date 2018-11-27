package motif.agot.logic.act;

import java.util.stream.Stream;

import motif.agot.ang.AgotText;
import motif.agot.ang.enums.AngType;
import motif.agot.ang.text.AngTrigAbility;
import motif.agot.ang.text.effects.IAngEffect;
import motif.agot.ang.text.filters.AngCardFilter;
import motif.agot.ang.text.instants.AngChooseACard;
import motif.agot.ang.text.limit.AngTrigLimit;
import motif.agot.endpoint.AgotContext;
import motif.agot.flow.request.AgotRequest;
import motif.agot.flow.request.AgotRequest.AgotRequestCod;
import motif.agot.flow.request.AgotResponse;
import motif.agot.flow.task.AgotHumanTask;
import motif.agot.flow.task.IAgotTask;
import motif.agot.logic.events.Event;
import motif.agot.logic.other.AbilityContext;
import motif.agot.logic.other.ExitGameProcedure;
import motif.agot.logic.other.FilterMatcher;
import motif.agot.logic.visitors.CardEventCreator;
import motif.agot.logic.visitors.CostPayTester;
import motif.agot.logic.visitors.EffectChangeTester;
import motif.agot.state.AgotGame;
import motif.agot.state.cards.Card;
import motif.agot.state.cards.EventCard;
import motif.agot.state.cards.MarshallCard;
import motif.agot.state.cards.TextCard;
import motif.shared.exceptions.MotifUnexpectedError;

public abstract class TrigAbilityAct<T extends AngTrigAbility> extends Act {

	protected T trigAbility;
	public T getTrigAbility () { return trigAbility; }
	
	public TextCard<?> getTrigCard () { return ac.thisCard; }

	protected AbilityContext ac;
	
	public TrigAbilityAct (T trigAbility, AbilityContext ac, AgotGame game) {
		super (game);
		this.ac = ac;
	} // TrigAbilityActStep

	@Override
	public boolean canBeInitiated () {
		if (!ac.thisCard.isControlledBy (ac.you)) { return false; }
		if (!ac.thisCard.isInteracting ()) { return false; }
		if (trigAbility.hasTrigLimit ()) {
			AngTrigLimit limit = trigAbility.getTrigLimit ();
			int triggeredTimes;
			switch (limit.getPer ()) {
				case GAME: throw new MotifUnexpectedError ();
				case PHASE: triggeredTimes = game.getPhaseCounter (trigAbility, (MarshallCard<?>) ac.thisCard); break;
				case ROUND: triggeredTimes = game.getRoundCounter (trigAbility, (MarshallCard<?>) ac.thisCard); break;
				default: throw new MotifUnexpectedError ();
			} // switch
			if (triggeredTimes >= limit.getTimes ()) { return false; }
		} // if
		if (trigAbility.hasTrigMax ()) {
			AngTrigLimit max = trigAbility.getTrigMax ();
			int triggeredTimes;
			switch (max.getPer ()) {
				case GAME: throw new MotifUnexpectedError ();
				case PHASE: triggeredTimes = game.getPhaseCounter (((EventCard) ac.thisCard).getAngCard (), ac.you); break;
				case ROUND: triggeredTimes = game.getRoundCounter (((EventCard) ac.thisCard).getAngCard (), ac.you); break;
				default: throw new MotifUnexpectedError ();
			} // switch
			if (triggeredTimes >= max.getTimes ()) { return false; }
		}
		boolean doesChangeState = EffectChangeTester.doesChangeState (trigAbility.getEffect (), ac, game);
		if (!doesChangeState) { return false; }
		return true;
	} // canBeInitiated
	
	@Override
	public final boolean canBePaid () {
		if (trigAbility.hasCost ()) {
			boolean canBePaid = CostPayTester.canBePaid (trigAbility.getCost (), ac.thisCard, ac.you, game);
			return canBePaid;
		} else {
			return true;
		} // if - else
	} // canBePaid
	
	@Override
	protected final ActPayCostStep getPayCostStep (AgotContext context) {
		return new TrigAbilityPayCostStep ();
	} // getPayCostStep
	
	@Override
	protected final ActChooseTargetStep getChooseTargetStep (AgotContext context) {
		if (trigAbility.getEffect () instanceof AngChooseACard) {
			AngChooseACard chooseEffect = (AngChooseACard) trigAbility.getEffect ();
			AngCardFilter cardFilter = chooseEffect.getCardFilter ();
			IAngEffect targetEffect = chooseEffect.getTargetEffect ();
			Stream<Card<?>> targettableCards = game.inPlayCards ()
					.filter (card -> FilterMatcher.doesMatch (card, ac.you, cardFilter))
					.filter (targetCard -> {
						ac.setThatCard (targetCard);
						boolean doesChangeState = EffectChangeTester.doesChangeState (targetEffect, ac, game);
						ac.setThatCard (null);
						return doesChangeState;
					});
			return new TrigAbilityChooseATargetStep (targettableCards);
		} else {
			return null;
		} // if - else
	} // getChooseTargetStep
	
	@Override
	protected ActEventStep getActEventStep (AgotContext context) {
		return new TrigAbilityEventStep ();
	} // getActEventStep
	
	@Override
 	protected Event getEvent () {
		Event event = CardEventCreator.getEvent (trigAbility.getEffect (), ac, game);
		return event;
	} // getEvent
	
	protected final class TrigAbilityPayCostStep extends ActPayCostStep {

		@Override
		public IAgotTask getStart (AgotContext context) {
			if (trigAbility.hasCost ()) {
				Event event = CardEventCreator.getEvent (trigAbility.getCost (), ac, game);
				return event.resolveEffect (context);
			} else {
				return null;				
			} // if - else
		} // getStart
		
	} // ReactionPayCostStep
	
	private class TrigAbilityChooseATargetStep extends ActChooseTargetStep {

		private Stream<Card<?>> targettableCards;
		
		public TrigAbilityChooseATargetStep (Stream<Card<?>> targettableCards) {
			this.targettableCards = targettableCards;
		} // ChooseATargetCardStep
		
		@Override
		public IAgotTask getStart (AgotContext context) {
			return new ChooseATargetCardRequest ();
		} // getStart
		
		private class ChooseATargetCardRequest extends AgotHumanTask {

			private AgotRequest<Card<?>> pendingRequest = null;

			@Override
			public IAgotTask receiveResponse (AgotResponse response, AgotContext context) {
				Card<?> targetCard = pendingRequest.getChoice (response).getModel ();
				ac.setThatCard (targetCard);
				return null;
			} // receiveResponse

			@Override
			public AgotRequest<?> getRequest (AgotContext context) {
				pendingRequest = AgotRequest.createRequest (AgotRequestCod.CHOOSE_CARD, ac.you, targettableCards, AgotText.request ().chooseACard (ac.you));
				return pendingRequest;
			} // getRequest

		} // ChooseATargetCardRequest
		
	} // ChooseATargetCardStep
	
	private class TrigAbilityEventStep extends ActEventStep {

		@Override
		public IAgotTask getNextTask (AgotContext context) {
			 if (trigAbility.hasTrigLimit ()) {
			 	game.registerAbility (trigAbility, (MarshallCard<?>) ac.thisCard);				
			 } // if
			 if (ac.thisCard.isType (AngType.EVENT)) {
				ExitGameProcedure.playEvent ((EventCard) ac.thisCard, ac.you, game, context);
			} // if
			return super.getNextTask (context);
		} // getNextTask
		
	} // TrigAbilityEventStep
	
} // TrigAbilityActStep
