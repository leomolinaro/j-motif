package com.motif.agot.flow.task;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.flow.request.AgotRequest;
import com.motif.agot.flow.request.AgotResponse;
import com.motif.shared.flow.task.MotifAutoTask;

public abstract class AgotAutoTask extends MotifAutoTask<AgotContext, AgotRequest<?>, AgotResponse> implements IAgotTask {
	
} // AgotAutoTask
