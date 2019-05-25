package com.motif.agot.logic.visitors;

import com.motif.agot.ang.enums.AngIcon;
import com.motif.agot.ang.text.AngTextKeyword;
import com.motif.agot.ang.text.conseffects.IAngConsEffect;
import com.motif.agot.ang.text.conseffects.IAngConsEffectVisitor;
import com.motif.agot.ang.text.conseffects.AngConsEffects.AngAddStrengthToYourTotalForDominance;
import com.motif.agot.ang.text.conseffects.AngConsEffects.AngAttachedGainsAKeyword;
import com.motif.agot.ang.text.conseffects.AngConsEffects.AngAttachedGainsAnIcon;
import com.motif.agot.ang.text.conseffects.AngConsEffects.AngAttachedGetsStrength;
import com.motif.agot.ang.text.conseffects.AngConsEffects.AngEachCardCannotBeBypassedByStealth;
import com.motif.agot.ang.text.conseffects.AngConsEffects.AngEachCardGainsAKeyword;
import com.motif.agot.ang.text.conseffects.AngConsEffects.AngEachCardGetsStrength;
import com.motif.agot.ang.text.conseffects.AngConsEffects.AngEachPlayerCannotDeclareMoreThanNCharacters;
import com.motif.agot.ang.text.conseffects.AngConsEffects.AngEachPlayerCannotInitiateMoreThanNChallengesDuringTheChallengePhase;
import com.motif.agot.ang.text.conseffects.AngConsEffects.AngEachPlayerCannotStandMoreThanNCardsDuringTheStandingPhase;
import com.motif.agot.ang.text.conseffects.AngConsEffects.AngEachPlayerCannotTriggerCardAbilities;
import com.motif.agot.ang.text.conseffects.AngConsEffects.AngMultiConsEffect;
import com.motif.agot.ang.text.conseffects.AngConsEffects.AngThatGainsAKeyword;
import com.motif.agot.ang.text.conseffects.AngConsEffects.AngThatGainsAnIcon;
import com.motif.agot.ang.text.conseffects.AngConsEffects.AngThatGetsStrength;
import com.motif.agot.ang.text.conseffects.AngConsEffects.AngThisDoesNotKneelWhenDeclared;
import com.motif.agot.ang.text.conseffects.AngConsEffects.AngThisGainsAKeyword;
import com.motif.agot.ang.text.conseffects.AngConsEffects.AngThisGainsAnIcon;
import com.motif.agot.ang.text.conseffects.AngConsEffects.AngThisGetsStrength;
import com.motif.agot.ang.text.conseffects.AngConsEffects.AngTreatEachCardAsIfItsPrintedTextBoxWereBlackExceptForTrait;
import com.motif.agot.ang.text.conseffects.AngConsEffects.AngTreatTheBaseGoldValueOfEachCardAsIfItWereN;
import com.motif.agot.ang.text.conseffects.AngConsEffects.AngYouCannotMarshallOrPlay;
import com.motif.agot.ang.text.conseffects.AngConsEffects.AngYouMayInitiateAnAdditionalChallengeDuringTheChallengePhase;
import com.motif.agot.logic.other.AbilityContext;
import com.motif.agot.logic.other.FilterMatcher;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.cards.AttachmentCard;
import com.motif.agot.state.cards.CharacterCard;
import com.motif.agot.state.cards.MarshallCard;

public class ConsEffectApplier implements IAngConsEffectVisitor {

	public static void applyAll(IAngConsEffect effect, AbilityContext ac, AgotGame game) {
		var applier = new ConsEffectApplier(ac, game, true);
		effect.accept(applier);
	}

	public static void unapplyAll(IAngConsEffect effect, AbilityContext ac, AgotGame game) {
		var unapplier = new ConsEffectApplier(ac, game, false);
		effect.accept(unapplier);
	}
	
	boolean activate;
	private AbilityContext ac;
	private AgotGame game;
	
	private ConsEffectApplier(AbilityContext ac, AgotGame game, boolean activate) {
		this.ac = ac;
		this.game = game;
		this.activate = activate;
	}
	
	private MarshallCard<?> getAttached() { return ((AttachmentCard) ac.thisCard).getAttachTo (); }
	
	private boolean applyGainsAnIcon(AngIcon icon, CharacterCard card) { if (activate) { card.addIcon(icon); } else { card.removeIcon(icon); } return true; }
	@Override public boolean visit(AngAttachedGainsAnIcon consEffect) { return applyGainsAnIcon(consEffect.getIcon(), (CharacterCard) getAttached()); }
	@Override public boolean visit(AngThisGainsAnIcon consEffect) { return applyGainsAnIcon(consEffect.getIcon(), (CharacterCard) ac.thisCard); }
	@Override public boolean visit(AngThatGainsAnIcon consEffect) { return applyGainsAnIcon(consEffect.getIcon(), (CharacterCard) ac.thatCard); }
	
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
