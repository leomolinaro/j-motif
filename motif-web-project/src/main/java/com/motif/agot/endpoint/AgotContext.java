package com.motif.agot.endpoint;

import com.google.gson.annotations.Expose;
import com.motif.agot.endpoint.clientstate.AgotReduxActionList;
import com.motif.shared.endpoint.MotifContext;
import com.motif.shared.endpoint.sessions.MotifSession;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class AgotContext extends MotifContext {

	@Getter private MotifSession session;
	
	private AgotReduxActionList actions;
	public AgotReduxActionList actions () {
		if (actions == null) { actions = new AgotReduxActionList (); }
		return this.actions;
	} // actions
	
	public static AgotContext create (MotifSession session) {
		AgotContext context = new AgotContext (
				session == null ? null : session.getUsername(),
				session == null ? null : session.getUsername().equals("leo") ? "fede" : "leo");
		context.session = session;
		return context;
	} // createAgotContext
	
	@Expose private final String player;
	@Expose private final String opponent;
	
	public String getPlayerId() { return session.getUsername(); }
	
	public String getOpponentId() { return session.getUsername().equals("leo") ? "fede" : "leo"; }

} // AgotContext
