package com.motif.shared.endpoint.messages;

import com.google.gson.annotations.Expose;
import com.motif.shared.endpoint.sessions.MotifSession;

public abstract class Message {

	public MotifSession getSession () { return session; }
	public void setSession (MotifSession session) { this.session = session; }	
	@Expose protected MotifSession session;

	public String getType () { return type; }
	public void setType (String type) { this.type = type; }
	@Expose protected String type;
	
} // MessageIn
