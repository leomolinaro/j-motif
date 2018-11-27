package motif.brit.state;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import motif.brit.ang.enums.AngPhase;
import motif.brit.ang.enums.BritGameLogRowType;
import motif.brit.endpoint.BritContext;
import motif.shared.gamelog.MotifGameLog;
import motif.shared.util.MotifConsole.MotifConsoleBorder;

public class BritGameLog extends MotifGameLog<BritGameLogRowType> {

	public BritGameLog (ArrayList<MotifGameLog<BritGameLogRowType>.MotifGameLogRow> logRows) {
		super (logRows);
	} // BritGameLog
	
	protected void addLog (BritContext context, BritGameLogRowType type, MotifConsoleBorder borderType, String text, Object... args) {
		MotifGameLog<BritGameLogRowType>.MotifGameLogRow logRow = super.add (type, borderType, text, args);
		context.actions ().addLog (logRow);
	} // addLog

	public void round (String round, BritContext context) { addLog (context, BritGameLogRowType.ROUND, MotifConsoleBorder.WIDE, round); }
	public void nationTurn (BritNation nation, BritContext context) { addLog (context, BritGameLogRowType.NATION_TURN, MotifConsoleBorder.NORMAL, nation.getName ()); }
	public void phase (AngPhase phase, BritContext context) { addLog (context, BritGameLogRowType.PHASE, MotifConsoleBorder.THIN, phase.getLabel ()); }
	private void event (BritContext context, String text, Object...args) { addLog (context, BritGameLogRowType.EVENT, MotifConsoleBorder.NONE, text, args); }

	public void noAvailableLandsForPlacingUnits (BritNation nation, BritContext context) { event(context, "{0} has no available lands to place new units.", nation.getName ()); }
	public void nationHasPopulationPoints (BritNation nation, int populationPoints, BritContext context) { event(context, "{0} has {1} population points.", nation.getName (), populationPoints); }
	public void playerPlacesUnit (BritUnit unit, BritArea area, BritPlayer player, BritContext context) { event(context, "{0} places the unit {1} in {2}.", player.getName (), unit.getLabel (), area.getName ()); }
	public void playerMovesUnit (BritUnit unit, BritArea fromArea, BritArea toArea, BritPlayer player, BritContext context) { event(context, "{0} moves the unit {1} from {2} to {3}.", player.getName (), unit.getLabel (), fromArea.getName (), toArea.getName ()); }
	public void unitRetreats(BritUnit unit, BritArea fromArea, BritArea toArea, BritPlayer player, BritContext context) { event(context, "Unit {0} retreats from {1} to {2}.", unit.getLabel (), fromArea.getName (), toArea.getName ()); }
	public void playerRollsDice (List<Integer> diceResult, int nDice, BritPlayer player, BritContext context) {
		String result = diceResult.stream ().map (String::valueOf).collect(Collectors.joining (", "));
		event(context, "{0} roll {1} dice with the result of {2}", player.getName (), nDice, result);
	}
	public void defenderWinsTheBattle(BritNation defNation, BritLandArea battleLand, BritContext context) { event(context, "{0} wins the battle and keeps the defences of {1}.", defNation.getName(), battleLand.getName()); }
	public void attackerWinsTheBattle(BritNation attNation, BritLandArea battleLand, BritContext context) { event(context, "{0} wins the battle and conquers {1}.", attNation.getName(), battleLand.getName()); }
	public void noUnitRemainsInTheBattle(BritLandArea battleLand, BritContext context) { event(context, "The battle was a massacre. No unit remains in {0}.", battleLand.getName()); }
	
//	// PLOT PHASE INFO
//	public void winsInitiative (AgotPlayer initiveWinner, AgotContext context) { add (context, "{0} wins the initiative.", initiveWinner.getName ()); }
//	public void hasMoreInitiativeThan (AgotPlayer p1, AgotPlayer p2, AgotContext context) { add (context, "{0} has more initiative than {1}.", p1.getName (), p2.getName ()); }
//	public void hasTheSameInitiativeButLessPowerThan (AgotPlayer p1, AgotPlayer p2, AgotContext context) { add (context, "{0} has the same initiative but less power than {1}.", p1.getName (), p2.getName ()); }
//	public void hasTheSameInitiativeAndTheSamePowerOf (AgotPlayer p1, AgotPlayer p2, AgotContext context) { add (context, "{0} has the same initiative and the same power of {1}.", p1.getName (), p2.getName ()); }
//	public void becomesFirstPlayer (AgotPlayer firstPlayer, AgotContext context) { add (context, "{0} becomes the first player.", firstPlayer.getName ()); }
//	public void initiativeTieBrokenByRandomlySelect (AgotPlayer randomlySelected, AgotContext context) { add (context, "{0} has been randomly selected to broken the tie.", randomlySelected.getName ()); }
//	
//	// DRAW PHASE INFO
//	public void drawDrawsCards (AgotPlayer player, int nCards, AgotContext context) { add (context, "Draw: {0} draws {1} cards.", player.getName (), nCards); }
//
//	// MARSHALL PHASE INFO
//	public void collectsGold (AgotPlayer activePlayer, int income, AgotContext context) { add (context, "{0} collects {1} golds.", activePlayer.getName (), income); }
//	public void marshalls (AgotPlayer player, MarshallCard<?> toMarshall, AgotContext context) { add (context, "{0} marshalls {1}.", player.getName (), toMarshall.getTitle ()); }
//	public void marhallsAttachedTo (AgotPlayer player, MarshallCard<?> toMarshall, MarshallCard<?> attachTo, AgotContext context) { add (context, "{0} marshalls {1} attached to {2}.", player.getName (), toMarshall.getTitle (), attachTo.getTitle ()); }
//	public void duplicates (AgotPlayer player, MarshallCard<?> toMarshall, AgotContext context) { add (context, "{0} duplicates {1}.", player.getName (), toMarshall.getTitle ()); }
//	
//	// CHALLENGES PHASE INFO
//	public void initiatesAchallenge (AgotPlayer attacker, AgotPlayer defender, AngIcon challengeType, AgotContext context) { add (context, "{0} initiates a {1} challenge against {2}.", attacker.getName (), challengeType.getLabel (), defender.getName ()); }
//	public void declaresAsAttacker (AgotPlayer player, CharacterCard att, AgotContext context) { add (context, "{0} declares {1} as attacker.", player.getName (), att.getTitle ()); }
//	public void charactedIsBypassed (AgotPlayer player, CharacterCard bypassed, AgotContext context) { add (context, "{0} bypassed {1} with stealth.", player.getName (), bypassed.getTitle ()); }
//	public void declaresAsDefender (AgotPlayer player, CharacterCard defender, AgotContext context) { add (context, "{0} declares {1} as defender.", player.getName (), defender.getTitle ()); }
//	public void winsTheChallenge (AgotPlayer winner, AgotContext context) { add (context, "{0} wins the challenge.", winner.getName ()); }
//	public void winsTheChallengeUnopposed (AgotPlayer winner, AgotContext context) { add (context, "{0} wins the challenge unopposed.", winner.getName ()); }
//	public void gainsPowerForUnopposed (AgotPlayer attacker, AgotContext context) { add (context, "{0} gains one power on the faction card due to unopposed.", attacker.getName ()); }
//	public void discards (AgotPlayer player, DrawCard<?> card, AgotContext context) { add (context, "{0} discards {1}.", player.getName (), card.getTitle ()); }
//	public void kills (AgotPlayer defender, CharacterCard toKill, AgotContext context) { add (context, "{0} kills {1}.", defender.getName (), toKill.getTitle ()); }
//	public void losesPowerTokens (AgotPlayer player, int lostPower, AgotContext context) { add (context, "{0} loses {1} power tokens.", player.getName (), lostPower); }
//	public void gainsPowerTokens (AgotPlayer player, int lostPower, AgotContext context) { add (context, "{0} gains {1} power tokens.", player.getName (), lostPower); }
//
//	// DOMINANCE PHASE INFO
//	public void hasMoreDominanceThan (AgotPlayer p1, AgotPlayer p2, AgotContext context) { add (context, "{0} has more dominance than {1}.", p1.getName (), p2.getName ()); }
//	public void haveTheSameDominance (AgotPlayer p1, AgotPlayer p2, AgotContext context) { add (context, "{0} and {1} have the same dominance.", p1.getName (), p2.getName ()); }
//	public void dominanceTie (AgotContext context) { add (context, "No player wins dominance."); }
//	public void winsDominance (AgotPlayer dominanceWinner, AgotContext context) { add (context, "{0} wins dominance.", dominanceWinner.getName ()); }
//	public void dominanceGainPower (AgotPlayer dominanceWinner, AgotContext context) { add (context, "Dominance: {0} gains 1 power on the faction card.", dominanceWinner.getName ()); }
//		
//	// STANDING PHASE INFO
//	public void standingStandsCard (AgotPlayer player, Card<?> standingCard, AgotContext context) { add (context, "Standing: {0} stands {1}.", player.getName (), standingCard.getTitle ()); }
//
//	// TRIBUTE PHASE INFO
//	public void tributeDiscardGold (AgotPlayer player, int unspent, AgotContext context) { add (context, "Tribute: {0} discards {1} unspent gold.", player.getName (), unspent); }
//	
//	// COST - EFFECTS INFO
//	public void paysNGold (AgotPlayer player, int nGold, AgotContext context) { add (context, "{0} pays {1} gold.", player.getName (), nGold); }
//	public void kneelsCard (AgotPlayer player, Card<?> card, AgotContext context) { add (context, "{0} kneels {1}.", player.getName (), card.getTitle ()); }
//	public void standsCard (AgotPlayer player, Card<?> card, AgotContext context) { add (context, "{0} stands {1}.", player.getName (), card.getTitle ()); }
//	public void reducesTheCostOfTheNextCardHeMashallsThisPhaseByN (AgotPlayer player, int n, AgotContext context) { add (context, "{0} reduces the cost of the next -restrictions- card he/she marshalls this phase by {1}.", player.getName (), n); }
//	@Deprecated
//	public void effectDrawsNCards (AgotPlayer player, TextCard<?> card, int nCardsDrawn, AgotContext context) { add (context, "{0}: {1} draws {2} cards.", card.getTitle (), player.getName (), nCardsDrawn); }
//	@Deprecated
//	public void effectStandsCard (AgotPlayer player, TextCard<?> card, TextCard<?> standingCard, AgotContext context) { add (context, "{0}: {1} stands {2}.", card.getTitle (), player.getName (), standingCard.getTitle ()); }
//	@Deprecated
//	public void effectKneelsCard (AgotPlayer player, TextCard<?> card, TextCard<?> standingCard, AgotContext context) { add (context, "{0}: {1} kneels {2}.", card.getTitle (), player.getName (), standingCard.getTitle ()); }
//	@Deprecated
//	public void effectGainNGolds (AgotPlayer player, TextCard<?> card, int gainedGold, AgotContext context) { add (context, "{0}: {1} gains {2} golds.", card.getTitle (), player.getName (), gainedGold); }
//	@Deprecated
//	public void effectLosePower (AgotPlayer player, TextCard<?> trigCard, Card<?> targetCard, int lostPower, AgotContext context) { add (context, "{0}: {1} loses {2} power tokens.", trigCard.getTitle (), targetCard.getTitle (), lostPower); }
//	@Deprecated
//	public void effectGainPower (AgotPlayer player, TextCard<?> trigCard, Card<?> targetCard, int gainedPower, AgotContext context) { add (context, "{0}: {1} gain {2} power tokens.", trigCard.getTitle (), targetCard.getTitle (), gainedPower); }
//	
//	// EVENTS
//	public void gainsNGolds (AgotPlayer player, int gainedGold, AgotContext context) { add (context, "{0} gains {1} gold.", player.getName (), gainedGold); }
//	public void drawsNCards (AgotPlayer player, int nCardsDrawn, AgotContext context) { add (context, "{0} draws {1} cards.", player.getName (), nCardsDrawn); }
//	public void standsCard (Card<?> standingCard, AgotContext context) { add (context, "{0} is standed.", standingCard.getTitle ()); }
//	public void kneelsCard (Card<?> kneelingCard, AgotContext context) { add (context, "{0} is kneeled.", kneelingCard.getTitle ()); }
//	public void killsCharacter (CharacterCard killedCard, AgotContext context) { add (context, "{0} is killed.", killedCard.getTitle ()); }
//	public void losePower (Card<?> targetCard, int lostPower, AgotContext context) { add (context, "{0} loses {1} power tokens.", targetCard.getTitle (), lostPower); }
//	public void gainPower (Card<?> targetCard, int gainedPower, AgotContext context) { add (context, "{0} gains {1} power tokens.", targetCard.getTitle (), gainedPower); }
//	public void savesCard (MarshallCard<?> card, AgotContext context) { add (context, "{0} is saved.", card.getTitle ()); }
//	public void discardsCard (MarshallCard<?> card, AgotContext context) { add (context, "{0} is discards.", card.getTitle ()); }
//	public void placeOneToken (AngToken token, MarshallCard<?> card, AgotContext context) { add (context, "{0} gains one {1} token.", card.getTitle (), token.getLabel ()); }
//	
//	public void becomesActivePlayer (AgotPlayer nextPlayer, AgotContext context) { add (context, "{0} becomes the active player.", nextPlayer.getName ()); }

} // GameLog
