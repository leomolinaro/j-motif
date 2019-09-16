package com.motif.agot.logic.visitors;

import java.util.function.Predicate;

import com.motif.agot.ang.text.effects.IAngEffect;
import com.motif.agot.ang.text.effects.IAngEffectVisitor;
import com.motif.agot.ang.text.filters.AngPlayerFilter;
import com.motif.agot.ang.text.instants.AngChooseACard;
import com.motif.agot.ang.text.instants.AngDrawNCards;
import com.motif.agot.ang.text.instants.AngGainNGold;
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
import com.motif.agot.ang.text.instants.AngLastingEffect;
import com.motif.agot.ang.text.instants.AngMovePowersFromAFactionToAFaction;
import com.motif.agot.ang.text.instants.AngPutThatIntoPlayUnderYourControl;
import com.motif.agot.ang.text.instants.AngReturnThisToYourHand;
import com.motif.agot.logic.other.AbilityContext;
import com.motif.agot.logic.other.FilterMatcher;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.cards.AttachmentCard;
import com.motif.agot.state.cards.Card;
import com.motif.agot.state.cards.CharacterCard;
import com.motif.agot.state.cards.DrawCard;

public class EffectChangeTester implements IAngEffectVisitor {

	public static boolean doesChangeState (IAngEffect effect, AbilityContext ac, AgotGame game) {
		EffectChangeTester checker = new EffectChangeTester (ac, game);
		boolean changeState = effect.accept (checker);
		return changeState;
	} // doesChangeState
	
	private AbilityContext ac;
	private AgotGame game;
	
	private EffectChangeTester (AbilityContext ac, AgotGame game) {
		this.ac = ac;
		this.game = game;
	} // ChangeChecker
	
	private boolean visit (AngEffectEachCard effect, Predicate<? super Card<?>> predicate) {
		return game.inPlayCards ()
		.anyMatch (c -> FilterMatcher.doesMatch (c, ac, effect.getFilter ()) && predicate.test (c));
	} // visit
	
	@Override
	public boolean visit (AngChooseACard effect) {
		// Già controllato in canBeInitiated
		return true;
	} // visit

	@Override public boolean visit (AngGainNGold effect) { return true; }
	@Override public boolean visit (AngDrawNCards effect) { return ac.you.canDraw (); }
	
	@Override public boolean visit (AngStandThis effect) { return ac.thisCard.isKneeling (); }
	@Override public boolean visit (AngStandThat effect) { return ac.thatCard.isKneeling (); }
	@Override public boolean visit (AngStandAttached effect) { return ((AttachmentCard) ac.thisCard).getAttachTo ().isKneeling (); }
	@Override public boolean visit (AngStandEach effect) { return visit (effect, c -> c.isKneeling ()); }

	@Override public boolean visit (AngKneelThis effect) { return ac.thisCard.isStanding (); }
	@Override public boolean visit (AngKneelThat effect) { return ac.thatCard.isStanding (); }
	@Override public boolean visit (AngKneelAttached effect) { return ((AttachmentCard) ac.thisCard).getAttachTo ().isStanding (); }
	@Override public boolean visit (AngKneelEach effect) { return visit (effect, c -> c.isStanding ()); }
	
	@Override public boolean visit (AngKillThat effect) { return ((CharacterCard) ac.thatCard).isKillable (); }

	@Override public boolean visit (AngDiscardNPowerFromThat effect) { return ac.thatCard.power () > 0; }

	@Override public boolean visit (AngGainNPowerOnThis effect) { return true; }
	@Override public boolean visit (AngGainNPowerOnYourFaction effect) { return true; }

	@Override public boolean visit (AngDiscardFromPlayThat effect) { return true; }
	@Override public boolean visit (AngDiscardFromPlayEach effect) { return visit (effect, c -> true); }

	@Override public boolean visit (AngPlaceOneTokenOnThis effect) { return true; }
	
	@Override
	public boolean visit (AngMovePowersFromAFactionToAFaction effect) {
		AngPlayerFilter fromFilter = effect.getFromPlayer ();
		return game.players ()
		.anyMatch (p -> FilterMatcher.doesMatch (p, ac, fromFilter, game) && p.getPower () > 0);
	} // visit
	
	@Override public boolean visit (AngReturnThisToYourHand effect) { return !ac.you.hasInHand ((DrawCard<?>) ac.thisCard); }
	@Override public boolean visit (AngShuffleThatBackIntoYourDeck effect) { return !ac.you.hasInDeck ((DrawCard<?>) ac.thatCard); }
	@Override public boolean visit (AngPutThatIntoPlayUnderYourControl effect) { return !ac.thatCard.isControlledBy (ac.you); }

	@Override public boolean visit (AngSaveThat effect) { return true; }
	@Override public boolean visit (AngSaveThis effect) { return true; }
	@Override public boolean visit (AngSaveAttached effect) { return true; }

	@Override public boolean visit (AngLastingEffect effect) { /*TODO da verificare*/ return true; }
	
	@Override
	public boolean visit (AngDiscardNCardsAtRandomFromEachPlayerHand effect) {
		return FilterMatcher.allPlayerMatches (ac, game, effect.getPlayerFilter ())
		.anyMatch (p -> p.handSize () > 0);
	} // visit
	
	@Override
	public boolean visit (AngTakeControlOfThat effect) {
		// TODO AngTakeControlOfThat
		return false;
	} // visit

} // ChangeChecker
