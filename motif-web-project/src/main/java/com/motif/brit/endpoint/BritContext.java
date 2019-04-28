package com.motif.brit.endpoint;

import com.motif.shared.endpoint.MotifContext;
import com.motif.shared.endpoint.sessions.MotifSession;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class BritContext extends MotifContext {

	@Getter private MotifSession session;

	private BritReduxActionList actions;
	public BritReduxActionList actions() {
		if (actions == null) { actions = new BritReduxActionList(); }
		return this.actions;
	}
	
	public static BritContext create(MotifSession session) {
		BritContext context = new BritContext();
		context.session = session;
		return context;
	}
	
	public String getPlayerId() { return session.getUsername(); }
	
	public String getOpponentId() { return session.getUsername().equals("leo") ? "fede" : "leo"; }
	
}
