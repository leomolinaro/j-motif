package com.motif.agot.logic.requests;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.state.AgotPlayer;

import lombok.Getter;

public class ContinueRequest extends AAgotRequest {

	private final String actionLabel;
	
	public ContinueRequest (String instruction, AgotPlayer player, IHasContinueRequest parent) {
		this ("Continue", instruction, player, parent);
	} // ContinueRequest
	
	public ContinueRequest (String actionLabel, String instruction, AgotPlayer player, IHasContinueRequest parent) {
		super(
				AgotRequestType.CONTINUE,
				player,
				instruction
		);
		this.parent = parent;
		this.actionLabel = actionLabel;
		this.addChoice (AgotChoice.continueChoice (actionLabel));
	} // ContinueRequest
	
	public interface IHasContinueRequest extends IAgotFlowProcess { public IAgotFlowStep after(ContinueRequest continueDecision, AgotContext context); }
	@Getter private final IHasContinueRequest parent; 
	@Override public IAgotFlowStep next(AgotContext context) { return this.parent.after(this, context); }
	
	@Override
	protected boolean acceptChoice (AgotChoice choice, AgotContext context) {
		return choice.equals (AgotChoice.continueChoice (actionLabel));
	} // acceptChoice
	
	@Override
	public AgotChoice getAutoChoice () {
		return null;
	} // getAutoChoice
	
} // ContinueRequest
