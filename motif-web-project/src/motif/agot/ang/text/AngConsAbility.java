package motif.agot.ang.text;

import lombok.Getter;
import motif.agot.ang.enums.AngIcon;
import motif.agot.ang.enums.AngKeyword;
import motif.agot.ang.text.consconditions.AngAPlayerControls;
import motif.agot.ang.text.consconditions.AngAttachedIs;
import motif.agot.ang.text.consconditions.AngDuringAChallenge;
import motif.agot.ang.text.consconditions.AngThisHasADuplicate;
import motif.agot.ang.text.consconditions.AngYouAreTheFirstPlayer;
import motif.agot.ang.text.consconditions.IAngWhileCondition;
import motif.agot.ang.text.conseffects.AngConsEffects.AngAddStrengthToYourTotalForDominance;
import motif.agot.ang.text.conseffects.AngConsEffects.AngAttachedGainsAKeyword;
import motif.agot.ang.text.conseffects.AngConsEffects.AngAttachedGainsAnIcon;
import motif.agot.ang.text.conseffects.AngConsEffects.AngAttachedGetsStrength;
import motif.agot.ang.text.conseffects.AngConsEffects.AngEachCardGainsAKeyword;
import motif.agot.ang.text.conseffects.AngConsEffects.AngThatGainsAKeyword;
import motif.agot.ang.text.conseffects.AngConsEffects.AngThatGainsAnIcon;
import motif.agot.ang.text.conseffects.AngConsEffects.AngThatGetsStrength;
import motif.agot.ang.text.conseffects.AngConsEffects.AngThisGainsAKeyword;
import motif.agot.ang.text.conseffects.AngConsEffects.AngThisGainsAnIcon;
import motif.agot.ang.text.conseffects.AngConsEffects.*;
import motif.agot.ang.text.conseffects.IAngConsEffect;
import motif.agot.ang.text.filters.AngCardFilter;
import motif.agot.ang.text.filters.AngCardFilter.CFB;
import motif.agot.ang.text.filters.AngChallengeFilter.ChFB;
import motif.agot.ang.text.filters.AngPlayerFilter.PFB;
import motif.agot.ang.text.variables.AngVariable;

public class AngConsAbility {
	
	@Getter private IAngConsEffect consEffect;
	
	private IAngWhileCondition whileCond;
	public IAngWhileCondition getWhileCond () { return whileCond; }
	public boolean hasWhileCond () { return whileCond != null; }
	
	public AngVariable whereXIs;
	public AngVariable getWhereXIs () { return whereXIs; }
	
	public AngCardFilter forEach;
	public AngCardFilter getForEach () { return forEach; }
	public boolean hasForEach () { return false; }
	
	public static class CAB {
		
		public static CAB i () { return new CAB (); }
		
		private CAB () {}
		
		private AngConsAbility ca = new AngConsAbility ();
		
		public AngConsAbility build () {
			return ca;
		} // build
		
		public CAB ifAttachedIs (CFB cardFilterBuilder) { return whileAttachedIs (cardFilterBuilder); }
		public CAB whileAttachedIs (CFB cardFilterBuilder) { ca.whileCond = new AngAttachedIs (cardFilterBuilder.build ()); return this; }
		public CAB whileYouAreTheFirstPlayer () { ca.whileCond = new AngYouAreTheFirstPlayer (true); return this; }
		public CAB whileYouAreNotTheFirstPlayer () { ca.whileCond = new AngYouAreTheFirstPlayer (false); return this; }
		public CAB whileYouControl (CFB cardFilterBuilder) { cardFilterBuilder.youControl (); return whileAPlayerControls (true, cardFilterBuilder); }
		public CAB whileAnOpponentControls (CFB cardFilterBuilder) { cardFilterBuilder.opponent (); return whileAPlayerControls (false, cardFilterBuilder); }
		public CAB whileThisHasADuplicate () { ca.whileCond = new AngThisHasADuplicate (); return this; }
		private CAB whileAPlayerControls (Boolean you, CFB cardFilterBuilder) { ca.whileCond = new AngAPlayerControls (you, cardFilterBuilder.build ()); return this; }
		public CAB whileThisIsPartecipating (ChFB challengeFilterBuilder) { return duringAChallenge (challengeFilterBuilder.inWhichThisIsPartecipating ()); }
		private CAB duringAChallenge (ChFB challengeFilterBuilder) { ca.whileCond = new AngDuringAChallenge (challengeFilterBuilder.build ()); return this; }
		
		public CAB attachedGainsAnIcon (AngIcon icon) { ca.consEffect = new AngAttachedGainsAnIcon (icon); return this; }
		public CAB thisGainsAnIcon (AngIcon icon) { ca.consEffect = new AngThisGainsAnIcon (icon); return this; }
		public CAB heGainsAnIcon (AngIcon icon) { ca.consEffect = new AngThatGainsAnIcon (icon); return this; }
		
		public CAB eachCardGains (CFB cfb, AngKeyword keyword) { ca.consEffect = new AngEachCardGainsAKeyword (new AngTextKeyword (keyword, null, null), cfb.build ()); return this; }
		public CAB attachedGains (AngKeyword keyword) { ca.consEffect = new AngAttachedGainsAKeyword (new AngTextKeyword (keyword, null, null)); return this; }
		public CAB thisGains (AngKeyword keyword) { ca.consEffect = new AngThisGainsAKeyword (new AngTextKeyword (keyword, null, null)); return this; }
		public CAB heGains (AngKeyword keyword) { ca.consEffect = new AngThatGainsAKeyword (new AngTextKeyword (keyword, null, null)); return this; }
		
		public CAB eachCardGetsStrength (CFB cfb, int strength) { ca.consEffect = new AngEachCardGetsStrength (strength, cfb.build ()); return this; }
		public CAB attachedGetsStrength (int strength) { ca.consEffect = new AngAttachedGetsStrength (strength); return this; }
		public CAB thisGetsStrength (int strength) { ca.consEffect = new AngThisGetsStrength (strength); return this; }
		public CAB heGetsStrength (int strength) { ca.consEffect = new AngThatGetsStrength (strength, null, null); return this; }
		
		public CAB addStrengthToYourTotalForDominance (int str) { ca.consEffect = new AngAddStrengthToYourTotalForDominance (str); return this; }
		
		public CAB treatEachCardAsIfItsPrintedTextBoxWereBlackExceptForTrait (CFB cfb) { ca.consEffect = new AngTreatEachCardAsIfItsPrintedTextBoxWereBlackExceptForTrait (cfb.build ()); return this; } 
		public CAB youCannotMarshallOrPlay (CFB cfb) { ca.consEffect = new AngYouCannotMarshallOrPlay (cfb.build ()); return this; }
		public CAB treatTheBaseGoldValueOfEachCardAsIfItWereN (CFB cfb, int n) { ca.consEffect = new AngTreatTheBaseGoldValueOfEachCardAsIfItWereN (n, cfb.build ()); return this; }
		public CAB youMayInitiateAnAdditionalChallengeDuringTheChallengePhase (AngIcon icon) { ca.consEffect = new AngYouMayInitiateAnAdditionalChallengeDuringTheChallengePhase (icon); return this; }
		public CAB youCannotInitiateMoreThanNChallengesDuringTheChallengePhase (int n) { ca.consEffect = new AngEachPlayerCannotInitiateMoreThanNChallengesDuringTheChallengePhase (n, PFB.i ().you ().build ()); return this; }
		public CAB eachPlayerCannotStandMoreThanNCardsDuringTheStandingPhase (int n, CFB cfb) { ca.consEffect = new AngEachPlayerCannotStandMoreThanNCardsDuringTheStandingPhase (n, cfb.build ()); return this; }
		public CAB eachCardCannotBeBypassedByStealth (CFB cfb) { ca.consEffect = new AngEachCardCannotBeBypassedByStealth (cfb.build ()); return this; }
		public CAB yourOpponentsCannotTriggerCardAbilities () { ca.consEffect = new AngEachPlayerCannotTriggerCardAbilities (PFB.i ().eachOpponents ().build ()); return this; }
		public CAB eachPlayerCannotDeclareMoreThanNCharactersInEachChallenge (int n, PFB pfb, Boolean asAttacker) { ca.consEffect = new AngEachPlayerCannotDeclareMoreThanNCharacters (n, asAttacker, pfb.build ()); return this; }
		
		public CAB and (IAngConsEffect...effects) { ca.consEffect = new AngMultiConsEffect (effects); return this; } 
		
		public CAB forEach (CFB cardFilterBuilder) { ca.forEach = cardFilterBuilder.build (); return this; }
		public CAB whereXIs (AngVariable variable) { ca.whereXIs = new AngVariable (); return this; }

	} // CAB
	
} // IAngConsAbility
