package com.motif.brit.logic.flow;

import com.motif.brit.endpoint.BritContext;

public interface IBritFlowStep {

	public IBritFlowProcess getParent();
	public IBritFlowStep next(BritContext context);
	
}
