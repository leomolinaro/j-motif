package com.motif.agot.ang.text.triggeringconditions;

import com.motif.agot.ang.enums.AngPhase;

public class AngPhaseEnds implements IAngTriggeringCondition {

	private AngPhase phase;
	public AngPhase getPhase () { return phase; }
	
	public AngPhaseEnds (AngPhase phase) {
		this.phase = phase;
	} // AngPhaseEnds

	@Override public boolean accept (IAngTriggeringConditionVisitor visitor) { return visitor.visit (this); }

} // AngPhaseEnds
