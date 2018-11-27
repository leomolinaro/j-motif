package motif.brit.logic.requests;

import java.util.List;

import motif.brit.endpoint.BritContext;
import motif.brit.flow.BritRequest;
import motif.brit.flow.BritRequest.BritChoice;
import motif.brit.flow.BritResponse;
import motif.brit.flow.IBritHumanIO;
import motif.brit.state.BritArea;
import motif.brit.state.BritPlayer;


public class BritSelectAreaRequest {

	public static abstract class ABritSelectAreaRequestIO<A extends BritArea> implements IBritHumanIO {
		@Override public BritRequest<?> request(BritContext context) { return new BritSelectAreaRequest().getRequest(this, context); }
		@Override public void response(BritResponse response, BritContext context) { new BritSelectAreaRequest().response(response, this, context); }
		public abstract List<A> getAvailableAreas();
		public abstract String getText();
		public abstract BritPlayer getPlayer();
		public abstract boolean canPass();
		private BritRequest<A> pendingRequest;
		public abstract void setArea(A unit);
	}
	
	public <A extends BritArea> BritRequest<A> getRequest(ABritSelectAreaRequestIO<A> IO, BritContext context) {
		IO.pendingRequest = BritRequest.createSelectAreaRequest (IO.getPlayer(), IO.getAvailableAreas(), IO.getText());
		if (IO.canPass()) { IO.pendingRequest.addPassOption(); }
		return IO.pendingRequest;
	}

	public <A extends BritArea> void response(BritResponse response, ABritSelectAreaRequestIO<A> IO, BritContext context) {
		BritChoice<A> choice = IO.pendingRequest.getChoice(response);
		if (!(IO.canPass() && choice.isPass())) {
			A area = IO.pendingRequest.getChoice(response).getModel();
			IO.setArea(area);			
		}
	}

}
