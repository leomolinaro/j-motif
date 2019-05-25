package com.motif.agot.logic.act;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.logic.flow.IAgotModelChoice;

public interface IPhaseAct extends IAgotModelChoice, IAgotFlowStep {

	public interface IHasPhaseAct extends IAgotFlowProcess { public IAgotFlowStep after(IPhaseAct phaseAct, AgotContext context); }

	public boolean canBeInitiated();

	public boolean canBePaid();
	
	public long getCardId();
	
}
