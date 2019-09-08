package com.motif.agot.test;

import java.util.Objects;

import com.motif.agot.ang.enums.AngIcon;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.AgotPlay;
import com.motif.agot.logic.flow.AgotTrigger;
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
import com.motif.shared.exceptions.MotifException;

public abstract class Test {

	public final void run () throws AgotTestException, MotifException {
		this.game = init ();
		this.trigger = new AgotTrigger ();
		var context = new AgotContext (this.game.players ().findFirst ().get ());
		this.trigger.start (new AgotPlay (this.game), context);
		execute ();
	}
	
	protected abstract AgotGame init ();
	protected abstract void execute () throws AgotTestException, MotifException;

	protected MotifUser testUser = new MotifUser("test");
	
	private AgotGame game;
	private AgotTrigger trigger;
	
	private void chooseOrPass (AgotChoice choice, AgotPlayer player) throws MotifException {
		var context = new AgotContext (player);
		var accepted = tryChoice (choice, context);
		while (!accepted) {
			var pendingRequest = (AAgotRequest) this.trigger.pendingRequests ().iterator ().next ();
			pass (pendingRequest);
			accepted = tryChoice (choice, context);
		}
	}
	
	private boolean tryChoice (AgotChoice choice, AgotContext context) {
		try {
			this.trigger.receive (choice, context);
			return true;
		} catch (MotifException e) {
			return false;
		} // try - catch
	} // tryChoice
	
	private void pass (AAgotRequest pendingRequest) throws MotifException {
		var choice = AgotChoice.passChoice (pendingRequest.getType ());
		var context = new AgotContext (pendingRequest.getPlayer ());
		this.trigger.receive (choice, context);
	} // pass
	
	protected void endPlotPhase() throws MotifException { endPhase(AngPhase.PLOT, this.game.firstPlayer()); }
	protected void endDrawPhase() throws MotifException { endPhase(AngPhase.DRAW, this.game.firstPlayer()); }
	protected void endMarshallingPhase() throws MotifException { endPhase(AngPhase.MARSHALLING, this.game.firstPlayer()); }
	protected void endChallengesPhase() throws MotifException { endPhase(AngPhase.CHALLENGES, this.game.firstPlayer()); }
	protected void endDominancePhase() throws MotifException { endPhase(AngPhase.DOMINANCE, this.game.firstPlayer()); }
	protected void endStandingPhase() throws MotifException { endPhase(AngPhase.STANDING, this.game.firstPlayer()); }
	protected void endTaxationPhase() throws MotifException { endPhase(AngPhase.TAXATION, this.game.firstPlayer()); }
	
	protected void endChallenge(AgotPlayer player) throws MotifException {
		continueGame(player);
	}
	
	private void endPhase(AngPhase phase, AgotPlayer player) throws MotifException {
		continueGame(player);
	}
	
	private void continueGame (AgotPlayer player) throws MotifException {
		chooseOrPass (AgotChoice.continueChoice ("Continue"), player);
	}
	
	public void noMulligan (AgotPlayer player) throws MotifException {
		chooseOrPass (AgotChoice.selectYesNoChoice (false), player);
	} // noMulligan

	protected void selectPlot(PlotCard plot, AgotPlayer player) throws MotifException {
		chooseOrPass(AgotChoice.selectCardChoice (AgotRequestType.SELECT_PLOT_TO_REVEAL, plot), player);
	}

	protected void selectFirstPlayer(AgotPlayer firstPlayer, AgotPlayer player) throws MotifException {
		chooseOrPass(AgotChoice.selectPlayerChoice (AgotRequestType.SELECT_FIRST_PLAYER, firstPlayer), player);
	}
	
	protected void marshall(MarshallCard<?> toMarshall, AgotPlayer player) throws MotifException {
		chooseOrPass(AgotChoice.selectCardActionChoice (AgotRequestType.SELECT_ACTION_TO_PERFORM, toMarshall, AgotChoiceCardAction.MARSHALL), player);
	}

	protected void initiateChallenge(AngIcon challengeType, AgotPlayer defender, CharacterCard[] attackers, AgotPlayer player) throws MotifException {
		selectChallengeType(challengeType, player);
		selectDefenderPlayer(defender, player);
		for (var attacker : attackers) {
			selectAttacker(attacker, player);
		}
	}
	
	private void selectDefenderPlayer (AgotPlayer defender, AgotPlayer player) throws MotifException {
		chooseOrPass (AgotChoice.selectPlayerChoice (AgotRequestType.SELECT_DEFENDER, defender), player);
	}

	private void selectChallengeType (AngIcon challengeType, AgotPlayer player) throws MotifException {
		chooseOrPass (AgotChoice.selectIconChoice (AgotRequestType.SELECT_CHALLENGE_TO_INITIATE, challengeType),
		        player);
	}

	protected void selectAttacker (CharacterCard attacker, AgotPlayer player) throws MotifException {
		chooseOrPass (AgotChoice.selectCardChoice (AgotRequestType.SELECT_CHARACTER_TO_ATTACK, attacker), player);
	}

	protected void defend (CharacterCard defender, AgotPlayer player) throws MotifException {
		chooseOrPass (AgotChoice.selectCardChoice (AgotRequestType.SELECT_CHARACTER_TO_DEFEND, defender), player);
	}

	protected void reaction (TextCard<?> reactingCard, AgotPlayer player) throws MotifException {
		chooseOrPass (AgotChoice.selectCardActionChoice (AgotRequestType.SELECT_REACTION_TO_PERFORM, reactingCard,
		        AgotChoiceCardAction.REACTION), player);
	}
	
	public void attach (AttachmentCard attachment, CharacterCard attachTo, AgotPlayer player) throws MotifException {
		chooseOrPass (AgotChoice.selectCardActionChoice (AgotRequestType.SELECT_ACTION_TO_PERFORM, attachment,
		        AgotChoiceCardAction.MARSHALL), player);
		chooseOrPass (AgotChoice.selectCardChoice (AgotRequestType.SELECT_CARD_TO_ATTACH, attachTo), player);
	} // attach
	
	public void draw (AgotPlayer player) throws MotifException {
		chooseOrPass (AgotChoice.drawChoice (), player);
	} // draw
	
	protected <T> void assertEqual (T o1, T o2) throws AgotTestException {
		if (!Objects.equals (o1, o2)) { throw new AgotTestException (); }
	}
	
	public static class AgotTestException extends Exception {
		private static final long serialVersionUID = -3252117767029803155L;
	}

}
