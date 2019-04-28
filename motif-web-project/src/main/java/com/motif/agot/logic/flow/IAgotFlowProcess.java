package com.motif.agot.logic.flow;

import com.motif.agot.endpoint.AgotContext;

public interface IAgotFlowProcess extends IAgotFlowStep {

	public IAgotFlowStep start(AgotContext context);
	
}
