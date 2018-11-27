package motif.brit.endpoint;

import com.google.gson.annotations.Expose;

public class BritReduxAction {
	
	@Expose private String type;
	@Expose private ActionPayload payload;
	
	public BritReduxAction (String type, ActionPayload data) {
		super ();
		this.type = type;
		this.payload = data;
	} // BritReduxAction

	public static abstract class ActionPayload {
		
	} // ActionPayload
	
} // BritReduxAction
