package com.motif.brit.endpoint;

import com.motif.brit.logic.flow.BritRequest;

public interface IBritSender {

	public void send (BritRequest<?> pendingRequest, BritContext context);
	
} // IBritSender
