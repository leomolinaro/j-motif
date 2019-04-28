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
				AAgotModelRequest.CONTINUE,
				player,
				instruction
		);
		this.parent = parent;
		this.options.add(new AgotGenericOption(CONTINUE_KEY, "Continue"));
	}
	
	public interface IHasContinueRequest extends IAgotFlowProcess { public IAgotFlowStep after(ContinueRequest continueDecision, AgotContext context); }
	@Getter private final IHasContinueRequest parent; 
	@Override public IAgotFlowStep next(AgotContext context) { return this.parent.after(this, context); }
	
	@Override
	public void response(AgotResponse response, AgotContext context) {
	}
	
	@Override
	public boolean isValidResponse(AgotResponse response) {
		return response.getKey().equals(CONTINUE_KEY);
	}

}