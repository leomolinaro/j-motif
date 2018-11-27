package motif.agot.state.cards;

import motif.agot.ang.cards.AngPlotCard;
import motif.agot.state.AgotPlayer;

public class PlotCard extends DeckCard<AngPlotCard> {

	public PlotCard (AngPlotCard ang, AgotPlayer controller) {
		super (ang, controller);
		controller.addPlotCard (this);
	} // PlotCard

	public int getIncome () { return ang.getIncome (); }
	public int getInitiative () { return ang.getInitiative (); }
	public int getClaim () { return ang.getClaim (); }
	public int getReserve () { return ang.getReserve (); }

} // PlotCard
