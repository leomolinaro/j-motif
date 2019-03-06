package com.motif.agot.flow.task;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.flow.request.AgotRequest;
import com.motif.agot.flow.request.AgotResponse;
import com.motif.shared.flow.task.MotifComplexTask;

public abstract class AgotComplexTask extends MotifComplexTask<AgotContext, AgotRequest<?>, AgotResponse> implements IAgotTask {

	@Override
	public abstract IAgotTask getStart (AgotContext context);
		
	@Override
	public abstract IAgotTask getNextTask (AgotContext context);
	
} // AgotAutoTask
