package motif.agot.flow.request;

import com.google.gson.annotations.Expose;

import motif.shared.flow.request.MotifClientResponse;

public class AgotResponse extends MotifClientResponse {

	@Expose private String command;
	public String getCommand () { return command; }
	
	public AgotResponse (String command) {
		this.command = command;
	} // AgotResponse
	
} // AgotClientResponse
