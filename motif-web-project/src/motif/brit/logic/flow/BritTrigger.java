package motif.brit.logic.flow;

import lombok.Getter;
import motif.brit.endpoint.BritContext;
import motif.brit.endpoint.IBritSender;

public class BritTrigger {

	private IBritSender sender;
	
	public BritTrigger(IBritSender sender) {
		this.sender = sender;
	}

	@Getter private BritRequest<?> pendingRequest;
	private IBritFlowDecision pendingDecision;
	public boolean hasPendingRequest () { return pendingRequest != null; }
	
	private void request(IBritFlowDecision decision, BritContext context) {
		BritRequest<?> request = decision.request(context);
		this.pendingRequest = request;
		this.pendingDecision = decision;
		sender.send(request, context);
	}
	
	public void receive(BritResponse response, BritContext context) {
		if (pendingRequest.isValidResponse(response)) {
			IBritFlowDecision decision = this.pendingDecision;
			decision.response(response, context);
			this.pendingRequest = null;
			this.pendingDecision = null;
			IBritFlowStep nextStep = decision.next(context);
			execute(nextStep, decision.getParent(), context);
		} else {
			sender.send(pendingRequest, context);
		}
	}
	
	public void start(IBritFlowProcess process, BritContext context) {
		IBritFlowStep subStep = process.start(context);
		execute(subStep, process, context);
	}

	private void end(IBritFlowProcess process, BritContext context) {
		IBritFlowStep nextStep = process.next(context);
		IBritFlowProcess parentProcess = process.getParent();
		if (parentProcess != null) {
			execute(nextStep, parentProcess, context);
		}
	}
	
	private void execute(IBritFlowStep flowStep, IBritFlowProcess parentProcess, BritContext context) {
		if (flowStep == null) {
			end(parentProcess, context);
		} else {
			if (flowStep instanceof IBritFlowProcess) {
				start((IBritFlowProcess) flowStep, context);
			} else {
				request((IBritFlowDecision) flowStep, context);
			}
		}
	}

}
