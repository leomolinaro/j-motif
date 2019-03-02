package motif.brit.logic.requests;

import lombok.RequiredArgsConstructor;
import motif.brit.endpoint.BritContext;
import motif.brit.logic.flow.BritRequest;
import motif.brit.logic.flow.BritResponse;
import motif.brit.logic.flow.IBritFlowDecision;
import motif.brit.state.BritPlayer;

@RequiredArgsConstructor
public abstract class BritContinueRequest implements IBritFlowDecision {

	private final String text;
	private final BritPlayer player;
	
	@Override
	public BritRequest<?> request(BritContext context) {
		BritRequest<?> pendingRequest = BritRequest.createContinueRequest(this.player, this.text);
		pendingRequest.addContinueOption ();
		return pendingRequest;
	}

	public void response (BritResponse response, BritContext context) {
	}

}
