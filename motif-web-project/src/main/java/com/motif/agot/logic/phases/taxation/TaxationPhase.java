package com.motif.agot.logic.phases.taxation;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.logic.phases.APhase;
import com.motif.agot.logic.phases.APhaseStep;
import com.motif.agot.logic.phases.AStartPhaseStep;
import com.motif.agot.logic.phases.taxation.EndTaxationPhaseStep.IHasEndTaxationPhaseStep;
import com.motif.agot.logic.phases.taxation.ReserveStep.IHasReserveStep;
import com.motif.agot.logic.phases.taxation.StartTaxationPhaseStep.IHasStartTaxationPhaseStep;
import com.motif.agot.logic.phases.taxation.TaxationActionStep.IHasTaxationActionStep;
import com.motif.agot.logic.phases.taxation.TributeStep.IHasTributeStep;
import com.motif.agot.state.AgotGame;

import lombok.Getter;

public class TaxationPhase extends APhase<ITaxationPhaseStep> implements
		IHasStartTaxationPhaseStep,
		IHasTributeStep,
		IHasReserveStep,
		IHasTaxationActionStep,
		IHasEndTaxationPhaseStep {

	public interface IAgotHasTaxationPhase extends IAgotFlowProcess { public IAgotFlowStep after(TaxationPhase phase, AgotContext context); }
	@Getter private final IAgotHasTaxationPhase parent;
	@Override public IAgotFlowStep next(AgotContext context) { return this.parent.after(this, context); }
	
	public TaxationPhase (AgotGame game, IAgotHasTaxationPhase parent) {
		super (AngPhase.TAXATION, game);
		this.parent = parent;
	}
	
	@Override public String getPhaseTitle() { return AgotText.title().taxationPhase(); }

	@Override
	public AStartPhaseStep<ITaxationPhaseStep> startPhaseStep() {
		return new StartTaxationPhaseStep(this.game, this);
	}
	
	@Override
	public APhaseStep<ITaxationPhaseStep> after(StartTaxationPhaseStep step, AgotContext context) {
		return new TributeStep(this.game, this);
	}
	
	@Override
	public APhaseStep<ITaxationPhaseStep> after(TributeStep step, AgotContext context) {
		return new ReserveStep(this.game, this);
	}

	@Override
	public APhaseStep<ITaxationPhaseStep> after(ReserveStep step, AgotContext context) {
		return new TaxationActionStep(this.game, this);
	}

	@Override
	public APhaseStep<ITaxationPhaseStep> after(TaxationActionStep step, AgotContext context) {
		return new EndTaxationPhaseStep(this.game, this);
	}

	@Override
	public APhaseStep<ITaxationPhaseStep> after(EndTaxationPhaseStep step, AgotContext context) {
		return null;
	}
	
}
