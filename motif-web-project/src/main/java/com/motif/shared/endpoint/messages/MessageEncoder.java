package com.motif.shared.endpoint.messages;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import com.motif.agot.endpoint.AgotGson;
import com.motif.brit.endpoint.BritGson;
import com.motif.shared.endpoint.MotifGson;

public class MessageEncoder implements Encoder.Text<MessageOut> {
	 
    @Override
    public String encode (MessageOut message) throws EncodeException {
    	switch (message.getApp ()) {
    		case MOTIF: return MotifGson.g ().toJson (message);
			case AGOT: return AgotGson.g ().toJson (message);
			case BRIT: return BritGson.g ().toJson (message);
			default: throw new EncodeException (message, "");
    	} // switch
    } // encode
 
    @Override
    public void init (EndpointConfig endpointConfig) {
        // Custom initialization logic
    } // init
 
    @Override
    public void destroy () {
        // Close resources
    } // destroy
    
} // MessageEncoder
