package com.motif.agot.logic.requests;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.AgotResponse;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.state.AgotPlayer;

import lombok.Getter;

public class ContinueRequest extends AAgotRequest {

	public static final String CONTINUE_KEY = "c";
	
	public ContinueRequest(String instruction, AgotPlayer player, IHasContinueRequest parent) {
		super(
				AgotRequestType.CONTINUE,
				player,
				instruction
		);
		this.parent = parent;
		this.addChoice(AgotChoice.continueChoice());
	}
	
	public interface IHasContinueRequest extends IAgotFlowProcess { public IAgotFlowStep after(ContinueRequest continueDecision, AgotContext context); }
	@Getter private final IHasContinueRequest parent; 
	@Override public IAgotFlowStep next(AgotContext context) { return this.parent.after(this, context); }
	
	@Override
	protected boolean accept(AgotChoice choice, AgotContext context) {
		return choice.equals(AgotChoice.continueChoice());
	}
	
	@Override
	public AgotResponse getAutoResponse() {
		return null;
	}
	
}