package motif.brit.endpoint;

import motif.brit.flow.BritRequest;

public interface IBritSender {

	public void send (BritRequest<?> pendingRequest, BritContext context);
	
} // IBritSender
