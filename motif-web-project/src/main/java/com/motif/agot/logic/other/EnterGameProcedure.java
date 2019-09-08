package com.motif.agot.logic.other;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;
import com.motif.agot.state.cards.AttachmentCard;
import com.motif.agot.state.cards.CharacterCard;
import com.motif.agot.state.cards.LocationCard;
import com.motif.agot.state.cards.MarshallCard;
import com.motif.agot.state.cards.PlotCard;
import com.motif.agot.state.cards.TextCard;

public class EnterGameProcedure {

	private static void registerConsAbilities (TextCard<?> card, AgotGame game) {
		if (card.hasConsAbilities ()) {
			AbilityContext ac = new AbilityContext (card, card.getController ());
			card.consAbilities ().forEach (consAbility -> ConsAbilities.subscribe (consAbility, ac, game));
		} // if
	} // registerConsAbility
	
	private static void submitConsAbilities (MarshallCard<?> playedCard, AgotGame game) {
		ConsAbilities.submitConsAbilities (playedCard, game);
	} // submitConsAbilities

	public static void play (CharacterCard card, AgotPlayer player, AgotGame game, AgotContext context) {
		player.play (card, context);
		registerConsAbilities (card, game);
		submitConsAbilities (card, game);
	} // play

	public static void play (LocationCard card, AgotPlayer player, AgotGame game, AgotContext context) {
		player.play (card, context);
		registerConsAbilities (card, game);
		submitConsAbilities (card, game);
	} // play

	public static void play (AttachmentCard card, MarshallCard<?> attachTo, AgotPlayer player, AgotGame game, AgotContext context) {
		player.play (card, attachTo, context);
		registerConsAbilities (card, game);
		submitConsAbilities (card, game);
	} // play
	
	public static void reveal (PlotCard card, AgotPlayer player, AgotGame game, AgotContext context) {
		card.reveal (context);
		registerConsAbilities (card, game);
	} // reveal
	
} // EnterGameProcedure
