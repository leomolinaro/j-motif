package com.motif.agot.endpoint;

import com.motif.agot.ang.enums.AngFaction;
import com.motif.agot.ang.sets.CoreSet;
import com.motif.agot.endpoint.clientstate.AgotReduxActionList;
import com.motif.agot.flow.request.AgotRequest;
import com.motif.agot.flow.request.AgotResponse;
import com.motif.agot.logic.GameFlow;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;
import com.motif.shared.endpoint.MotifEndpoint;
import com.motif.shared.endpoint.messages.MessageOut;
import com.motif.shared.endpoint.messages.MessageOut.MotifApp;
import com.motif.shared.endpoint.sessions.MotifSession;
import com.motif.shared.endpoint.sessions.MotifSessionManager;
import com.motif.shared.endpoint.sessions.MotifUser;
import com.motif.shared.exceptions.MotifUnexpectedError;
import com.motif.shared.flow.IMotifSender;
import com.motif.shared.flow.TaskTrigger;

public class AgotEndpoint implements IMotifSender<AgotContext, AgotRequest<?>> {

	private AgotGame game = null;
	private boolean gameStarted = false;
	private TaskTrigger<AgotContext, AgotRequest<?>, AgotResponse> trigger;

	private static AgotEndpoint instance;
	public static AgotEndpoint getInstance () {
		if (instance == null) { instance = new AgotEndpoint (); }
		return instance;
	} // getInstance
	private AgotEndpoint () {};
	
	private AgotGame init () {
		
		AgotPlayer leo = new AgotPlayer ("leo", "Leo");
		AgotPlayer fede = new AgotPlayer ("fede", "Fede");
		
		game = new AgotGame ();
		game.initPlayer (leo);
		game.initPlayer (fede);
		
		game.initFaction (fede, AngFaction.TARGARYEN);
		game.initCard (fede, CoreSet.A_NOBLE_CAUSE, 2);
		game.initCard (fede, CoreSet.BRAIDED_WARRIOR, 3);
		game.initCard (fede, CoreSet.DAENERYS_TARGARYEN, 3);
		game.initCard (fede, CoreSet.DROGON, 3);
		game.initCard (fede, CoreSet.HANDMAIDEN, 3);
		game.initCard (fede, CoreSet.KHAL_DROGO, 3);
		game.initCard (fede, CoreSet.LITTLEFINGER, 2);
		game.initCard (fede, CoreSet.MAGISTER_ILLYRIO, 2);
		game.initCard (fede, CoreSet.RHAEGAL, 3);
		game.initCard (fede, CoreSet.SER_JORAH_MORMONT, 3);
		game.initCard (fede, CoreSet.TARGARYEN_LOYALIST, 3);
		game.initCard (fede, CoreSet.UNSULLIED, 3);
		game.initCard (fede, CoreSet.VISERION, 3);
		game.initCard (fede, CoreSet.VISERYS_TARGARYEN, 2);
		game.initCard (fede, CoreSet.MILK_OF_THE_POPPY, 2);
		game.initCard (fede, CoreSet.SEAL_OF_THE_HAND, 2);
		game.initCard (fede, CoreSet.ILLYRIOS_ESTATE, 3);
		game.initCard (fede, CoreSet.PLAZA_OF_PUNISHMENT, 3);
		game.initCard (fede, CoreSet.THE_IRON_THRONE, 1);
		game.initCard (fede, CoreSet.THE_KINGSROAD, 3);
		game.initCard (fede, CoreSet.THE_ROSEROAD, 3);
		game.initCard (fede, CoreSet.DRACARYS, 3);
		game.initCard (fede, CoreSet.FIRE_AND_BLOOD, 2);
		game.initCard (fede, CoreSet.WAKING_THE_DRAGON, 2);
		
		game.initFaction (leo, AngFaction.BARATHEON);
		game.initCard (leo, CoreSet.A_FEAST_FOR_CROWS, 1);
		game.initCard (leo, CoreSet.A_NOBLE_CAUSE, 1);
		game.initCard (leo, CoreSet.SHIREEN_BARATHEON, 5);
		game.initCard (leo, CoreSet.LITTLEFINGER, 5);
		game.initCard (leo, CoreSet.MELISANDRE, 3);
		game.initCard (leo, CoreSet.SEAL_OF_THE_HAND, 3);
		game.initCard (leo, CoreSet.BODYGUARD, 2);
		game.initCard (leo, CoreSet.FIERY_FOLLOWERS, 5);
		
//		game.initFaction (fede, AngFaction.TARGARYEN);
//		game.initCard (fede, CoreSet.A_NOBLE_CAUSE, 2);
//		game.initCard (fede, CoreSet.CONFISCATION, 1);
//		game.initCard (fede, CoreSet.COUNTING_COPPERS, 1);
//		game.initCard (fede, CoreSet.FILTHY_ACCUSATIONS, 1);
//		game.initCard (fede, CoreSet.MARCHED_TO_THE_WALL, 1);
//		game.initCard (fede, CoreSet.WILDFIRE_ASSAULT, 1);
//		game.initCard (fede, CoreSet.BRAIDED_WARRIOR, 3);
//		game.initCard (fede, CoreSet.DAENERYS_TARGARYEN, 3);
//		game.initCard (fede, CoreSet.DROGON, 3);
//		game.initCard (fede, CoreSet.HANDMAIDEN, 3);
//		game.initCard (fede, CoreSet.KHAL_DROGO, 3);
//		game.initCard (fede, CoreSet.LITTLEFINGER, 2);
//		game.initCard (fede, CoreSet.MAGISTER_ILLYRIO, 2);
//		game.initCard (fede, CoreSet.RHAEGAL, 3);
//		game.initCard (fede, CoreSet.SER_JORAH_MORMONT, 3);
//		game.initCard (fede, CoreSet.TARGARYEN_LOYALIST, 3);
//		game.initCard (fede, CoreSet.UNSULLIED, 3);
//		game.initCard (fede, CoreSet.VISERION, 3);
//		game.initCard (fede, CoreSet.VISERYS_TARGARYEN, 2);
//		game.initCard (fede, CoreSet.MILK_OF_THE_POPPY, 2);
//		game.initCard (fede, CoreSet.SEAL_OF_THE_HAND, 2);
//		game.initCard (fede, CoreSet.ILLYRIOS_ESTATE, 3);
//		game.initCard (fede, CoreSet.PLAZA_OF_PUNISHMENT, 3);
//		game.initCard (fede, CoreSet.THE_IRON_THRONE, 1);
//		game.initCard (fede, CoreSet.THE_KINGSROAD, 3);
//		game.initCard (fede, CoreSet.THE_ROSEROAD, 3);
//		game.initCard (fede, CoreSet.DRACARYS, 3);
//		game.initCard (fede, CoreSet.FIRE_AND_BLOOD, 2);
//		game.initCard (fede, CoreSet.WAKING_THE_DRAGON, 2);
		
//		game.initFaction (leo, AngFaction.BARATHEON);
//		game.initCard (leo, CoreSet.A_FEAST_FOR_CROWS, 1);
//		game.initCard (leo, CoreSet.A_NOBLE_CAUSE, 1);
//		game.initCard (leo, CoreSet.CONFISCATION, 1);
//		game.initCard (leo, CoreSet.FILTHY_ACCUSATIONS, 2);
//		game.initCard (leo, CoreSet.SUMMONS, 1);
//		game.initCard (leo, CoreSet.WILDFIRE_ASSAULT, 1);
//		game.initCard (leo, CoreSet.BASTARD_IN_HIDING, 3);
//		game.initCard (leo, CoreSet.DRAGONSTONE_FAITHFUL, 3);
//		game.initCard (leo, CoreSet.FIERY_FOLLOWERS, 3);
//		game.initCard (leo, CoreSet.KINGS_HUNTING_PARTY, 1);
//		game.initCard (leo, CoreSet.LITTLEFINGER, 2);
//		game.initCard (leo, CoreSet.MAESTER_CRESSEN, 2);
//		game.initCard (leo, CoreSet.MELISANDRE, 3);
//		game.initCard (leo, CoreSet.ROBERT_BARATHEON, 3);
//		game.initCard (leo, CoreSet.SELYSE_BARATHEON, 2);
//		game.initCard (leo, CoreSet.SER_DAVOS_SEAWORTH, 2);
//		game.initCard (leo, CoreSet.SHIREEN_BARATHEON, 1);
//		game.initCard (leo, CoreSet.STANNIS_BARATHEON, 3);
//		game.initCard (leo, CoreSet.VANGUARD_LANCER, 2);
//		game.initCard (leo, CoreSet.BODYGUARD, 1);
//		game.initCard (leo, CoreSet.LIGHTBRINGER, 1);
//		game.initCard (leo, CoreSet.MILK_OF_THE_POPPY, 3);
//		game.initCard (leo, CoreSet.SEAL_OF_THE_HAND, 1);
//		game.initCard (leo, CoreSet.CHAMBER_OF_THE_PAINTED_TABLE, 2);
//		game.initCard (leo, CoreSet.DRAGONSTONE_PORT, 3);
//		game.initCard (leo, CoreSet.THE_IRON_THRONE, 2);
//		game.initCard (leo, CoreSet.THE_KINGSROAD, 3);
//		game.initCard (leo, CoreSet.THE_RED_KEEP, 3);
//		game.initCard (leo, CoreSet.THE_ROSEROAD, 3);
//		game.initCard (leo, CoreSet.CONSOLIDATION_OF_POWER, 3);
//		game.initCard (leo, CoreSet.OURS_IS_THE_FURY, 2);
//		game.initCard (leo, CoreSet.SEEN_IN_FLAMES, 3);
		
		return game;
		
	} // init	

	public void initState (MotifSession session) {
		AgotContext context = AgotContext.create (session);
		if (game == null) { game = init (); } 
		MessageOut message = new MessageOut (MotifApp.AGOT);
		message.setSession (session);
		message.setType (MessageOut.AGOT_REDUX_ACTION_LIST);
		AgotRequest<?> request = null;
		if (trigger != null && trigger.hasPendingRequest ()) {
			AgotRequest<?> pendingRequest = trigger.getPendingRequest ();
			if (context.getPlayer ().equals (pendingRequest.getPlayer ().getUsername ())) {
				request = pendingRequest;
			} // if			
		} // if
		context.actions ().initState (game, context, request); 
		message.setData (context.actions ());
		MotifEndpoint.send (message, session);
	} // initState
	
	public void start (MotifSession session) {
		AgotContext context = AgotContext.create (session);
		if (!gameStarted) {
			gameStarted = true;
			trigger = new TaskTrigger<AgotContext, AgotRequest<?>, AgotResponse> (this);
			trigger.start (new GameFlow (game), context);
		} // if
	} // start

	public void actionChoice (AgotResponse response, MotifSession session) throws MotifUnexpectedError {
		AgotContext context = AgotContext.create (session);
		trigger.receive (response, context);
	} // actionChoice
	
	@Override
	public void send (AgotRequest<?> request, AgotContext context) {
		AgotPlayer player = request.getPlayer ();
		MotifUser user = MotifSessionManager.getInstance ().getUser (player.getUsername ());
		AgotPlayer oppPlayer = player.getNextPlayer ();
		MotifUser oppUser = MotifSessionManager.getInstance ().getUser (oppPlayer.getUsername ());
		AgotReduxActionList actions = context.actions ();
		
		if (oppUser != null) {
			actions.request (null);
			MessageOut oppMessage = new MessageOut (MotifApp.AGOT);
			oppMessage.setSession (context.getSession ());
			oppMessage.setType (MessageOut.AGOT_REDUX_ACTION_LIST);
			oppMessage.setData (actions);
			MotifEndpoint.send (oppMessage, oppUser);
			actions.removeLast ();
		} // if
		
		if (user != null) {
			actions.request (request);
			MessageOut message = new MessageOut (MotifApp.AGOT);
			message.setSession (context.getSession ());
			message.setType (MessageOut.AGOT_REDUX_ACTION_LIST);
			message.setData (actions);
			MotifEndpoint.send (message, user);
			actions.removeLast ();
		} // if
		
	} // send

} // AgotEndpoint
