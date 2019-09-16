package com.motif.agot.state.cards;

import com.motif.agot.ang.cards.AngPlotCard;
import com.motif.agot.ang.text.AngWhenRevealed;
import com.motif.agot.state.AgotPlayer;

public class PlotCard extends DeckCard<AngPlotCard> {

	public PlotCard (AngPlotCard ang, AgotPlayer controller) {
		super (ang, controller);
		controller.addPlotCard (this);
	} // PlotCard

	public int getIncome () { return ang.getIncome (); }
	public int getInitiative () { return ang.getInitiative (); }
	public int getClaim () { return ang.getClaim (); }
	public int getReserve () { return ang.getReserve (); }

	public AngWhenRevealed getWhenRevealed () { return this.ang.getWhenRevealed (); }
	public boolean hasWhenRevealed (boolean implicit) { return this.ang.hasWhenRevealed (implicit); }

} // PlotCard
