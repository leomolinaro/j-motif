package com.motif.brit.state;

import com.google.gson.annotations.Expose;
import com.motif.shared.endpoint.MotifUser;
import com.motif.shared.game.MotifPlayer;

public class BritPlayer extends MotifPlayer {

	public BritPlayer(String id, String name, MotifUser user) {
		super(user);
		this.id = id;
		this.name = name;
	}

	@Expose private String id;
	public String id() { return id; }
	
	@Expose private String name;
	public String getName() { return name; }
	
}
