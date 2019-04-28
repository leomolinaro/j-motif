package com.motif.agot.logic.phases.dominance;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.phases.APhaseStep;
import com.motif.agot.logic.phases.AStartPhaseStep;
import com.motif.agot.state.AgotGame;

import lombok.Getter;

public class StartDominancePhaseStep extends AStartPhaseStep<IDominancePhaseStep> {

	public interface IHasStartDominancePhaseStep extends IAgotFlowProcess { public APhaseStep<IDominancePhaseStep> after(StartDominancePhaseStep step, AgotContext context); }
	@Getter private final IHasStartDominancePhaseStep parent; 
	@Override public APhaseStep<IDominancePhaseStep> next(AgotContext context) { return this.parent.after(this, context); }
	
	public StartDominancePhaseStep(AgotGame game, IHasStartDominancePhaseStep parent) {
		super(AngPhase.DOMINANCE, game);
		this.parent = parent;
	}

	@Override
	public String getStepTitle() { return AgotText.title().startDominancePhaseStep(); }

}
