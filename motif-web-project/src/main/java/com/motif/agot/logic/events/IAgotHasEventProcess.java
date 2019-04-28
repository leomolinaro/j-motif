package com.motif.agot.logic.events;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;

public interface IAgotHasEventProcess extends IAgotFlowProcess {
	public IAgotFlowStep after(AgotEventProcess eventProcess, AgotContext context);
}