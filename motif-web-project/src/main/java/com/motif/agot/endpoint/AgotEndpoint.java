package com.motif.agot.endpoint;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.reactivestreams.Publisher;

import com.motif.agot.ang.deck.InputPlayer;
import com.motif.agot.logic.requests.AAgotRequest;
import com.motif.agot.logic.requests.AgotChoice;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;
import com.motif.agot.state.cards.DrawCard;
import com.motif.shared.endpoint.MotifAuthManager;
import com.motif.shared.endpoint.MotifContext;
import com.motif.shared.endpoint.MotifToken;
import com.motif.shared.exceptions.MotifException;

import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.annotations.GraphQLSubscription;

public class AgotEndpoint {

	private static AgotEndpoint instance;
	public static AgotEndpoint getInstance () {
		if (instance == null) { instance = new AgotEndpoint (); }
		return instance;
	}
	private AgotEndpoint () {};
	
	@GraphQLMutation
	public AgotGame agotNewGame (String gameName, ArrayList<InputPlayer> inputPlayers, MotifToken token) {
		var user = MotifAuthManager.getInstance ().getUserByToken (token).orElseThrow ();
		var context = new MotifContext (user);
		var game = new AgotGame (gameName);
		for (var inputPlayer : inputPlayers) {
			var player = new AgotPlayer(inputPlayer.id, inputPlayer.name, context.getUser());
			game.initPlayer(player);
			game.initFaction(player, inputPlayer.faction);
			for (var inputCard : inputPlayer.deck) {
				game.initCard(player, inputCard.card(), inputCard.quantity);
			} // for
		} // for
		AgotGameCache.newGameCache (game);
		return game;
	} // agotNewGame
	
	@GraphQLMutation
	public AgotGame agotRemoveGame (long gameId, MotifToken token) {
		MotifAuthManager.getInstance ().getUserByToken (token).orElseThrow ();
		var gameCache = AgotGameCache.removeGameCache (gameId);
		return gameCache.orElseThrow ().getGame ();
	} // agotRemoveGame

	@GraphQLQuery
	public List<AgotGame> agotGames (MotifToken token) {
		var games = AgotGameCache.getGames ();
		return games;
	} // agotGames
	
	@GraphQLQuery
	public AgotGame agotGame (long gameId, MotifToken token) {
		var gameCache = AgotGameCache.getGameCache (gameId);
		return gameCache.orElseThrow ().getGame ();
	} // agotGame
	
	@GraphQLQuery
	public List<AAgotRequest> agotRequests (long gameId, MotifToken token) {
		var user = MotifAuthManager.getInstance ().getUserByToken (token).orElseThrow ();
		var gameCache = AgotGameCache.getGameCache (gameId).orElseThrow ();
		var userPendingRequests = gameCache.getPendingRequests ().orElseGet (() -> new ArrayList<> ()).stream ()
				.filter (request -> user.getUsername ().equals (request.getPlayer ().getUser ().getUsername ()))
				.map (request -> (AAgotRequest) request)
				.collect (Collectors.toList ());
		return userPendingRequests;
	} // agotRequests
	
	@GraphQLSubscription (name = "agotRequests")
	public Publisher<List<AAgotRequest>> agotSubscribeToRequests (long gameId, MotifToken token) {
		var user = MotifAuthManager.getInstance ().getUserByToken (token).orElseThrow ();
		var gameCache = AgotGameCache.getGameCache (gameId).orElseThrow ();
		var pub = gameCache.subscribeToRequests (user);
		return pub;
	} // agotSubscribeToRequests
	
	@GraphQLSubscription (name = "agotChanges")
	public Publisher<AgotReduxActionList> agotSubscribeToChanges (long gameId, MotifToken token) {
		var user = MotifAuthManager.getInstance ().getUserByToken (token).orElseThrow ();
		var gameCache = AgotGameCache.getGameCache (gameId).orElseThrow ();
		var pub = gameCache.subscribeToChanges (user);
		return pub;
	} // agotSubscribeToChanges
	
	@GraphQLMutation
	public void agotStartGame (long gameId, MotifToken token) throws MotifException {
		var user = MotifAuthManager.getInstance ().getUserByToken (token).orElseThrow ();
		var gameCache = AgotGameCache.getGameCache (gameId).orElseThrow ();
		var game = gameCache.getGame ();
		var playContext = new AgotContext (game.getAnyPlayerByUser (user));
		gameCache.startGame (playContext);
	} // agotStartGame

	@GraphQLMutation
	public void agotChooseAction (AgotChoice choice, String playerId, long gameId, MotifToken token) throws MotifException {
		MotifAuthManager.getInstance ().getUserByToken (token).orElseThrow ();
		var gameCache = AgotGameCache.getGameCache (gameId).orElseThrow ();
		var game = gameCache.getGame ();
		var player = game.getPlayer (playerId);
		var playContext = new AgotContext (player);
		gameCache.chooseAction (choice, playContext);
	} // agotChooseAction
	
	@GraphQLMutation
	public void agotCheatDrawDeck (List<Long> cardIds, String playerId, long gameId, MotifToken token) {
		MotifAuthManager.getInstance ().getUserByToken (token).orElseThrow ();
		var gameCache = AgotGameCache.getGameCache (gameId).orElseThrow ();
		var game = gameCache.getGame ();
		var player = game.getPlayer (playerId);
		var playContext = new AgotContext (player);
		var cards = new LinkedList<DrawCard<?>> ();
		cardIds.forEach (id -> {
			var card = game.getCard (id);
			cards.add ((DrawCard<?>) card);
		});
		player.cheatDrawDeck (cards, playContext);
	} // agotCheatDrawDeck
	
} // AgotEndpoint
