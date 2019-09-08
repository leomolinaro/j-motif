package com.motif.agot.logic.flow;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.requests.AgotChoice;
import com.motif.agot.state.AgotPlayer;

public interface IAgotFlowRequest extends IAgotFlowStep {

	public boolean accept (AgotChoice choice, AgotContext context);

	public AgotPlayer getPlayer ();

	public AgotChoice getAutoChoice ();

} // IAgotFlowRequest
