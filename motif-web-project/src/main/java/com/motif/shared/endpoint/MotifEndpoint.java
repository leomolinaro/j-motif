package com.motif.shared.endpoint;

import java.io.IOException;

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
import com.motif.agot.flow.request.AgotResponse;
import com.motif.brit.endpoint.BritEndpoint;
import com.motif.brit.endpoint.BritGson;
import com.motif.brit.logic.flow.BritResponse;
import com.motif.shared.endpoint.messages.MessageDecoder;
import com.motif.shared.endpoint.messages.MessageEncoder;
import com.motif.shared.endpoint.messages.MessageIn;
import com.motif.shared.endpoint.messages.MessageOut;
import com.motif.shared.endpoint.messages.MessageOut.MotifApp;
import com.motif.shared.endpoint.sessions.MotifSession;
import com.motif.shared.endpoint.sessions.MotifSessionManager;
import com.motif.shared.endpoint.sessions.MotifUser;
import com.motif.shared.util.DebugUtil;

@ServerEndpoint(
	value = "/motif/{username}",
	decoders = MessageDecoder.class,
	encoders = MessageEncoder.class
) // @ServerEndpoint
public class MotifEndpoint {
	
    private static MotifSessionManager sessionManager = MotifSessionManager.getInstance ();
    private static AgotEndpoint agotEndpoint = AgotEndpoint.getInstance ();
    private static BritEndpoint britEndpoint = BritEndpoint.getInstance ();
    
    @OnOpen
    public void onOpen (Session session, @PathParam("username") String username) throws IOException {
    	MotifSession mSession = sessionManager.addSession (session, username);
    	DebugUtil.onOpen (mSession);
    	MessageOut message = new MessageOut (MotifApp.MOTIF);
        message.setSession (mSession);
        message.setType (MessageOut.NOTIFY_OPEN_CONNECTION);        
        sendAll (message);
    } // onOpen
 
    @OnMessage
    public void onMessage (Session session, MessageIn message) throws IOException {
    	MotifSession mSession = sessionManager.getSession (session.getId ());
    	message.setSession (mSession);
    	DebugUtil.onMessage (message);
    	switch (message.getType ()) {
    		case MessageIn.AGOT_INIT_STATE: agotEndpoint.initState (mSession); break;
    		case MessageIn.AGOT_START: agotEndpoint.start (mSession); break;
    		case MessageIn.AGOT_ACTION_CHOICE: agotEndpoint.actionChoice (AgotGson.g ().fromJson (message.getData (), AgotResponse.class), mSession); break;
    		case MessageIn.BRIT_INIT_STATE: britEndpoint.initState (mSession); break;
    		case MessageIn.BRIT_START: britEndpoint.start (mSession); break;
    		case MessageIn.BRIT_ACTION_CHOICE: britEndpoint.actionChoice (BritGson.g ().fromJson (message.getData (), BritResponse.class), mSession); break;
    	} // switch
    } // onMessage
 
    @OnClose
    public void onClose (Session session) throws IOException {
    	MotifSession mSession = sessionManager.removeSession (session);
    	DebugUtil.onClose (mSession);
    	MessageOut message = new MessageOut (MotifApp.MOTIF);
        message.setSession (mSession);
        message.setType (MessageOut.NOTIFY_CLOSE_CONNECTION);        
        sendAll (message);
    } // onClose
 
    @OnError
    public void onError (Session session, Throwable throwable) {
    	MotifSession mSession = sessionManager.getSession (session.getId ());
    	DebugUtil.onError (mSession, throwable); 
    	MessageOut message = new MessageOut (MotifApp.MOTIF);
        message.setSession (mSession);
        message.setType (MessageOut.NOTIFY_ERROR);
        message.setData (throwable.toString ());
        sendAll (message);
    } // onError
	
	public static void send (MessageOut message, MotifSession toSession) {
		try {
			toSession.getSender ().sendObject (message);
		} catch (IOException | EncodeException e) {
			e.printStackTrace ();
		} // try - catch
	} // send
	
	public static void sendAll (MessageOut message) {
    	for (MotifSession session : sessionManager.sessions ()) {
    		send (message, session);    		
    	} // for
	} // broadcast
	
	public static void send (MessageOut message, MotifUser toUser) {
		for (MotifSession session : toUser.sessions ()) {
			send (message, session);
		} // for
	} // send
    
} // MotifEndpoint
