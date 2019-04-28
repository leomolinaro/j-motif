package com.motif.agot.logic.flow;

import com.google.gson.JsonElement;
import com.google.gson.annotations.Expose;

public class AgotResponse {

	@Expose private String key;
	public String getKey () { return key; }
	
	@Expose private JsonElement payload;
	public JsonElement getPayload () { return payload; }
	
	public AgotResponse (String key) {
		this.key = key;
	}
	
}
