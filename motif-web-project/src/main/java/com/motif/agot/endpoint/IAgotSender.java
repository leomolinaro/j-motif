package com.motif.agot.endpoint;

import com.motif.agot.logic.flow.IAgotFlowRequest;

public interface IAgotSender {

	public void send(IAgotFlowRequest decision, AgotContext context);
	
}
