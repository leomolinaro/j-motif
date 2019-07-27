package com.motif.shared.endpoint.messages;

import com.google.gson.annotations.Expose;

public abstract class Message {

	public String getType () { return type; }
	public void setType (String type) { this.type = type; }
	@Expose protected String type;
	
}
