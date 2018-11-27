package motif.agot.logic.visitors;

import motif.agot.ang.enums.AngIcon;
import motif.agot.ang.text.AngTextKeyword;
import motif.agot.ang.text.conseffects.AngConsEffects.AngAddStrengthToYourTotalForDominance;
import motif.agot.ang.text.conseffects.AngConsEffects.AngAttachedGainsAKeyword;
import motif.agot.ang.text.conseffects.AngConsEffects.AngAttachedGainsAnIcon;
import motif.agot.ang.text.conseffects.AngConsEffects.AngAttachedGetsStrength;
import motif.agot.ang.text.conseffects.AngConsEffects.AngEachCardCannotBeBypassedByStealth;
import motif.agot.ang.text.conseffects.AngConsEffects.AngEachCardGainsAKeyword;
import motif.agot.ang.text.conseffects.AngConsEffects.AngEachCardGetsStrength;
import motif.agot.ang.text.conseffects.AngConsEffects.AngEachPlayerCannotDeclareMoreThanNCharacters;
import motif.agot.ang.text.conseffects.AngConsEffects.AngEachPlayerCannotInitiateMoreThanNChallengesDuringTheChallengePhase;
import motif.agot.ang.text.conseffects.AngConsEffects.AngEachPlayerCannotStandMoreThanNCardsDuringTheStandingPhase;
import motif.agot.ang.text.conseffects.AngConsEffects.AngEachPlayerCannotTriggerCardAbilities;
import motif.agot.ang.text.conseffects.AngConsEffects.AngMultiConsEffect;
import motif.agot.ang.text.conseffects.AngConsEffects.AngThatGainsAKeyword;
import motif.agot.ang.text.conseffects.AngConsEffects.AngThatGainsAnIcon;
import motif.agot.ang.text.conseffects.AngConsEffects.AngThatGetsStrength;
import motif.agot.ang.text.conseffects.AngConsEffects.AngThisDoesNotKneelWhenDeclared;
import motif.agot.ang.text.conseffects.AngConsEffects.AngThisGainsAKeyword;
import motif.agot.ang.text.conseffects.AngConsEffects.AngThisGainsAnIcon;
import motif.agot.ang.text.conseffects.AngConsEffects.AngThisGetsStrength;
import motif.agot.ang.text.conseffects.AngConsEffects.AngTreatEachCardAsIfItsPrintedTextBoxWereBlackExceptForTrait;
import motif.agot.ang.text.conseffects.AngConsEffects.AngTreatTheBaseGoldValueOfEachCardAsIfItWereN;
import motif.agot.ang.text.conseffects.AngConsEffects.AngYouCannotMarshallOrPlay;
import motif.agot.ang.text.conseffects.AngConsEffects.AngYouMayInitiateAnAdditionalChallengeDuringTheChallengePhase;
import motif.agot.ang.text.conseffects.IAngConsEffect;
import motif.agot.ang.text.conseffects.IAngConsEffectVisitor;
import motif.agot.logic.other.AbilityContext;
import motif.agot.logic.other.FilterMatcher;
import motif.agot.state.AgotGame;
import motif.agot.state.cards.AttachmentCard;
import motif.agot.state.cards.CharacterCard;
import motif.agot.state.cards.MarshallCard;

public class ConsEffectApplier implements IAngConsEffectVisitor {

	public static void applyAll (IAngConsEffect effect, AbilityContext ac, AgotGame game) {
		ConsEffectApplier subscriber = new ConsEffectApplier (ac, game, true);
		effect.accept (subscriber);
	} // apply

	public static void unapplyAll (IAngConsEffect effect, AbilityContext ac, AgotGame game) {
		ConsEffectApplier subscriber = new ConsEffectApplier (ac, game, false);
		effect.accept (subscriber);
	} // unapply
	
	boolean activate;
	private AbilityContext ac;
	private AgotGame game;
	
	private ConsEffectApplier (AbilityContext ac, AgotGame game, boolean activate) {
		this.ac = ac;
		this.game = game;
		this.activate = activate;
	} // ConsEffects
	
	private MarshallCard<?> getAttached () { return ((AttachmentCard) ac.thisCard).getAttachTo (); }
	
	private boolean applyGainsAnIcon (AngIcon icon, CharacterCard card) { if (activate) { card.addIcon (icon); } else { card.removeIcon (icon); } return true; }
	@Override public boolean visit (AngAttachedGainsAnIcon consEffect) { return applyGainsAnIcon (consEffect.getIcon (), (CharacterCard) getAttached ()); }
	@Override public boolean visit (AngThisGainsAnIcon consEffect) { return applyGainsAnIcon (consEffect.getIcon (), (CharacterCard) ac.thisCard); }
	@Override public boolean visit (AngThatGainsAnIcon consEffect) { return applyGainsAnIcon (consEffect.getIcon (), (CharacterCard) ac.thatCard); }
	
	public static boolean applyGainsAKeyword (AngTextKeyword keyword, CharacterCard card, boolean activate) { if (activate) { card.addKeyword (keyword); } else { card.removeKeyword (keyword); } return true; }
	@Override public boolean visit (AngAttachedGainsAKeyword consEffect) { return applyGainsAKeyword (consEffect.getKeyword (), (CharacterCard) getAttached (), activate); }
	@Override public boolean visit (AngThisGainsAKeyword consEffect) { return applyGainsAKeyword (consEffect.getKeyword (), (CharacterCard) ac.thisCard, activate); }
	@Override public boolean visit (AngThatGainsAKeyword consEffect) { return applyGainsAKeyword (consEffect.getKeyword (), (CharacterCard) ac.thatCard, activate); }
	@Override public boolean visit (AngEachCardGainsAKeyword consEffect) {
		FilterMatcher.allMatches (ac.you, game, consEffect.getFilter ())
		.forEach (c -> applyGainsAKeyword (consEffect.getKeyword (), (CharacterCard) c, activate));
		return true;
	} // visit
	
	public static boolean applyGetsStrength (int strength, CharacterCard card, boolean activate) { card.modifyStrength (strength * (activate ? 1 : -1)); return true; }
	@Override public boolean visit (AngEachCardGetsStrength consEffect) {
		FilterMatcher.allMatches (ac.you, game, consEffect.getFilter ())
		.forEach (c -> applyGetsStrength (consEffect.getStrength (), (CharacterCard) c, activate));
		return true;
	} // visit
	@Override public boolean visit (AngThisGetsStrength consEffect) { return applyGetsStrength (consEffect.getStrength (), (CharacterCard) ac.thisCard, activate); }
	@Override public boolean visit (AngThatGetsStrength consEffect) {
		int strength = consEffect.getStrength ();
		if (consEffect.getIfInstead () != null) {
			boolean insteadTrue = ConsCondTester.test (consEffect.getIfInstead (), ac, game);
			if (insteadTrue) { strength = consEffect.getStrengthInstead (); }
		} // if
		return applyGetsStrength (strength, (CharacterCard) ac.thatCard, activate);
	} // visit
	@Override public boolean visit (AngAttachedGetsStrength consEffect) { return applyGetsStrength (consEffect.getStrength (), (CharacterCard) getAttached (), activate); }

	@Override public boolean visit (AngAddStrengthToYourTotalForDominance consEffect) { ac.you.increaseDominanceStrength (consEffect.getStrength () * (activate ? 1 : -1)); return true; }

	@Override
	public boolean visit (AngTreatEachCardAsIfItsPrintedTextBoxWereBlackExceptForTrait consAbility) {
		// TODO applicare AngTreatEachCardAsIfItsPrintedTextBoxWereBlackExceptForTrait
		return false;
	}

	@Override
	public boolean visit (AngYouCannotMarshallOrPlay consAbility) {
		// TODO applicare AngYouCannotMarshallOrPlay
		return false;
	}

	@Override
	public boolean visit (AngTreatTheBaseGoldValueOfEachCardAsIfItWereN consAbility) {
		// TODO applicare AngTreatTheBaseGoldValueOfEachCardAsIfItWereN
		return false;
	}

	@Override
	public boolean visit (AngYouMayInitiateAnAdditionalChallengeDuringTheChallengePhase consAbility) {
		// TODO applicare AngYouMayInitiateAnAdditionalChallengeDuringTheChallengePhase
		return false;
	}

	@Override
	public boolean visit (AngEachPlayerCannotStandMoreThanNCardsDuringTheStandingPhase consAbility) {
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean applyCannotBeBypassedByStealth (CharacterCard card, boolean activate) {
		if (activate) {
			card.subscribeCannotBeBypassedByStealth ();
		} else {
			card.unsubscribeCannotBeBypassedByStealth ();
		} // if - else
		return true;
	} // applyCannotBeBypassedByStealth
	@Override
	public boolean visit (AngEachCardCannotBeBypassedByStealth consEffect) {
		FilterMatcher.allMatches (ac.you, game, consEffect.getCardFilter ())
		.forEach (c -> applyCannotBeBypassedByStealth ((CharacterCard) c, activate));
		return true;
	} // visit

	@Override
	public boolean visit (AngEachPlayerCannotInitiateMoreThanNChallengesDuringTheChallengePhase consAbility) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visit (AngEachPlayerCannotTriggerCardAbilities consAbility) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visit (AngEachPlayerCannotDeclareMoreThanNCharacters consAbility) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visit (AngMultiConsEffect consEffect) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visit (AngThisDoesNotKneelWhenDeclared consEffect) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
