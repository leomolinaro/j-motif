package com.motif.shared.endpoint;

import io.leangen.graphql.annotations.GraphQLMutation;

public class MotifEndpoint {

	private static MotifAuthManager sessionManager = MotifAuthManager.getInstance();
	
	private static MotifEndpoint instance;
	public static MotifEndpoint getInstance () {
		if (instance == null) { instance = new MotifEndpoint (); }
		return instance;
	} // getInstance
	private MotifEndpoint () {};
	
	@GraphQLMutation
	public MotifToken login (String username) {
		var user = sessionManager.registerUser (username);
		return new MotifToken (user);
	} // login
	
} // MotifEndpoint
