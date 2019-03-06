package com.motif.agot.ang.cards;

import com.motif.agot.ang.enums.AngFaction;
import com.motif.agot.ang.enums.AngType;

public abstract class AngCard {
	
	private static long idCounter = 0;

	protected long id = ++idCounter;
	public long getId () { return id; }
	
	private AngType type;
	public AngType getType () { return this.type; }
	public boolean isType (AngType type) { return this.type == type; }

	private AngFaction faction;
	public boolean isFaction (AngFaction faction) { return this.faction == faction; }

	private String title;
	public String getTitle () { return this.title; }
	public boolean hasTitle (String title) { return this.title.equals (title); }
	
	private String imageSource;
	public String getImageSource () { return this.imageSource; }
	
	public AngCard (String title, AngType type, AngFaction faction, String imageSource) {
		this.title = title;
		this.type = type;
		this.faction = faction;
		this.imageSource = imageSource;
	} // AngCard
	
	@Override public String toString () { return title; }	
	
} // AngCard
