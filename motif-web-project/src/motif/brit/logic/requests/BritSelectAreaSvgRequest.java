package motif.brit.logic.requests;

import java.util.List;

import com.google.gson.annotations.Expose;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import motif.brit.endpoint.BritContext;
import motif.brit.endpoint.BritGson;
import motif.brit.logic.flow.BritRequest;
import motif.brit.logic.flow.BritResponse;
import motif.brit.logic.flow.IBritFlowDecision;
import motif.brit.logic.flow.IBritFlowProcess;
import motif.brit.logic.flow.IBritFlowStep;
import motif.brit.logic.flow.BritRequest.BritChoice;
import motif.brit.state.BritArea;
import motif.brit.state.BritPlayer;
	
@RequiredArgsConstructor
public class BritSelectAreaSvgRequest<A extends BritArea> implements IBritFlowDecision {

	private final List<A> availableAreas;
	private final String text;
	private final BritPlayer player;
	private final boolean canPass;
	
	public interface IBritFlowWithSelectAreaSvg<A extends BritArea> extends IBritFlowProcess { public IBritFlowStep after(BritSelectAreaSvgRequest<A> selectAreaSvg, BritContext context); }
	@Getter private final IBritFlowWithSelectAreaSvg<A> parent;
	@Override public IBritFlowStep next(BritContext context) { return this.parent.after(this, context); }
	
	private BritRequest<A> pendingRequest;
	
	@Getter private A area;
	@Getter private double svgX;
	@Getter private double svgY;
	
	@Override
	public BritRequest<A> request(BritContext context) {
		pendingRequest = BritRequest.createSelectAreaRequest (player, availableAreas, text);
		if (canPass) { pendingRequest.addPassOption(); }
		return pendingRequest;
	}

	@Override
	public void response(BritResponse response, BritContext context) {
		BritChoice<A> choice = pendingRequest.getChoice(response);
		if (!(canPass && choice.isPass())) {
			A area = pendingRequest.getChoice(response).getModel();
			this.area = area;
			Payload payload = BritGson.g ().fromJson (response.getPayload (), Payload.class);
			this.svgX = payload.svgX;
			this.svgY = payload.svgY;
		}
	}
	
	private static class Payload {
		@Expose private double svgX;
		@Expose private double svgY;
	}

}
