package motif.agot.flow.task;

import motif.agot.endpoint.AgotContext;
import motif.agot.flow.request.AgotRequest;
import motif.agot.flow.request.AgotResponse;
import motif.shared.flow.task.MotifAutoTask;

public abstract class AgotAutoTask extends MotifAutoTask<AgotContext, AgotRequest<?>, AgotResponse> implements IAgotTask {
	
} // AgotAutoTask
