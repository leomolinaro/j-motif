package com.motif.agot.endpoint;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.reactivestreams.Publisher;

import com.motif.agot.ang.deck.InputPlayer;
import com.motif.agot.logic.AgotPlay;
import com.motif.agot.logic.flow.AgotResponse;
import com.motif.agot.logic.flow.AgotTrigger;
import com.motif.agot.logic.flow.IAgotFlowRequest;
import com.motif.agot.logic.requests.AAgotRequest;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;
import com.motif.shared.endpoint.MotifContext;
import com.motif.shared.endpoint.MotifToken;
import com.motif.shared.endpoint.messages.MessageOut;
import com.motif.shared.endpoint.messages.MessageOut.MotifApp;
import com.motif.shared.exceptions.MotifUnexpectedError;
import com.motif.ws.MotifSessionManager;
import com.motif.ws.MotifWebsocketEndpoint;

import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.annotations.GraphQLSubscription;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Observable;

public class AgotEndpoint implements IAgotSender {

	private AgotGame game = null;
	private AgotTrigger trigger;

	private static AgotEndpoint instance;
	public static AgotEndpoint getInstance () {
		if (instance == null) { instance = new AgotEndpoint (); }
		return instance;
	}
	private AgotEndpoint () {};
	
	@GraphQLMutation
	public AgotGame createGame (ArrayList<InputPlayer> inputPlayers, MotifToken token) {
		var user = MotifSessionManager.getInstance ().getUserByToken (token);
		var context = new MotifContext (user);
		var game = new AgotGame ();
		for (var inputPlayer : inputPlayers) {
			var player = new AgotPlayer(inputPlayer.id, inputPlayer.name, context.getUser());
			game.initPlayer(player);
			game.initFaction(player, inputPlayer.faction);
			for (var inputCard : inputPlayer.deck) {
				game.initCard(player, inputCard.card(), inputCard.quantity);
			}
		}
		this.game = game;
		return game;
	} // createGame

	@GraphQLQuery
	public AgotGame game () {
		return this.game;
	} // game
	
	@GraphQLQuery
	public AAgotRequest request (MotifToken token) {
		var user = MotifSessionManager.getInstance ().getUserByToken (token);
		if (this.trigger != null && this.trigger.hasPendingRequest()) {
			var pendingRequest = this.trigger.getPendingRequest();
			if (user.getUsername().equals(pendingRequest.getPlayer().getUser().getUsername())) {
				return (AAgotRequest) pendingRequest;
			}
		}
		return null;
	} // request
	
	@GraphQLSubscription
    public Publisher<Integer> tick () {
        Observable<Integer> observable = Observable.create(emitter -> {
            emitter.onNext(1);
            Thread.sleep(1000);
            emitter.onNext(2);
            Thread.sleep(1000);
            emitter.onComplete();
        });

        return observable.toFlowable(BackpressureStrategy.BUFFER);
    }
	
	public void initState(MotifContext context) {
		if (game == null) { return; }
		var message = new MessageOut(MotifApp.AGOT);
		message.setUser(context.getUser());
		message.setType(MessageOut.AGOT_REDUX_ACTION_LIST);
		IAgotFlowRequest request = null;
		if (trigger != null && trigger.hasPendingRequest()) {
			var pendingRequest = trigger.getPendingRequest();
			if (context.getUser().getUsername().equals(pendingRequest.getPlayer().getUser().getUsername())) {
				request = pendingRequest;
			}
		}
		var actions = new AgotReduxActionList();
		actions.initState(game, request); 
		message.setData(actions);
		MotifWebsocketEndpoint.send(message, context.getUser());
	}
	
	public void start(MotifContext context) {
		if (!this.game.started()) {
			var playContext = new AgotContext(this.game.getAnyPlayerByUser(context.getUser()));
			this.game.setStarted(true, playContext);
			this.trigger = new AgotTrigger(this);
			this.trigger.start(new AgotPlay(this.game), playContext);
		}
	}

	public void actionChoice(AgotResponse response, MotifContext context) throws MotifUnexpectedError {
		var player = this.game.getPlayer(response.getPlayerId());
		var playContext = new AgotContext(player);
		trigger.receive(response, playContext);
	}
	
	@Override
	public void send (IAgotFlowRequest request, AgotContext context) {
		var player = request.getPlayer();
		var user = player.getUser();
		var sourceUser = context.getPlayer().getUser();
		var actions = context.actions();
		
		var oppUsers = this.game.players()
				.filter(p -> p != player && p.getUser() != user)
				.map(p -> p.getUser())
				.collect(Collectors.toSet());
		
		if (!oppUsers.isEmpty()) {
			actions.request (null);
			var oppMessage = new MessageOut (MotifApp.AGOT);
			oppMessage.setUser(sourceUser);
			oppMessage.setType (MessageOut.AGOT_REDUX_ACTION_LIST);
			oppMessage.setData (actions);
			MotifWebsocketEndpoint.send(oppMessage, oppUsers);
			//actions.removeLast ();
		}
		
		actions.request (request);
		var message = new MessageOut (MotifApp.AGOT);
		message.setUser (sourceUser);
		message.setType (MessageOut.AGOT_REDUX_ACTION_LIST);
		message.setData (actions);
		MotifWebsocketEndpoint.send (message, user);
		//actions.removeLast ();
		
	}

	
	
}
