package com.motif.agot.logic.phases.dominance;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.logic.phases.APhase;
import com.motif.agot.logic.phases.APhaseStep;
import com.motif.agot.logic.phases.AStartPhaseStep;
import com.motif.agot.logic.phases.dominance.DetermineDominanceStep.IHasDetermineDominanceStep;
import com.motif.agot.logic.phases.dominance.DominanceActionStep.IHasDominanceActionStep;
import com.motif.agot.logic.phases.dominance.EndDominancePhaseStep.IHasEndDominancePhaseStep;
import com.motif.agot.logic.phases.dominance.StartDominancePhaseStep.IHasStartDominancePhaseStep;
import com.motif.agot.state.AgotGame;

import lombok.Getter;

public class DominancePhase extends APhase<IDominancePhaseStep> implements
		IHasStartDominancePhaseStep, 
		IHasDetermineDominanceStep,
		IHasDominanceActionStep,
		IHasEndDominancePhaseStep {

	public interface IAgotHasDominancePhase extends IAgotFlowProcess { public IAgotFlowStep after(DominancePhase phase, AgotContext context); }
	@Getter private final IAgotHasDominancePhase parent;
	@Override public IAgotFlowStep next(AgotContext context) { return this.parent.after(this, context); }
	
	public DominancePhase (AgotGame game, IAgotHasDominancePhase parent) {
		super (AngPhase.DOMINANCE, game);
		this.parent = parent;
	}
	
	@Override public String getPhaseTitle () { return AgotText.title ().dominancePhase (); }

	@Override
	public AStartPhaseStep<IDominancePhaseStep> startPhaseStep() {
		return new StartDominancePhaseStep (this.game, this);
	}

	@Override
	public APhaseStep<IDominancePhaseStep> after(StartDominancePhaseStep step, AgotContext context) {
		return new DetermineDominanceStep(this.game, this);
	}
	
	@Override
	public APhaseStep<IDominancePhaseStep> after(DetermineDominanceStep step, AgotContext context) {
		return new DominanceActionStep(this.game, this);
	}
	
	@Override
	public APhaseStep<IDominancePhaseStep> after(DominanceActionStep step, AgotContext context) {
		return new EndDominancePhaseStep(this.game, this);
	}
	
	@Override
	public APhaseStep<IDominancePhaseStep> after(EndDominancePhaseStep step, AgotContext context) {
		return null;
	}

}
