package com.motif.shared.endpoint;

import java.util.ArrayList;

import com.motif.shared.game.MotifPlayer;

import io.leangen.graphql.annotations.GraphQLQuery;

public class MotifUser {

	private String username;
	private ArrayList<MotifPlayer> players = new ArrayList<MotifPlayer> ();
	
	public MotifUser (String username) {
		this.username = username;
	} // MotifUser

	@GraphQLQuery public String getUsername () { return username; }
	
	
	public void addPlayer (MotifPlayer player) { this.players.add (player); }
	public void removePlayer (MotifPlayer player) { this.players.remove (player); }
	public boolean hasPlayers () { return !this.players.isEmpty (); }

	public boolean isEmpty () {
		return !hasPlayers ();
	}
	
} // MotifUser
