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
		var token = sessionManager.addUser (username);
		return new MotifToken (token);
	} // login
	
} // MotifEndpoint
