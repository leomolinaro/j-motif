package com.motif.agot.logic.phases.challenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.cards.AngCharacterCard.IcB;
import com.motif.agot.ang.enums.AngIcon;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.events.AgotEvent;
import com.motif.agot.logic.events.AgotEventProcess;
import com.motif.agot.logic.events.IAgotHasEventProcess;
import com.motif.agot.logic.events.list.InitiateAChallengeEvent;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.logic.phases.APhaseStep;
import com.motif.agot.logic.requests.ChooseAChallengeTypeRequest;
import com.motif.agot.logic.requests.SelectCharacterToAttackRequest;
import com.motif.agot.logic.requests.ChooseDefenderRequest;
import com.motif.agot.logic.requests.ChooseOptionalAttackerRequest;
import com.motif.agot.logic.requests.ResolveStealthRequest;
import com.motif.agot.logic.requests.ChooseAChallengeTypeRequest.IHasChooseAChallengeTypeRequest;
import com.motif.agot.logic.requests.SelectCharacterToAttackRequest.IHasSelectCharacterToAttackRequest;
import com.motif.agot.logic.requests.ChooseDefenderRequest.IHasChooseDefenderRequest;
import com.motif.agot.logic.requests.ChooseOptionalAttackerRequest.IHasChooseOptionalAttackerRequest;
import com.motif.agot.logic.requests.ResolveStealthRequest.IHasResolveStealthRequest;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;
import com.motif.agot.state.Challenge;
import com.motif.agot.state.cards.CharacterCard;

import lombok.Getter;

public class InitiateChallengeStep extends APhaseStep<IChallengesPhaseStep> implements
		IHasChooseAChallengeTypeRequest,
		IHasChooseDefenderRequest,
		IHasSelectCharacterToAttackRequest,
		IHasChooseOptionalAttackerRequest,
		IHasResolveStealthRequest,
		IAgotHasEventProcess {

	private final AgotPlayer activePlayer;
		
	public interface IHasInitiateChallengeStep extends IAgotFlowProcess { public APhaseStep<IChallengesPhaseStep> after(InitiateChallengeStep step, AgotContext context); }
	@Getter private final IHasInitiateChallengeStep parent; 
	@Override public APhaseStep<IChallengesPhaseStep> next(AgotContext context) { return this.parent.after(this, context); }
	
	public InitiateChallengeStep(AgotPlayer activePlayer, AgotGame game, IHasInitiateChallengeStep parent) {
		super (game);
		this.activePlayer = activePlayer;
		this.parent = parent;
	}
	
	private Map<AngIcon, ArrayList<CharacterCard>> availableAttackersByType = new HashMap<AngIcon, ArrayList<CharacterCard>>();
	private AngIcon challengeType;
	@Getter private Challenge challenge;
	private AgotPlayer defender;
	private ArrayList<CharacterCard> availableAttackers;
	private ArrayList<CharacterCard> attackers = new ArrayList<CharacterCard>();
	private ArrayList<CharacterCard> bypassed = new ArrayList<CharacterCard>();
	
	@Override
	public String getStepTitle() { return AgotText.title().initiateChallengeStep(activePlayer); }
	
	private ArrayList<CharacterCard> getAvailableAttackers (AgotPlayer player, AngIcon challType) {
		ArrayList<CharacterCard> availableAttackers = new ArrayList<CharacterCard> ();
		player.characters ().forEach (cha -> {
			if (cha.hasIcon (challType) && cha.isStanding ()) {
				availableAttackers.add (cha);
			}		
		});
		return availableAttackers;
	}

	@Override
	protected IAgotFlowStep stepStart(AgotContext context) {
		if (this.game.firstPlayerChallenge ()) { this.game.setRemainingChallenges(new IcB().military().intrigue().power().build()); }
		var availableChallenges = new ArrayList<AngIcon>();
		this.game.remainingChallenges().forEach(challType -> {
			ArrayList<CharacterCard> availableAttackers = getAvailableAttackers(this.activePlayer, challType);
			if (!availableAttackers.isEmpty()) {
				this.availableAttackersByType.put(challType, availableAttackers);
				availableChallenges.add(challType);
			}
		});
		return new ChooseAChallengeTypeRequest(availableChallenges, this.activePlayer, this);	
	}
	
	@Override
	public IAgotFlowStep after(ChooseAChallengeTypeRequest decision, AgotContext context) {
		if (decision.isHasPassed()) {
			return null;
		} else {
			this.challengeType = decision.getChoosenModel();
			this.game.removeRemainingChallenge(this.challengeType);
			var availableDefenders = this.game.players().filter(player -> player != this.activePlayer);
			return new ChooseDefenderRequest(availableDefenders.collect(Collectors.toList()), this.activePlayer, this);			
		}
	}
	
	@Override
	public IAgotFlowStep after(ChooseDefenderRequest decision, AgotContext context) {
		this.defender = decision.getChoosenModel();
		this.availableAttackers = this.availableAttackersByType.get(this.challengeType);
		return new SelectCharacterToAttackRequest(this.availableAttackers, this.activePlayer, this);
	}
	
	@Override
	public IAgotFlowStep after(SelectCharacterToAttackRequest decision, AgotContext context) {
		var attacker = decision.getChoosenModel();
		return afterChooseAttacker(attacker, context);
	}
	
	private IAgotFlowStep afterChooseAttacker(CharacterCard attacker, AgotContext context) {
		this.attackers.add(attacker);
		this.availableAttackers.remove (attacker);
		if (attacker.hasStealth ()) {
			var availableDefenders = this.defender.characters().filter(cha -> cha.canBeBypassedByStealth());
			return new ResolveStealthRequest(availableDefenders.collect(Collectors.toList()), this.activePlayer, this);
		} else {
			return new ChooseOptionalAttackerRequest(this.availableAttackers, this.activePlayer, this);
		}
	}
	
	@Override
	public IAgotFlowStep after(ChooseOptionalAttackerRequest decision, AgotContext context) {
		if (decision.isHasPassed()) {
			var challenge = new Challenge(this.challengeType, this.activePlayer, this.defender, this.attackers, this.bypassed);
			this.game.log().initiatesAchallenge(challenge.attacker(), challenge.defender(), challenge.type(), context);
			challenge.attackers().forEach (att -> {
				att.kneel(context);
				this.game.log().declaresAsAttacker(challenge.attacker(), att, context);
			});
			challenge.bypassed().forEach(bypassed -> {
				this.game.log().charactedIsBypassed(challenge.attacker(), bypassed, context);
			});
			this.challenge = challenge;
			this.game.setChallenge(challenge);
			AgotEvent event = new InitiateAChallengeEvent(challenge, this.game);
			return new AgotEventProcess(event, this.game, this);
		} else {
			var attacker = decision.getChoosenModel();
			return afterChooseAttacker(attacker, context);
		}
	}
	
	@Override
	public IAgotFlowStep after(ResolveStealthRequest decision, AgotContext context) {
		if (!decision.isHasPassed()) {
			var bypassedCha = decision.getChoosenModel();
			this.bypassed.add(bypassedCha);
		}
		return new ChooseOptionalAttackerRequest(this.availableAttackers, this.activePlayer, this);
	}
	
	@Override
	public IAgotFlowStep after(AgotEventProcess eventProcess, AgotContext context) {
		return null;
	}
	
}
