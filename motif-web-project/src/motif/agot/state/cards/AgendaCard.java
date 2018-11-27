package motif.agot.state.cards;

import motif.agot.ang.cards.AngAgendaCard;
import motif.agot.state.AgotPlayer;

public class AgendaCard extends TextCard<AngAgendaCard> {

	public AgendaCard (AngAgendaCard ang, AgotPlayer controller) {
		super (ang, controller);
		controller.setAgenda (this);
	} // AgendaCard
	
} // AgendaCard
