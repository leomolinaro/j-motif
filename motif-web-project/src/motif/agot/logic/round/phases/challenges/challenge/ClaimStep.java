package motif.agot.logic.round.phases.challenges.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import motif.agot.ang.AgotText;
import motif.agot.endpoint.AgotContext;
import motif.agot.flow.request.AgotRequest;
import motif.agot.flow.request.AgotRequest.AgotChoice;
import motif.agot.flow.request.AgotRequest.AgotRequestCod;
import motif.agot.flow.request.AgotResponse;
import motif.agot.flow.task.AgotAutoTask;
import motif.agot.flow.task.AgotHumanTask;
import motif.agot.flow.task.IAgotTask;
import motif.agot.logic.events.Event;
import motif.agot.logic.events.EventTrigger;
import motif.agot.logic.events.list.KillEvent;
import motif.agot.logic.events.list.MultiEvent;
import motif.agot.logic.round.phases.Step;
import motif.agot.logic.round.phases.challenges.IChallengesPhaseStep;
import motif.agot.state.AgotGame;
import motif.agot.state.Challenge;
import motif.agot.state.AgotPlayer;
import motif.agot.state.cards.CharacterCard;
import motif.agot.state.cards.DrawCard;
import motif.agot.state.cards.FactionCard;

public class ClaimStep extends Step<IChallengesPhaseStep> {

	private Challenge data;
	private AgotPlayer defender;
	private AgotPlayer attacker;

	public ClaimStep (Challenge data, AgotGame game) {
		super (game);
		this.data = data;
		this.defender = data.defender;
		this.attacker = data.attacker ();
	} // DeterminWinnderStep

	@Override
	public String getStepTitle () { return AgotText.title ().claimStep (); }

	@Override
	public IAgotTask getStartTask (AgotContext context) {
		if (data.attackWins ()) {
			int claim = attacker.revealedPlot ().getClaim ();
			switch (data.type ()) {
				case INTRIGUE:
					int nCards = Math.min (defender.handSize (), claim);
					ArrayList<DrawCard<?>> lostCards = new ArrayList<DrawCard<?>> (); 
					for (int i = 0; i < nCards; i++) { lostCards.add (defender.randomDiscardFromHand (context)); }
					for (DrawCard<?> lostCard : lostCards) {
						game.log ().discards (defender, lostCard, context);
					} // for
					return null;
				case MILITARY:
					int nKills = Math.min (defender.charactersSize (), claim);
					if (nKills > 0) {
						return new MilitaryClaimRequest (nKills, new ArrayList<CharacterCard> ());
					} else {
						return null;
					} // if - else
				case POWER:
					FactionCard defFacCard = defender.getFaction ();
					int lostPower = Math.min (defFacCard.getPower (), claim);
					defFacCard.losePower (lostPower, context);
					attacker.gainPowerOnTheFactionCard (lostPower, context);
					game.log ().losesPowerTokens (defender, lostPower, context);
					game.log ().gainsPowerTokens (attacker, lostPower, context);
					return null;
				default: return null;
			} // switch - case
		} else {
			return null;
		} // if - else
	} // getStartTask

	@Override
	public KeywordsStep getNextTask (AgotContext context) {
		return new KeywordsStep (data, game);
	} // getNextTask

	private class MilitaryClaimRequest extends AgotHumanTask {

		private int nKills;
		private AgotRequest<CharacterCard> pendingRequest = null;
		private ArrayList<CharacterCard> alreadySelected;
		
		public MilitaryClaimRequest (int nKills, ArrayList<CharacterCard> alreadySelected) {
			this.nKills = nKills;
			this.alreadySelected = alreadySelected;
		} // MilitaryClaimRequest
		
		@Override
		public AgotRequest<?> getRequest (AgotContext context) {
			Stream<CharacterCard> available = defender.characters ().filter (cha -> !alreadySelected.contains (cha));
			pendingRequest = AgotRequest.createRequest (AgotRequestCod.SELECT_CHARACTER_TO_KILL, defender, available, AgotText.request ().selectCharacterToKill (defender));
			return pendingRequest;
		} // getRequest

		@Override
		public IAgotTask receiveResponse (AgotResponse response, AgotContext context) {
			AgotChoice<CharacterCard> choice = pendingRequest.getChoice (response);
			CharacterCard toKill = choice.getModel ();
			alreadySelected.add (toKill);
			nKills--;
			if (nKills > 0) {
				return new MilitaryClaimRequest (nKills, alreadySelected);
			} else {
				return new MilitaryClaimExecution (alreadySelected);
			} // if - else
		} // receiveResponse
		
	} // MilitaryClaimRequest
	
	private class MilitaryClaimExecution extends AgotAutoTask {

		private ArrayList<CharacterCard> toKill;

		public MilitaryClaimExecution (ArrayList<CharacterCard> toKill) {
			this.toKill = toKill;
		} // MilitaryClaimExecution

		@Override
		public IAgotTask execute (AgotContext context) {
			List<KillEvent> events = toKill.stream ().map (c -> new KillEvent (c, game)).collect (Collectors.toList ());
			Event event = new MultiEvent (events, game);
			return EventTrigger.execute (event, game);
		} // execute
		
	} // MilitaryClaimExecution
	
} // DeterminWinnderStep
