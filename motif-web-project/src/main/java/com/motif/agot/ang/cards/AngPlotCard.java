package com.motif.agot.ang.cards;

import com.motif.agot.ang.enums.AngFaction;
import com.motif.agot.ang.enums.AngType;
import com.motif.agot.ang.sets.AgotCardSeed;
import com.motif.agot.ang.sets.AgotPack;
import com.motif.agot.ang.text.AngText.TB;
import com.motif.agot.ang.text.AngWhenRevealed;

public class AngPlotCard extends AngDeckCard {

	private int income;
	private int initiative;
	private int claim;
	private int reserve;
	
	public int getIncome () { return income; }
	public int getInitiative () { return initiative; }
	public int getClaim () { return claim; }
	public int getReserve () { return reserve; }

	public AngPlotCard (AgotCardSeed cardSeed, AgotPack setCard, int setId, String title, AngFaction faction, boolean loyal, int income, int initiative, int claim, int reserveValue, TB text) {
		super (cardSeed, setCard, setId, title, AngType.PLOT, faction, loyal, text.build ());
		this.income = income;
		this.initiative = initiative;
		this.claim = claim;
		this.reserve = reserveValue;
	} // AngPlotCard

	@Override public void accept (AngTextCardVisitor visitor) { visitor.visit (this); }
	
	public AngWhenRevealed getWhenRevealed () { return text.getWhenRevealed (); }
	public boolean hasWhenRevealed (boolean implicit) { return text.hasWhenRevealed (implicit); }
	
} // AngPlotCard
