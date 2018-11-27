package motif.agot.logic.other;

import motif.agot.endpoint.AgotContext;
import motif.agot.state.AgotGame;
import motif.agot.state.AgotPlayer;
import motif.agot.state.cards.AttachmentCard;
import motif.agot.state.cards.CharacterCard;
import motif.agot.state.cards.LocationCard;
import motif.agot.state.cards.MarshallCard;
import motif.agot.state.cards.TextCard;

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
	
} // EnterGameProcedure
