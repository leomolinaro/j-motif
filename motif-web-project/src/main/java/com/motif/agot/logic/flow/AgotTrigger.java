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
	
	private void request(IAgotFlowRequest decision, AgotContext context) {
		this.pendingRequest = decision;
		sender.send(pendingRequest, context);
	}
	
	public boolean receive(AgotResponse response, AgotContext context) {
		var request = this.pendingRequest;
		if (request.accept(response, context)) {
			this.pendingRequest = null;
			var nextStep = request.next(context);
			execute(nextStep, request.getParent(), context);
			return true;
		} else {
			request.setRepeated();
			this.sender.send(request, context);
			return false;
		}
	}
	
	public void start(IAgotFlowProcess process, AgotContext context) {
		IAgotFlowStep subStep = process.start(context);
		execute(subStep, process, context);
	}

	private void end(IAgotFlowProcess process, AgotContext context) {
		IAgotFlowStep nextStep = process.next(context);
		IAgotFlowProcess parentProcess = process.getParent();
		if (parentProcess != null) {
			execute(nextStep, parentProcess, context);
		}
	}
	
	private void execute(IAgotFlowStep flowStep, IAgotFlowProcess parentProcess, AgotContext context) {
		if (flowStep == null) {
			end(parentProcess, context);
		} else {
			if (flowStep instanceof IAgotFlowProcess) {
				start((IAgotFlowProcess) flowStep, context);
			} else {
				request((IAgotFlowRequest) flowStep, context);
			}
		}
	}

}
