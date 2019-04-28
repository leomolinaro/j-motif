package com.motif.agot.logic.phases.dominance;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.phases.AEndPhaseStep;
import com.motif.agot.logic.phases.APhaseStep;
import com.motif.agot.state.AgotGame;

import lombok.Getter;

public class EndDominancePhaseStep extends AEndPhaseStep<IDominancePhaseStep> {

	public interface IHasEndDominancePhaseStep extends IAgotFlowProcess { public APhaseStep<IDominancePhaseStep> after(EndDominancePhaseStep endDominancePhaseStep, AgotContext context); }
	@Getter private final IHasEndDominancePhaseStep parent; 
	@Override public APhaseStep<IDominancePhaseStep> next(AgotContext context) { return this.parent.after(this, context); }
	
	public EndDominancePhaseStep(AgotGame game, IHasEndDominancePhaseStep parent) {
		super(AngPhase.DOMINANCE, game);
		this.parent = parent;
	}

	@Override
	public String getStepTitle() { return AgotText.title().endDominancePhaseStep(); }
	
}
