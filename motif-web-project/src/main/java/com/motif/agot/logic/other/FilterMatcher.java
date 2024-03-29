package com.motif.agot.logic.other;

import java.util.stream.Stream;

import com.motif.agot.ang.cards.AngCard;
import com.motif.agot.ang.cards.AngTextCard;
import com.motif.agot.ang.text.filters.AngCardFilter;
import com.motif.agot.ang.text.filters.AngChallengeFilter;
import com.motif.agot.ang.text.filters.AngPlayerFilter;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;
import com.motif.agot.state.Challenge;
import com.motif.agot.state.cards.Card;
import com.motif.agot.state.cards.CharacterCard;
import com.motif.agot.state.cards.TextCard;
import com.motif.shared.exceptions.MotifUnexpectedError;

public class FilterMatcher {

	@SuppressWarnings("unchecked")
	public static <C extends Card<?>> Stream<C> allMatches (AbilityContext ac, AgotGame game, AngCardFilter cardFilter) {
		return game.inPlayCards ()
		.filter (c -> doesMatch (c, ac, cardFilter))
		.map (c -> (C) c);
	} // allMatches

	public static Stream<AgotPlayer> allPlayerMatches (AbilityContext ac, AgotGame game, AngPlayerFilter playerFilter) {
		return game.players ()
				.filter (p -> doesMatch (p, ac, playerFilter, game));
	} // allMatches

	public static boolean doesMatch (Card<?> card, AbilityContext ac, AngCardFilter cardFilter) {
		AngCard ang = card.getAngCard ();
		// TODO nuovi vincoli...
		if (cardFilter.kneeling () && !card.isKneeling ()) { return false; }
		if (cardFilter.standing () && !card.isStanding ()) { return false; }
		if (cardFilter.hasTitle () && !ang.hasTitle (cardFilter.getTitle ())) { return false; }
		if (cardFilter.hasTypes () && !cardFilter.types ().anyMatch (type -> ang.isType (type))) { return false; }
		if (cardFilter.hasFaction () && !ang.isFaction (cardFilter.getFaction ())) { return false; }
		if (cardFilter.getOther () && card == ac.thisCard) { return false; }
		if (cardFilter.hasYouControl () && cardFilter.getYouControl () != card.isControlledBy (ac.you)) { return false; }
		if (card instanceof TextCard<?>) {
			TextCard<?> textCard = (TextCard<?>) card;
			AngTextCard angTextCard = textCard.getAngCard ();
			if (cardFilter.hasTraits () && !cardFilter.traits ().anyMatch (trait -> angTextCard.hasTrait (trait))) { return false; }
		} // if
		return true;
	} // doesMatch
	
//	public static boolean doesMatch (Card<?> card, AgotPlayer you, AngCardFilter cardFilter) {
//		AngCard ang = card.getAngCard ();
//		// TODO nuovi vincoli...
//		if (cardFilter.kneeling () && !card.isKneeling ()) { return false; }
//		if (cardFilter.standing () && !card.isStanding ()) { return false; }
//		if (cardFilter.hasTitle () && !ang.hasTitle (cardFilter.getTitle ())) { return false; }
//		if (cardFilter.hasTypes () && !cardFilter.types ().anyMatch (type -> ang.isType (type))) { return false; }
//		if (cardFilter.hasFaction () && !ang.isFaction (cardFilter.getFaction ())) { return false; }
//		if (cardFilter.hasYouControl () && cardFilter.getYouControl () != card.isControlledBy (you)) { return false; }
//		if (card instanceof TextCard<?>) {
//			TextCard<?> textCard = (TextCard<?>) card;
//			AngTextCard angTextCard = textCard.getAngCard ();
//			if (cardFilter.hasTraits () && !cardFilter.traits ().anyMatch (trait -> angTextCard.hasTrait (trait))) { return false; }
//		} // if
//		return true;
//	} // doesMatch
	
	public static boolean doesMatch (Challenge challenge, AbilityContext ac, AngChallengeFilter filter, AgotGame game) {
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
			}, ac, game);
		} // if
		return true;
	} // doesMatch
	
	public static boolean doesMatch (AgotPlayer player, AbilityContext ac, AngPlayerFilter filter, AgotGame game) {
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
				return player == ac.you;
			} else if (filter.opponent ()) {
				return player != ac.you;
			} // if - else
		} // if - else
		throw new MotifUnexpectedError ();
	} // doesMatch
	
} // FilterMatcher
