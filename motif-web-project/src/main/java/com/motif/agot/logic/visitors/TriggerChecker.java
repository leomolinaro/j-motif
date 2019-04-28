package com.motif.agot.logic.visitors;

import java.util.List;
import java.util.function.Predicate;

import com.motif.agot.ang.enums.AngSubject;
import com.motif.agot.ang.text.filters.AngCardFilter;
import com.motif.agot.ang.text.triggeringconditions.AngACardEntersPlay;
import com.motif.agot.ang.text.triggeringconditions.AngACardGainsOneOrMorePower;
import com.motif.agot.ang.text.triggeringconditions.AngACardIsDiscardedFromPlay;
import com.motif.agot.ang.text.triggeringconditions.AngACardIsKilled;
import com.motif.agot.ang.text.triggeringconditions.AngACardIsSacrificed;
import com.motif.agot.ang.text.triggeringconditions.AngACardLeavesPlay;
import com.motif.agot.ang.text.triggeringconditions.AngACardLosesOneOrMorePower;
import com.motif.agot.ang.text.triggeringconditions.AngAChallengeIsInitiated;
import com.motif.agot.ang.text.triggeringconditions.AngAChallengeIsLost;
import com.motif.agot.ang.text.triggeringconditions.AngAChallengeIsWon;
import com.motif.agot.ang.text.triggeringconditions.AngOr;
import com.motif.agot.ang.text.triggeringconditions.AngPhaseBegins;
import com.motif.agot.ang.text.triggeringconditions.AngPhaseEnds;
import com.motif.agot.ang.text.triggeringconditions.AngYouMarshallOrPlayACard;
import com.motif.agot.ang.text.triggeringconditions.AngYouMarshallThis;
import com.motif.agot.ang.text.triggeringconditions.AngYouWinDominance;
import com.motif.agot.ang.text.triggeringconditions.IAngTriggeringCondition;
import com.motif.agot.ang.text.triggeringconditions.IAngTriggeringConditionVisitor;
import com.motif.agot.logic.events.AgotEvent;
import com.motif.agot.logic.events.IEventVisitor;
import com.motif.agot.logic.events.list.ApplyLastingEffectEvent;
import com.motif.agot.logic.events.list.ChallengeEndEvent;
import com.motif.agot.logic.events.list.DetermineAChallengeEvent;
import com.motif.agot.logic.events.list.DiscardFromPlayEvent;
import com.motif.agot.logic.events.list.DiscardNPowerFromEvent;
import com.motif.agot.logic.events.list.DrawNCardsEvent;
import com.motif.agot.logic.events.list.GainNGoldEvent;
import com.motif.agot.logic.events.list.GainNPowerOnEvent;
import com.motif.agot.logic.events.list.InitiateAChallengeEvent;
import com.motif.agot.logic.events.list.KillEvent;
import com.motif.agot.logic.events.list.KneelEvent;
import com.motif.agot.logic.events.list.MarshallEvent;
import com.motif.agot.logic.events.list.MoveNPowerEvent;
import com.motif.agot.logic.events.list.MultiEvent;
import com.motif.agot.logic.events.list.PayNGoldEvent;
import com.motif.agot.logic.events.list.PhaseBeginsEvent;
import com.motif.agot.logic.events.list.PhaseEndsEvent;
import com.motif.agot.logic.events.list.PlaceOneTokenEvent;
import com.motif.agot.logic.events.list.ReturnToYourHandEvent;
import com.motif.agot.logic.events.list.SaveEvent;
import com.motif.agot.logic.events.list.StandEvent;
import com.motif.agot.logic.events.list.WinDominanceEvent;
import com.motif.agot.logic.other.FilterMatcher;
import com.motif.agot.logic.other.Subjects;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;
import com.motif.agot.state.Challenge;
import com.motif.agot.state.cards.Card;
import com.motif.agot.state.cards.CharacterCard;
import com.motif.agot.state.cards.TextCard;

public class TriggerChecker implements IEventVisitor {

	public static boolean canTrigger (AgotEvent event, IAngTriggeringCondition trigCond, TextCard<?> trigCard, AgotPlayer trigPlayer, AgotGame game) {
		TriggerChecker checker = new TriggerChecker (trigCard, trigPlayer, game);
		boolean hasEventChecker = event.accept (checker);
		if (hasEventChecker) {
			EventTrigChecker<?> eventChecker = checker.eventTrigChecker;
			boolean canTrigger = trigCond.accept (eventChecker);
			return canTrigger;
		} else {
			return false;
		} // if - else
	} // canTrigger
	
	private TextCard<?> trigCard;
	private AgotPlayer you;
	private AgotGame game;
	private EventTrigChecker<?> eventTrigChecker = null;
	
	private TriggerChecker (TextCard<?> trigCard, AgotPlayer you, AgotGame game) {
		this.trigCard = trigCard;
		this.you = you;
		this.game = game;
	} // TriggerChecker
	
	private boolean checkSubject (AngSubject subject, AngCardFilter cardFilter, Predicate<? super Card<?>> predicate) {
		return Subjects.test (subject, cardFilter, predicate, null, trigCard, you, game);
	} // checkSubject
	
	private abstract class EventTrigChecker<E extends AgotEvent> implements IAngTriggeringConditionVisitor {
		protected E event;
		protected EventTrigChecker (E event) {
			this.event = event;
		} // EventTriggerChecker
		@Override public final boolean visit (AngOr trigCond) {
			return trigCond.trigConds ()
			.anyMatch (tc -> tc.accept (this));
		} // visit
	} // EventTriggerChecker
	
	private abstract class StandardEventTrigChecker<E extends AgotEvent> extends EventTrigChecker<E> {
		protected StandardEventTrigChecker (E event) { super (event); }
		@Override public boolean visit (AngYouMarshallThis trigCond) { return false; }
		@Override public boolean visit (AngPhaseBegins trigCond) { return false; }
		@Override public boolean visit (AngPhaseEnds trigCond) { return false; }
		@Override public boolean visit (AngYouMarshallOrPlayACard trigCond) { return false; }
		@Override public boolean visit (AngACardIsSacrificed trigCond) { return false; }
		@Override public boolean visit (AngACardIsKilled trigCond) { return false; }
		@Override public boolean visit (AngACardIsDiscardedFromPlay trigCond) { return false; }
		@Override public boolean visit (AngAChallengeIsInitiated trigCond) { return false; }
		@Override public boolean visit (AngAChallengeIsWon trigCond) { return false; }
		@Override public boolean visit (AngAChallengeIsLost trigCond) { return false; }
		@Override public boolean visit (AngACardGainsOneOrMorePower trigCond) { return false; }
		@Override public boolean visit (AngACardEntersPlay trigCond) { return false; }
		@Override public boolean visit (AngYouWinDominance trigCond) { return false; }
		@Override public boolean visit (AngACardLeavesPlay trigCond) { return false; }
		@Override public boolean visit (AngACardLosesOneOrMorePower trigCond) { return false; }
	} // StandardEventTrigChecker

	private class ApplyLastingEffectEventTrigChecker extends StandardEventTrigChecker<ApplyLastingEffectEvent> {
		protected ApplyLastingEffectEventTrigChecker (ApplyLastingEffectEvent event) { super (event); }
	} // SaveEventTrigChecker

	private class SaveEventTrigChecker extends StandardEventTrigChecker<SaveEvent> {
		protected SaveEventTrigChecker (SaveEvent event) { super (event); }
	} // SaveEventTrigChecker

	private class DiscardFromPlayEventTrigChecker extends StandardEventTrigChecker<DiscardFromPlayEvent> {
		protected DiscardFromPlayEventTrigChecker (DiscardFromPlayEvent event) { super (event); }
		private boolean doesMatch (AngCardFilter cardFilter) {
			if (event.isSaved ()) {
				return false;
			} else {
				return FilterMatcher.doesMatch (event.getCard (), event.getCard ().getController (), cardFilter); }				
			} // if - else
		@Override public boolean visit (AngACardIsDiscardedFromPlay trigCond) { return doesMatch (trigCond.getCardFilter ()); }
		@Override public boolean visit (AngACardLeavesPlay trigCond) { return doesMatch (trigCond.getCardFilter ()); }
	} // DiscardFromPlayEventTrigChecker
	
	private class ReturnToYourHandEventTrigChecker extends StandardEventTrigChecker<ReturnToYourHandEvent> {
		protected ReturnToYourHandEventTrigChecker (ReturnToYourHandEvent event) { super (event); }
		private boolean doesMatch (AngCardFilter cardFilter) { return FilterMatcher.doesMatch (event.getCard (), event.getCard ().getController (), cardFilter); }
		@Override public boolean visit (AngACardLeavesPlay trigCond) { return doesMatch (trigCond.getCardFilter ()); }
	} // ReturnToYourHandEventTrigChecker
	
	private class KillEventTrigChecker extends StandardEventTrigChecker<KillEvent> {
		protected KillEventTrigChecker (KillEvent event) { super (event); }
		@Override public boolean visit (AngACardIsKilled trigCond) {
			if (event.isSaved ()) {
				return false;
			} else {
				return checkSubject (trigCond.getSubject (), trigCond.getCardFilter (), card -> card instanceof CharacterCard && event.doesKill ((CharacterCard) card));				
			} // if - else
		} // visit
	} // KillEventTrigChecker
	
	private class MarshallEventTrigChecker extends StandardEventTrigChecker<MarshallEvent> {
		protected MarshallEventTrigChecker (MarshallEvent event) { super (event); }
		@Override public boolean visit (AngYouMarshallThis trigCond) { return event.getMarshalledCard () == trigCard; }
		@Override public boolean visit (AngACardEntersPlay trigCond) { return event.getMarshalledCard () == trigCard; }
		@Override public boolean visit (AngYouMarshallOrPlayACard trigCond) {
			boolean doesMatch = FilterMatcher.doesMatch (event.getMarshalledCard (), you, trigCond.getCardFilter ());
			return doesMatch;
		} // visit
	} // MarshallEventTrigChecker
	
	private class DiscardNPowerFromEventTrigChecker extends StandardEventTrigChecker<DiscardNPowerFromEvent> {
		protected DiscardNPowerFromEventTrigChecker (DiscardNPowerFromEvent event) { super (event); }
	} // DiscardNPowerFromEventTrigChecker
	
	private class DrawNCardsEventTrigChecker extends StandardEventTrigChecker<DrawNCardsEvent> {
		protected DrawNCardsEventTrigChecker (DrawNCardsEvent event) { super (event); }
	} // DrawNCardsEventTrigChecker
	
	private class GainNGoldEventTrigChecker extends StandardEventTrigChecker<GainNGoldEvent> {
		protected GainNGoldEventTrigChecker (GainNGoldEvent event) { super (event); }
	} // GainNGoldEventTrigChecker
	
	private class GainNPowerOnEventTrigChecker extends StandardEventTrigChecker<GainNPowerOnEvent> {
		protected GainNPowerOnEventTrigChecker (GainNPowerOnEvent event) { super (event); }
		@Override public boolean visit (AngACardGainsOneOrMorePower trigCond) {
			return checkSubject (trigCond.getSubject (), trigCond.getCardFilter (), card -> event.getCard () == card);
		} // visit
	} // GainNPowerOnEventTrigChecker

	private class MoveNPowerEventTrigChecker extends StandardEventTrigChecker<MoveNPowerEvent> {
		protected MoveNPowerEventTrigChecker (MoveNPowerEvent event) { super (event); }
		@Override public boolean visit (AngACardGainsOneOrMorePower trigCond) {
			return checkSubject (trigCond.getSubject (), trigCond.getCardFilter (), card -> event.getToCard () == card);
		} // visit
		@Override public boolean visit (AngACardLosesOneOrMorePower trigCond) {
			return checkSubject (trigCond.getSubject (), trigCond.getCardFilter (), card -> event.getFromCard () == card);
		} // visit
	} // GainNPowerOnEventTrigChecker
	
	private class KneelEventTrigChecker extends StandardEventTrigChecker<KneelEvent> {
		protected KneelEventTrigChecker (KneelEvent event) { super (event); }
	} // KneelEventTrigChecker
	
	private class StandEventTrigChecker extends StandardEventTrigChecker<StandEvent> {
		protected StandEventTrigChecker (StandEvent event) { super (event); }
	} // StandEventTrigChecker
	
	private class PhaseBeginsEventTrigChecker extends StandardEventTrigChecker<PhaseBeginsEvent> {
		protected PhaseBeginsEventTrigChecker (PhaseBeginsEvent event) { super (event); }
		@Override public boolean visit (AngPhaseBegins trigCond) { return event.getPhase ().equals (trigCond.getPhase ()); }
	} // PhaseBeginsEventTrigChecker
	
	private class PhaseEndsEventTrigChecker extends StandardEventTrigChecker<PhaseEndsEvent> {
		protected PhaseEndsEventTrigChecker (PhaseEndsEvent event) { super (event); }
		@Override public boolean visit (AngPhaseEnds trigCond) { return event.getPhase ().equals (trigCond.getPhase ()); }
	} // PhaseEndsEventTrigChecker

	private class InitiateAChallengeEventTrigChecker extends StandardEventTrigChecker<InitiateAChallengeEvent> {
		protected InitiateAChallengeEventTrigChecker (InitiateAChallengeEvent event) { super (event); }
		@Override public boolean visit (AngAChallengeIsInitiated trigCond) {
			return FilterMatcher.doesMatch (event.getChallenge (), you, null, trigCard, trigCond.getChallengeFilter (), game);
		} // visit
	} // InitiateAChallengeEventTrigChecker

	private class WinDominanceEventTrigChecker extends StandardEventTrigChecker<WinDominanceEvent> {
		protected WinDominanceEventTrigChecker (WinDominanceEvent event) { super (event); }
		@Override public boolean visit (AngYouWinDominance trigCond) {
			return event.getWinner () == you;
		} // visit
	} // WinDominanceEventTrigChecker

	private class DetermineAChallengeEventTrigChecker extends StandardEventTrigChecker<DetermineAChallengeEvent> {
		protected DetermineAChallengeEventTrigChecker (DetermineAChallengeEvent event) { super (event); }
		@Override public boolean visit (AngAChallengeIsWon trigCond) {
			Challenge challenge = event.getChallenge ();
			boolean challengeMathces = FilterMatcher.doesMatch (challenge, you, null, trigCard, trigCond.getChallengeFilter (), game);
			if (challengeMathces && (challenge.attackWins () || challenge.defenseWins ())) {
				if (trigCond.byYou ()) {
					return challenge.winner () == you;
				} else if (trigCond.againstYou ()) {
					return challenge.winner () != you;
				} else {
					return true;
				} // if - else
			} else {
				return false;
			} // if - else
		} // visit
		@Override public boolean visit (AngAChallengeIsLost trigCond) {
			Challenge challenge = event.getChallenge ();
			boolean challengeMathces = FilterMatcher.doesMatch (challenge, you, null, trigCard, trigCond.getChallengeFilter (), game);
			if (challengeMathces && (challenge.attackLoses () || challenge.defenseLoses ())) {
				if (trigCond.byYou ()) {
					return challenge.loser () == you;
				} else if (trigCond.againstYou ()) {
					return challenge.loser () != you;
				} else {
					return true;
				} // if - else
			} else {
				return false;
			} // if - else
		} // visit
	} // DetermineAChallengeEventTrigChecker
	
	private class MultiEventTrigChecker extends EventTrigChecker<MultiEvent> {
		protected MultiEventTrigChecker (MultiEvent event) { super (event); }
		private boolean canTrigger (IAngTriggeringCondition trigCond) {
			List<? extends AgotEvent> events = this.event.getEvents ();
			return events.stream ()
			.anyMatch (event -> {
				TriggerChecker checker = TriggerChecker.this;
				event.accept (checker);
				EventTrigChecker<?> eventChecker = checker.eventTrigChecker;
				boolean canTrigger = trigCond.accept (eventChecker);
				return canTrigger;
			});
		}
		@Override public boolean visit (AngYouMarshallThis trigCond) { return canTrigger (trigCond); }
		@Override public boolean visit (AngPhaseBegins trigCond) { return canTrigger (trigCond); }
		@Override public boolean visit (AngPhaseEnds trigCond) { return canTrigger (trigCond); }
		@Override public boolean visit (AngYouMarshallOrPlayACard trigCond) { return canTrigger (trigCond); }
		@Override public boolean visit (AngACardIsSacrificed trigCond) { return canTrigger (trigCond); }
		@Override public boolean visit (AngACardIsKilled trigCond) { return canTrigger (trigCond); }
		@Override public boolean visit (AngACardIsDiscardedFromPlay trigCond) { return canTrigger (trigCond); }
		@Override public boolean visit (AngAChallengeIsInitiated trigCond) { return canTrigger (trigCond); }
		@Override public boolean visit (AngAChallengeIsWon trigCond) { return canTrigger (trigCond); }
		@Override public boolean visit (AngAChallengeIsLost trigCond) { return canTrigger (trigCond); }
		@Override public boolean visit (AngACardGainsOneOrMorePower trigCond) { return canTrigger (trigCond); }
		@Override public boolean visit (AngACardLosesOneOrMorePower trigCond) { return canTrigger (trigCond); }
		@Override public boolean visit (AngACardEntersPlay trigCond) { return canTrigger (trigCond); }
		@Override public boolean visit (AngYouWinDominance trigCond) { return canTrigger (trigCond); }
		@Override public boolean visit (AngACardLeavesPlay trigCond) { return canTrigger (trigCond); }
	} // MultiEventTrigChecker

	@Override public boolean visit (ApplyLastingEffectEvent event) { eventTrigChecker = new ApplyLastingEffectEventTrigChecker (event); return true; }
	@Override public boolean visit (SaveEvent event) { eventTrigChecker = new SaveEventTrigChecker (event); return true; }
	@Override public boolean visit (DiscardFromPlayEvent event) { eventTrigChecker = new DiscardFromPlayEventTrigChecker (event); return true; }
	@Override public boolean visit (DiscardNPowerFromEvent event) { eventTrigChecker = new DiscardNPowerFromEventTrigChecker (event); return true; }
	@Override public boolean visit (DrawNCardsEvent event) { eventTrigChecker = new DrawNCardsEventTrigChecker (event); return true; }
	@Override public boolean visit (GainNGoldEvent event) { eventTrigChecker = new GainNGoldEventTrigChecker (event); return true; }
	@Override public boolean visit (GainNPowerOnEvent event) { eventTrigChecker = new GainNPowerOnEventTrigChecker (event); return true; }
	@Override public boolean visit (KneelEvent event) { eventTrigChecker = new KneelEventTrigChecker (event); return true; }
	@Override public boolean visit (MarshallEvent event) { eventTrigChecker = new MarshallEventTrigChecker (event); return true; }
	@Override public boolean visit (PhaseBeginsEvent event) { eventTrigChecker = new PhaseBeginsEventTrigChecker (event); return true; }
	@Override public boolean visit (PhaseEndsEvent event) { eventTrigChecker = new PhaseEndsEventTrigChecker (event); return true; }
	@Override public boolean visit (ReturnToYourHandEvent event) { eventTrigChecker = new ReturnToYourHandEventTrigChecker (event); return true; }
	@Override public boolean visit (StandEvent event) { eventTrigChecker = new StandEventTrigChecker (event); return true; }
	@Override public boolean visit (KillEvent event) { eventTrigChecker = new KillEventTrigChecker (event); return true; }
	@Override public boolean visit (InitiateAChallengeEvent event) { eventTrigChecker = new InitiateAChallengeEventTrigChecker (event); return true; }
	@Override public boolean visit (DetermineAChallengeEvent event) { eventTrigChecker = new DetermineAChallengeEventTrigChecker (event); return true; }
	@Override public boolean visit (MultiEvent event) { eventTrigChecker = new MultiEventTrigChecker (event); return true; }
	@Override public boolean visit (MoveNPowerEvent event) { eventTrigChecker = new MoveNPowerEventTrigChecker (event); return true; }
	@Override public boolean visit (WinDominanceEvent event) { eventTrigChecker = new WinDominanceEventTrigChecker (event); return true; }
	@Override public boolean visit (PlaceOneTokenEvent event) { return false; }
	@Override public boolean visit (PayNGoldEvent event) { return false; }
	@Override public boolean visit (ChallengeEndEvent event) { return false; }

} // TriggerChecker
