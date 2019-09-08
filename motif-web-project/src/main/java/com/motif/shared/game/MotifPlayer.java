package com.motif.shared.game;

import com.motif.shared.endpoint.MotifUser;

import io.leangen.graphql.annotations.GraphQLQuery;

public abstract class MotifPlayer {

	public MotifPlayer (MotifUser user) {
		this.user = user;
		this.user.addPlayer (this);
	} // MotifPlayer
	
	private final MotifUser user;
	@GraphQLQuery public MotifUser getUser () { return this.user; }
	
} // MotifPlayer
