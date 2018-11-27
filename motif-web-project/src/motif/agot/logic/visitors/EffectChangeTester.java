package motif.agot.logic.visitors;

import java.util.function.Predicate;

import motif.agot.ang.text.effects.IAngEffect;
import motif.agot.ang.text.effects.IAngEffectVisitor;
import motif.agot.ang.text.filters.AngPlayerFilter;
import motif.agot.ang.text.instants.AngChooseACard;
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
import motif.agot.ang.text.instants.AngLastingEffect;
import motif.agot.ang.text.instants.AngMovePowersFromAFactionToAFaction;
import motif.agot.ang.text.instants.AngPutThatIntoPlayUnderYourControl;
import motif.agot.ang.text.instants.AngReduceTheCostOTheNextCardYouMarshallThisPhaseByN;
import motif.agot.ang.text.instants.AngReturnThisToYourHand;
import motif.agot.logic.other.AbilityContext;
import motif.agot.logic.other.FilterMatcher;
import motif.agot.state.AgotGame;
import motif.agot.state.cards.AttachmentCard;
import motif.agot.state.cards.Card;
import motif.agot.state.cards.CharacterCard;
import motif.agot.state.cards.DrawCard;

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
		.anyMatch (c -> FilterMatcher.doesMatch (c, ac.you, effect.getFilter ()) && predicate.test (c));
	} // visit
	
	@Override
	public boolean visit (AngChooseACard effect) {
		// TODO controllare cambio con i target
		return true;
	}

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

	@Override public boolean visit (AngDiscardNPowerFromThat effect) { return ac.thatCard.getPower () > 0; }

	@Override public boolean visit (AngGainNPowerOnThis effect) { return true; }
	@Override public boolean visit (AngGainNPowerOnYourFaction effect) { return true; }

	@Override public boolean visit (AngDiscardFromPlayThat effect) { return true; }
	@Override public boolean visit (AngDiscardFromPlayEach effect) { return visit (effect, c -> true); }

	@Override public boolean visit (AngPlaceOneTokenOnThis effect) { return true; }
	
	@Override
	public boolean visit (AngMovePowersFromAFactionToAFaction effect) {
		AngPlayerFilter fromFilter = effect.getFromPlayer ();
		return game.players ()
		.anyMatch (p -> FilterMatcher.doesMatch (p, ac.you, fromFilter, game) && p.getPower () > 0);
	} // visit
	
	@Override public boolean visit (AngReduceTheCostOTheNextCardYouMarshallThisPhaseByN effect) { return true; }
	@Override public boolean visit (AngReturnThisToYourHand effect) { return !ac.you.hasInHand ((DrawCard<?>) ac.thisCard); }
	@Override public boolean visit (AngShuffleThatBackIntoYourDeck effect) { return !ac.you.hasInDeck ((DrawCard<?>) ac.thatCard); }
	@Override public boolean visit (AngPutThatIntoPlayUnderYourControl effect) { return !ac.thatCard.isControlledBy (ac.you); }

	@Override public boolean visit (AngSaveThat effect) { return true; }
	@Override public boolean visit (AngSaveThis effect) { return true; }
	@Override public boolean visit (AngSaveAttached effect) { return true; }


	@Override
	public boolean visit (AngLastingEffect effect) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean visit (AngDiscardNCardsAtRandomFromEachPlayerHand effect) {
		return FilterMatcher.allPlayerMatches (ac.you, game, effect.getPlayerFilter ())
		.anyMatch (p -> p.handSize () > 0);
	} // visit
	
	@Override
	public boolean visit (AngTakeControlOfThat effect) {
		// TODO AngTakeControlOfThat
		return false;
	} // visit

} // ChangeChecker
