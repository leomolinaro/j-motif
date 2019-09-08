package com.motif.agot.logic.flow;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.motif.agot.endpoint.AgotContext;

import lombok.Getter;

public class AgotFlowParallelSteps implements IAgotFlowStep {

	@Getter private final List<IAgotFlowStep> steps;
	
	private AgotFlowParallelSteps (List<IAgotFlowStep> steps) {
		this.steps = steps;
	} // AgotFlowParallelSteps
	
	public static AgotFlowStepWait getFlowWait () { return new AgotFlowStepWait (); }
	public static AgotFlowParallelSteps of (Stream<IAgotFlowStep> stepStream) { return of (stepStream.collect (Collectors.toList ())); }
	public static AgotFlowParallelSteps of (List<IAgotFlowStep> stepList) { return new AgotFlowParallelSteps (stepList); }

	@Override
	public IAgotFlowStep getParent () {
		return null;
	}

	@Override
	public IAgotFlowStep next (AgotContext context) {
		return null;
	}
	
} // IAgotFlowParallel
