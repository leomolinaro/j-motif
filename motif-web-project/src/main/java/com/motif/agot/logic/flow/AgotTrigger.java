package com.motif.agot.logic.flow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.requests.AgotChoice;
import com.motif.shared.exceptions.MotifException;

public class AgotTrigger {

	// N.B.: gestita al massimo una richiesta per giocatore.
	private Map<String, IAgotFlowRequest> pendingRequestsByPlayer = new HashMap<> ();
	public boolean hasPendingRequest() { return !this.pendingRequestsByPlayer.isEmpty (); }
	public Collection<IAgotFlowRequest> pendingRequests () { return this.pendingRequestsByPlayer.values (); }
	
	public List<IAgotFlowRequest> receive (AgotChoice choice, AgotContext context) throws MotifException {
		var request = this.pendingRequestsByPlayer.get (context.getPlayerId ());
		if (request == null) { throw new MotifException ("Player has not pending requests."); }
		if (request.accept (choice, context)) {
			this.pendingRequestsByPlayer.remove (context.getPlayerId ());
			var nextStep = request.next (context);
			var newRequests = continueProcess (nextStep, request.getParent (), context);
			return newRequests;
		} else {
			throw new MotifException ("Not valid choice.");
		} // if - else
	} // receive
	
	public List<IAgotFlowRequest> start (IAgotFlowProcess process, AgotContext context) {
		var flowStep = process.start (context);
		return continueProcess (flowStep, process, context);
	} // start
	
//	private List<IAgotFlowRequest> continueProcess1 (IAgotFlowStep flowStep, IAgotFlowStep parentStep,
//	        AgotContext context) {
//		var requests = new ArrayList<IAgotFlowRequest> ();
//		var endFlow = false;
//		do {
//			if (flowStep == null) {
//				flowStep = parentStep.next (context);
//				parentStep = parentStep.getParent ();
//				if (parentStep == null) {
//					endFlow = true;
//				} // if			
//			} else if (flowStep instanceof IAgotFlowProcess) {
//				var parentProcess = (IAgotFlowProcess) flowStep;
//				flowStep = parentProcess.start (context);
//				parentStep = parentProcess;
//			} else {
//				var request = (IAgotFlowRequest) flowStep;
//				var autoChoice = request.getAutoChoice ();
//				if (autoChoice == null) {
//					requests.add (request);
//					flowStep = null;
//				} else {
//					request.accept (autoChoice, context);
//					flowStep = request.next (context);
//				} // if - else
//			} // if - else
//		} while (requests.isEmpty () && !endFlow);
//		if (!requests.isEmpty ()) {
//			requests.forEach (request -> {
//				this.pendingRequestsByPlayer.put (request.getPlayer ().id (), request);
//			});
//			return requests;
//		} else {
//			return null;
//		}
//	} // continueProcess
	
	private List<IAgotFlowRequest> continueProcess (IAgotFlowStep flowStep, IAgotFlowStep parentStep,
	        AgotContext context) {
		var requests = new ArrayList<IAgotFlowRequest> ();
		continueProcess (flowStep, parentStep, requests, context);
		requests.forEach (request -> {
			this.pendingRequestsByPlayer.put (request.getPlayer ().id (), request);
		});
		return requests;
	}
	
	private void continueProcess (IAgotFlowStep flowStep, IAgotFlowStep parentStep, List<IAgotFlowRequest> requests,
	        AgotContext context) {
		if (flowStep == null) {
			var nextFlowStep = parentStep.next (context);
			var grandParentStep = parentStep.getParent ();
			if (grandParentStep != null) {
				continueProcess (nextFlowStep, grandParentStep, requests, context);
			} // if - else
		} else if (flowStep instanceof AgotFlowParallelSteps) {
			var flowParallel = (AgotFlowParallelSteps) flowStep;
			flowParallel.getSteps ().forEach (s -> continueProcess (s, parentStep, requests, context));
		} else if (flowStep instanceof IAgotFlowProcess) {
			var parentProcess = (IAgotFlowProcess) flowStep;
			var startFlowStep = parentProcess.start (context);
			continueProcess (startFlowStep, parentProcess, requests, context);
		} else if (flowStep instanceof AgotFlowStepWait) {
			
//		} else if (flowStep instanceof IAgotFlowFork) {
//			var parentFork = (IAgotFlowFork) flowStep;
//			var parallelSteps = parentFork.start (context);
//			parallelSteps.forEach (s -> continueProcess (s, parentFork, requests, context));
		} else {
			var request = (IAgotFlowRequest) flowStep;
			var autoChoice = request.getAutoChoice ();
			if (autoChoice == null) {
				requests.add (request);
			} else {
				request.accept (autoChoice, context);
				var nextFlowStep = request.next (context);
				continueProcess (nextFlowStep, parentStep, requests, context);
			} // if - else
		} // if - else
	} // continueProcess

} // AgotTrigger
