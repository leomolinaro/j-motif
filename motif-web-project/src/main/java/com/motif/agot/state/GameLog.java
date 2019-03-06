package com.motif.agot.state;

import java.text.MessageFormat;
import java.util.ArrayList;

import com.motif.agot.ang.enums.AngIcon;
import com.motif.agot.ang.enums.AngToken;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.state.cards.Card;
import com.motif.agot.state.cards.CharacterCard;
import com.motif.agot.state.cards.DrawCard;
import com.motif.agot.state.cards.MarshallCard;
import com.motif.agot.state.cards.TextCard;

public class GameLog {

	private enum GameLogRowType {
		EVENT, ROUND, PHASE, STEP;
	} // GameLogRowType
	
	public class GameLogRow {
		@SuppressWarnings("unused")
		private String message;
		@SuppressWarnings("unused")
		private GameLogRowType type;
		public GameLogRow (String message, GameLogRowType type) {
			this.message = message;
			this.type = type;
		} // GameLogRow
	} // GameLogRow
	
	private ArrayList<GameLogRow> logRows;
	
	public GameLog (ArrayList<GameLogRow> logRows) {
		this.logRows = logRows;
	} // GameLog

	private void add (AgotContext context, GameLogRowType type, String text, Object...args) {
		String message = new MessageFormat (text).format (args);
		GameLogRow logRow = new GameLogRow (message, type);
		logRows.add (logRow);
		System.out.println (message);
		context.actions ().addLog (logRow);
	} // add

	private void add (AgotContext context, String text, Object...args) {
		add (context, GameLogRowType.EVENT, text, args);
	} // add
	
	public void round (String round, AgotContext context) { add (context, GameLogRowType.ROUND, round); }
	public void phase (String phase, AgotContext context) { add (context, GameLogRowType.PHASE, phase); }
	public void step (String step, AgotContext context) { add (context, GameLogRowType.STEP, step); }
	
	// PLOT PHASE INFO
	public void winsInitiative (AgotPlayer initiveWinner, AgotContext context) { add (context, "{0} wins the initiative.", initiveWinner.getName ()); }
	public void hasMoreInitiativeThan (AgotPlayer p1, AgotPlayer p2, AgotContext context) { add (context, "{0} has more initiative than {1}.", p1.getName (), p2.getName ()); }
	public void hasTheSameInitiativeButLessPowerThan (AgotPlayer p1, AgotPlayer p2, AgotContext context) { add (context, "{0} has the same initiative but less power than {1}.", p1.getName (), p2.getName ()); }
	public void hasTheSameInitiativeAndTheSamePowerOf (AgotPlayer p1, AgotPlayer p2, AgotContext context) { add (context, "{0} has the same initiative and the same power of {1}.", p1.getName (), p2.getName ()); }
	public void becomesFirstPlayer (AgotPlayer firstPlayer, AgotContext context) { add (context, "{0} becomes the first player.", firstPlayer.getName ()); }
	public void initiativeTieBrokenByRandomlySelect (AgotPlayer randomlySelected, AgotContext context) { add (context, "{0} has been randomly selected to broken the tie.", randomlySelected.getName ()); }
	
	// DRAW PHASE INFO
	public void drawDrawsCards (AgotPlayer player, int nCards, AgotContext context) { add (context, "Draw: {0} draws {1} cards.", player.getName (), nCards); }

	// MARSHALL PHASE INFO
	public void collectsGold (AgotPlayer activePlayer, int income, AgotContext context) { add (context, "{0} collects {1} golds.", activePlayer.getName (), income); }
	public void marshalls (AgotPlayer player, MarshallCard<?> toMarshall, AgotContext context) { add (context, "{0} marshalls {1}.", player.getName (), toMarshall.getTitle ()); }
	public void marhallsAttachedTo (AgotPlayer player, MarshallCard<?> toMarshall, MarshallCard<?> attachTo, AgotContext context) { add (context, "{0} marshalls {1} attached to {2}.", player.getName (), toMarshall.getTitle (), attachTo.getTitle ()); }
	public void duplicates (AgotPlayer player, MarshallCard<?> toMarshall, AgotContext context) { add (context, "{0} duplicates {1}.", player.getName (), toMarshall.getTitle ()); }
	
	// CHALLENGES PHASE INFO
	public void initiatesAchallenge (AgotPlayer attacker, AgotPlayer defender, AngIcon challengeType, AgotContext context) { add (context, "{0} initiates a {1} challenge against {2}.", attacker.getName (), challengeType.getLabel (), defender.getName ()); }
	public void declaresAsAttacker (AgotPlayer player, CharacterCard att, AgotContext context) { add (context, "{0} declares {1} as attacker.", player.getName (), att.getTitle ()); }
	public void charactedIsBypassed (AgotPlayer player, CharacterCard bypassed, AgotContext context) { add (context, "{0} bypassed {1} with stealth.", player.getName (), bypassed.getTitle ()); }
	public void declaresAsDefender (AgotPlayer player, CharacterCard defender, AgotContext context) { add (context, "{0} declares {1} as defender.", player.getName (), defender.getTitle ()); }
	public void winsTheChallenge (AgotPlayer winner, AgotContext context) { add (context, "{0} wins the challenge.", winner.getName ()); }
	public void winsTheChallengeUnopposed (AgotPlayer winner, AgotContext context) { add (context, "{0} wins the challenge unopposed.", winner.getName ()); }
	public void gainsPowerForUnopposed (AgotPlayer attacker, AgotContext context) { add (context, "{0} gains one power on the faction card due to unopposed.", attacker.getName ()); }
	public void discards (AgotPlayer player, DrawCard<?> card, AgotContext context) { add (context, "{0} discards {1}.", player.getName (), card.getTitle ()); }
	public void kills (AgotPlayer defender, CharacterCard toKill, AgotContext context) { add (context, "{0} kills {1}.", defender.getName (), toKill.getTitle ()); }
	public void losesPowerTokens (AgotPlayer player, int lostPower, AgotContext context) { add (context, "{0} loses {1} power tokens.", player.getName (), lostPower); }
	public void gainsPowerTokens (AgotPlayer player, int lostPower, AgotContext context) { add (context, "{0} gains {1} power tokens.", player.getName (), lostPower); }

	// DOMINANCE PHASE INFO
	public void hasMoreDominanceThan (AgotPlayer p1, AgotPlayer p2, AgotContext context) { add (context, "{0} has more dominance than {1}.", p1.getName (), p2.getName ()); }
	public void haveTheSameDominance (AgotPlayer p1, AgotPlayer p2, AgotContext context) { add (context, "{0} and {1} have the same dominance.", p1.getName (), p2.getName ()); }
	public void dominanceTie (AgotContext context) { add (context, "No player wins dominance."); }
	public void winsDominance (AgotPlayer dominanceWinner, AgotContext context) { add (context, "{0} wins dominance.", dominanceWinner.getName ()); }
	public void dominanceGainPower (AgotPlayer dominanceWinner, AgotContext context) { add (context, "Dominance: {0} gains 1 power on the faction card.", dominanceWinner.getName ()); }
		
	// STANDING PHASE INFO
	public void standingStandsCard (AgotPlayer player, Card<?> standingCard, AgotContext context) { add (context, "Standing: {0} stands {1}.", player.getName (), standingCard.getTitle ()); }

	// TRIBUTE PHASE INFO
	public void tributeDiscardGold (AgotPlayer player, int unspent, AgotContext context) { add (context, "Tribute: {0} discards {1} unspent gold.", player.getName (), unspent); }
	
	// COST - EFFECTS INFO
	public void paysNGold (AgotPlayer player, int nGold, AgotContext context) { add (context, "{0} pays {1} gold.", player.getName (), nGold); }
	public void kneelsCard (AgotPlayer player, Card<?> card, AgotContext context) { add (context, "{0} kneels {1}.", player.getName (), card.getTitle ()); }
	public void standsCard (AgotPlayer player, Card<?> card, AgotContext context) { add (context, "{0} stands {1}.", player.getName (), card.getTitle ()); }
	public void reducesTheCostOfTheNextCardHeMashallsThisPhaseByN (AgotPlayer player, int n, AgotContext context) { add (context, "{0} reduces the cost of the next -restrictions- card he/she marshalls this phase by {1}.", player.getName (), n); }
	@Deprecated
	public void effectDrawsNCards (AgotPlayer player, TextCard<?> card, int nCardsDrawn, AgotContext context) { add (context, "{0}: {1} draws {2} cards.", card.getTitle (), player.getName (), nCardsDrawn); }
	@Deprecated
	public void effectStandsCard (AgotPlayer player, TextCard<?> card, TextCard<?> standingCard, AgotContext context) { add (context, "{0}: {1} stands {2}.", card.getTitle (), player.getName (), standingCard.getTitle ()); }
	@Deprecated
	public void effectKneelsCard (AgotPlayer player, TextCard<?> card, TextCard<?> standingCard, AgotContext context) { add (context, "{0}: {1} kneels {2}.", card.getTitle (), player.getName (), standingCard.getTitle ()); }
	@Deprecated
	public void effectGainNGolds (AgotPlayer player, TextCard<?> card, int gainedGold, AgotContext context) { add (context, "{0}: {1} gains {2} golds.", card.getTitle (), player.getName (), gainedGold); }
	@Deprecated
	public void effectLosePower (AgotPlayer player, TextCard<?> trigCard, Card<?> targetCard, int lostPower, AgotContext context) { add (context, "{0}: {1} loses {2} power tokens.", trigCard.getTitle (), targetCard.getTitle (), lostPower); }
	@Deprecated
	public void effectGainPower (AgotPlayer player, TextCard<?> trigCard, Card<?> targetCard, int gainedPower, AgotContext context) { add (context, "{0}: {1} gain {2} power tokens.", trigCard.getTitle (), targetCard.getTitle (), gainedPower); }
	
	// EVENTS
	public void gainsNGolds (AgotPlayer player, int gainedGold, AgotContext context) { add (context, "{0} gains {1} gold.", player.getName (), gainedGold); }
	public void drawsNCards (AgotPlayer player, int nCardsDrawn, AgotContext context) { add (context, "{0} draws {1} cards.", player.getName (), nCardsDrawn); }
	public void standsCard (Card<?> standingCard, AgotContext context) { add (context, "{0} is standed.", standingCard.getTitle ()); }
	public void kneelsCard (Card<?> kneelingCard, AgotContext context) { add (context, "{0} is kneeled.", kneelingCard.getTitle ()); }
	public void killsCharacter (CharacterCard killedCard, AgotContext context) { add (context, "{0} is killed.", killedCard.getTitle ()); }
	public void losePower (Card<?> targetCard, int lostPower, AgotContext context) { add (context, "{0} loses {1} power tokens.", targetCard.getTitle (), lostPower); }
	public void gainPower (Card<?> targetCard, int gainedPower, AgotContext context) { add (context, "{0} gains {1} power tokens.", targetCard.getTitle (), gainedPower); }
	public void savesCard (MarshallCard<?> card, AgotContext context) { add (context, "{0} is saved.", card.getTitle ()); }
	public void discardsCard (MarshallCard<?> card, AgotContext context) { add (context, "{0} is discards.", card.getTitle ()); }
	public void placeOneToken (AngToken token, MarshallCard<?> card, AgotContext context) { add (context, "{0} gains one {1} token.", card.getTitle (), token.getLabel ()); }
	
	public void becomesActivePlayer (AgotPlayer nextPlayer, AgotContext context) { add (context, "{0} becomes the active player.", nextPlayer.getName ()); }

} // GameLog
