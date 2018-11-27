package motif.agot.test;

import java.util.Objects;

import motif.agot.ang.enums.AngIcon;
import motif.agot.ang.enums.AngPhase;
import motif.agot.endpoint.AgotContext;
import motif.agot.flow.request.AgotRequest;
import motif.agot.flow.request.AgotRequest.AgotOption;
import motif.agot.flow.request.AgotRequest.AgotRequestCod;
import motif.agot.flow.request.AgotResponse;
import motif.agot.logic.GameFlow;
import motif.agot.logic.act.Act;
import motif.agot.logic.act.MarshallingAct;
import motif.agot.logic.act.ReactionAct;
import motif.agot.logic.round.phases.challenges.InitiateChallengeStep.AvailableChallenge;
import motif.agot.state.AgotGame;
import motif.agot.state.AgotPlayer;
import motif.agot.state.cards.CharacterCard;
import motif.agot.state.cards.MarshallCard;
import motif.agot.state.cards.PlotCard;
import motif.agot.state.cards.TextCard;
import motif.shared.exceptions.MotifUnexpectedError;
import motif.shared.flow.IMotifSender;
import motif.shared.flow.TaskTrigger;

@SuppressWarnings("unchecked")
public abstract class Test {

	public final void run () throws AgotTestException {
		game = init ();
		IMotifSender<AgotContext, AgotRequest<?>> sender = new IMotifSender<AgotContext, AgotRequest<?>> () {
			@Override public void send (AgotRequest<?> request, AgotContext context) {
				pendingRequest = (AgotRequest<?>) request;
				System.out.println (request);
			}
		};
		context = AgotContext.create (null);
		trigger = new TaskTrigger<AgotContext, AgotRequest<?>, AgotResponse> (sender);
		trigger.start (new GameFlow (game), context);
		execute ();
	} // run
	
	protected abstract AgotGame init ();
	protected abstract void execute () throws AgotTestException;

	private AgotGame game;
	private AgotRequest<?> pendingRequest;
	private TaskTrigger<AgotContext, AgotRequest<?>, AgotResponse> trigger;
	private AgotContext context;
	
	private void passRequests (AgotRequestCod untilRequestCod, AgotPlayer untilPlayer) {
		boolean matchRequestCod = pendingRequest.getRequestCod ().equals (untilRequestCod);
		boolean matchPlayer = pendingRequest.getPlayer () == untilPlayer;
		while (!matchRequestCod || !matchPlayer) {
			if (pendingRequest.hasPassOption ()) {
				passSafe (pendingRequest.getPlayer ());
				matchRequestCod = pendingRequest.getRequestCod ().equals (untilRequestCod);
				matchPlayer = pendingRequest.getPlayer () == untilPlayer;
			} else {
				if (!matchRequestCod) {
					throw new MotifUnexpectedError ("Test: unexpected operation");
				} else {
					throw new MotifUnexpectedError ("Test: unexpected player");
				} // if - else
			} // if - else
		} // while
	} // passRequests
	
	private void passSafe (AgotPlayer player) {
		AgotOption<?> option = pendingRequest.getPassOption ();
		trigger.receive (new AgotResponse (option.getKey ()), context);
	} // pass
	
	protected void pass (AgotPlayer player) {
		if (pendingRequest.getPlayer () != player) {
			throw new MotifUnexpectedError ("Test: unexpected player");
		} // if
		passSafe (player);
	} // pass
	
	protected void endPlotPhase () { endPhase (AngPhase.PLOT); }
	protected void endDrawPhase () { endPhase (AngPhase.DRAW); }
	protected void endMarshallingPhase () { endPhase (AngPhase.MARSHALLING); }
	protected void endChallengesPhase () { endPhase (AngPhase.CHALLENGES); }
	protected void endDominancePhase () { endPhase (AngPhase.DOMINANCE); }
	protected void endStandingPhase () { endPhase (AngPhase.STANDING); }
	protected void endTaxationPhase () { endPhase (AngPhase.TAXATION); }
	
	protected void endChallenge (AgotPlayer player) {
		passRequests (AgotRequestCod.CONTINUE, player);
		if (!game.isDuringChallenge ()) {
			throw new MotifUnexpectedError ("Test: challenge expected");
		} // if
		continueGame ();
	} // endChallenge
	
	private void endPhase (AngPhase phase) {
		passRequests (AgotRequestCod.CONTINUE, game.getFirstPlayer ());
		if (!game.getPhase ().equals (phase)) {
			throw new MotifUnexpectedError ("Test: unexpected phase");
		} // if
		continueGame ();
	} // endPhase
	
	private void continueGame () {
		AgotOption<?> option = pendingRequest.getContinueOption ();
		trigger.receive (new AgotResponse (option.getKey ()), context);
	} // continueGame
	
	protected void selectPlot (PlotCard plot, AgotPlayer player) {
		passRequests (AgotRequestCod.SELECT_PLOT_TO_REVEAL, player);
		AgotRequest<PlotCard> req = (AgotRequest<PlotCard>) pendingRequest;
		AgotOption<PlotCard> option = req.getOptionByModel (plot);
		trigger.receive (new AgotResponse (option.getKey ()), context);
	} // selectPlot

	protected void selectFirstPlayer (AgotPlayer firstPlayer, AgotPlayer player) {
		passRequests (AgotRequestCod.SELECT_FIRST_PLAYER, player);
		AgotRequest<AgotPlayer> req = (AgotRequest<AgotPlayer>) pendingRequest;
		AgotOption<AgotPlayer> option = req.getOptionByModel (firstPlayer);
		trigger.receive (new AgotResponse (option.getKey ()), context);
	} // selectFirstPlayer
	
	protected void marshall (MarshallCard<?> toMarshall, AgotPlayer player) {
		passRequests (AgotRequestCod.SELECT_ACTION_TO_PERFORM, player);
		AgotRequest<? super Act> req = (AgotRequest<? super Act>) pendingRequest;
		MarshallingAct act = req.options ()
		.map (o -> o.getModel ())
		.filter (m -> m != null)
		.filter (m -> m instanceof MarshallingAct)
		.map (m -> (MarshallingAct) m)
		.filter (m -> m.getCard () == toMarshall)
		.findFirst ()
		.get ();
		AgotOption<? super Act> option = req.getOptionByModel (act);
		trigger.receive (new AgotResponse (option.getKey ()), context);
	} // marshall

	protected void initiateChallenge (AngIcon challengeType, AgotPlayer player) {
		passRequests (AgotRequestCod.SELECT_CHALLENGE_TO_INITIATE, player);
		AgotRequest<AvailableChallenge> req = (AgotRequest<AvailableChallenge>) pendingRequest;
		AvailableChallenge avaChal = req.options ()
		.map (o -> o.getModel ())
		.filter (m -> m != null)
		.filter (m -> m.getChallengeType ().equals (challengeType))
		.findFirst ()
		.get ();
		AgotOption<AvailableChallenge> option = req.getOptionByModel (avaChal);
		trigger.receive (new AgotResponse (option.getKey ()), context);
	} // initiateChallenge
	
	protected void attack (CharacterCard attacker, AgotPlayer player) {
		passRequests (AgotRequestCod.SELECT_CHARACTER_TO_ATTACK, player);
		AgotRequest<CharacterCard> req = (AgotRequest<CharacterCard>) pendingRequest;
		AgotOption<CharacterCard> option = req.getOptionByModel (attacker);
		trigger.receive (new AgotResponse (option.getKey ()), context);
	} // attack
	
	protected void defend (CharacterCard defender, AgotPlayer player) {
		passRequests (AgotRequestCod.SELECT_CHARACTER_TO_DEFEND, player);
		AgotRequest<CharacterCard> req = (AgotRequest<CharacterCard>) pendingRequest;
		AgotOption<CharacterCard> option = req.getOptionByModel (defender);
		trigger.receive (new AgotResponse (option.getKey ()), context);
	} // defend
	
	protected void reaction (TextCard<?> reactingCard, AgotPlayer player) {
		passRequests (AgotRequestCod.SELECT_REACTION_TO_PERFORM, player);
		AgotRequest<ReactionAct> req = (AgotRequest<ReactionAct>) pendingRequest;
		ReactionAct reactionAct = req.options ()
		.map (o -> o.getModel ())
		.filter (ra -> ra.getTrigCard () == reactingCard)
		.findFirst ().get ();
		AgotOption<ReactionAct> option = req.getOptionByModel (reactionAct);
		trigger.receive (new AgotResponse (option.getKey ()), context);
	} // reaction
	
	protected <T> void assertEqual (T o1, T o2) throws AgotTestException {
		if (!Objects.equals (o1, o2)) { throw new AgotTestException (); }
	} // assertEq
	
	public static class AgotTestException extends Exception {
		private static final long serialVersionUID = -3252117767029803155L;
	} // AgotTestException
	
} // Test
