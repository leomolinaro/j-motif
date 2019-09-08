package com.motif.agot.endpoint;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.reactivestreams.Publisher;

import com.motif.agot.logic.AgotPlay;
import com.motif.agot.logic.flow.AgotTrigger;
import com.motif.agot.logic.flow.IAgotFlowRequest;
import com.motif.agot.logic.requests.AAgotRequest;
import com.motif.agot.logic.requests.AgotChoice;
import com.motif.agot.state.AgotGame;
import com.motif.shared.endpoint.MotifGraphqlUtil;
import com.motif.shared.endpoint.MotifUser;
import com.motif.shared.exceptions.MotifException;

import lombok.Getter;
import reactor.core.publisher.FluxSink;

public class AgotGameCache {

	private static HashMap<Long, AgotGameCache> cache = new HashMap<> (); 
	
	@Getter private final AgotGame game;
	
	private AgotTrigger trigger;
	private Optional<AgotTrigger> getTrigger () { return Optional.ofNullable (this.trigger); }
	public Optional<Collection<IAgotFlowRequest>> getPendingRequests () { return getTrigger ().map (t -> t.pendingRequests ()); }

	private Map<String, List<FluxSink<List<AAgotRequest>>>> requestSinksByUser = new HashMap<> ();
	public Publisher<List<AAgotRequest>> subscribeToRequests (MotifUser user) { return MotifGraphqlUtil.subscribe (this.requestSinksByUser, user); }
	
	private Map<String, List<FluxSink<AgotReduxActionList>>> changesSinksByUser = new HashMap<> ();
	public Publisher<AgotReduxActionList> subscribeToChanges (MotifUser user) { return MotifGraphqlUtil.subscribe (this.changesSinksByUser, user); }

	private AgotGameCache (AgotGame game) {
		this.game = game;
	} // AgotGameCache
	
	public static void newGameCache (AgotGame game) {
		var gameCache = new AgotGameCache (game);
		cache.put (game.id (), gameCache);
	} // newGameCache
	
	public static Optional<AgotGameCache> removeGameCache (long gameId) {
		var gameCache = cache.remove (gameId);
		return Optional.ofNullable (gameCache);
	} // removeGameCache

	public static Optional<AgotGameCache> getGameCache (long gameId) {
		return Optional.ofNullable (cache.get (gameId));
	} // getGameCache
	
	public static List<AgotGame> getGames () {
		return cache.values ().stream ().map (c -> c.game).collect (Collectors.toList ());
	} // getGames

	public void startGame (AgotContext context) throws MotifException {
		if (this.game.started ()) {
			throw new MotifException ("Game already started.");
		} else {
			this.game.setStarted (true, context);
			this.trigger = new AgotTrigger ();
			var requests = this.trigger.start (new AgotPlay (this.game), context);
			this.notify (requests, context);
		} // if - else
	} // startGame

	public void chooseAction (AgotChoice choice, AgotContext context) throws MotifException {
		var trigger = this.getTrigger ().orElseThrow ();
		var requests = trigger.receive (choice, context);
		this.notify (requests, context);
	} // chooseAction
	
	private void notify (List<IAgotFlowRequest> requests, AgotContext context) {
		// Notifico i cambiamenti a tutti gli utenti.
		var allUsers = this.game.players ()
				.map (p -> p.getUser ())
				.collect (Collectors.toSet ());
		var actions = context.actions();
		MotifGraphqlUtil.publish (actions, this.changesSinksByUser, allUsers);
		
		// Notifico le richieste ai rispetivi utenti.
		if (requests != null) {
			var requestsByUser = new HashMap<MotifUser, List<AAgotRequest>> ();
			requests.forEach (request -> {
				var player = request.getPlayer ();
				var user = player.getUser ();
				var userRequests = requestsByUser.get (user);
				if (userRequests == null) {
					userRequests = new ArrayList<AAgotRequest> ();
					requestsByUser.put (user, userRequests);
				} // if
				userRequests.add ((AAgotRequest) request);
			}); // forEach
			
			requestsByUser.forEach ((user, userRequests) -> {
				MotifGraphqlUtil.publish (userRequests, this.requestSinksByUser, user);
			}); // forEach			
		} // if
		
	} // notify
	
} // AgotCachedGame
