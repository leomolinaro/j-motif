package com.motif.agot.ang.text;

import com.motif.agot.ang.enums.AngSubject;
import com.motif.agot.ang.enums.AngTime;
import com.motif.agot.ang.enums.AngToken;
import com.motif.agot.ang.text.consconditions.IAngIfCondition;
import com.motif.agot.ang.text.conseffects.AngConsEffects.AngThatGetsStrength;
import com.motif.agot.ang.text.costs.IAngCost;
import com.motif.agot.ang.text.costs.IAngCostVisitor;
import com.motif.agot.ang.text.effects.IAngEffect;
import com.motif.agot.ang.text.effects.IAngEffectVisitor;
import com.motif.agot.ang.text.filters.AngCardFilter;
import com.motif.agot.ang.text.filters.AngPlayerFilter;
import com.motif.agot.ang.text.filters.AngCardFilter.CFB;
import com.motif.agot.ang.text.filters.AngPlayerFilter.PFB;
import com.motif.agot.ang.text.instants.AngChooseACard;
import com.motif.agot.ang.text.instants.AngDiscardATokenFromThis;
import com.motif.agot.ang.text.instants.AngDiscardNCardsFromYourHand;
import com.motif.agot.ang.text.instants.AngDrawNCards;
import com.motif.agot.ang.text.instants.AngGainNGold;
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
import com.motif.agot.ang.text.instants.AngInstants.AngGainNPowerOnThis;
import com.motif.agot.ang.text.instants.AngInstants.AngGainNPowerOnYourFaction;
import com.motif.agot.ang.text.instants.AngInstants.AngKillThat;
import com.motif.agot.ang.text.instants.AngInstants.AngKneelThat;
import com.motif.agot.ang.text.instants.AngInstants.AngKneelThis;
import com.motif.agot.ang.text.instants.AngInstants.AngPlaceOneTokenOnThis;
import com.motif.agot.ang.text.instants.AngInstants.AngSaveThat;
import com.motif.agot.ang.text.instants.AngInstants.AngShuffleThatBackIntoYourDeck;
import com.motif.agot.ang.text.instants.AngInstants.AngStandAttached;
import com.motif.agot.ang.text.instants.AngInstants.AngStandEach;
import com.motif.agot.ang.text.instants.AngInstants.AngStandThat;
import com.motif.agot.ang.text.instants.AngInstants.AngStandThis;
import com.motif.agot.ang.text.instants.AngInstants.AngTakeControlOfThat;
import com.motif.agot.ang.text.limit.AngTrigLimit;
import com.motif.agot.ang.text.untilconditions.AngUntilTheEndOfTheChallenge;
import com.motif.agot.ang.text.untilconditions.AngUntilTheEndOfThePhase;
import com.motif.agot.ang.text.untilconditions.IAngUntilCondition;

public abstract class AngTrigAbility {
	
	private static long idGenerator = 1;
	
	private long id = idGenerator++;
	public long getId () { return id; }
	
	private IAngCost cost;
	public void accept (IAngCostVisitor visitor) { this.cost.accept (visitor); }
	public IAngCost getCost () { return cost; }
	public boolean hasCost () { return cost != null; }
	
	private IAngEffect effect;
	public IAngEffect getEffect () { return effect; }
	public void accept (IAngEffectVisitor visitor) { this.effect.accept (visitor); }

	private AngTrigLimit limit;
	public AngTrigLimit getTrigLimit () { return limit; }
	public boolean hasTrigLimit () { return limit != null; }

	private AngTrigLimit max;
	public AngTrigLimit getTrigMax () { return max; }
	public boolean hasTrigMax () { return max != null; }
	
	public AngTrigAbility (IAngCost cost, IAngEffect effect, AngTrigLimit limit) {
		this.cost = cost;
		this.effect = effect;
		this.limit = limit;
	} // AngTrigAbility
	
	public static abstract class TAB<T extends TAB<T>> {
		protected abstract T getThis ();
		
		protected IAngCost cost;
		protected IAngEffect effect;
		protected AngTrigLimit limit;
		protected AngTrigLimit max;
		
		public T limitPerRound (int times) { limit = new AngTrigLimit (times, AngTime.ROUND); return getThis (); }
		public T limitPerPhase (int times) { limit = new AngTrigLimit (times, AngTime.PHASE); return getThis (); }
		public T maxPerRound (int times) { max = new AngTrigLimit (times, AngTime.ROUND); return getThis (); }
		public T maxPerPhase (int times) { max = new AngTrigLimit (times, AngTime.PHASE); return getThis (); }
		public T maxPerChallenge (int times) { max = new AngTrigLimit (times, AngTime.CHALLENGE); return getThis (); }
		
		public EB kneelThisTo () { cost = new AngKneelThis (); return new EB (); }
		public EB discardNCardsFromYourHandTo (int n) { cost = new AngDiscardNCardsFromYourHand (n); return new EB (); }
		public EB removeThisFromTheGameTo () { cost = new AngRemoveThisFromTheGame (); return new EB (); }
		public EB sacrificeThisTo () { cost = new AngSacrificeThis (); return new EB (); }

		public class EB {
			protected EB () {}
			
			public LEB untilTheEndOfThePhase () { return new LEB (new AngUntilTheEndOfThePhase ()); }
			public LEB untilTheEndOfTheChallenge () { return new LEB (new AngUntilTheEndOfTheChallenge ()); }

			public EB payNGoldTo (int n) { cost = new AngPayNGold (n); return this; }
			public EB kneelThisTo () { cost = new AngKneelThis (); return this; }
			public EB discardNCardsFromYourHandTo (int n) { cost = new AngDiscardNCardsFromYourHand (n); return this; }
			public EB removeThisFromTheGameTo () { cost = new AngRemoveThisFromTheGame (); return this; }
			public EB sacrificeThisTo () { cost = new AngSacrificeThis (); return this; }
			public EB returnThisToYourHandTo () { cost = new AngReturnThisToYourHand (); return this; }
			public EB discardATokenFromThisTo (AngToken token) { cost = new AngDiscardATokenFromThis (token); return this; }
			
			public T drawNCards (int n) { effect = new AngDrawNCards (n); return getThis (); }
			public T gainNGold (int n, CFB forEach) { effect = new AngGainNGold (n, forEach == null ? null : forEach.build ()); return getThis (); }
			
			public T kneelThis () { effect = new AngKneelThis (); return getThis (); }
			public T standThis () { effect = new AngStandThis (); return getThis (); }
			public T standAttached () { effect = new AngStandAttached (); return getThis (); }
			public T standEachCard (CFB cardFilterBuilder) { effect = new AngStandEach (cardFilterBuilder.build ()); return getThis (); }
			
			public T saveIt () { effect = new AngSaveThat (); return getThis (); }
			
			public T gainPowerForYourFaction (int n) { effect = new AngGainNPowerOnYourFaction (n); return getThis (); }
			public T thisGainsNPower (int n) { effect = new AngGainNPowerOnThis (n); return getThis (); }
			public T returnThisToYourHand () { effect = new AngReturnThisToYourHand (); return getThis (); }
			public T discardEachFromPlay (CFB cardFilterBuilder) { effect = new AngDiscardFromPlayEach (cardFilterBuilder.build ()); return getThis (); }
			public T movePowersFromAFactionToAFaction (int n, PFB fromPlayer, PFB toPlayer) { effect = new AngMovePowersFromAFactionToAFaction (n, fromPlayer.build (), toPlayer.build ()); return getThis (); }
			public T reduceTheCostOfTheNextCardYouMarshallThisPhaseByN (CFB cardFilterBuilder, int n) { effect = new AngReduceTheCostOTheNextCardYouMarshallThisPhaseByN (cardFilterBuilder.build (), n); return getThis (); }
			public T placeOneTokenOnThis (AngToken token)  { effect = new AngPlaceOneTokenOnThis (token); return getThis (); }
			public T discardNCardsAtRandomFromEachPlayerHand (int n, PFB pfb)  { effect = new AngDiscardNCardsAtRandomFromEachPlayerHand (n, pfb.build ()); return getThis (); }
			
			public CB chooseACard (CFB cardFilterBuilder) { return new CB (cardFilterBuilder.build ()); }
			public CPB chooseAPlayer (PFB playerFilterBuilder) { return new CPB (playerFilterBuilder.build ()); }
			
			public class CB {
				private AngCardFilter cardFilter;
				protected CB (AngCardFilter cardFilter) {
					this.cardFilter = cardFilter;
				} // CB
				public T andDiscardItFromPlay () { effect = new AngChooseACard (cardFilter, new AngDiscardFromPlayThat ()); return getThis (); }
				public T andKneelIt () { effect = new AngChooseACard (cardFilter, new AngKneelThat ()); return getThis (); }
				public T andKillIt () { effect = new AngChooseACard (cardFilter, new AngKillThat ()); return getThis (); }
				public T andStandIt () { effect = new AngChooseACard (cardFilter, new AngStandThat ()); return getThis (); }
				public T andPutItIntoPlay () { return andPutItIntoPlayUnderYourControl (); }
				public T andPutItIntoPlayUnderYourControl () { effect = new AngChooseACard (cardFilter, new AngPutThatIntoPlayUnderYourControl (AngSubject.TARGET)); return getThis (); }
				public T andDiscardNPowerFromThatCard (int n) { effect = new AngChooseACard (cardFilter, new AngDiscardNPowerFromThat (n)); return getThis (); }
				public T andShuffleItBackIntoYourDeck () { effect = new AngChooseACard (cardFilter, new AngShuffleThatBackIntoYourDeck ()); return getThis (); }
				public T andTakeControlOfThat () { effect = new AngChooseACard (cardFilter, new AngTakeControlOfThat ()); return getThis (); }
				public LEB untilTheEndOfThePhase () { return EB.this.untilTheEndOfThePhase (); }
				public LEB untilTheEndOfTheChallenge () { return EB.this.untilTheEndOfTheChallenge (); }
			} // CB
			
			public class CPB {
//				private AngPlayerFilter playerFilter;
				protected CPB (AngPlayerFilter playerFilter) {
//					this.playerFilter = playerFilter;
				} // CPB
				public T andGainNGold (int n, CFB forEach) { /*TODO effect = new AngChooseAPlayer (playerFilter, new AngGainNGold (n, forEach.build ()));*/ return getThis (); }   
			} // CPB

			
		} // EB
		
		public class LEB {
			private IAngUntilCondition until;
			private LEB (IAngUntilCondition until) {
				this.until = until;
			} // LEB
			public T thatCardGetsStrength (int strength) { return thatCardGetsStrength (strength, null, null); }
			public T thatCardGetsStrength (int strength, Integer strengthInstead, IAngIfCondition ifInstead) { effect = new AngLastingEffect (new AngThatGetsStrength (strength, strengthInstead, ifInstead), until); return getThis (); }
		} // LEB
		
	} // TAB
	
} // AngTrigAbility
