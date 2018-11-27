package motif.agot.logic.round.phases.challenges;

import java.util.ArrayList;
import java.util.stream.Stream;

import lombok.Getter;
import motif.agot.ang.AgotText;
import motif.agot.ang.cards.AngCharacterCard.IcB;
import motif.agot.ang.enums.AngIcon;
import motif.agot.endpoint.AgotContext;
import motif.agot.flow.request.AgotRequest;
import motif.agot.flow.request.AgotRequest.AgotChoice;
import motif.agot.flow.request.AgotRequest.AgotRequestCod;
import motif.agot.flow.request.AgotResponse;
import motif.agot.flow.request.IAgotModel;
import motif.agot.flow.request.IAgotModelVisitor;
import motif.agot.flow.task.AgotHumanTask;
import motif.agot.flow.task.IAgotTask;
import motif.agot.logic.events.Event;
import motif.agot.logic.events.EventTrigger;
import motif.agot.logic.events.list.InitiateAChallengeEvent;
import motif.agot.logic.round.phases.Step;
import motif.agot.logic.round.phases.challenges.challenge.ChallengeFirstActionStep;
import motif.agot.state.AgotGame;
import motif.agot.state.Challenge;
import motif.agot.state.Challenge.ChallengeBuilder;
import motif.agot.state.AgotPlayer;
import motif.agot.state.cards.CharacterCard;

public class InitiateChallengeStep extends Step<IChallengesPhaseStep> {

	private AgotPlayer activePlayer;
		
	private Challenge challenge = null;
	
	public InitiateChallengeStep (AgotPlayer activePlayer, AgotGame game) {
		super (game);
		this.activePlayer = activePlayer;
	} // InitiateChallengeStep

	@Override
	public String getStepTitle () { return AgotText.title ().initiateChallengeStep (activePlayer); }
	
	private ArrayList<CharacterCard> getAvailableAttackers (AgotPlayer player, AngIcon challType) {
		ArrayList<CharacterCard> availableAttackers = new ArrayList<CharacterCard> ();
		player.characters ().forEach (cha -> {
			if (cha.hasIcon (challType) && cha.isStanding ()) {
				availableAttackers.add (cha);
			} // if			
		});
		return availableAttackers;
	} // getAvailableAttackers

	@Override
	public IAgotTask getStartTask (AgotContext context) {
		if (game.firstPlayerChallenge ()) { game.setRemainingChallenges (new IcB ().military ().intrigue ().power ().build ()); }
		ArrayList<AvailableChallenge> availableChallenges = new ArrayList<AvailableChallenge> ();
		game.remainingChallenges ().forEach (challType -> {
			ArrayList<CharacterCard> availableAttackers = getAvailableAttackers (activePlayer, challType);
			if (!availableAttackers.isEmpty ()) {
				AvailableChallenge avaChall = new AvailableChallenge ();
				avaChall.challengeType = challType;
				avaChall.availableAttackers = availableAttackers;
				availableChallenges.add (avaChall);
			} // if
		});
		return new ChooseChallengeTypeRequest (availableChallenges);			
	} // getStartTask

	@Override
	public Step<IChallengesPhaseStep> getNextTask (AgotContext context) {
		if (challenge == null) {
			return new ActivateNextChallengesStep (activePlayer, game);			
		} else {
			return new ChallengeFirstActionStep (challenge, game);
		} // if - else
	} // getNextTask
	
	private class ChooseChallengeTypeRequest extends AgotHumanTask {

		private ArrayList<AvailableChallenge> availableChallenges;
		private AgotRequest<AvailableChallenge> pendingRequest = null;
		
		public ChooseChallengeTypeRequest (ArrayList<AvailableChallenge> availableChallenges) {
			this.availableChallenges = availableChallenges;
		} // ChooseChallengeTypeRequest
		
		@Override
		public AgotRequest<?> getRequest (AgotContext context) {
			pendingRequest = AgotRequest.createRequest (AgotRequestCod.SELECT_CHALLENGE_TO_INITIATE, activePlayer, availableChallenges.stream (), AgotText.request ().selectChallengeToInitiate (activePlayer));
			pendingRequest.addPassOption ();
			return pendingRequest;
		} // getRequest

		@Override
		public ChooseDefenderRequest receiveResponse (AgotResponse response, AgotContext context) {
			AgotChoice<AvailableChallenge> choice = pendingRequest.getChoice (response);
			if (choice.isPass ()) {
				return null;
			} else {
				AvailableChallenge challenge = choice.getModel ();
				ChallengeBuilder challengeBuilder = new ChallengeBuilder (activePlayer);
				challengeBuilder.type (challenge.challengeType);
				game.removeRemainingChallenge (challenge.challengeType);
				return new ChooseDefenderRequest (challenge.availableAttackers, challengeBuilder);				
			} // if - else
		} // receiveResponse
		
	} // ChooseChallengeTypeRequest
		
	private class ChooseDefenderRequest extends AgotHumanTask {

		private AgotRequest<AgotPlayer> pendingRequest = null;
		private ChallengeBuilder challengeBuilder;
		private ArrayList<CharacterCard> availableAttackers;
		
		private ChooseDefenderRequest (ArrayList<CharacterCard> availableAttackers, ChallengeBuilder challengeBuilder) {
			this.challengeBuilder = challengeBuilder;
			this.availableAttackers = availableAttackers;
		} // ChooseDefenderRequest
		
		@Override
		public AgotRequest<?> getRequest (AgotContext context) {
			Stream<AgotPlayer> availableDefenders = game.players ().filter (player -> player != activePlayer);
			pendingRequest = AgotRequest.createRequest (AgotRequestCod.SELECT_DEFENDER, activePlayer, availableDefenders, AgotText.request ().selectDefender (activePlayer));
			return pendingRequest;
		} // getRequest

		@Override
		public IAgotTask receiveResponse (AgotResponse response, AgotContext context) {
			AgotChoice<AgotPlayer> choice = pendingRequest.getChoice (response);
			AgotPlayer defender = choice.getModel ();
			challengeBuilder.defender (defender);
			return new ChooseAttackerRequest (availableAttackers, true, defender, challengeBuilder);
		} // receiveResponse
		
	} // ChooseDefenderRequest
	
	private class ChooseAttackerRequest extends AgotHumanTask {

		private ArrayList<CharacterCard> availableAttackers;
		private boolean mandatory;
		private AgotRequest<CharacterCard> pendingRequest = null;
		private ChallengeBuilder challengeBuilder;
		private AgotPlayer defender;
		
		public ChooseAttackerRequest (ArrayList<CharacterCard> availableAttackers, boolean mandatory, AgotPlayer defender, ChallengeBuilder challengeBuilder) {
			this.availableAttackers = availableAttackers;
			this.mandatory = mandatory;
			this.challengeBuilder = challengeBuilder;
			this.defender = defender;
		} // ChooseAttackerRequest
		
		@Override
		public AgotRequest<?> getRequest (AgotContext context) {
			pendingRequest = AgotRequest.createRequest (AgotRequestCod.SELECT_CHARACTER_TO_ATTACK, activePlayer, availableAttackers.stream (), AgotText.request ().selectCharacterToAttack (activePlayer));
			if (!mandatory) {
				pendingRequest.addPassOption ();
			} // if
			return pendingRequest;
		} // getRequest

		@Override
		public IAgotTask receiveResponse (AgotResponse response, AgotContext context) {
			AgotChoice<CharacterCard> choice = pendingRequest.getChoice (response);
			if (choice.isPass ()) {
				Challenge challenge = challengeBuilder.build ();
				game.log ().initiatesAchallenge (challenge.attacker (), challenge.defender (), challenge.type (), context);
				challenge.attackers ().forEach (att -> {
					att.kneel (context);
					game.log ().declaresAsAttacker (challenge.attacker (), att, context);
				});
				challenge.bypassed ().forEach (bypassed -> {
					game.log ().charactedIsBypassed (challenge.attacker (), bypassed, context);
				});
				InitiateChallengeStep.this.challenge = challenge;
				game.setChallenge (challenge);
				Event event = new InitiateAChallengeEvent (challenge, game);
				return EventTrigger.execute (event, game);
			} else {
				CharacterCard attacker = choice.getModel ();
				challengeBuilder.attacker (attacker);
				availableAttackers.remove (attacker);
				if (attacker.hasStealth ()) {
					return new ResolveStealth (defender, availableAttackers, challengeBuilder);
				} else {
					return new ChooseAttackerRequest (availableAttackers, false, defender, challengeBuilder);
				} // if - else
			} // if - else
		} // receiveResponse
		
	} // ChooseAttackerRequest
	
	private class ResolveStealth extends AgotHumanTask {
		
		private AgotRequest<CharacterCard> pendingRequest = null;
		private ChallengeBuilder challengeBuilder;
		private AgotPlayer defender;
		private ArrayList<CharacterCard> availableAttackers;
		
		private ResolveStealth (AgotPlayer defender, ArrayList<CharacterCard> availableAttackers, ChallengeBuilder challengeBuilder) {
			this.challengeBuilder = challengeBuilder;
			this.defender = defender;
			this.availableAttackers = availableAttackers;
		} // ResolveStealth
		
		@Override
		public AgotRequest<?> getRequest (AgotContext context) {
			Stream<CharacterCard> availableDefenders = defender.characters ().filter (cha -> cha.canBeBypassedByStealth ());
			pendingRequest = AgotRequest.createRequest (AgotRequestCod.SELECT_CHARACTER_TO_BYPASS, activePlayer, availableDefenders, AgotText.request ().selectCharacterToBypass (activePlayer));
			pendingRequest.addPassOption ();
			return pendingRequest;
		} // getRequest
		
		@Override
		public IAgotTask receiveResponse (AgotResponse response, AgotContext context) {
			AgotChoice<CharacterCard> choice = pendingRequest.getChoice (response);
			if (!choice.isPass ()) {
				CharacterCard bypassed = choice.getModel ();
				challengeBuilder.bypassed (bypassed);
			} // if
			return new ChooseAttackerRequest (availableAttackers, false, defender, challengeBuilder);
		} // receiveResponse
		
	} // ResolveStealth
	
	public static class AvailableChallenge implements IAgotModel {
		private ArrayList<CharacterCard> availableAttackers;
		@Getter private AngIcon challengeType;
		
		@Override
		public String getLabel () { return challengeType.getLabel (); }
		
		@Override public void accept (IAgotModelVisitor visitor) { visitor.visit (this); }

	} // AvailableChallenge
	
} // InitiateChallengeStep
