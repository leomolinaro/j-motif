package com.motif.agot.logic.phases.draw;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.phases.APhaseStep;
import com.motif.agot.logic.phases.AStandardActionPhaseStep;
import com.motif.agot.state.AgotGame;

import lombok.Getter;

public class DrawActionStep extends AStandardActionPhaseStep<IDrawPhaseStep> {

	public interface IHasDrawActionPhaseStep extends IAgotFlowProcess { public APhaseStep<IDrawPhaseStep> after(DrawActionStep drawActionStep, AgotContext context); }
	@Getter private final IHasDrawActionPhaseStep parent; 
	@Override public APhaseStep<IDrawPhaseStep> next(AgotContext context) { return this.parent.after(this, context); }
	
	public DrawActionStep (AgotGame game, IHasDrawActionPhaseStep parent) {
		super (AngPhase.DRAW, game);
		this.parent = parent;
	}

	@Override
	public String getStepTitle () { return AgotText.title ().actionWindow (); }

}
