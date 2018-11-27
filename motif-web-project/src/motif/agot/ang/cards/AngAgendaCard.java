package motif.agot.ang.cards;

import motif.agot.ang.enums.AngFaction;
import motif.agot.ang.enums.AngType;
import motif.agot.ang.sets.AgotSetCard;
import motif.agot.ang.text.AngText.TB;

public class AngAgendaCard extends AngTextCard {

	public AngAgendaCard (AgotSetCard setCard, int setId, String title, AngFaction faction, TB text) {
		super (setCard, setId, title, AngType.AGENDA, faction, text.build ());
	} // AngAgendaCard

	@Override public void accept (AngTextCardVisitor visitor) { visitor.visit (this); }

} // AngAgendaCard
