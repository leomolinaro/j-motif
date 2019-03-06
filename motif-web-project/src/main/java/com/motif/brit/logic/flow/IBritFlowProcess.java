package com.motif.brit.logic.flow;

import com.motif.brit.endpoint.BritContext;

public interface IBritFlowProcess extends IBritFlowStep {

	public IBritFlowStep start(BritContext context);
	
}
