package com.motif.agot.logic.flow;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.endpoint.IAgotSender;

import lombok.Getter;

public class AgotTrigger {

	private IAgotSender sender;
	
	public AgotTrigger(IAgotSender sender) {
		this.sender = sender;
	}

	@Getter private IAgotFlowRequest pendingDecision;
	public boolean hasPendingDecision() { return this.pendingDecision != null; }
	
	private void request(IAgotFlowRequest decision, AgotContext context) {
		this.pendingDecision = decision;
		sender.send(pendingDecision, context);
	}
	
	public void receive(AgotResponse response, AgotContext context) {
		if (this.pendingDecision.isValidResponse(response)) {
			IAgotFlowRequest decision = this.pendingDecision;
			decision.response(response, context);
			this.pendingDecision = null;
			IAgotFlowStep nextStep = decision.next(context);
			execute(nextStep, decision.getParent(), context);
		} else {
			sender.send(this.pendingDecision, context);
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
