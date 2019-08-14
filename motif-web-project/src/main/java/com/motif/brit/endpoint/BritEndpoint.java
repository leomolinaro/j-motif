package com.motif.brit.endpoint;

import com.motif.brit.logic.flow.BritRequest;

public class BritEndpoint implements IBritSender {
	
//	private BritGame game = null;
//	private BritTrigger trigger;
//
//	private static BritEndpoint instance;
//	public static BritEndpoint getInstance () {
//		if (instance == null) { instance = new BritEndpoint (); }
//		return instance;
//	}
//	private BritEndpoint() {};
//	
//	private BritGame init(MotifContext context) {
//		BritInitializer initializer = new BritInitializer();
//		game = initializer.init(context.getUser());
//		return game;
//	}
//
//	public void initState (MotifContext context) {
//		if (game == null) {
//			game = init(context);
//			new BritDatabase().insert(game);
//		}
//		var message = new MessageOut(MotifApp.BRIT);
//		message.setUser(context.getUser());
//		message.setType(MessageOut.BRIT_REDUX_ACTION_LIST);
//		BritRequest<?> request = null;
//		if (trigger != null && trigger.hasPendingRequest()) {
//			BritRequest<?> pendingRequest = trigger.getPendingRequest();
//			if (context.getUser().getUsername().equals(pendingRequest.getPlayer().getUser().getUsername())) {
//				request = pendingRequest;
//			}
//		}
//		var actions = new BritReduxActionList();
//		var userPlayerIds = this.game.getPlayersByUser(context.getUser())
//				.map(p -> p.id())
//				.collect(Collectors.toList());
//		actions.initState(game, userPlayerIds, request); 
//		message.setData(actions);
//		MotifWebsocketEndpoint.send(message, context.getUser());
//	}
//	
//	public void start(MotifContext context) {
//		if (!this.game.isStarted()) {
//			var playContext = new BritContext(this.game.getAnyPlayerByUser(context.getUser()));
//			this.game.setStarted(true, playContext);
//			this.trigger = new BritTrigger(this);
//			this.trigger.start(new BritPlay(this.game), playContext);
//		}
//	}
//	
//
//	public void actionChoice (BritResponse response, MotifContext context) throws MotifUnexpectedError {
//		var player = this.game.getPlayer(response.getPlayerId());
//		var playContext = new BritContext(player);
//		trigger.receive (response, playContext);
//	}
//	
	public void send (BritRequest<?> request, BritContext context) {
//		var player = request.getPlayer ();
//		var user = player.getUser();
//		var sourceUser = context.getPlayer().getUser();
//		var actions = context.actions ();
//		
//		var oppUsers = this.game.opponents(player).map(p -> p.getUser()).collect(Collectors.toSet());
//		if (!oppUsers.isEmpty()) {
//			actions.request(null);
//			MessageOut oppMessage = new MessageOut(MotifApp.BRIT);
//			oppMessage.setUser(sourceUser);
//			oppMessage.setType(MessageOut.BRIT_REDUX_ACTION_LIST);
//			oppMessage.setData(actions);
//			MotifWebsocketEndpoint.send(oppMessage, oppUsers);
//			actions.removeLast();
//		}
//		
//		if (user != null) {
//			actions.request(request);
//			MessageOut message = new MessageOut(MotifApp.BRIT);
//			message.setUser(sourceUser);
//			message.setType(MessageOut.BRIT_REDUX_ACTION_LIST);
//			message.setData(actions);
//			MotifWebsocketEndpoint.send(message, user);
//			actions.removeLast();
//		}
//		
	}
	
}
