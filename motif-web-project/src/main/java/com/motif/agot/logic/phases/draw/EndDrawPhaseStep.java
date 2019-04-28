package com.motif.agot.logic.phases.draw;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.phases.AEndPhaseStep;
import com.motif.agot.logic.phases.APhaseStep;
import com.motif.agot.state.AgotGame;

import lombok.Getter;

public class EndDrawPhaseStep extends AEndPhaseStep<IDrawPhaseStep> {

	public interface IHasEndDrawPhaseStep extends IAgotFlowProcess { public APhaseStep<IDrawPhaseStep> after(EndDrawPhaseStep endDrawPhaseStep, AgotContext context); }
	@Getter private final IHasEndDrawPhaseStep parent; 
	@Override public APhaseStep<IDrawPhaseStep> next(AgotContext context) { return this.parent.after(this, context); }
	
	public EndDrawPhaseStep (AgotGame game, IHasEndDrawPhaseStep parent) {
		super (AngPhase.DRAW, game);
		this.parent = parent;
	}

	@Override
	public String getStepTitle () { return AgotText.title ().endDrawPhaseStep (); }
	
}
