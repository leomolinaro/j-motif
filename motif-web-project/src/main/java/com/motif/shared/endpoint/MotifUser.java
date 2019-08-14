package com.motif.shared.endpoint;

import java.util.ArrayList;

import com.google.gson.annotations.Expose;
import com.motif.shared.game.MotifPlayer;

public class MotifUser {

	@Expose public String username;
//	private HashMap<String, MotifSession> sessions = new HashMap<String, MotifSession> ();
	private ArrayList<MotifPlayer> players = new ArrayList<MotifPlayer> ();
	
	public MotifUser (String username) {
		this.username = username;
	} // MotifUser

	public String getUsername () { return username; }
	
//	public void addSession (MotifSession session) { sessions.put (session.getId (), session); }
//	public void removeSession (MotifSession session) { sessions.remove (session.getId ()); }
//	public boolean hasSessions () { return !sessions.isEmpty (); }
//	public Iterable<MotifSession> sessions () { return sessions.values (); }
	
	public void addPlayer (MotifPlayer player) { this.players.add (player); }
	public void removePlayer (MotifPlayer player) { this.players.remove (player); }
	public boolean hasPlayers () { return !this.players.isEmpty (); }

	public boolean isEmpty () {
		return /*!hasSessions () &&*/ !hasPlayers ();
	}
	
} // MotifUser
