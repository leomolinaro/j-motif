package com.motif.shared.endpoint.sessions;

import javax.websocket.RemoteEndpoint.Basic;

import com.google.gson.annotations.Expose;

import javax.websocket.Session;

public class MotifSession {

	@Expose protected Session session;
	public String getId () { return session.getId (); }
	public Basic getSender () { return session.getBasicRemote (); }

	@Expose protected MotifUser user;
	public MotifUser getUser () { return user; }
	public String getUsername () { return user.getUsername (); }
	
	public MotifSession (Session session, MotifUser user) {
		this.session = session;
		this.user = user;
	} // MotifSession

	@Override
	public String toString () {
		return "MotifSession [sessionId=" + session.getId () + ", user=" + user.getUsername () + "]";
	} // toString
		
} // MotifSession
