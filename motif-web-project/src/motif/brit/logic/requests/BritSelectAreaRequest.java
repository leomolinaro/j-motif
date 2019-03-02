package motif.brit.logic.requests;

import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import motif.brit.endpoint.BritContext;
import motif.brit.logic.flow.BritRequest;
import motif.brit.logic.flow.BritResponse;
import motif.brit.logic.flow.IBritFlowDecision;
import motif.brit.logic.flow.IBritFlowProcess;
import motif.brit.logic.flow.IBritFlowStep;
import motif.brit.logic.flow.BritRequest.BritChoice;
import motif.brit.state.BritArea;
import motif.brit.state.BritPlayer;
	
@RequiredArgsConstructor
public class BritSelectAreaRequest<A extends BritArea> implements IBritFlowDecision {

	private final List<A> availableAreas;
	private final String text;
	private final BritPlayer player;
	private final boolean canPass;
	
	public interface IBritAfterSelectArea<A extends BritArea> extends IBritFlowProcess { public IBritFlowStep after(BritSelectAreaRequest<A> selectAreaSvg, BritContext context); }
	@Getter private final IBritAfterSelectArea<A> parent;
	@Override public IBritFlowStep next(BritContext context) { return this.parent.after(this, context); }
	
	private BritRequest<A> pendingRequest;
	
	@Getter private A area;
	
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
		}
	}

}
