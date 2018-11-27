package motif.brit.logic.requests;

import motif.brit.endpoint.BritContext;
import motif.brit.flow.BritRequest;
import motif.brit.flow.BritResponse;
import motif.brit.flow.IBritHumanIO;
import motif.brit.state.BritPlayer;

public class BritContinueRequest {

	public static abstract class ABritContinueRequestIO implements IBritHumanIO {
		@Override public BritRequest<?> request(BritContext context) { return new BritContinueRequest().getRequest(this, context); }
		@Override public void response(BritResponse response, BritContext context) { new BritContinueRequest().response(response, this, context); }
		public abstract String getText();
		public abstract BritPlayer getPlayer();
	}
	
	public BritRequest<?> getRequest (ABritContinueRequestIO IO, BritContext context) {
		BritRequest<?> pendingRequest = BritRequest.createContinueRequest (IO.getPlayer (), IO.getText());
		pendingRequest.addContinueOption ();
		return pendingRequest;
	}

	public void response (BritResponse response, ABritContinueRequestIO IO, BritContext context) {
	}

}
