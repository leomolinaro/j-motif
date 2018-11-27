package motif.brit.flow;

import motif.brit.endpoint.BritContext;

public interface IBritHumanIO extends IBritIO {

	public BritRequest<?> request (BritContext context);

	public void response (BritResponse response, BritContext context);
	
} // IBritHumanIO
