package com.motif.agot.logic.flow;

import java.util.List;

import com.motif.agot.endpoint.AgotContext;

@Deprecated
public interface IAgotFlowFork extends IAgotFlowStep {

	public List<IAgotFlowStep> start (AgotContext context);
	
	public default AgotFlowStepWait getFlowWait () { return new AgotFlowStepWait (); }
	
} // IAgotFlowFork
