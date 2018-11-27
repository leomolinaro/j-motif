package motif.agot.ang;

import motif.agot.ang.enums.AngPhase;
import motif.agot.state.AgotPlayer;
import motif.agot.state.cards.AttachmentCard;
import motif.shared.util.MotifConsole;

public class AgotText {
	
	public static AgotTitle title () { return new AgotTitle (); }
	
	public static class AgotTitle {
		public String actionWindow () { return "Action window"; }

		public String plotPhase () { return "1 Plot phase"; }
		public String startPlotPhaseStep () { return "1.1 Plot phase begins"; }
		public String choosePlotStep () { return "1.2 Choose plots"; }
		public String revealPlotStep () { return "1.3 Reveal plot"; }
		public String endPlotPhaseStep () { return "1.5 Plot phase ends"; }

		public String drawPhase () { return "2 Draw phase"; }
		public String startDrawPhaseStep () { return "2.1 Draw phase begins"; }
		public String drawCardsStep () { return "2.2 Draw"; }
		public String endDrawPhaseStep () { return "2.3 Draw phase ends"; }

		public String marshallingPhase () { return "3 Marshalling phase"; }
		public String startMarshallingPhaseStep () { return "3.1 Marshalling phase begins"; }
		public String collectIncomeStep (AgotPlayer activePlayer) { return MotifConsole.format ("3.2 Collect income ({0})", activePlayer.getName ()); }
		public String marshallingActionStep (AgotPlayer activePlayer) { return  MotifConsole.format ("Special action window {0}", activePlayer.getName ()); }
		public String activateNextMarhsallingStep () { return "3.3 Player activation"; }
		public String endMarshallingPhaseStep () { return "3.4 Marshalling phase ends"; }

		public String challengesPhase () { return "4 Challenges phase"; }
		public String startChallengesPhaseStep () { return "4.1 Challenges phase begins"; }
		public String initiateChallengeStep (AgotPlayer activePlayer) { return MotifConsole.format ("4.2 Initiate challenge ({0})", activePlayer.getName ()); }
		public String defendingStep () { return "4.2.1 Defenders declaration"; }
		public String determineWinner () { return "4.2.2 Determine winner"; }
		public String gainChallengeBonus () { return "4.2.3 Gain challenge bonus"; }
		public String claimStep () { return "4.2.4 Apply claim result"; }
		public String keywordsStep () { return "4.2.5 Process challenge resolution keywords"; }
		public String endChallengeStep () { return "4.2.6 Challenge ends"; }
		public String activateNextChallengesStep () { return "4.3 Player activation"; }
		public String endChallengesPhaseStep () { return "4.4 Challenges phase ends"; }
		
		public String dominancePhase () { return "5 Dominance phase"; }
		public String startDominancePhaseStep () { return "5.1 Dominance phase begins"; }
		public String determineDominanceStep () { return "5.2 Determine dominance"; }
		public String endDominancePhaseStep () { return "5.3 Dominance phase ends"; }

		public String standingPhase () { return "6 Standing phase"; }
		public String startStandingPhaseStep () { return "6.1 Standing phase begins"; }
		public String standingCardsStep () { return "6.2 Standing cards"; }
		public String endStandingPhaseStep () { return "6.3 Standing phase ends"; }
		
		public String taxationPhase () { return "7 Taxation phase"; }
		public String startTaxationPhaseStep () { return "7.1 Taxation phase begins"; }
		public String tributeStep () { return "7.2 Tribute"; }
		public String reserveStep () { return "7.3 Check reserve"; }
		public String endTaxationPhaseStep () { return "7.5 Taxation phase ends"; }

	} // AgotTitle
	
	public static AgotRequestMessage request () { return new AgotRequestMessage (); }

	public static class AgotRequestMessage {

		public String selectActionToPerform (AgotPlayer player) { return  MotifConsole.format ("{0}, select an action to perform.", player.getName ()); }
		public String selectReactionToPerform (AgotPlayer player) { return  MotifConsole.format ("{0}, select a reaction to perform.", player.getName ()); }
		public String selectInterruptToPerform (AgotPlayer player) { return  MotifConsole.format ("{0}, select an interrupt to perform.", player.getName ()); }
		public String selectCharacterToKill (AgotPlayer player) { return MotifConsole.format ("{0}, select a character to be killed.", player.getName ()); }
		public String selectCharacterToDefend (AgotPlayer player) { return MotifConsole.format ("{0}, select a character to defend.", player.getName ()); }
		public String selectChallengeToInitiate (AgotPlayer player) { return MotifConsole.format ("{0}, select a challenge to initiate.", player.getName ()); }
		public String selectCharacterToAttack (AgotPlayer player) { return MotifConsole.format ("{0}, select a character to declare as an attacker.", player.getName ()); }
		public String selectCharacterToBypass (AgotPlayer player) { return MotifConsole.format ("{0}, select a character to bypass by stealth.", player.getName ()); }
		public String selectDefender (AgotPlayer player) { return MotifConsole.format ("{0}, select a defender player.", player.getName ()); }
		public String selectPlotToReveal (AgotPlayer player) { return MotifConsole.format ("{0}, select a plot to reveal.", player.getName ()); }
		public String selectFirstPlayer (AgotPlayer player) { return MotifConsole.format ("{0}, select the player that becomes the first player.", player.getName ()); }
		public String selectCardToAttach (AgotPlayer player, AttachmentCard card) { return MotifConsole.format ("{0}, select a card to attach {1}.", player.getName (), card.getTitle ()); }
		public String selectCardToDiscard (AgotPlayer player) { return MotifConsole.format ("{0}, select a card to discard.", player.getName ()); }
		public String chooseACard (AgotPlayer player) { return MotifConsole.format ("{0}, choose a card to apply the effect.", player.getName ()); }
		public String endPhase (AngPhase phase, AgotPlayer player) { return MotifConsole.format ("{0}, end {1}.", player.getName (), phase.getLabel ()); }
		public String endChallenge (AgotPlayer player) { return MotifConsole.format ("{0}, end challenge.", player.getName ()); }

	} // AgotRequestMessage
	
} // AgotText
