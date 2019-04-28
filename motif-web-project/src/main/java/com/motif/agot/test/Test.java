package com.motif.agot.test;

import java.util.Objects;

import com.motif.agot.ang.enums.AngIcon;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.endpoint.IAgotSender;
import com.motif.agot.logic.AgotPlay;
import com.motif.agot.logic.act.IPhaseAct;
import com.motif.agot.logic.act.MarshallingAct;
import com.motif.agot.logic.flow.AgotResponse;
import com.motif.agot.logic.flow.AgotTrigger;
import com.motif.agot.logic.flow.IAgotFlowRequest;
import com.motif.agot.logic.requests.AAgotModelOptionalRequest;
import com.motif.agot.logic.requests.AAgotRequest;
import com.motif.agot.logic.requests.SelectActionToPerformRequest;
import com.motif.agot.logic.requests.ChooseAChallengeTypeRequest;
import com.motif.agot.logic.requests.SelectCharacterToAttackRequest;
import com.motif.agot.logic.requests.ChooseDefenderCharacterRequest;
import com.motif.agot.logic.requests.ChoosePlotRequest;
import com.motif.agot.logic.requests.ContinueRequest;
import com.motif.agot.logic.requests.FirstPlayerRequest;
import com.motif.agot.logic.requests.SelectReactionToPerformRequest;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;
import com.motif.agot.state.cards.CharacterCard;
import com.motif.agot.state.cards.MarshallCard;
import com.motif.agot.state.cards.PlotCard;
import com.motif.agot.state.cards.TextCard;
import com.motif.shared.exceptions.MotifUnexpectedError;

@SuppressWarnings("unchecked")
public abstract class Test {

	public final void run() throws AgotTestException {
		this.game = init();
		IAgotSender sender = new IAgotSender() {
			@Override
			public void send(IAgotFlowRequest request, AgotContext context) {
				Test.this.pendingRequest = (AAgotRequest) request;
				System.out.println(request);
			}
		};
		this.context = AgotContext.create(null);
		this.trigger = new AgotTrigger(sender);
		this.trigger.start(new AgotPlay(this.game), this.context);
		execute();
	}
	
	protected abstract AgotGame init ();
	protected abstract void execute () throws AgotTestException;

	private AgotGame game;
	private AAgotRequest pendingRequest;
	private AgotTrigger trigger;
	private AgotContext context;
	
	private void passRequests(String untilRequestType, AgotPlayer untilPlayer) {
		var matchRequestCod = this.pendingRequest.getType().equals(untilRequestType);
		var matchPlayer = this.pendingRequest.getPlayer() == untilPlayer;
		while (!matchRequestCod || !matchPlayer) {
			if (this.pendingRequest instanceof AAgotModelOptionalRequest<?>) {
				passSafe(this.pendingRequest.getPlayer());
				matchRequestCod = this.pendingRequest.getType().equals(untilRequestType);
				matchPlayer = this.pendingRequest.getPlayer() == untilPlayer;
			} else {
				if (!matchRequestCod) {
					throw new MotifUnexpectedError("Test: unexpected operation");
				} else {
					throw new MotifUnexpectedError("Test: unexpected player");
				}
			}
		}
	}
	
	private void passSafe (AgotPlayer player) {
		this.trigger.receive(new AgotResponse(AAgotModelOptionalRequest.PASS_KEY), this.context);
	}
	
	protected void pass (AgotPlayer player) {
		if (this.pendingRequest.getPlayer () != player) {
			throw new MotifUnexpectedError ("Test: unexpected player");
		}
		passSafe (player);
	}
	
	protected void endPlotPhase () { endPhase (AngPhase.PLOT); }
	protected void endDrawPhase () { endPhase (AngPhase.DRAW); }
	protected void endMarshallingPhase () { endPhase (AngPhase.MARSHALLING); }
	protected void endChallengesPhase () { endPhase (AngPhase.CHALLENGES); }
	protected void endDominancePhase () { endPhase (AngPhase.DOMINANCE); }
	protected void endStandingPhase () { endPhase (AngPhase.STANDING); }
	protected void endTaxationPhase () { endPhase (AngPhase.TAXATION); }
	
	protected void endChallenge(AgotPlayer player) {
		passRequests(AAgotRequest.CONTINUE, player);
		if (!this.game.isDuringChallenge()) {
			throw new MotifUnexpectedError("Test: challenge expected");
		}
		continueGame();
	}
	
	private void endPhase(AngPhase phase) {
		passRequests(AAgotRequest.CONTINUE, this.game.getFirstPlayer());
		if (!this.game.getPhase().equals(phase)) {
			throw new MotifUnexpectedError("Test: unexpected phase");
		}
		continueGame();
	}
	
	private void continueGame() {
		this.trigger.receive(new AgotResponse(ContinueRequest.CONTINUE_KEY), this.context);
	}

	protected void selectPlot(PlotCard plot, AgotPlayer player) {
		passRequests(AAgotRequest.SELECT_PLOT_TO_REVEAL, player);
		var req = (ChoosePlotRequest) this.pendingRequest;
		var option = req.getKeyByModel(plot);
		this.trigger.receive(new AgotResponse(option), this.context);
	}

	protected void selectFirstPlayer(AgotPlayer firstPlayer, AgotPlayer player) {
		passRequests(AAgotRequest.SELECT_FIRST_PLAYER, player);
		var req = (FirstPlayerRequest) this.pendingRequest;
		var option = req.getKeyByModel(firstPlayer);
		this.trigger.receive(new AgotResponse(option), this.context);
	} // selectFirstPlayer
	
	protected void marshall(MarshallCard<?> toMarshall, AgotPlayer player) {
		passRequests(AAgotRequest.SELECT_ACTION_TO_PERFORM, player);
		var req = (SelectActionToPerformRequest<IPhaseAct>) this.pendingRequest;
		var act = req.models()
		.filter (m -> m != null)
		.filter (m -> m instanceof MarshallingAct)
		.map (m -> (MarshallingAct) m)
		.filter (m -> m.getCard() == toMarshall)
		.findFirst()
		.get ();
		var option = req.getKeyByModel(act);
		this.trigger.receive(new AgotResponse(option), this.context);
	}

	protected void initiateChallenge (AngIcon challengeType, AgotPlayer player) {
		passRequests (AAgotRequest.SELECT_CHALLENGE_TO_INITIATE, player);
		var req = (ChooseAChallengeTypeRequest) this.pendingRequest;
		var avaChal = req.models()
		.filter (m -> m != null)
		.filter (m -> m.equals(challengeType))
		.findFirst ()
		.get ();
		var option = req.getKeyByModel(avaChal);
		this.trigger.receive(new AgotResponse (option), this.context);
	}
	
	protected void attack (CharacterCard attacker, AgotPlayer player) {
		passRequests (AAgotRequest.SELECT_CHARACTER_TO_ATTACK, player);
		var req = (SelectCharacterToAttackRequest) pendingRequest;
		var option = req.getKeyByModel(attacker);
		trigger.receive (new AgotResponse (option), context);
	}
	
	protected void defend (CharacterCard defender, AgotPlayer player) {
		passRequests (AAgotRequest.SELECT_CHARACTER_TO_DEFEND, player);
		var req = (ChooseDefenderCharacterRequest) this.pendingRequest;
		var option = req.getKeyByModel(defender);
		this.trigger.receive (new AgotResponse(option), this.context);
	}
	
	protected void reaction (TextCard<?> reactingCard, AgotPlayer player) {
		passRequests (AAgotRequest.SELECT_REACTION_TO_PERFORM, player);
		var req = (SelectReactionToPerformRequest) this.pendingRequest;
		var reactionAct = req.models()
		.filter (ra -> ra.getTrigCard () == reactingCard)
		.findFirst ().get ();
		var option = req.getKeyByModel(reactionAct);
		this.trigger.receive (new AgotResponse(option), this.context);
	}
	
	protected <T> void assertEqual (T o1, T o2) throws AgotTestException {
		if (!Objects.equals (o1, o2)) { throw new AgotTestException (); }
	}
	
	public static class AgotTestException extends Exception {
		private static final long serialVersionUID = -3252117767029803155L;
	}
	
}
