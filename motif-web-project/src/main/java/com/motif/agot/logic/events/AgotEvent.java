package com.motif.agot.logic.events;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.state.AgotGame;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public abstract class AgotEvent implements IAgotFlowProcess {

	protected final AgotGame game;
	
	@Getter @Setter private IAgotHasEvent parent;
	@Override public IAgotFlowStep next(AgotContext context) { return this.parent.after(this, context); }
	
	public abstract boolean accept (IEventVisitor visitor);
	
}
