package com.motif.agot.ang.text.instants;

import com.motif.agot.ang.enums.AngSubject;
import com.motif.agot.ang.text.effects.IAngEffect;
import com.motif.agot.ang.text.effects.IAngEffectVisitor;

public class AngPutThatIntoPlayUnderYourControl implements IAngEffect {

	private AngSubject subject;
	public AngSubject getSubject () { return subject; }
	
	public AngPutThatIntoPlayUnderYourControl (AngSubject subject) {
		this.subject = subject;
	} // AngDiscardEachFromPlay

	@Override public boolean accept (IAngEffectVisitor visitor) { return visitor.visit (this); }

} // AngPutIntoPlayUnderYourControl
