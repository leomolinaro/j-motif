package com.motif.agot.logic.other;

import java.util.function.Predicate;

import com.motif.agot.ang.enums.AngSubject;
import com.motif.agot.ang.text.filters.AngCardFilter;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;
import com.motif.agot.state.cards.AttachmentCard;
import com.motif.agot.state.cards.Card;
import com.motif.agot.state.cards.MarshallCard;
import com.motif.agot.state.cards.TextCard;

public class Subjects {

	public static boolean test (AngSubject subject, AngCardFilter cardFilter, Predicate<? super Card<?>> predicate, Card<?> targetCard, TextCard<?> thisCard, AgotPlayer you, AgotGame game) {
		switch (subject) {
			case ATTACHED:
				AttachmentCard att = (AttachmentCard) thisCard;
				MarshallCard<?> attachTo = att.getAttachTo ();
				return predicate.test (attachTo);
			case EACH_IN_PLAY:
				return game.inPlayCards ()
				.anyMatch (card -> FilterMatcher.doesMatch (card, you, cardFilter) && predicate.test (card));
			case TARGET: return predicate.test (targetCard);
			case THIS: return predicate.test (thisCard);
			default: return false;
		} // switch
	} // test

} // Subjects
