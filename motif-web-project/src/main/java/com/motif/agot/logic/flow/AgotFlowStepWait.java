package com.motif.agot.logic.flow;

import com.motif.agot.endpoint.AgotContext;

public class AgotFlowStepWait implements IAgotFlowStep {

	@Override
	public IAgotFlowProcess getParent () {
		return null;
	}

	@Override
	public IAgotFlowStep next (AgotContext context) {
		return null;
	}
	
}
