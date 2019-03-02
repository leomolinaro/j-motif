package motif.brit.logic.flow;

import com.google.gson.JsonElement;
import com.google.gson.annotations.Expose;

public class BritResponse {

	@Expose private String key;
	public String getKey () { return key; }
	
	@Expose private JsonElement payload;
	public JsonElement getPayload () { return payload; }
	
	public BritResponse (String key) {
		this.key = key;
	} // BritResponse
	
} // BritResponse
