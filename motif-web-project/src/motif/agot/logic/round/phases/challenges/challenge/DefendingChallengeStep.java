package motif.agot.logic.round.phases.challenges.challenge;

import java.util.ArrayList;

import motif.agot.ang.AgotText;
import motif.agot.endpoint.AgotContext;
import motif.agot.flow.request.AgotRequest;
import motif.agot.flow.request.AgotRequest.AgotChoice;
import motif.agot.flow.request.AgotRequest.AgotRequestCod;
import motif.agot.flow.request.AgotResponse;
import motif.agot.flow.task.AgotHumanTask;
import motif.agot.flow.task.IAgotTask;
import motif.agot.logic.round.phases.Step;
import motif.agot.logic.round.phases.challenges.IChallengesPhaseStep;
import motif.agot.state.AgotGame;
import motif.agot.state.Challenge;
import motif.agot.state.AgotPlayer;
import motif.agot.state.cards.CharacterCard;

public class DefendingChallengeStep extends Step<IChallengesPhaseStep> {

	private Challenge challenge;
	private AgotPlayer defender;
	
	public DefendingChallengeStep (Challenge data, AgotGame game) {
		super (game);
		this.challenge = data;
		this.defender = data.defender;
	} // DefendingChallengeStep

	private ArrayList<CharacterCard> getAvailableDefenders () {
		ArrayList<CharacterCard> availableDefenders = new ArrayList<CharacterCard> ();
		defender.characters ().forEach (cha -> {
			if (cha.isStanding () && cha.hasIcon (challenge.type ()) && !challenge.isBypassed (cha)) {
				availableDefenders.add (cha);
			} // if			
		});
		return availableDefenders;
	} // getAvailableDefenders

	@Override
	public String getStepTitle () { return AgotText.title ().defendingStep (); }

	@Override
	public IAgotTask getStartTask (AgotContext context) {
		ArrayList<CharacterCard> availableDefenders = getAvailableDefenders ();
		return new ChooseDefenderRequest (availableDefenders);			
	} // getStartTask

	@Override
	public ChallengeSecondActionStep getNextTask (AgotContext context) {
		challenge.defenders ().forEach (def -> {
			def.kneel (context);
			game.log ().declaresAsDefender (this.defender, def, context);			
		});
		return new ChallengeSecondActionStep (challenge, game);
	} // getNextTask

	private class ChooseDefenderRequest extends AgotHumanTask {

		private ArrayList<CharacterCard> availableDefenders;
		private AgotRequest<CharacterCard> pendingRequest = null;
		
		public ChooseDefenderRequest (ArrayList<CharacterCard> availableDefenders) {
			this.availableDefenders = availableDefenders;
		} // ChooseDefenderRequest
		
		@Override
		public AgotRequest<?> getRequest (AgotContext context) {
			pendingRequest = AgotRequest.createRequest (AgotRequestCod.SELECT_CHARACTER_TO_DEFEND, defender, availableDefenders.stream (), AgotText.request ().selectCharacterToDefend (defender));
			pendingRequest.addPassOption ();
			return pendingRequest;
		} // getRequest

		@Override
		public IAgotTask receiveResponse (AgotResponse response, AgotContext context) {
			AgotChoice<CharacterCard> choice = pendingRequest.getChoice (response);
			if (choice.isPass ()) {
				return null;
			} else {
				CharacterCard defender = choice.getModel ();
				challenge.addDefender (defender);
				availableDefenders.remove (defender);
				return new ChooseDefenderRequest (availableDefenders);			
			} // if
		} // receiveResponse
		
	} // ChooseDefenderRequest
	
} // DefendingChallengeStep
