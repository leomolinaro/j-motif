package com.motif.agot.logic.flow;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.endpoint.IAgotSender;

import lombok.Getter;

public class AgotTrigger {

	private IAgotSender sender;
	
	public AgotTrigger(IAgotSender sender) {
		this.sender = sender;
	}

	@Getter private IAgotFlowRequest pendingRequest;
	public boolean hasPendingRequest() { return this.pendingRequest != null; }
	
	public boolean receive(AgotResponse response, AgotContext context) {
		var request = this.pendingRequest;
		if (request.accept(response, context)) {
			this.pendingRequest = null;
			var nextStep = request.next(context);
			continueProcess(nextStep, request.getParent(), context);
			return true;
		} else {
			request.setRepeated();
			this.sender.send(request, context);
			return false;
		}
	}
	
	public void start(IAgotFlowProcess process, AgotContext context) {
		var flowStep = process.start(context);
		continueProcess(flowStep, process, context);
	}
	
	private void continueProcess(IAgotFlowStep flowStep, IAgotFlowProcess parentProcess, AgotContext context) {
		var sendRequest = false;
		var endFlow = false;
		do {
			if (flowStep == null) {
				flowStep = parentProcess.next(context);
				parentProcess = parentProcess.getParent();
				if (parentProcess == null) {
					endFlow = true;
				}
			} else if (flowStep instanceof IAgotFlowProcess) {
				parentProcess = (IAgotFlowProcess) flowStep;
				flowStep = parentProcess.start(context);
			} else {
				var request = (IAgotFlowRequest) flowStep;
				var autoResponse = request.getAutoResponse();
				if (autoResponse == null) {
					sendRequest = true;
				} else {
					request.accept(autoResponse, context);
					flowStep = request.next(context);
				}
			}
		} while (!sendRequest && !endFlow);
		if (sendRequest) {
			this.pendingRequest = (IAgotFlowRequest) flowStep;
			this.sender.send(this.pendingRequest, context);
		}
	}

}
