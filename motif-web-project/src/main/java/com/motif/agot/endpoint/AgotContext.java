package com.motif.agot.endpoint;

import com.google.gson.annotations.Expose;
import com.motif.agot.state.AgotPlayer;

import lombok.Getter;

public class AgotContext {

	@Getter
	private final AgotPlayer player;
	
	@Expose @Getter
	private final String playerId;
	
	private AgotReduxActionList actions;
	public AgotReduxActionList actions () {
		if (actions == null) { actions = new AgotReduxActionList (); }
		return this.actions;
	}
	
	public AgotContext(AgotPlayer player) {
		this.player = player;
		this.playerId = player.id();
	}
	
}
