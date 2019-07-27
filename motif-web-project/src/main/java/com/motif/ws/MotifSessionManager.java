package com.motif.ws;

import java.util.HashMap;

import javax.websocket.Session;

import com.motif.shared.endpoint.MotifToken;
import com.motif.shared.endpoint.MotifUser;

public class MotifSessionManager {

	private static MotifSessionManager instance;

	public static MotifSessionManager getInstance () {
		if (instance == null) {
			instance = new MotifSessionManager ();
		}
		return instance;
	} // getInstance

	private MotifSessionManager () {};

	private HashMap<String, MotifSession> sessions = new HashMap<String, MotifSession> ();
	private HashMap<String, MotifUser> users = new HashMap<String, MotifUser> ();

	public MotifSession addSession (Session session, String username) {
		var user = this.users.get (username);
		if (user == null) {
			user = new MotifUser (username);
			this.users.put (user.getUsername (), user);
		}
		var mSession = new MotifSession (session, user);
		user.addSession (mSession);
		this.sessions.put (mSession.getId (), mSession);
		return mSession;
	}

	public MotifSession removeSession (Session session) {
		MotifSession mSession = this.sessions.remove (session.getId ());
		MotifUser user = mSession.user;
		user.removeSession (mSession);
		if (user.isEmpty ()) {
			this.users.remove (user.getUsername ());
		}
		return mSession;
	} // removeSession

	public MotifUser getUser (String username) {
		return users.get (username);
	} // getUser
	
	public MotifUser getUserByToken (MotifToken token) {
		return this.getUser (token.getToken ());
	} // getUserByToken

	public MotifSession getSession (String sessionId) {
		return sessions.get (sessionId);
	} // getSession

	public Iterable<MotifSession> sessionsByUser (String username) {
		MotifUser user = users.get (username);
		return user.sessions ();
	} // sessionsByUser

	public Iterable<MotifSession> sessions () {
		return sessions.values ();
	} // sessionsByUser

} // MotifSessionManager
