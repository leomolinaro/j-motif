package motif.brit.logic.flow;

import motif.brit.endpoint.BritContext;

public interface IBritFlowDecision extends IBritFlowStep {

	public BritRequest<?> request(BritContext context);
	public void response(BritResponse response, BritContext context);
	
}
