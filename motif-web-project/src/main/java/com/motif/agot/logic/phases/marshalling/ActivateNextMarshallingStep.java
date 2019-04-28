package com.motif.agot.logic.phases.marshalling;

import com.motif.agot.ang.AgotText;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.phases.APhaseStep;
import com.motif.agot.logic.phases.AActivateNextStep;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;

import lombok.Getter;

public class ActivateNextMarshallingStep extends AActivateNextStep<IMarshallingPhaseStep> {

	public interface IHasActivateNextMarshallingStep extends IAgotFlowProcess { public APhaseStep<IMarshallingPhaseStep> after(ActivateNextMarshallingStep activateNextMarshallingStep, AgotContext context); }
	@Getter private final IHasActivateNextMarshallingStep parent; 
	@Override public APhaseStep<IMarshallingPhaseStep> next(AgotContext context) { return this.parent.after(this, context); }
	
	public ActivateNextMarshallingStep (AgotPlayer activePlayer, AgotGame game, IHasActivateNextMarshallingStep parent) {
		super (activePlayer, game);
		this.parent = parent;
	}

	@Override
	public String getStepTitle () { return AgotText.title ().activateNextMarhsallingStep (); }

}
