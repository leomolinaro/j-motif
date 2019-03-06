package com.motif.brit.state;

import com.google.gson.annotations.Expose;

public class BritPlayer {

	public BritPlayer (String id, String name) {
		this.id = id;
		this.name = name;
	} // BritPlayer

	@Expose private String id;
	public String getId () { return id; }
	
	@Expose private String name;
	public String getName () { return name; }
	
} // BritPlayer
