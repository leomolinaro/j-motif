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
import motif.brit.state.BritPlayer;
import motif.brit.state.BritUnit;

@RequiredArgsConstructor
public class BritSelectUnitRequest<U extends BritUnit> implements IBritFlowDecision {

	private final List<U> availableUnits;
	private final String text;
	private final BritPlayer player;
	private final boolean canPass;
	
	public interface IBritFlowWithSelectUnit<U extends BritUnit> extends IBritFlowProcess { public IBritFlowStep after(BritSelectUnitRequest<U> selectUnit, BritContext context); }
	@Getter private final IBritFlowWithSelectUnit<U> parent;
	@Override public IBritFlowStep next(BritContext context) { return this.parent.after(this, context); }
	
	private BritRequest<U> pendingRequest;
	@Getter private U unit;
	
	public BritRequest<U> request(BritContext context) {
		this.pendingRequest = BritRequest.createSelectUnitRequest(this.player, this.availableUnits, this.text);
		if (this.canPass) { this.pendingRequest.addPassOption(); }
		return this.pendingRequest;
	}

	public void response(BritResponse response, BritContext context) {
		BritChoice<U> choice = this.pendingRequest.getChoice(response);
		if (!(this.canPass && choice.isPass())) {
			U unit = this.pendingRequest.getChoice(response).getModel();
			this.unit = unit;			
		}
	}

}
