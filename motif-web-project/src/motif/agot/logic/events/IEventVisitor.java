package motif.agot.logic.events;

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

public interface IEventVisitor {

	public boolean visit (DiscardFromPlayEvent event);
	public boolean visit (DiscardNPowerFromEvent event);
	public boolean visit (DrawNCardsEvent event);
	public boolean visit (GainNGoldEvent event);
	public boolean visit (GainNPowerOnEvent event);
	public boolean visit (KneelEvent event);
	public boolean visit (MarshallEvent event);
	public boolean visit (PhaseBeginsEvent event);
	public boolean visit (PhaseEndsEvent event);
	public boolean visit (ReturnToYourHandEvent event);
	public boolean visit (SaveEvent event);
	public boolean visit (StandEvent event);
	public boolean visit (KillEvent event);
	public boolean visit (InitiateAChallengeEvent event);
	public boolean visit (DetermineAChallengeEvent event);
	public boolean visit (MultiEvent event);
	public boolean visit (ApplyLastingEffectEvent event);
	public boolean visit (PlaceOneTokenEvent event);
	public boolean visit (PayNGoldEvent event);
	public boolean visit (ChallengeEndEvent event);
	public boolean visit (MoveNPowerEvent event);
	public boolean visit (WinDominanceEvent event);

} // IEventVisitor
