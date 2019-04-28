package com.motif.agot.logic.phases.draw;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.phases.APhaseStep;
import com.motif.agot.logic.phases.AStartPhaseStep;
import com.motif.agot.state.AgotGame;

import lombok.Getter;

public class StartDrawPhaseStep extends AStartPhaseStep<IDrawPhaseStep> {

	public interface IHasStartDrawPhaseStep extends IAgotFlowProcess { public APhaseStep<IDrawPhaseStep> after(StartDrawPhaseStep startPhaseStep, AgotContext context); }
	@Getter private final IHasStartDrawPhaseStep parent; 
	@Override public APhaseStep<IDrawPhaseStep> next(AgotContext context) { return this.parent.after(this, context); }
	
	public StartDrawPhaseStep(AgotGame game, IHasStartDrawPhaseStep parent) {
		super(AngPhase.DRAW, game);
		this.parent = parent;
	}

	@Override
	public String getStepTitle () { return AgotText.title ().startDrawPhaseStep (); }

}
