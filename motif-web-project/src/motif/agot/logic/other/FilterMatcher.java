package motif.agot.logic.other;

import java.util.stream.Stream;

import motif.agot.ang.cards.AngCard;
import motif.agot.ang.cards.AngTextCard;
import motif.agot.ang.text.filters.AngCardFilter;
import motif.agot.ang.text.filters.AngChallengeFilter;
import motif.agot.ang.text.filters.AngPlayerFilter;
import motif.agot.state.Challenge;
import motif.agot.state.AgotGame;
import motif.agot.state.AgotPlayer;
import motif.agot.state.cards.Card;
import motif.agot.state.cards.CharacterCard;
import motif.agot.state.cards.TextCard;
import motif.shared.exceptions.MotifUnexpectedError;

public class FilterMatcher {

	@SuppressWarnings("unchecked")
	public static <C extends Card<?>> Stream<C> allMatches (AgotPlayer you, AgotGame game, AngCardFilter cardFilter) {
		return game.inPlayCards ()
		.filter (c -> doesMatch (c, you, cardFilter))
		.map (c -> (C) c);
	} // allMatches

	public static Stream<AgotPlayer> allPlayerMatches (AgotPlayer you, AgotGame game, AngPlayerFilter playerFilter) {
		return game.players ()
				.filter (p -> doesMatch (p, you, playerFilter, game));
	} // allMatches

	
	public static boolean doesMatch (Card<?> card, AgotPlayer you, AngCardFilter cardFilter) {
		AngCard ang = card.getAngCard ();
		// TODO nuovi vincoli...
		if (cardFilter.hasTitle () && !ang.hasTitle (cardFilter.getTitle ())) { return false; }
		if (cardFilter.hasTypes () && !cardFilter.types ().anyMatch (type -> ang.isType (type))) { return false; }
		if (cardFilter.hasFaction () && !ang.isFaction (cardFilter.getFaction ())) { return false; }
		if (cardFilter.hasYouControl () && cardFilter.getYouControl () != card.isControlledBy (you)) { return false; }
		if (card instanceof TextCard<?>) {
			TextCard<?> textCard = (TextCard<?>) card;
			AngTextCard angTextCard = textCard.getAngCard ();
			if (cardFilter.hasTraits () && !cardFilter.traits ().anyMatch (trait -> angTextCard.hasTrait (trait))) { return false; }
		} // if
		return true;
	} // doesMatch
	
	public static boolean doesMatch (Challenge challenge, AgotPlayer you, Card<?> targetCard, TextCard<?> thisCard, AngChallengeFilter filter, AgotGame game) {
		if (filter.hasIcon () && !challenge.isType (filter.getIcon ())) { return false; }
		if (filter.unopposed () && !challenge.unopposed ()) { return false; }
		if (filter.hasPartecipatingCondition ()) {
			Subjects.test (filter.getPartecipatingSubject (), filter.getPartecipatingCardFilter (), card -> {
				if (challenge.isAttacker ((CharacterCard) card)) {
					return !filter.partecipatingAsDefender ();
				} else if (challenge.isDefender ((CharacterCard) card)) {
					return !filter.partecipatingAsAttacker ();
				} else {
					return false;
				} // if - else
			}, targetCard, thisCard, you, game);
		} // if
		return true;
	} // doesMatch
	
	public static boolean doesMatch (AgotPlayer player, AgotPlayer you, AngPlayerFilter filter, AgotGame game) {
		if (filter.duringChallenge ()) {
			Challenge challenge = game.getChallenge ();
			if (challenge == null) {
				return false;
			} else {
				if (filter.theLoosingOpponent ()) {
					return player == challenge.loser ();
				} // if				
			} // if - else
		} else {
			if (filter.you ()) {
				return player == you;
			} else if (filter.opponent ()) {
				return player != you;
			} // if - else
		} // if - else
		throw new MotifUnexpectedError ();
	} // doesMatch
	
} // FilterMatcher
