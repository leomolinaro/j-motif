package com.motif.agot.endpoint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import com.motif.shared.endpoint.MotifGraphqlUtil;
import com.motif.shared.endpoint.MotifAuthManager;
import com.motif.shared.endpoint.MotifToken;
import com.motif.shared.exceptions.MotifUnexpectedError;

import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.annotations.GraphQLSubscription;
import reactor.core.publisher.FluxSink;

public class AgotEndpoint implements IAgotSender {

	private AgotGame game = null;
	private AgotTrigger trigger;

	private Map<String, List<FluxSink<AAgotRequest>>> requestSinksByUser = new HashMap<String, List<FluxSink<AAgotRequest>>> ();
	private Map<String, List<FluxSink<AgotReduxActionList>>> changesSinksByUser = new HashMap<String, List<FluxSink<AgotReduxActionList>>> ();
	
	private static AgotEndpoint instance;
	public static AgotEndpoint getInstance () {
		if (instance == null) { instance = new AgotEndpoint (); }
		return instance;
	}
	private AgotEndpoint () {};
	
	@GraphQLMutation
	public AgotGame createGame (ArrayList<InputPlayer> inputPlayers, MotifToken token) {
		var user = MotifAuthManager.getInstance ().getUserByToken (token);
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
		var user = MotifAuthManager.getInstance ().getUserByToken (token);
		if (this.trigger != null && this.trigger.hasPendingRequest()) {
			var pendingRequest = this.trigger.getPendingRequest();
			if (user.getUsername().equals(pendingRequest.getPlayer().getUser().getUsername())) {
				return (AAgotRequest) pendingRequest;
			}
		}
		return null;
	} // request
	
	@GraphQLSubscription (name = "request")
	public Publisher<AAgotRequest> subscribeRequests (MotifToken token) {
		var user = MotifAuthManager.getInstance ().getUserByToken (token);
		var pub = MotifGraphqlUtil.subscribe (this.requestSinksByUser, user);
		return pub;
	} // subscribeRequests
	
	@GraphQLSubscription (name = "changes")
	public Publisher<AgotReduxActionList> subscribeChanges (MotifToken token) {
		var user = MotifAuthManager.getInstance ().getUserByToken (token);
		var pub = MotifGraphqlUtil.subscribe (this.changesSinksByUser, user);
		return pub;
	} // subscribeChanges
	
//	public void initState (MotifContext context) {
//		if (game == null) { return; }
//		var message = new MessageOut(MotifApp.AGOT);
//		message.setUser(context.getUser());
//		message.setType(MessageOut.AGOT_REDUX_ACTION_LIST);
//		var actions = new AgotReduxActionList();
//		actions.initGame(game); 
//		message.setData(actions);
//		MotifWebsocketEndpoint.send(message, context.getUser());
//	}
	
	@GraphQLMutation
	public void startGame (MotifToken token) {
		var user = MotifAuthManager.getInstance ().getUserByToken (token);
		if (!this.game.started ()) {
			var playContext = new AgotContext (this.game.getAnyPlayerByUser (user));
			this.game.setStarted (true, playContext);
			this.trigger = new AgotTrigger (this);
			this.trigger.start (new AgotPlay (this.game), playContext);
		}
	}

	@GraphQLMutation
	public void chooseAction (AgotResponse response, MotifToken token) {
		var player = this.game.getPlayer (response.getPlayerId ());
		var playContext = new AgotContext (player);
		this.trigger.receive (response, playContext);
	} // chooseAction
	
	public void actionChoice (AgotResponse response, MotifContext context) throws MotifUnexpectedError {
		var player = this.game.getPlayer(response.getPlayerId());
		var playContext = new AgotContext(player);
		trigger.receive(response, playContext);
	}
	
	@Override
	public void send (IAgotFlowRequest request, AgotContext context) {
		var player = request.getPlayer();
		var user = player.getUser();
//		var sourceUser = context.getPlayer().getUser();
		var actions = context.actions();
		
//		var oppUsers = this.game.players()
//				.filter(p -> p != player && p.getUser() != user)
//				.map(p -> p.getUser())
//				.collect(Collectors.toSet());
//		
//		if (!oppUsers.isEmpty()) {
//			var oppMessage = new MessageOut (MotifApp.AGOT);
//			oppMessage.setUser(sourceUser);
//			oppMessage.setType (MessageOut.AGOT_REDUX_ACTION_LIST);
//			oppMessage.setData (actions);
//			MotifWebsocketEndpoint.send(oppMessage, oppUsers);
//			//actions.removeLast ();
//		}
		
		var users = this.game.players ()
				.map (p -> p.getUser ())
				.collect (Collectors.toSet ());
//		var message = new MessageOut (MotifApp.AGOT);
//		message.setUser (sourceUser);
//		message.setType (MessageOut.AGOT_REDUX_ACTION_LIST);
//		message.setData (actions);
//		MotifWebsocketEndpoint.send (message, users);
		
		// .getActions ().stream ().map (a -> a.toString ()).collect (Collectors.toList ())
		MotifGraphqlUtil.publish (actions, this.changesSinksByUser, users);
		MotifGraphqlUtil.publish ((AAgotRequest) request, this.requestSinksByUser, user);
		
	}

}
