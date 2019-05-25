package com.motif.agot.logic.flow;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.state.AgotPlayer;

public interface IAgotFlowRequest extends IAgotFlowStep {

	public boolean accept(AgotResponse response, AgotContext context);

	public AgotPlayer getPlayer();
	
	public boolean isRepeated();
	public void setRepeated();
	
}
