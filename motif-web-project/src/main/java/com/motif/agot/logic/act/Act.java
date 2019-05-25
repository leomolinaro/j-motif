package com.motif.agot.logic.act;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.events.AgotEventProcess;
import com.motif.agot.logic.events.IAgotHasEventProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.logic.flow.IAgotModelChoice;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class Act implements IAgotHasEventProcess, IAgotModelChoice {

//	protected final AgotGame game;
	
	public abstract boolean canBeInitiated ();
	public abstract boolean canBePaid ();
//	protected abstract AActPayCostStep getPayCostStep (AgotContext context);
//	protected abstract AgotEvent getEvent ();
	
	@Override
	public IAgotFlowStep after(AgotEventProcess eventProcess, AgotContext context) {
		return null;
	}

}
