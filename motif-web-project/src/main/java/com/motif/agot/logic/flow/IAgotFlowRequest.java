package com.motif.agot.logic.flow;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.state.AgotPlayer;

public interface IAgotFlowRequest extends IAgotFlowStep {

	// public AgotRequest<?> request(AgotContext context);
	public void response(AgotResponse response, AgotContext context);

	public boolean isValidResponse(AgotResponse response);

	public AgotPlayer getPlayer();
	
}
