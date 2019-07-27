package com.motif.agot.ang.cards;

import com.motif.agot.ang.enums.AngFaction;
import com.motif.agot.ang.enums.AngType;
import com.motif.agot.ang.sets.AgotPack;
import com.motif.agot.ang.text.AngText.TB;

public class AngAgendaCard extends AngTextCard {

	public AngAgendaCard (AgotPack setCard, int setId, String title, AngFaction faction, TB text) {
		super (setCard, setId, title, AngType.AGENDA, faction, text.build ());
	} // AngAgendaCard

	@Override public void accept (AngTextCardVisitor visitor) { visitor.visit (this); }

} // AngAgendaCard
