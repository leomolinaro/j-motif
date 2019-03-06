package com.motif.agot.ang.text.triggeringconditions;

import com.motif.agot.ang.enums.AngPhase;

public class AngPhaseBegins implements IAngTriggeringCondition {

	private AngPhase phase;
	public AngPhase getPhase () { return phase; }

	public AngPhaseBegins (AngPhase phase) {
		this.phase = phase;
	} // AngPhaseBegins

	@Override public boolean accept (IAngTriggeringConditionVisitor visitor) { return visitor.visit (this); }
	
} // AngYouMarshallThis
