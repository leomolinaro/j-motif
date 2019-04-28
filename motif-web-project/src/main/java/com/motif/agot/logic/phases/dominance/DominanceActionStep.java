package com.motif.agot.logic.phases.dominance;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.phases.APhaseStep;
import com.motif.agot.logic.phases.AStandardActionPhaseStep;
import com.motif.agot.state.AgotGame;

import lombok.Getter;

public class DominanceActionStep extends AStandardActionPhaseStep<IDominancePhaseStep> {

	public interface IHasDominanceActionStep extends IAgotFlowProcess { public APhaseStep<IDominancePhaseStep> after(DominanceActionStep step, AgotContext context); }
	@Getter private final IHasDominanceActionStep parent; 
	@Override public APhaseStep<IDominancePhaseStep> next(AgotContext context) { return this.parent.after(this, context); }
	
	public DominanceActionStep (AgotGame game, IHasDominanceActionStep parent) {
		super (AngPhase.DOMINANCE, game);
		this.parent = parent;
	}

	@Override
	public String getStepTitle () { return AgotText.title ().actionWindow (); }

}
