package com.motif.agot.ang.text;

import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.ang.enums.AngSubject;
import com.motif.agot.ang.text.costs.IAngCost;
import com.motif.agot.ang.text.effects.IAngEffect;
import com.motif.agot.ang.text.effects.replacedeffects.IAngReplacedEffect;
import com.motif.agot.ang.text.filters.AngCardFilter.CFB;
import com.motif.agot.ang.text.instants.AngPlaceItInYourDeadPile;
import com.motif.agot.ang.text.limit.AngTrigLimit;
import com.motif.agot.ang.text.triggeringconditions.AngACardIsDiscardedFromPlay;
import com.motif.agot.ang.text.triggeringconditions.AngACardIsKilled;
import com.motif.agot.ang.text.triggeringconditions.AngACardLeavesPlay;
import com.motif.agot.ang.text.triggeringconditions.AngOr;
import com.motif.agot.ang.text.triggeringconditions.AngPhaseBegins;
import com.motif.agot.ang.text.triggeringconditions.AngPhaseEnds;
import com.motif.agot.ang.text.triggeringconditions.IAngTriggeringCondition;

public class AngInterrupt extends AngTrigAbility {

	private boolean cancelling = false;
	public boolean isCancelling () { return cancelling; }
	
	private IAngTriggeringCondition when;
	public IAngTriggeringCondition getWhen () { return when; }
	
	private IAngReplacedEffect replacedEffect;
	public IAngReplacedEffect getReplacedEffect () { return replacedEffect; }
	
	public AngInterrupt (IAngTriggeringCondition when, boolean cancelling, IAngCost cost, IAngEffect effect, IAngReplacedEffect replacedEffect, AngTrigLimit limit) {
		super (cost, effect, limit);
		this.when = when;
		this.cancelling = cancelling;
		this.replacedEffect = replacedEffect;
	} // AngReaction
	
	public static class IB extends TAB<IB> {
		
		@Override protected IB getThis () { return this; }
		
		protected IAngTriggeringCondition when;
		protected IAngReplacedEffect replaced;
		private boolean cancelling = false;
		
		public AngInterrupt build () {
			AngInterrupt interrupt = new AngInterrupt (when, cancelling, cost, effect, replaced, limit);
			return interrupt;
		} // build
		
		public IB limitPerRound (int times) { super.limitPerRound (times); return this; }
		
		public EB whenThisIsKilled () { when = new AngACardIsKilled (AngSubject.THIS, null); return new EB (); }
		public EB whenACharacterWouldBeKilled (CFB cardFilterBuilder) { cancelling = true; when = new AngACardIsKilled (AngSubject.EACH_IN_PLAY, cardFilterBuilder.character ().build ()); return new EB (); }
		public EB whenAttachedWouldBeKilledOrDiscardFromPlay () { cancelling = true; when = new AngOr (new AngACardIsKilled (AngSubject.ATTACHED, null), new AngACardIsDiscardedFromPlay (AngSubject.ATTACHED, null)); return new EB (); }
		public EB whenThePhaseEnds (AngPhase phase) { when = new AngPhaseEnds (phase); return new EB (); }
		public EB whenThePhaseBegins (AngPhase phase) { when = new AngPhaseBegins (phase); return new EB (); }
		public EB whenThisLeavesPlay () { when = new AngACardLeavesPlay (AngSubject.THIS, null); return new EB (); }
		
		public IB insteadOfPlacingThisInYourDeadPile () { replaced = new AngPlaceItInYourDeadPile (); return this; }

	} // RB
	
} // AngReaction
