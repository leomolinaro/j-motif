package com.motif.agot.logic.flow;

import com.motif.agot.endpoint.AgotContext;

public interface IAgotFlowStep {

	public IAgotFlowStep getParent();
	public IAgotFlowStep next(AgotContext context);
	
}
