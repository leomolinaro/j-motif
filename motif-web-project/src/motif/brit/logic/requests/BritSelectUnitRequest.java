package motif.brit.logic.requests;

import java.util.List;

import motif.brit.endpoint.BritContext;
import motif.brit.flow.BritRequest;
import motif.brit.flow.BritRequest.BritChoice;
import motif.brit.flow.BritResponse;
import motif.brit.flow.IBritHumanIO;
import motif.brit.state.BritPlayer;
import motif.brit.state.BritUnit;

public class BritSelectUnitRequest {

	public static abstract class ABritSelectUnitRequestIO<U extends BritUnit> implements IBritHumanIO {
		@Override public BritRequest<?> request(BritContext context) { return new BritSelectUnitRequest().getRequest(this, context); }
		@Override public void response(BritResponse response, BritContext context) { new BritSelectUnitRequest().response(response, this, context); }
		public abstract List<U> getAvailableUnits();
		public abstract String getText();
		public abstract BritPlayer getPlayer();
		public abstract boolean canPass();
		private BritRequest<U> pendingRequest;
		public abstract void setUnit(U unit);
	}
	
	public <U extends BritUnit> BritRequest<U> getRequest(ABritSelectUnitRequestIO<U> IO, BritContext context) {
		IO.pendingRequest = BritRequest.createSelectUnitRequest (IO.getPlayer(), IO.getAvailableUnits(), IO.getText());
		if (IO.canPass()) { IO.pendingRequest.addPassOption(); }
		return IO.pendingRequest;
	}

	public <U extends BritUnit> void response(BritResponse response, ABritSelectUnitRequestIO<U> IO, BritContext context) {
		BritChoice<U> choice = IO.pendingRequest.getChoice(response);
		if (!(IO.canPass() && choice.isPass())) {
			U unit = IO.pendingRequest.getChoice(response).getModel();
			IO.setUnit(unit);			
		}
	}

}
