package com.motif.agot.ang.cards;

import com.motif.agot.ang.enums.AngFaction;
import com.motif.agot.ang.enums.AngType;
import com.motif.agot.ang.sets.AgotPack;
import com.motif.agot.ang.text.AngText.TB;

public class AngPlotCard extends AngDeckCard {

	private int income;
	private int initiative;
	private int claim;
	private int reserve;
	
	public int getIncome () { return income; }
	public int getInitiative () { return initiative; }
	public int getClaim () { return claim; }
	public int getReserve () { return reserve; }

	public AngPlotCard (AgotPack setCard, int setId, String title, AngFaction faction, boolean loyal, int income, int initiative, int claim, int reserveValue, TB text) {
		super (setCard, setId, title, AngType.PLOT, faction, loyal, text.build ());
		this.income = income;
		this.initiative = initiative;
		this.claim = claim;
		this.reserve = reserveValue;
	} // AngPlotCard

	@Override public void accept (AngTextCardVisitor visitor) { visitor.visit (this); }
	
} // AngPlotCard
