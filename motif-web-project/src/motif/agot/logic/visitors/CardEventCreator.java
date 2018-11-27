package motif.agot.logic.visitors;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import motif.agot.ang.text.costs.IAngCost;
import motif.agot.ang.text.costs.IAngCostVisitor;
import motif.agot.ang.text.effects.IAngEffect;
import motif.agot.ang.text.effects.IAngEffectVisitor;
import motif.agot.ang.text.filters.AngPlayerFilter;
import motif.agot.ang.text.instants.AngChooseACard;
import motif.agot.ang.text.instants.AngDiscardATokenFromThis;
import motif.agot.ang.text.instants.AngDiscardNCardsFromYourHand;
import motif.agot.ang.text.instants.AngDrawNCards;
import motif.agot.ang.text.instants.AngGainNGold;
import motif.agot.ang.text.instants.AngInstants.AngDiscardFromPlayEach;
import motif.agot.ang.text.instants.AngInstants.AngDiscardFromPlayThat;
import motif.agot.ang.text.instants.AngInstants.AngDiscardNCardsAtRandomFromEachPlayerHand;
import motif.agot.ang.text.instants.AngInstants.AngDiscardNPowerFromThat;
import motif.agot.ang.text.instants.AngInstants.AngEffectEachCard;
import motif.agot.ang.text.instants.AngInstants.AngGainNPowerOnThis;
import motif.agot.ang.text.instants.AngInstants.AngGainNPowerOnYourFaction;
import motif.agot.ang.text.instants.AngInstants.AngKillThat;
import motif.agot.ang.text.instants.AngInstants.AngKneelAttached;
import motif.agot.ang.text.instants.AngInstants.AngKneelEach;
import motif.agot.ang.text.instants.AngInstants.AngKneelThat;
import motif.agot.ang.text.instants.AngInstants.AngKneelThis;
import motif.agot.ang.text.instants.AngInstants.AngPlaceOneTokenOnThis;
import motif.agot.ang.text.instants.AngInstants.AngSaveAttached;
import motif.agot.ang.text.instants.AngInstants.AngSaveThat;
import motif.agot.ang.text.instants.AngInstants.AngSaveThis;
import motif.agot.ang.text.instants.AngInstants.AngShuffleThatBackIntoYourDeck;
import motif.agot.ang.text.instants.AngInstants.AngStandAttached;
import motif.agot.ang.text.instants.AngInstants.AngStandEach;
import motif.agot.ang.text.instants.AngInstants.AngStandThat;
import motif.agot.ang.text.instants.AngInstants.AngStandThis;
import motif.agot.ang.text.instants.AngInstants.AngTakeControlOfThat;
import motif.agot.ang.text.instants.AngKneelYourFactionCard;
import motif.agot.ang.text.instants.AngLastingEffect;
import motif.agot.ang.text.instants.AngMovePowersFromAFactionToAFaction;
import motif.agot.ang.text.instants.AngPayNGold;
import motif.agot.ang.text.instants.AngPutThatIntoPlayUnderYourControl;
import motif.agot.ang.text.instants.AngReduceTheCostOTheNextCardYouMarshallThisPhaseByN;
import motif.agot.ang.text.instants.AngRemoveThisFromTheGame;
import motif.agot.ang.text.instants.AngReturnThisToYourHand;
import motif.agot.ang.text.instants.AngSacrificeThis;
import motif.agot.logic.events.Event;
import motif.agot.logic.events.list.ApplyLastingEffectEvent;
import motif.agot.logic.events.list.DiscardFromPlayEvent;
import motif.agot.logic.events.list.DiscardNPowerFromEvent;
import motif.agot.logic.events.list.DrawNCardsEvent;
import motif.agot.logic.events.list.GainNGoldEvent;
import motif.agot.logic.events.list.GainNPowerOnEvent;
import motif.agot.logic.events.list.KillEvent;
import motif.agot.logic.events.list.KneelEvent;
import motif.agot.logic.events.list.MoveNPowerEvent;
import motif.agot.logic.events.list.MultiEvent;
import motif.agot.logic.events.list.PayNGoldEvent;
import motif.agot.logic.events.list.PlaceOneTokenEvent;
import motif.agot.logic.events.list.ReturnToYourHandEvent;
import motif.agot.logic.events.list.SaveEvent;
import motif.agot.logic.events.list.StandEvent;
import motif.agot.logic.other.AbilityContext;
import motif.agot.logic.other.FilterMatcher;
import motif.agot.state.AgotGame;
import motif.agot.state.AgotPlayer;
import motif.agot.state.cards.AttachmentCard;
import motif.agot.state.cards.Card;
import motif.agot.state.cards.CharacterCard;
import motif.agot.state.cards.DrawCard;
import motif.agot.state.cards.MarshallCard;

public class CardEventCreator implements IAngEffectVisitor, IAngCostVisitor {

	public static Event getEvent (IAngEffect effect, AbilityContext ac, AgotGame game) {
		CardEventCreator creator = new CardEventCreator (ac, game);
		effect.accept (creator);
		Event event = creator.event;
		return event;
	} // getEvent

	public static Event getEvent (IAngCost cost, AbilityContext ac, AgotGame game) {
		CardEventCreator creator = new CardEventCreator (ac, game);
		cost.accept (creator);
		Event event = creator.event;
		return event;
	} // getEvent

	
	private Event event;
	private AbilityContext ac;
	private AgotGame game;

	private CardEventCreator (AbilityContext ac, AgotGame game) {
		this.ac = ac;
		this.game = game;
	} // CardEffectCreator
	
	private boolean visit (AngEffectEachCard effect, Function<? super Card<?>, ? extends Event> mapper) {
		List<? extends Event> events = FilterMatcher.allMatches (ac.you, game, effect.getFilter ())
		.map (mapper)
		.collect (Collectors.toList ());
		event = new MultiEvent (events, game);
		return true;
	} // visit
	
	@Override
	public boolean visit (AngChooseACard effect) {
		IAngEffect targetEffect = effect.getTargetEffect ();
		event = getEvent (targetEffect, ac, game);
		return true;
	} // visit

	@Override public boolean visit (AngGainNGold effect) { event = new GainNGoldEvent (effect.getN (), ac.you, game); return true; }
	@Override public boolean visit (AngDrawNCards effect) { event = new DrawNCardsEvent (effect.getN (), ac.you, game); return true; }
	@Override public boolean visit (AngStandThis effect) { event = new StandEvent (ac.thisCard, game); return true; }
	@Override public boolean visit (AngStandThat effect) { event = new StandEvent (ac.thatCard, game); return true; }
	@Override public boolean visit (AngStandAttached effect) { event = new StandEvent (((AttachmentCard) ac.thisCard).getAttachTo (), game); return true; }
	@Override public boolean visit (AngStandEach effect) { return visit (effect, c -> new StandEvent (ac.thisCard, game)); }
	@Override public boolean visit (AngKneelThis effect) { event = new KneelEvent (ac.thisCard, game); return true; }
	@Override public boolean visit (AngKneelThat effect) { event = new KneelEvent (ac.thatCard, game); return true; }
	@Override public boolean visit (AngKneelAttached effect) { event = new KneelEvent (((AttachmentCard) ac.thisCard).getAttachTo (), game); return true; }
	@Override public boolean visit (AngKneelYourFactionCard instant) { event = new KneelEvent (ac.you.getFaction (), game); return true; }
	@Override public boolean visit (AngKneelEach effect) { return visit (effect, c -> new KneelEvent (c, game)); }
	@Override public boolean visit (AngKillThat effect) { event = new KillEvent ((CharacterCard) ac.thatCard, game); return true; }
	@Override public boolean visit (AngDiscardNPowerFromThat effect) { event = new DiscardNPowerFromEvent (effect.getN (), ac.thatCard, game); return true; }
	@Override public boolean visit (AngDiscardFromPlayThat effect) { event = new DiscardFromPlayEvent ((MarshallCard<?>) ac.thatCard, game); return true; }
	@Override public boolean visit (AngDiscardFromPlayEach effect) { return visit (effect, c -> new DiscardFromPlayEvent ((MarshallCard<?>) c, game)); }
	@Override public boolean visit (AngGainNPowerOnThis effect) { event = new GainNPowerOnEvent (effect.getN (), ac.thisCard, game); return true; }
	@Override public boolean visit (AngGainNPowerOnYourFaction effect) { event = new GainNPowerOnEvent (effect.getN (), ac.you.getFaction (), game); return true; }
	@Override public boolean visit (AngReturnThisToYourHand effect) { event = new ReturnToYourHandEvent ((DrawCard<?>) ac.thisCard, game); return true; }
	@Override public boolean visit (AngLastingEffect effect) { event = new ApplyLastingEffectEvent (effect, ac, game); return true; }
	@Override public boolean visit (AngPlaceOneTokenOnThis effect) { event = new PlaceOneTokenEvent (effect.getToken (), (MarshallCard<?>) ac.thisCard, game); return true; }
	@Override public boolean visit (AngSaveThis effect) { event = new SaveEvent ((MarshallCard<?>) ac.thisCard, game); return true; }
	@Override public boolean visit (AngSaveAttached effect) { event = new SaveEvent (((AttachmentCard) ac.thisCard).getAttachTo (), game); return true; }
	@Override public boolean visit (AngSaveThat effect) { event = new SaveEvent ((MarshallCard<?>) ac.thatCard, game); return true; }
	
	@Override
	public boolean visit (AngReduceTheCostOTheNextCardYouMarshallThisPhaseByN effect) {
		// TODO Auto-generated method stub
		return false;
	} // visit
	
	@Override
	public boolean visit (AngPutThatIntoPlayUnderYourControl effect) {
		// TODO Auto-generated method stub
		return false;
	} // visit

	@Override
	public boolean visit (AngShuffleThatBackIntoYourDeck effect) {
		// TODO Auto-generated method stub
		return false;
	} // visit
	
	@Override
	public boolean visit (AngMovePowersFromAFactionToAFaction effect) {
		AngPlayerFilter fromFilter = effect.getFromPlayer ();
		AgotPlayer fromPlayer = game.players ()
		.filter (p -> FilterMatcher.doesMatch (p, ac.you, fromFilter, game))
		.findFirst ().get ();
		AngPlayerFilter toFilter = effect.getToPlayer ();
		AgotPlayer toPlayer = game.players ()
		.filter (p -> FilterMatcher.doesMatch (p, ac.you, toFilter, game))
		.findFirst ().get ();
		int nPower = Math.min (effect.getN (), fromPlayer.getFaction ().getPower ());
		event = new MoveNPowerEvent (nPower, fromPlayer.getFaction (), toPlayer.getFaction (), game);
		return true;
	} // visit

	@Override public boolean visit (AngPayNGold instant) { event = new PayNGoldEvent (instant.getNGold (), ac.you, game); return true; }

	@Override
	public boolean visit (AngRemoveThisFromTheGame instant) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visit (AngSacrificeThis instant) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visit (AngDiscardNCardsFromYourHand angStandThis) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visit (AngDiscardATokenFromThis angStandThis) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visit (AngDiscardNCardsAtRandomFromEachPlayerHand effect) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visit (AngTakeControlOfThat effect) {
		// TODO Auto-generated method stub
		return false;
	}

	
} // CardEventCreator
