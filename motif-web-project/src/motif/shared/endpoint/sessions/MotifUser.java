package motif.shared.endpoint.sessions;

import java.util.HashMap;

import com.google.gson.annotations.Expose;

public class MotifUser {

	@Expose private String username;
	private HashMap<String, MotifSession> sessions = new HashMap<String, MotifSession> ();
	
	public MotifUser (String username) {
		this.username = username;
	} // MotifUser

	public String getUsername () { return username; }
	
	public void addSession (MotifSession session) { sessions.put (session.getId (), session); }
	public void removeSession (MotifSession session) { sessions.remove (session.getId ()); }
	public boolean hasSessions () { return !sessions.isEmpty (); }

	public Iterable<MotifSession> sessions () {
		return sessions.values ();
	} // sessions
	
} // MotifUser
