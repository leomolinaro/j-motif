package com.motif.agot.logic.visitors;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.motif.agot.ang.text.costs.IAngCost;
import com.motif.agot.ang.text.costs.IAngCostVisitor;
import com.motif.agot.ang.text.effects.IAngEffect;
import com.motif.agot.ang.text.effects.IAngEffectVisitor;
import com.motif.agot.ang.text.filters.AngPlayerFilter;
import com.motif.agot.ang.text.instants.AngChooseACard;
import com.motif.agot.ang.text.instants.AngDiscardATokenFromThis;
import com.motif.agot.ang.text.instants.AngDiscardNCardsFromYourHand;
import com.motif.agot.ang.text.instants.AngDrawNCards;
import com.motif.agot.ang.text.instants.AngGainNGold;
import com.motif.agot.ang.text.instants.AngKneelYourFactionCard;
import com.motif.agot.ang.text.instants.AngLastingEffect;
import com.motif.agot.ang.text.instants.AngMovePowersFromAFactionToAFaction;
import com.motif.agot.ang.text.instants.AngPayNGold;
import com.motif.agot.ang.text.instants.AngPutThatIntoPlayUnderYourControl;
import com.motif.agot.ang.text.instants.AngReduceTheCostOTheNextCardYouMarshallThisPhaseByN;
import com.motif.agot.ang.text.instants.AngRemoveThisFromTheGame;
import com.motif.agot.ang.text.instants.AngReturnThisToYourHand;
import com.motif.agot.ang.text.instants.AngSacrificeThis;
import com.motif.agot.ang.text.instants.AngInstants.AngDiscardFromPlayEach;
import com.motif.agot.ang.text.instants.AngInstants.AngDiscardFromPlayThat;
import com.motif.agot.ang.text.instants.AngInstants.AngDiscardNCardsAtRandomFromEachPlayerHand;
import com.motif.agot.ang.text.instants.AngInstants.AngDiscardNPowerFromThat;
import com.motif.agot.ang.text.instants.AngInstants.AngEffectEachCard;
import com.motif.agot.ang.text.instants.AngInstants.AngGainNPowerOnThis;
import com.motif.agot.ang.text.instants.AngInstants.AngGainNPowerOnYourFaction;
import com.motif.agot.ang.text.instants.AngInstants.AngKillThat;
import com.motif.agot.ang.text.instants.AngInstants.AngKneelAttached;
import com.motif.agot.ang.text.instants.AngInstants.AngKneelEach;
import com.motif.agot.ang.text.instants.AngInstants.AngKneelThat;
import com.motif.agot.ang.text.instants.AngInstants.AngKneelThis;
import com.motif.agot.ang.text.instants.AngInstants.AngPlaceOneTokenOnThis;
import com.motif.agot.ang.text.instants.AngInstants.AngSaveAttached;
import com.motif.agot.ang.text.instants.AngInstants.AngSaveThat;
import com.motif.agot.ang.text.instants.AngInstants.AngSaveThis;
import com.motif.agot.ang.text.instants.AngInstants.AngShuffleThatBackIntoYourDeck;
import com.motif.agot.ang.text.instants.AngInstants.AngStandAttached;
import com.motif.agot.ang.text.instants.AngInstants.AngStandEach;
import com.motif.agot.ang.text.instants.AngInstants.AngStandThat;
import com.motif.agot.ang.text.instants.AngInstants.AngStandThis;
import com.motif.agot.ang.text.instants.AngInstants.AngTakeControlOfThat;
import com.motif.agot.logic.events.AgotEvent;
import com.motif.agot.logic.events.list.ApplyLastingEffectEvent;
import com.motif.agot.logic.events.list.DiscardFromPlayEvent;
import com.motif.agot.logic.events.list.DiscardNPowerFromEvent;
import com.motif.agot.logic.events.list.DrawNCardsEvent;
import com.motif.agot.logic.events.list.GainNGoldEvent;
import com.motif.agot.logic.events.list.GainNPowerOnEvent;
import com.motif.agot.logic.events.list.KillEvent;
import com.motif.agot.logic.events.list.KneelEvent;
import com.motif.agot.logic.events.list.MoveNPowerEvent;
import com.motif.agot.logic.events.list.MultiEvent;
import com.motif.agot.logic.events.list.PayNGoldEvent;
import com.motif.agot.logic.events.list.PlaceOneTokenEvent;
import com.motif.agot.logic.events.list.ReturnToYourHandEvent;
import com.motif.agot.logic.events.list.SaveEvent;
import com.motif.agot.logic.events.list.StandEvent;
import com.motif.agot.logic.other.AbilityContext;
import com.motif.agot.logic.other.FilterMatcher;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;
import com.motif.agot.state.cards.AttachmentCard;
import com.motif.agot.state.cards.Card;
import com.motif.agot.state.cards.CharacterCard;
import com.motif.agot.state.cards.DrawCard;
import com.motif.agot.state.cards.MarshallCard;

public class CardEventCreator implements IAngEffectVisitor, IAngCostVisitor {

	public static AgotEvent getEvent (IAngEffect effect, AbilityContext ac, AgotGame game) {
		CardEventCreator creator = new CardEventCreator (ac, game);
		effect.accept (creator);
		AgotEvent event = creator.event;
		return event;
	} // getEvent

	public static AgotEvent getEvent (IAngCost cost, AbilityContext ac, AgotGame game) {
		CardEventCreator creator = new CardEventCreator (ac, game);
		cost.accept (creator);
		AgotEvent event = creator.event;
		return event;
	} // getEvent

	
	private AgotEvent event;
	private AbilityContext ac;
	private AgotGame game;

	private CardEventCreator (AbilityContext ac, AgotGame game) {
		this.ac = ac;
		this.game = game;
	} // CardEffectCreator
	
	private boolean visit (AngEffectEachCard effect, Function<? super Card<?>, ? extends AgotEvent> mapper) {
		List<? extends AgotEvent> events = FilterMatcher.allMatches (ac.you, game, effect.getFilter ())
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
		int nPower = Math.min (effect.getN (), fromPlayer.getFaction ().power ());
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
