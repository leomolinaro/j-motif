package com.motif.brit.endpoint;

import com.motif.shared.endpoint.MotifContext;
import com.motif.shared.endpoint.sessions.MotifSession;

public class BritContext extends MotifContext {

	private MotifSession session;
	public MotifSession getSession() { return this.session; }
	private void setSession(MotifSession session) { this.session = session; }

	private BritReduxActionList actions;
	public BritReduxActionList actions() {
		if (actions == null) { actions = new BritReduxActionList(); }
		return this.actions;
	}
	
	private BritContext() {}
	
	public static BritContext create(MotifSession session) {
		BritContext context = new BritContext();
		context.setSession(session);
		return context;
	}
	
	public String getPlayerId() { return session.getUsername(); }
	
	public String getOpponentId() { return session.getUsername().equals("leo") ? "fede" : "leo"; }
	
}