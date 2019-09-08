package com.motif.agot.ang.cards;

import java.util.ArrayList;

import com.motif.agot.ang.enums.AngFaction;
import com.motif.agot.ang.enums.AngIcon;
import com.motif.agot.ang.enums.AngType;
import com.motif.agot.ang.sets.AgotCardSeed;
import com.motif.agot.ang.sets.AgotPack;
import com.motif.agot.ang.text.AngText.TB;

public class AngCharacterCard extends AngMarshallCard {

	private Integer strength;
	public Integer getStrength () { return strength; }
	
	private ArrayList<AngIcon> icons = new ArrayList<AngIcon> ();
	public boolean hasIcon (AngIcon icon) { return icons.contains (icon); }
	public boolean hasIcons () { return !icons.isEmpty (); }
	
	public AngCharacterCard (AgotCardSeed cardSeed, AgotPack setCard, int setId, String title, AngFaction faction, boolean loyal, int cost, boolean unique, IcB iconsBuilder, Integer strength, TB text) {
		super (cardSeed, setCard, setId, title, AngType.CHARACTER, faction, loyal, cost, unique, text.build ());
		if (iconsBuilder != null) { iconsBuilder.build ().forEach (icon -> this.icons.add (icon)); }
		this.strength = strength;
	} // AngCharacterCard
	
	public static class IcB {
		private ArrayList<AngIcon> icons = new ArrayList<AngIcon> ();
		public IcB military () { icons.add (AngIcon.MILITARY); return this; }
		public IcB power () { icons.add (AngIcon.POWER); return this; }
		public IcB intrigue () { icons.add (AngIcon.INTRIGUE); return this; }
		public ArrayList<AngIcon> build () { return icons; }
	} // IconB

	@Override public void accept (AngTextCardVisitor visitor) { visitor.visit (this); }
	
} // AngCharacterCard
