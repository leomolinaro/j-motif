package motif.agot.flow.task;

import motif.agot.endpoint.AgotContext;
import motif.agot.flow.request.AgotRequest;
import motif.agot.flow.request.AgotResponse;
import motif.shared.flow.task.MotifComplexTask;

public abstract class AgotComplexTask extends MotifComplexTask<AgotContext, AgotRequest<?>, AgotResponse> implements IAgotTask {

	@Override
	public abstract IAgotTask getStart (AgotContext context);
		
	@Override
	public abstract IAgotTask getNextTask (AgotContext context);
	
} // AgotAutoTask
