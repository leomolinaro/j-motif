package com.motif.agot.logic.requests;

import java.util.List;

import com.motif.agot.ang.AgotText;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.act.InterruptAct;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.state.AgotPlayer;

import lombok.Getter;

public class InterruptRequest extends AAgotModelOptionalRequest<InterruptAct> {

	public InterruptRequest(List<InterruptAct> modelChoices, AgotPlayer player, IHasInterruptRequest parent) {
		super(
				AgotRequestType.SELECT_INTERRUPT_TO_PERFORM,
				modelChoices,
				player,
				AgotText.request().selectInterruptToPerform(player)
		);
		this.parent = parent;
	}
	
	public interface IHasInterruptRequest extends IAgotFlowProcess { public IAgotFlowStep after(InterruptRequest decision, AgotContext context); }
	@Getter private final IHasInterruptRequest parent; 
	@Override public IAgotFlowStep next(AgotContext context) { return this.parent.after(this, context); }
	
}