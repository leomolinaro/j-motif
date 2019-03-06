package com.motif.shared.endpoint.sessions;

import java.util.HashMap;

import javax.websocket.Session;

public class MotifSessionManager {

	private static MotifSessionManager instance;
	public static MotifSessionManager getInstance () {
		if (instance == null) { instance = new MotifSessionManager (); }
		return instance;
	} // getInstance
	private MotifSessionManager () {};
	
	private HashMap<String, MotifSession> sessions = new HashMap<String, MotifSession> ();
	private HashMap<String, MotifUser> users = new HashMap<String, MotifUser> ();
	
	public MotifSession addSession (Session session, String username) {
		MotifUser user = users.get (username);
		if (user == null) { user = new MotifUser (username); users.put (user.getUsername(), user); }
		MotifSession mSession = new MotifSession (session, user);
		user.addSession (mSession);
		sessions.put (mSession.getId (), mSession);
		return mSession;
	} // addSession
	
	public MotifSession removeSession (Session session) {
		MotifSession mSession = sessions.remove (session.getId ());
		MotifUser user = mSession.user;
		user.removeSession (mSession);
		if (!user.hasSessions ()) { users.remove (user.getUsername ()); }
		return mSession;
	} // removeSession

	public MotifUser getUser (String username) {
		return users.get (username);
	} // getUser
	
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
