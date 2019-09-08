package com.motif.shared.endpoint;

import java.util.HashMap;
import java.util.Optional;

public class MotifAuthManager {

	private static MotifAuthManager instance;

	public static MotifAuthManager getInstance () {
		if (instance == null) {
			instance = new MotifAuthManager ();
		}
		return instance;
	} // getInstance

	private MotifAuthManager () {};

	private HashMap<String, MotifUser> users = new HashMap<String, MotifUser> ();

	public Optional<MotifUser> getUser (String username) {
		return Optional.ofNullable (this.users.get (username));
	} // getUser
	
	public Optional<MotifUser> getUserByToken (MotifToken token) {
		return this.getUser (token.getToken ());
	} // getUserByToken

	public String registerUser (String username) {
		var user = this.getUser (username)
			.orElseGet (() -> {
				var newUser = new MotifUser (username);
				this.users.put (username, newUser);
				return newUser;
			});
		var token = user.getUsername ();
		return token;
	} // registerUser
	
} // MotifSessionManager
