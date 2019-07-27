package com.motif.agot.endpoint;

import java.util.ArrayList;
import java.util.stream.Collectors;

import com.motif.agot.ang.deck.InputPlayer;
import com.motif.agot.ang.enums.AngFaction;
import com.motif.agot.ang.sets.AgotCardSeed;
import com.motif.agot.logic.AgotPlay;
import com.motif.agot.logic.flow.AgotResponse;
import com.motif.agot.logic.flow.AgotTrigger;
import com.motif.agot.logic.flow.IAgotFlowRequest;
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
	
	public AgotGame init(MotifContext context) {
		
		var leo = new AgotPlayer("leo", "Leo", context.getUser());
		var fede = new AgotPlayer("fede", "Fede", context.getUser());
		
		game = new AgotGame ();
		game.initPlayer (leo);
		game.initPlayer (fede);
		
		game.initFaction (fede, AngFaction.TARGARYEN);
		game.initCard (fede, AgotCardSeed.A_NOBLE_CAUSE_Core, 2);
		game.initCard (fede, AgotCardSeed.BRAIDED_WARRIOR_Core, 3);
		game.initCard (fede, AgotCardSeed.DAENERYS_TARGARYEN_Core, 3);
		game.initCard (fede, AgotCardSeed.DROGON_Core, 3);
		game.initCard (fede, AgotCardSeed.HANDMAIDEN_Core, 3);
		game.initCard (fede, AgotCardSeed.KHAL_DROGO_Core, 3);
		game.initCard (fede, AgotCardSeed.LITTLEFINGER_Core, 2);
		game.initCard (fede, AgotCardSeed.MAGISTER_ILLYRIO_Core, 2);
		game.initCard (fede, AgotCardSeed.RHAEGAL_Core, 3);
		game.initCard (fede, AgotCardSeed.SER_JORAH_MORMONT_Core, 3);
		game.initCard (fede, AgotCardSeed.TARGARYEN_LOYALIST_Core, 3);
		game.initCard (fede, AgotCardSeed.UNSULLIED_Core, 3);
		game.initCard (fede, AgotCardSeed.VISERION_Core, 3);
		game.initCard (fede, AgotCardSeed.VISERYS_TARGARYEN_Core, 2);
		game.initCard (fede, AgotCardSeed.MILK_OF_THE_POPPY_Core, 2);
		game.initCard (fede, AgotCardSeed.SEAL_OF_THE_HAND_Core, 2);
		game.initCard (fede, AgotCardSeed.ILLYRIOS_ESTATE_Core, 3);
		game.initCard (fede, AgotCardSeed.PLAZA_OF_PUNISHMENT_Core, 3);
		game.initCard (fede, AgotCardSeed.THE_IRON_THRONE_Core, 1);
		game.initCard (fede, AgotCardSeed.THE_KINGSROAD_Core, 3);
		game.initCard (fede, AgotCardSeed.THE_ROSEROAD_Core, 3);
		game.initCard (fede, AgotCardSeed.DRACARYS_Core, 3);
		game.initCard (fede, AgotCardSeed.FIRE_AND_BLOOD_Core, 2);
		game.initCard (fede, AgotCardSeed.WAKING_THE_DRAGON_Core, 2);
		
		game.initFaction (leo, AngFaction.BARATHEON);
		game.initCard (leo, AgotCardSeed.A_FEAST_FOR_CROWS_Core, 1);
		game.initCard (leo, AgotCardSeed.A_NOBLE_CAUSE_Core, 1);
		game.initCard (leo, AgotCardSeed.SHIREEN_BARATHEON_Core, 5);
		game.initCard (leo, AgotCardSeed.LITTLEFINGER_Core, 5);
		game.initCard (leo, AgotCardSeed.MELISANDRE_Core, 3);
		game.initCard (leo, AgotCardSeed.SEAL_OF_THE_HAND_Core, 3);
		game.initCard (leo, AgotCardSeed.BODYGUARD_Core, 2);
		game.initCard (leo, AgotCardSeed.FIERY_FOLLOWERS_Core, 5);
		
//		game.initFaction (fede, AngFaction.TARGARYEN);
//		game.initCard (fede, AgotCardEnum.A_NOBLE_CAUSE, 2);
//		game.initCard (fede, AgotCardEnum.CONFISCATION, 1);
//		game.initCard (fede, AgotCardEnum.COUNTING_COPPERS, 1);
//		game.initCard (fede, AgotCardEnum.FILTHY_ACCUSATIONS, 1);
//		game.initCard (fede, AgotCardEnum.MARCHED_TO_THE_WALL, 1);
//		game.initCard (fede, AgotCardEnum.WILDFIRE_ASSAULT, 1);
//		game.initCard (fede, AgotCardEnum.BRAIDED_WARRIOR, 3);
//		game.initCard (fede, AgotCardEnum.DAENERYS_TARGARYEN, 3);
//		game.initCard (fede, AgotCardEnum.DROGON, 3);
//		game.initCard (fede, AgotCardEnum.HANDMAIDEN, 3);
//		game.initCard (fede, AgotCardEnum.KHAL_DROGO, 3);
//		game.initCard (fede, AgotCardEnum.LITTLEFINGER, 2);
//		game.initCard (fede, AgotCardEnum.MAGISTER_ILLYRIO, 2);
//		game.initCard (fede, AgotCardEnum.RHAEGAL, 3);
//		game.initCard (fede, AgotCardEnum.SER_JORAH_MORMONT, 3);
//		game.initCard (fede, AgotCardEnum.TARGARYEN_LOYALIST, 3);
//		game.initCard (fede, AgotCardEnum.UNSULLIED, 3);
//		game.initCard (fede, AgotCardEnum.VISERION, 3);
//		game.initCard (fede, AgotCardEnum.VISERYS_TARGARYEN, 2);
//		game.initCard (fede, AgotCardEnum.MILK_OF_THE_POPPY, 2);
//		game.initCard (fede, AgotCardEnum.SEAL_OF_THE_HAND, 2);
//		game.initCard (fede, AgotCardEnum.ILLYRIOS_ESTATE, 3);
//		game.initCard (fede, AgotCardEnum.PLAZA_OF_PUNISHMENT, 3);
//		game.initCard (fede, AgotCardEnum.THE_IRON_THRONE, 1);
//		game.initCard (fede, AgotCardEnum.THE_KINGSROAD, 3);
//		game.initCard (fede, AgotCardEnum.THE_ROSEROAD, 3);
//		game.initCard (fede, AgotCardEnum.DRACARYS, 3);
//		game.initCard (fede, AgotCardEnum.FIRE_AND_BLOOD, 2);
//		game.initCard (fede, AgotCardEnum.WAKING_THE_DRAGON, 2);
		
//		game.initFaction (leo, AngFaction.BARATHEON);
//		game.initCard (leo, AgotCardEnum.A_FEAST_FOR_CROWS, 1);
//		game.initCard (leo, AgotCardEnum.A_NOBLE_CAUSE, 1);
//		game.initCard (leo, AgotCardEnum.CONFISCATION, 1);
//		game.initCard (leo, AgotCardEnum.FILTHY_ACCUSATIONS, 2);
//		game.initCard (leo, AgotCardEnum.SUMMONS, 1);
//		game.initCard (leo, AgotCardEnum.WILDFIRE_ASSAULT, 1);
//		game.initCard (leo, AgotCardEnum.BASTARD_IN_HIDING, 3);
//		game.initCard (leo, AgotCardEnum.DRAGONSTONE_FAITHFUL, 3);
//		game.initCard (leo, AgotCardEnum.FIERY_FOLLOWERS, 3);
//		game.initCard (leo, AgotCardEnum.KINGS_HUNTING_PARTY, 1);
//		game.initCard (leo, AgotCardEnum.LITTLEFINGER, 2);
//		game.initCard (leo, AgotCardEnum.MAESTER_CRESSEN, 2);
//		game.initCard (leo, AgotCardEnum.MELISANDRE, 3);
//		game.initCard (leo, AgotCardEnum.ROBERT_BARATHEON, 3);
//		game.initCard (leo, AgotCardEnum.SELYSE_BARATHEON, 2);
//		game.initCard (leo, AgotCardEnum.SER_DAVOS_SEAWORTH, 2);
//		game.initCard (leo, AgotCardEnum.SHIREEN_BARATHEON, 1);
//		game.initCard (leo, AgotCardEnum.STANNIS_BARATHEON, 3);
//		game.initCard (leo, AgotCardEnum.VANGUARD_LANCER, 2);
//		game.initCard (leo, AgotCardEnum.BODYGUARD, 1);
//		game.initCard (leo, AgotCardEnum.LIGHTBRINGER, 1);
//		game.initCard (leo, AgotCardEnum.MILK_OF_THE_POPPY, 3);
//		game.initCard (leo, AgotCardEnum.SEAL_OF_THE_HAND, 1);
//		game.initCard (leo, AgotCardEnum.CHAMBER_OF_THE_PAINTED_TABLE, 2);
//		game.initCard (leo, AgotCardEnum.DRAGONSTONE_PORT, 3);
//		game.initCard (leo, AgotCardEnum.THE_IRON_THRONE, 2);
//		game.initCard (leo, AgotCardEnum.THE_KINGSROAD, 3);
//		game.initCard (leo, AgotCardEnum.THE_RED_KEEP, 3);
//		game.initCard (leo, AgotCardEnum.THE_ROSEROAD, 3);
//		game.initCard (leo, AgotCardEnum.CONSOLIDATION_OF_POWER, 3);
//		game.initCard (leo, AgotCardEnum.OURS_IS_THE_FURY, 2);
//		game.initCard (leo, AgotCardEnum.SEEN_IN_FLAMES, 3);
		
		return game;
		
	}

	public void initState(MotifContext context) {
		if (game == null) { return; } //game = init(context); } 
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
		var userPlayerIds = this.game.getPlayersByUser(context.getUser())
				.map(p -> p.id())
				.collect(Collectors.toList());
		actions.initState(game, userPlayerIds, request); 
		message.setData(actions);
		MotifWebsocketEndpoint.send(message, context.getUser());
	}
	
	public void start(MotifContext context) {
		if (!this.game.isStarted()) {
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

	@GraphQLQuery
	public AgotGame game() {
		return this.game;
	}
	
}
