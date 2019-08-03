package com.motif.ws;

import java.io.IOException;
import java.util.Collection;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.motif.agot.endpoint.AgotEndpoint;
import com.motif.agot.endpoint.AgotGson;
import com.motif.agot.logic.flow.AgotResponse;
import com.motif.brit.endpoint.BritEndpoint;
import com.motif.brit.endpoint.BritGson;
import com.motif.brit.logic.flow.BritResponse;
import com.motif.shared.endpoint.MotifContext;
import com.motif.shared.endpoint.MotifUser;
import com.motif.shared.endpoint.messages.MessageDecoder;
import com.motif.shared.endpoint.messages.MessageEncoder;
import com.motif.shared.endpoint.messages.MessageIn;
import com.motif.shared.endpoint.messages.MessageOut;
import com.motif.shared.endpoint.messages.MessageOut.MotifApp;
import com.motif.shared.util.DebugUtil;

@ServerEndpoint(
	value = "/motif/websocket/{username}",
	decoders = MessageDecoder.class,
	encoders = MessageEncoder.class
)
public class MotifWebsocketEndpoint {
	
	private static MotifSessionManager sessionManager = MotifSessionManager.getInstance();
	private static AgotEndpoint agotEndpoint = AgotEndpoint.getInstance();
	private static BritEndpoint britEndpoint = BritEndpoint.getInstance ();
    
	@OnOpen
	public void onOpen(Session session, @PathParam("username") String username) throws IOException {
		var mSession = sessionManager.addSession(session, username);
		DebugUtil.onOpen(mSession);
		var message = new MessageOut(MotifApp.MOTIF);
		message.setUser(mSession.getUser());
		message.setType(MessageOut.NOTIFY_OPEN_CONNECTION);
		send(message, mSession);
	}
 
    @OnMessage
    public void onMessage (Session session, MessageIn message) throws IOException {
    	var mSession = sessionManager.getSession (session.getId ());
    	var user = mSession.getUser();
    	DebugUtil.onMessage(message, user);
    	var motifContext = new MotifContext(user);
    	switch (message.getType ()) {
    		case MessageIn.AGOT_INIT_STATE: agotEndpoint.initState(motifContext); break;
    		case MessageIn.AGOT_START: agotEndpoint.start(motifContext); break;
    		case MessageIn.AGOT_ACTION_CHOICE: agotEndpoint.actionChoice(AgotGson.g ().fromJson (message.getData (), AgotResponse.class), motifContext); break;
    		case MessageIn.BRIT_INIT_STATE: britEndpoint.initState(motifContext); break;
    		case MessageIn.BRIT_START: britEndpoint.start(motifContext); break;
    		case MessageIn.BRIT_ACTION_CHOICE: britEndpoint.actionChoice(BritGson.g ().fromJson (message.getData (), BritResponse.class), motifContext); break;
    	}
    }
 
	@OnClose
	public void onClose (Session session) throws IOException {
		MotifSession mSession = sessionManager.removeSession (session);
		DebugUtil.onClose (mSession);
		MessageOut message = new MessageOut (MotifApp.MOTIF);
		message.setUser (mSession.getUser ());
		message.setType (MessageOut.NOTIFY_CLOSE_CONNECTION);
		sendAll (message);
	}
 
	@OnError
	public void onError (Session session, Throwable throwable) {
		MotifSession mSession = sessionManager.getSession (session.getId ());
		DebugUtil.onError (mSession, throwable);
		MessageOut message = new MessageOut (MotifApp.MOTIF);
		message.setUser (mSession.getUser ());
		message.setType (MessageOut.NOTIFY_ERROR);
		message.setData (throwable.toString ());
		sendAll (message);
	}
	
	public static void send (MessageOut message, MotifSession toSession) {
		try {
			toSession.getSender ().sendObject (message);
		} catch (IOException | EncodeException e) {
			e.printStackTrace ();
		}
	}
	
	public static void sendAll (MessageOut message) {
		for (var session : sessionManager.sessions ()) {
			send (message, session);
		}
	}

	public static void send (MessageOut message, Collection<MotifUser> toUsers) {
		for (var toUser : toUsers) {
			send (message, toUser);
		}
	}

	public static void send (MessageOut message, MotifUser toUser) {
		for (var session : toUser.sessions ()) {
			send (message, session);
		}
	}
    
}
