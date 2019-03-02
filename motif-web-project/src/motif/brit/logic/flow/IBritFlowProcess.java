package motif.brit.logic.flow;

import motif.brit.endpoint.BritContext;

public interface IBritFlowProcess extends IBritFlowStep {

	public IBritFlowStep start(BritContext context);
	
}
