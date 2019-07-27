package com.motif.shared.endpoint.messages;

import com.google.gson.JsonElement;
import com.google.gson.annotations.Expose;

public class MessageIn extends Message {
	
	public static final String AGOT_INIT_STATE = "[Agot] Init State";
	public static final String AGOT_START = "[Agot] Start";
	public static final String AGOT_ACTION_CHOICE = "[Agot] Action Choice";
	public static final String BRIT_INIT_STATE = "[Brit] Init State";
	public static final String BRIT_START = "[Brit] Start";
	public static final String BRIT_ACTION_CHOICE = "[Brit] Action Choice";

	@Expose private JsonElement data;
	public JsonElement getData () { return data; }
	
	@Override
	public String toString () {
		return "Message [data=" + data + ", type=" + type + "]";
	} // toString
	
} // MessageIn
