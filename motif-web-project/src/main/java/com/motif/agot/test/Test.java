package com.motif.agot.test;

import java.util.Objects;

import com.motif.agot.ang.enums.AngIcon;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.endpoint.IAgotSender;
import com.motif.agot.logic.AgotPlay;
import com.motif.agot.logic.flow.AgotResponse;
import com.motif.agot.logic.flow.AgotTrigger;
import com.motif.agot.logic.flow.IAgotFlowRequest;
import com.motif.agot.logic.requests.AAgotRequest;
import com.motif.agot.logic.requests.AAgotRequest.AgotRequestType;
import com.motif.agot.logic.requests.AgotChoice;
import com.motif.agot.logic.requests.AgotChoice.AgotChoiceCardAction;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;
import com.motif.agot.state.cards.AttachmentCard;
import com.motif.agot.state.cards.CharacterCard;
import com.motif.agot.state.cards.MarshallCard;
import com.motif.agot.state.cards.PlotCard;
import com.motif.agot.state.cards.TextCard;
import com.motif.shared.endpoint.MotifUser;

public abstract class Test {

	public final void run() throws AgotTestException {
		this.game = init();
		var sender = new IAgotSender() {
			@Override
			public void send(IAgotFlowRequest request, AgotContext context) {
				Test.this.pendingRequest = (AAgotRequest) request;
				if (!request.isRepeated()) { System.out.println(request); }
			}
		};
		this.trigger = new AgotTrigger(sender);
		var context = new AgotContext(this.game.players().findFirst().get());
		this.trigger.start(new AgotPlay(this.game), context);
		execute();
	}
	
	protected abstract AgotGame init ();
	protected abstract void execute () throws AgotTestException;

	protected MotifUser testUser = new MotifUser("test");
	
	private AgotGame game;
	private AAgotRequest pendingRequest;
	private AgotTrigger trigger;
	
	private void chooseOrPass(AgotChoice choice, AgotPlayer player) {
		var response = new AgotResponse(player.id(), choice);
		var context = new AgotContext(player); 
		var accepted = this.trigger.receive(response, context);
		while(!accepted) {
			pass(this.pendingRequest.getPlayer());
			accepted = this.trigger.receive(response, context);
		}
	}
	
	private void pass(AgotPlayer player) {
		var choice = AgotChoice.passChoice().sRequestType(this.pendingRequest.getType());
		var response = new AgotResponse(player.id(), choice);
		var context = new AgotContext(player); 
		this.trigger.receive(response, context);
	}
	
	protected void endPlotPhase() { endPhase(AngPhase.PLOT, this.game.firstPlayer()); }
	protected void endDrawPhase() { endPhase(AngPhase.DRAW, this.game.firstPlayer()); }
	protected void endMarshallingPhase() { endPhase(AngPhase.MARSHALLING, this.game.firstPlayer()); }
	protected void endChallengesPhase() { endPhase(AngPhase.CHALLENGES, this.game.firstPlayer()); }
	protected void endDominancePhase() { endPhase(AngPhase.DOMINANCE, this.game.firstPlayer()); }
	protected void endStandingPhase() { endPhase(AngPhase.STANDING, this.game.firstPlayer()); }
	protected void endTaxationPhase() { endPhase(AngPhase.TAXATION, this.game.firstPlayer()); }
	
	protected void endChallenge(AgotPlayer player) {
		continueGame(player);
	}
	
	private void endPhase(AngPhase phase, AgotPlayer player) {
		continueGame(player);
	}
	
	private void continueGame(AgotPlayer player) {
		chooseOrPass(AgotChoice.continueChoice().sRequestType(AgotRequestType.CONTINUE), player);
	}

	protected void selectPlot(PlotCard plot, AgotPlayer player) {
		chooseOrPass(AgotChoice.selectCardChoice(plot).sRequestType(AgotRequestType.SELECT_PLOT_TO_REVEAL), player);
	}

	protected void selectFirstPlayer(AgotPlayer firstPlayer, AgotPlayer player) {
		chooseOrPass(AgotChoice.selectPlayerChoice(firstPlayer).sRequestType(AgotRequestType.SELECT_FIRST_PLAYER), player);
	}
	
	protected void marshall(MarshallCard<?> toMarshall, AgotPlayer player) {
		chooseOrPass(AgotChoice.selectCardActionChoice(toMarshall, AgotChoiceCardAction.MARSHALL).sRequestType(AgotRequestType.SELECT_ACTION_TO_PERFORM), player);
	}

	protected void initiateChallenge(AngIcon challengeType, AgotPlayer defender, CharacterCard[] attackers, AgotPlayer player) {
		selectChallengeType(challengeType, player);
		selectDefenderPlayer(defender, player);
		for (var attacker : attackers) {
			selectAttacker(attacker, player);
		}
	}
	
	private void selectDefenderPlayer(AgotPlayer defender, AgotPlayer player) {
		chooseOrPass(AgotChoice.selectPlayerChoice(defender).sRequestType(AgotRequestType.SELECT_DEFENDER), player);
	}

	private void selectChallengeType(AngIcon challengeType, AgotPlayer player) {
		chooseOrPass(AgotChoice.selectIconChoice(challengeType).sRequestType(AgotRequestType.SELECT_CHALLENGE_TO_INITIATE), player);
	}
	
	protected void selectAttacker(CharacterCard attacker, AgotPlayer player) {
		chooseOrPass(AgotChoice.selectCardChoice(attacker).sRequestType(AgotRequestType.SELECT_CHARACTER_TO_ATTACK), player);
	}
	
	protected void defend (CharacterCard defender, AgotPlayer player) {
		chooseOrPass(AgotChoice.selectCardChoice(defender).sRequestType(AgotRequestType.SELECT_CHARACTER_TO_DEFEND), player);
	}
	
	protected void reaction (TextCard<?> reactingCard, AgotPlayer player) {
		chooseOrPass(AgotChoice.selectCardActionChoice(reactingCard, AgotChoiceCardAction.REACTION).sRequestType(AgotRequestType.SELECT_REACTION_TO_PERFORM), player);
	}
	
	public void attach(AttachmentCard attachment, CharacterCard attachTo, AgotPlayer player) {
		chooseOrPass(AgotChoice.selectCardActionChoice(attachment, AgotChoiceCardAction.MARSHALL).sRequestType(AgotRequestType.SELECT_ACTION_TO_PERFORM), player);
		chooseOrPass(AgotChoice.selectCardChoice(attachTo).sRequestType(AgotRequestType.SELECT_CARD_TO_ATTACH), player);
	}
	
	protected <T> void assertEqual (T o1, T o2) throws AgotTestException {
		if (!Objects.equals (o1, o2)) { throw new AgotTestException (); }
	}
	
	public static class AgotTestException extends Exception {
		private static final long serialVersionUID = -3252117767029803155L;
	}

	
	
}
