package com.motif.shared.game;

import com.motif.shared.endpoint.MotifUser;

import lombok.Getter;

public abstract class MotifPlayer {

	public MotifPlayer(MotifUser user) {
		this.user = user;
		this.user.addPlayer (this);
	}
	
	@Getter
	private final MotifUser user;
	
}
