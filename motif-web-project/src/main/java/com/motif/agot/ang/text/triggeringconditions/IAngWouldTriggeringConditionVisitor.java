package com.motif.agot.ang.text.triggeringconditions;

public interface IAngWouldTriggeringConditionVisitor<R> {

	public R visit (AngACardIsKilled wouldTrigCond);
	public R visit (AngACardIsDiscardedFromPlay wouldTrigCond);
	public R visit (AngOr wouldTrigCond);
	
} // IAngTriggeringConditionVisitor
