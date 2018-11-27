package motif.agot.ang.text.conseffects;

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

public interface IAngConsEffectVisitor {

	public boolean visit (AngAttachedGainsAnIcon consEffect);
	public boolean visit (AngThisGainsAnIcon consEffect);
	public boolean visit (AngThatGainsAnIcon consEffect);
	public boolean visit (AngAttachedGainsAKeyword consEffect);
	public boolean visit (AngThisGainsAKeyword consEffect);
	public boolean visit (AngThatGainsAKeyword consEffect);
	public boolean visit (AngEachCardGainsAKeyword consEffect);
	public boolean visit (AngAttachedGetsStrength consEffect);
	public boolean visit (AngThisGetsStrength consEffect);
	public boolean visit (AngThatGetsStrength consEffect);
	public boolean visit (AngEachCardGetsStrength consEffect);
	public boolean visit (AngAddStrengthToYourTotalForDominance consEffect);
	public boolean visit (AngTreatEachCardAsIfItsPrintedTextBoxWereBlackExceptForTrait consEffect);
	public boolean visit (AngYouCannotMarshallOrPlay consEffect);
	public boolean visit (AngTreatTheBaseGoldValueOfEachCardAsIfItWereN consEffect);
	public boolean visit (AngYouMayInitiateAnAdditionalChallengeDuringTheChallengePhase consEffect);
	public boolean visit (AngEachPlayerCannotStandMoreThanNCardsDuringTheStandingPhase consEffect);
	public boolean visit (AngEachCardCannotBeBypassedByStealth consEffect);
	public boolean visit (AngEachPlayerCannotInitiateMoreThanNChallengesDuringTheChallengePhase consEffect);
	public boolean visit (AngEachPlayerCannotTriggerCardAbilities consEffect);
	public boolean visit (AngEachPlayerCannotDeclareMoreThanNCharacters consEffect);
	public boolean visit (AngMultiConsEffect consEffect);
	public boolean visit (AngThisDoesNotKneelWhenDeclared consEffect);

} // IAngConsEffectVisitor
