package motif.agot.logic.other;

import java.util.function.Predicate;

import motif.agot.ang.enums.AngSubject;
import motif.agot.ang.text.filters.AngCardFilter;
import motif.agot.state.AgotGame;
import motif.agot.state.AgotPlayer;
import motif.agot.state.cards.AttachmentCard;
import motif.agot.state.cards.Card;
import motif.agot.state.cards.MarshallCard;
import motif.agot.state.cards.TextCard;

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
