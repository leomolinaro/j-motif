package motif.agot.ang.text;

import motif.agot.ang.enums.AngPhase;
import motif.agot.ang.enums.AngSubject;
import motif.agot.ang.text.costs.IAngCost;
import motif.agot.ang.text.effects.IAngEffect;
import motif.agot.ang.text.filters.AngCardFilter;
import motif.agot.ang.text.filters.AngCardFilter.CFB;
import motif.agot.ang.text.filters.AngChallengeFilter.ChFB;
import motif.agot.ang.text.limit.AngTrigLimit;
import motif.agot.ang.text.triggeringconditions.AngACardEntersPlay;
import motif.agot.ang.text.triggeringconditions.AngACardGainsOneOrMorePower;
import motif.agot.ang.text.triggeringconditions.AngACardIsKilled;
import motif.agot.ang.text.triggeringconditions.AngACardIsSacrificed;
import motif.agot.ang.text.triggeringconditions.AngAChallengeIsInitiated;
import motif.agot.ang.text.triggeringconditions.AngAChallengeIsLost;
import motif.agot.ang.text.triggeringconditions.AngAChallengeIsWon;
import motif.agot.ang.text.triggeringconditions.AngOr;
import motif.agot.ang.text.triggeringconditions.AngPhaseBegins;
import motif.agot.ang.text.triggeringconditions.AngYouMarshallOrPlayACard;
import motif.agot.ang.text.triggeringconditions.AngYouMarshallThis;
import motif.agot.ang.text.triggeringconditions.AngYouWinDominance;
import motif.agot.ang.text.triggeringconditions.IAngTriggeringCondition;

public class AngReaction extends AngTrigAbility {

	private IAngTriggeringCondition after;
	public IAngTriggeringCondition getAfter () { return after; }
	
	public AngReaction (IAngTriggeringCondition after, IAngCost cost, IAngEffect effect, AngTrigLimit limit) {
		super (cost, effect, limit);
		this.after = after;
	} // AngReaction

	public static class RB extends TAB<RB> {

		public static RB i () { return new RB (); }
		
		private RB () {}
		
		@Override protected RB getThis () { return this; }
		
		private IAngTriggeringCondition after;
		
		public AngReaction build () {
			AngReaction reaction = new AngReaction (after, cost, effect, limit);
			return reaction;
		} // build
		
		public EB afterYouMarshallThis () { after = new AngYouMarshallThis (); return new EB (); }
		public EB afterYouWinDominance () { after = new AngYouWinDominance (); return new EB (); }
		public EB afterThisEntersPlay () { after = new AngACardEntersPlay (AngSubject.THIS, null); return new EB (); }
		public EB afterPhaseBegins (AngPhase phase) { after = new AngPhaseBegins (phase); return new EB (); }
		public EB afterYouInitiateAChallenge (ChFB challengeFilterBuilder) { after = new AngAChallengeIsInitiated (challengeFilterBuilder.build (), true); return new EB (); }
		public EB afterYouWinAChallenge (ChFB challengeFilterBuilder) { after = new AngAChallengeIsWon (challengeFilterBuilder.build (), true); return new EB (); }
		public EB afterYouLoseAChallenge (ChFB challengeFilterBuilder) { after = new AngAChallengeIsLost (challengeFilterBuilder.build (), true); return new EB (); }
		public EB afterAChallengeIsInitiated (ChFB challengeFilterBuilder) { after = new AngAChallengeIsInitiated (challengeFilterBuilder.build (), null); return new EB (); }
		public EB afterAChallengeIsInitiatedAgainstYou (ChFB challengeFilterBuilder) { after = new AngAChallengeIsInitiated (challengeFilterBuilder.build (), false); return new EB (); }
		public EB afterYouMarshallOrPlayACard (CFB cardFilterBuilder) { after = new AngYouMarshallOrPlayACard (cardFilterBuilder.build ()); return new EB (); }
		public EB afterACardIsSacrificedOrKilled (CFB cardFilterBuilder) { AngCardFilter cardFilter = cardFilterBuilder.build (); after = new AngOr (new AngACardIsSacrificed (AngSubject.EACH_IN_PLAY, cardFilter), new AngACardIsKilled (AngSubject.EACH_IN_PLAY, cardFilter)); return new EB (); }
		public EB afterAttachedGainsOneOrMorePower () { after = new AngACardGainsOneOrMorePower (AngSubject.ATTACHED, null); return new EB (); }

	} // RB
	
} // AngReaction
