package motif.agot.logic.visitors;

import motif.agot.ang.text.untilconditions.AngUntilTheEndOfTheChallenge;
import motif.agot.ang.text.untilconditions.AngUntilTheEndOfThePhase;
import motif.agot.ang.text.untilconditions.IAngUntilCondition;
import motif.agot.ang.text.untilconditions.IAngUntilConditionVisitor;
import motif.agot.logic.events.Event;
import motif.agot.logic.events.IEventVisitor;
import motif.agot.logic.events.list.ApplyLastingEffectEvent;
import motif.agot.logic.events.list.ChallengeEndEvent;
import motif.agot.logic.events.list.DetermineAChallengeEvent;
import motif.agot.logic.events.list.DiscardFromPlayEvent;
import motif.agot.logic.events.list.DiscardNPowerFromEvent;
import motif.agot.logic.events.list.DrawNCardsEvent;
import motif.agot.logic.events.list.GainNGoldEvent;
import motif.agot.logic.events.list.GainNPowerOnEvent;
import motif.agot.logic.events.list.InitiateAChallengeEvent;
import motif.agot.logic.events.list.KillEvent;
import motif.agot.logic.events.list.KneelEvent;
import motif.agot.logic.events.list.MarshallEvent;
import motif.agot.logic.events.list.MoveNPowerEvent;
import motif.agot.logic.events.list.MultiEvent;
import motif.agot.logic.events.list.PayNGoldEvent;
import motif.agot.logic.events.list.PhaseBeginsEvent;
import motif.agot.logic.events.list.PhaseEndsEvent;
import motif.agot.logic.events.list.PlaceOneTokenEvent;
import motif.agot.logic.events.list.ReturnToYourHandEvent;
import motif.agot.logic.events.list.SaveEvent;
import motif.agot.logic.events.list.StandEvent;
import motif.agot.logic.events.list.WinDominanceEvent;
import motif.agot.state.AgotGame;

public class UntilChecker implements IEventVisitor {

	public static boolean check (Event event, IAngUntilCondition untilCond, AgotGame game) {
		UntilChecker checker = new UntilChecker (game);
		boolean check = event.accept (checker);
		if (check) {
			EventUntilChecker<?> eventChecker = checker.eventUntilChecker;
			check = untilCond.accept (eventChecker);			
		} // if
		return check;
	} // canTrigger
	
	@SuppressWarnings("unused")
	private AgotGame game;
	private EventUntilChecker<?> eventUntilChecker;
	
	private UntilChecker (AgotGame game) {
		this.game = game;
	} // UntilChecker
	
	private abstract class EventUntilChecker<E extends Event> implements IAngUntilConditionVisitor {
		@SuppressWarnings("unused")
		protected E event;
		protected EventUntilChecker (E event) {
			this.event = event;
		} // EventUntilChecker
	} // EventTriggerChecker
	
	private abstract class StandardEventUntilChecker<E extends Event> extends EventUntilChecker<E> {
		protected StandardEventUntilChecker (E event) { super (event); }
		@Override public boolean visit (AngUntilTheEndOfThePhase untilCond) { return false; }
		@Override public boolean visit (AngUntilTheEndOfTheChallenge untilCond) { return false; }
	} // StandardEventUntilChecker
	
	private class PhaseEndsEventUntilChecker extends StandardEventUntilChecker<PhaseEndsEvent> {
		protected PhaseEndsEventUntilChecker (PhaseEndsEvent event) { super (event); }
		@Override public boolean visit (AngUntilTheEndOfThePhase untilCond) { return true; }
	} // PhaseEndsEventUntilChecker

	private class ChallengeEndEventUntilChecker extends StandardEventUntilChecker<ChallengeEndEvent> {
		protected ChallengeEndEventUntilChecker (ChallengeEndEvent event) { super (event); }
		@Override public boolean visit (AngUntilTheEndOfTheChallenge untilCond) { return true; }
	} // ChallengeEndEventUntilChecker

	@Override public boolean visit (ApplyLastingEffectEvent event) { return false; }
	@Override public boolean visit (SaveEvent event) { return false; }
	@Override public boolean visit (DiscardFromPlayEvent event) { return false; }
	@Override public boolean visit (DiscardNPowerFromEvent event) { return false; }
	@Override public boolean visit (DrawNCardsEvent event) { return false; }
	@Override public boolean visit (GainNGoldEvent event) { return false; }
	@Override public boolean visit (GainNPowerOnEvent event) { return false; }
	@Override public boolean visit (KneelEvent event) { return false; }
	@Override public boolean visit (MarshallEvent event) { return false; }
	@Override public boolean visit (PhaseBeginsEvent event) { return false; }
	@Override public boolean visit (PhaseEndsEvent event) { eventUntilChecker = new PhaseEndsEventUntilChecker (event); return true; }
	@Override public boolean visit (ChallengeEndEvent event) { eventUntilChecker = new ChallengeEndEventUntilChecker (event); return true; }
	@Override public boolean visit (ReturnToYourHandEvent event) { return false; }
	@Override public boolean visit (StandEvent event) { return false; }
	@Override public boolean visit (KillEvent event) { return false; }
	@Override public boolean visit (InitiateAChallengeEvent event) { return false; }
	@Override public boolean visit (DetermineAChallengeEvent event) { return false; }
	@Override public boolean visit (MultiEvent event) { return false; }
	@Override public boolean visit (PlaceOneTokenEvent event) { return false; }
	@Override public boolean visit (PayNGoldEvent event) { return false; }
	@Override public boolean visit (MoveNPowerEvent event) { return false; }
	@Override public boolean visit (WinDominanceEvent event) { return false; }

} // TriggerChecker
