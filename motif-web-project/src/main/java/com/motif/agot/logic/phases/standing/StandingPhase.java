package com.motif.agot.logic.phases.standing;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.logic.phases.APhase;
import com.motif.agot.logic.phases.APhaseStep;
import com.motif.agot.logic.phases.AStartPhaseStep;
import com.motif.agot.logic.phases.standing.EndStandingPhaseStep.IHasEndStandingPhaseStep;
import com.motif.agot.logic.phases.standing.StandingActionStep.IHasStandingActionStep;
import com.motif.agot.logic.phases.standing.StandingStep.IHasStandingStep;
import com.motif.agot.logic.phases.standing.StartStandingPhaseStep.IHasStartStandingPhaseStep;
import com.motif.agot.state.AgotGame;

import lombok.Getter;

public class StandingPhase extends APhase<IStandingPhaseStep> implements
		IHasStartStandingPhaseStep,
		IHasStandingStep,
		IHasStandingActionStep,
		IHasEndStandingPhaseStep {

	public interface IAgotHasStandingPhase extends IAgotFlowProcess {
		public IAgotFlowStep after(StandingPhase phase, AgotContext context);
	}

	@Getter
	private final IAgotHasStandingPhase parent;

	@Override
	public IAgotFlowStep next(AgotContext context) {
		return this.parent.after(this, context);
	}
	
	public StandingPhase (AgotGame game, IAgotHasStandingPhase parent) {
		super (AngPhase.STANDING, game);
		this.parent = parent;
	} // StandingPhase
	
	@Override public String getPhaseTitle () { return AgotText.title ().standingPhase (); }

	@Override
	public AStartPhaseStep<IStandingPhaseStep> startPhaseStep() {
		return new StartStandingPhaseStep(this.game, this); 
	}

	@Override
	public APhaseStep<IStandingPhaseStep> after(StartStandingPhaseStep step, AgotContext context) {
		return new StandingStep(this.game, this);
	}

	@Override
	public APhaseStep<IStandingPhaseStep> after(StandingStep step, AgotContext context) {
		return new StandingActionStep(this.game, this);
	}

	@Override
	public APhaseStep<IStandingPhaseStep> after(StandingActionStep step, AgotContext context) {
		return new EndStandingPhaseStep(this.game, this);
	}

	@Override
	public APhaseStep<IStandingPhaseStep> after(EndStandingPhaseStep step, AgotContext context) {
		return null;
	}

}
