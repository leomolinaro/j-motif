package com.motif.agot.logic.other;

import java.util.ArrayList;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;
import com.motif.agot.state.cards.AttachmentCard;
import com.motif.agot.state.cards.CharacterCard;
import com.motif.agot.state.cards.EventCard;
import com.motif.agot.state.cards.LocationCard;
import com.motif.agot.state.cards.MarshallCard;
import com.motif.shared.util.ListUtil;

public class ExitGameProcedure {

	public static void discardCard (MarshallCard<?> card, AgotGame game, AgotContext context) {
		 AgotPlayer player = card.getController ();
		 removeAttachments (card, player, game, context);
		 removeDuplicates (card, player, context);
		 resetCard (card, game, context);
		 switch (card.getType ()) {
			case ATTACHMENT: AttachmentCard att = (AttachmentCard) card; player.discardAttachment (att, att.getAttachTo (), context); break;
			case CHARACTER: player.discardCharacter ((CharacterCard) card, context); break;
			case LOCATION: player.discardLocation ((LocationCard) card, context); break;
			case FACTION:
			case AGENDA:			
			case EVENT:
			case PLOT: break;
		 } // switch
	} // discardCard
	
	public static void killCharacter (CharacterCard character, AgotGame game, AgotContext context) {
		AgotPlayer player = character.getController ();
		removeAttachments (character, player, game, context);
		removeDuplicates (character, player, context);
		resetCard (character, game, context);
		player.kill (character, context);
	} // killCharacter
	
	private static void resetCard (MarshallCard<?> card, AgotGame game, AgotContext context) {
		if (card.isKneeling ()) { card.stand (context); }
		if (card.getPower () > 0) { card.losePower (card.getPower (), context); }
		if (card.hasConsAbilities ()) {
			card.consAbilities ().forEach (consAbility -> ConsAbilities.unsubscribe (consAbility, card, game));
		} // if
		ConsAbilities.unsubmitConsAbilities (card, game);
	} // resetCard
	
	private static void removeAttachments (MarshallCard<?> attachTo, AgotPlayer player, AgotGame game, AgotContext context) {
		ArrayList<AttachmentCard> attachments = ListUtil.getCopy (attachTo.attachments ());
		for (AttachmentCard att : attachments) {
			removeDuplicates (att, player, context);
			resetCard (att, game, context);
			if (att.isTerminal ()) {
				player.discardAttachment (att, attachTo, context);
			} else {
				player.returnAttachmentToHand (att, attachTo, context);				
			} // if - else
		} // for
	} // removeDuplicates

	private static void removeDuplicates (MarshallCard<?> duplicateTo, AgotPlayer player, AgotContext context) {
		ArrayList<MarshallCard<?>> duplicates = ListUtil.getCopy (duplicateTo.duplicates ());
		for (MarshallCard<?> dup : duplicates) {
			player.discardDuplicate (dup, duplicateTo, context);
		} // for
	} // removeDuplicates

	public static void playEvent (EventCard eventCard, AgotPlayer player, AgotGame game, AgotContext context) {
		game.registerEvent (eventCard.getAngCard (), player);
		player.play (eventCard, context);
	} // playEvent
	
} // ExitGameProcedure
