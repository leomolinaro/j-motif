package com.motif.shared.endpoint.messages;

import com.google.gson.annotations.Expose;
import com.motif.shared.endpoint.MotifUser;

import lombok.Getter;
import lombok.Setter;

public class MessageOut extends Message {

	@Expose @Getter @Setter
	protected MotifUser user;
	
	public static final String NOTIFY_OPEN_CONNECTION = "[Motif] Notify Open Connection";
	public static final String ECHO_MESSAGE = "[Motif] Echo Message";
	public static final String NOTIFY_ERROR = "[Motif] Notify Error";
	public static final String NOTIFY_CLOSE_CONNECTION = "[Motif] Notify Close Connection";
	public static final String AGOT_REDUX_ACTION_LIST = "[Agot] Redux Action List";
	public static final String BRIT_REDUX_ACTION_LIST = "[Brit] Redux Action List";
	
	public enum MotifApp { MOTIF, AGOT, BRIT };
	
	@Expose private MotifApp app;
	public MotifApp getApp () { return app; }
	
	@Expose private Object data;
	public Object getData () { return data; }
	public void setData (Object data) { this.data = data; }
	
	public MessageOut (MotifApp app) {
		this.app = app;
	} // MessageOut
	
	@Override
	public String toString () {
		return "Message [data=" + data + ", type=" + type + "]";
	} // toString
	
} // MessageOut
