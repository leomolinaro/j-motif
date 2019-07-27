package com.motif.shared.util;

import com.motif.shared.endpoint.MotifUser;
import com.motif.shared.endpoint.messages.Message;
import com.motif.ws.MotifSession;

public class DebugUtil {

	public static void print (String string) {
		System.out.println (string);
	} // print
	
	public static void onOpen (MotifSession mSession) { print ("onOpen " + mSession.getUsername () + " " + mSession.getId ()); }
	
	public static void onClose (MotifSession mSession) { print ("onClose " + mSession.getUsername () + " " + mSession.getId ()); }
	
	public static void onError (MotifSession mSession, Throwable throwable) {
		print ("onError " + mSession.getUsername () + " " + mSession.getId ());
		throwable.printStackTrace ();
	} // onError
	
	public static void onMessage(Message message, MotifUser user) {
		print ("onMessage " + user.getUsername ());
		print ("	" + message);
	} // onMessage
	
	public static void todo (String string) { System.out.println ("TODO " + string); }
	
} // DebugUtil
