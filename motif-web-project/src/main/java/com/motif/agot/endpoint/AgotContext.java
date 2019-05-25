package com.motif.agot.endpoint;

import com.google.gson.annotations.Expose;
import com.motif.agot.endpoint.clientstate.AgotReduxActionList;
import com.motif.agot.state.AgotPlayer;
import com.motif.shared.endpoint.MotifContext;
import com.motif.shared.endpoint.sessions.MotifSession;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class AgotContext extends MotifContext {

	@Getter private MotifSession session;
	@Expose @Getter private final String player;
	@Expose @Getter private final String opponent;
	
	private AgotReduxActionList actions;
	public AgotReduxActionList actions () {
		if (actions == null) { actions = new AgotReduxActionList (); }
		return this.actions;
	}
	
	public static AgotContext create (MotifSession session) {
		AgotContext context = new AgotContext (session.getUsername(), getOpponent(session.getUsername()));
		context.session = session;
		return context;
	}
	
	public static AgotContext create(AgotPlayer player) {
		var context = new AgotContext(player.getUsername(), getOpponent(player.getUsername()));
		return context;
	}
	
	private static String getOpponent(String player) {
		return player.equals("leo") ? "fede" : "leo";
	}
	
}
