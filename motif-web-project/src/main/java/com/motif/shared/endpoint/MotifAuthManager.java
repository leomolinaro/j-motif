package com.motif.shared.endpoint;

import java.util.HashMap;

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

	public MotifUser getUser (String username) {
		return users.get (username);
	} // getUser
	
	public MotifUser getUserByToken (MotifToken token) {
		return this.getUser (token.getToken ());
	} // getUserByToken

	public String addUser (String username) {
		var user = new MotifUser (username);
		this.users.put (username, user);
		return username;
	} // addUser
	
} // MotifSessionManager
