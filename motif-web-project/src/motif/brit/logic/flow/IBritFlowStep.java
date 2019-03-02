package motif.brit.logic.flow;

import motif.brit.endpoint.BritContext;

public interface IBritFlowStep {

	public IBritFlowProcess getParent();
	public IBritFlowStep next(BritContext context);
	
}
