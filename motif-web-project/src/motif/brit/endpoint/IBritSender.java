package motif.brit.endpoint;

import motif.brit.logic.flow.BritRequest;

public interface IBritSender {

	public void send (BritRequest<?> pendingRequest, BritContext context);
	
} // IBritSender
