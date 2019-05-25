package com.motif.brit.endpoint;

import com.motif.brit.logic.flow.BritRequest;
import com.motif.brit.logic.flow.BritResponse;
import com.motif.brit.logic.flow.BritTrigger;
import com.motif.brit.logic.init.BritInitializer;
import com.motif.brit.logic.play.BritPlay;
import com.motif.brit.state.BritDatabase;
import com.motif.brit.state.BritGame;
import com.motif.brit.state.BritPlayer;
import com.motif.main.MotifWebsocketEndpoint;
import com.motif.shared.endpoint.messages.MessageOut;
import com.motif.shared.endpoint.messages.MessageOut.MotifApp;
import com.motif.shared.endpoint.sessions.MotifSession;
import com.motif.shared.endpoint.sessions.MotifSessionManager;
import com.motif.shared.endpoint.sessions.MotifUser;
import com.motif.shared.exceptions.MotifUnexpectedError;

public class BritEndpoint implements IBritSender {
	
	private BritGame game = null;
	private BritTrigger trigger;

	private static BritEndpoint instance;
	public static BritEndpoint getInstance () {
		if (instance == null) { instance = new BritEndpoint (); }
		return instance;
	}
	private BritEndpoint () {};
	
	private BritGame init () {
		BritInitializer initializer = new BritInitializer ();
		game = initializer.init ();
		return game;
	}

	public void initState (MotifSession session) {
		BritContext context = BritContext.create (session);
		if (game == null) {
			game = init ();
			new BritDatabase().insert(game);
		} 
		MessageOut message = new MessageOut (MotifApp.BRIT);
		message.setSession (session);
		message.setType (MessageOut.BRIT_REDUX_ACTION_LIST);
		BritRequest<?> request = null;
		if (trigger != null && trigger.hasPendingRequest ()) {
			BritRequest<?> pendingRequest = trigger.getPendingRequest ();
			if (context.getPlayerId ().equals (pendingRequest.getPlayer ().getId ())) {
				request = pendingRequest;
			}		
		}
		context.actions ().initState (game, context, request); 
		message.setData (context.actions ());
		MotifWebsocketEndpoint.send (message, session);
	}
	
	public void start(MotifSession session) {
		BritContext context = BritContext.create(session);
		if (!game.isStarted()) {
			game.setStarted(true, context);
			trigger = new BritTrigger(this);
			trigger.start(new BritPlay(game), context);
		}
	}

	public void actionChoice (BritResponse response, MotifSession session) throws MotifUnexpectedError {
		BritContext context = BritContext.create (session);
		trigger.receive (response, context);
	}
	
	public void send (BritRequest<?> request, BritContext context) {
		BritPlayer player = request.getPlayer ();
		MotifUser user = MotifSessionManager.getInstance ().getUser (player.getId ());
		BritReduxActionList actions = context.actions ();
		game.opponents (player).forEach (opponent -> {
			MotifUser oppUser = MotifSessionManager.getInstance ().getUser (opponent.getId ());
			if (oppUser != null) {
				actions.request (null);
				MessageOut oppMessage = new MessageOut (MotifApp.BRIT);
				oppMessage.setSession (context.getSession ());
				oppMessage.setType (MessageOut.BRIT_REDUX_ACTION_LIST);
				oppMessage.setData (actions);
				MotifWebsocketEndpoint.send (oppMessage, oppUser);
				actions.removeLast ();
			}
		});
		
		if (user != null) {
			actions.request (request);
			MessageOut message = new MessageOut (MotifApp.BRIT);
			message.setSession (context.getSession ());
			message.setType (MessageOut.BRIT_REDUX_ACTION_LIST);
			message.setData (actions);
			MotifWebsocketEndpoint.send (message, user);
			actions.removeLast ();
		}
		
	}
	
}
