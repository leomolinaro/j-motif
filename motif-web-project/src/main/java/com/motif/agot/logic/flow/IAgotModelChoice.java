package com.motif.agot.logic.flow;

import com.motif.agot.logic.requests.AAgotRequest.AgotRequestType;
import com.motif.agot.logic.requests.AgotChoice;

public interface IAgotModelChoice {
	
	public AgotChoice getChoice (AgotRequestType requestType);
	
} // IAgotModelChoice
