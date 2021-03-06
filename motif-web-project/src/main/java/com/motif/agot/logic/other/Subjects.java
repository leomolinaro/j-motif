package com.motif.agot.logic.other;

import java.util.function.Predicate;

import com.motif.agot.ang.enums.AngSubject;
import com.motif.agot.ang.text.filters.AngCardFilter;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.cards.AttachmentCard;
import com.motif.agot.state.cards.Card;
import com.motif.agot.state.cards.MarshallCard;

public class Subjects {

	public static boolean test (AngSubject subject, AngCardFilter cardFilter, Predicate<? super Card<?>> predicate, AbilityContext ac, AgotGame game) {
		switch (subject) {
			case ATTACHED:
				AttachmentCard att = (AttachmentCard) ac.thisCard;
				MarshallCard<?> attachTo = att.getAttachTo ();
				return predicate.test (attachTo);
			case EACH_IN_PLAY:
				return game.inPlayCards ()
				.anyMatch (card -> FilterMatcher.doesMatch (card, ac, cardFilter) && predicate.test (card));
			case TARGET: return predicate.test (ac.thatCard);
			case THIS: return predicate.test (ac.thisCard);
			default: return false;
		} // switch
	} // test

} // Subjects
