package motif.brit.logic.requests;

import java.util.List;

import com.google.gson.annotations.Expose;

import motif.brit.endpoint.BritContext;
import motif.brit.endpoint.BritGson;
import motif.brit.flow.BritRequest;
import motif.brit.flow.BritRequest.BritChoice;
import motif.brit.flow.BritResponse;
import motif.brit.flow.IBritHumanIO;
import motif.brit.state.BritArea;
import motif.brit.state.BritPlayer;
	
public class BritSelectAreaSvgRequest {

	public static abstract class ABritSelectAreaSvgRequestIO<A extends BritArea> implements IBritHumanIO {
		@Override public BritRequest<?> request(BritContext context) { return new BritSelectAreaSvgRequest().getRequest(this, context); }
		@Override public void response(BritResponse response, BritContext context) { new BritSelectAreaSvgRequest().response(response, this, context); }
		public abstract List<A> getAvailableAreas();
		public abstract String getText();
		public abstract BritPlayer getPlayer();
		public abstract boolean canPass();
		private BritRequest<A> pendingRequest;
		public abstract void setArea(A unit);
		public abstract void setSvgX(double svgX);
		public abstract void setSvgY(double svgY);
	}
	
	public <A extends BritArea> BritRequest<A> getRequest(ABritSelectAreaSvgRequestIO<A> IO, BritContext context) {
		IO.pendingRequest = BritRequest.createSelectAreaRequest (IO.getPlayer(), IO.getAvailableAreas(), IO.getText());
		if (IO.canPass()) { IO.pendingRequest.addPassOption(); }
		return IO.pendingRequest;
	}

	public <A extends BritArea> void response(BritResponse response, ABritSelectAreaSvgRequestIO<A> IO, BritContext context) {
		BritChoice<A> choice = IO.pendingRequest.getChoice(response);
		if (!(IO.canPass() && choice.isPass())) {
			A area = IO.pendingRequest.getChoice(response).getModel();
			IO.setArea(area);
			Payload payload = BritGson.g ().fromJson (response.getPayload (), Payload.class);
			IO.setSvgX(payload.svgX);
			IO.setSvgY(payload.svgY);
		}
	}
	
	private static class Payload {
		@Expose private double svgX;
		@Expose private double svgY;
	}

}
