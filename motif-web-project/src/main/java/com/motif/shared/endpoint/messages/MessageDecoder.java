package com.motif.shared.endpoint.messages;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import com.motif.shared.endpoint.MotifGson;

public class MessageDecoder implements Decoder.Text<MessageIn> {
	  
    @Override
    public MessageIn decode (String json) throws DecodeException {    	
        return MotifGson.g ().fromJson (json, MessageIn.class);
    } // decode
 
    @Override
    public boolean willDecode (String s) {
        return (s != null);
    } // willDecode
 
    @Override
    public void init (EndpointConfig endpointConfig) {
        // Custom initialization logic
    } // init
 
    @Override
    public void destroy () {
        // Close resources
    } // destroy
    
} // MessageDecoder
