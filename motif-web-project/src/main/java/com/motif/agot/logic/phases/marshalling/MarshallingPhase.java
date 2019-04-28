package com.motif.agot.logic.phases.marshalling;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.logic.phases.APhase;
import com.motif.agot.logic.phases.APhaseStep;
import com.motif.agot.logic.phases.AStartPhaseStep;
import com.motif.agot.logic.phases.marshalling.ActivateNextMarshallingStep.IHasActivateNextMarshallingStep;
import com.motif.agot.logic.phases.marshalling.CollectIncomeStep.IHasCollectIncomeStep;
import com.motif.agot.logic.phases.marshalling.EndMarshallingPhaseStep.IHasEndMarshallingPhaseStep;
import com.motif.agot.logic.phases.marshalling.MarshallingActionStep.IHasMarshallingActionStep;
import com.motif.agot.logic.phases.marshalling.StartMarhallingPhaseStep.IHasStartMarhallingPhaseStep;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;

import lombok.Getter;

public class MarshallingPhase extends APhase<IMarshallingPhaseStep> implements
		IHasStartMarhallingPhaseStep,
		IHasCollectIncomeStep,
		IHasMarshallingActionStep,
		IHasActivateNextMarshallingStep,
		IHasEndMarshallingPhaseStep {
	
	public interface IAgotHasMarshallingPhase extends IAgotFlowProcess { public IAgotFlowStep after(MarshallingPhase phase, AgotContext context); }
	@Getter private final IAgotHasMarshallingPhase parent;
	@Override public IAgotFlowStep next(AgotContext context) { return this.parent.after(this, context); }
	
	public MarshallingPhase(AgotGame game, IAgotHasMarshallingPhase parent) {
		super(AngPhase.MARSHALLING, game);
		this.parent = parent;
	}
	
	@Override public String getPhaseTitle () { return AgotText.title ().marshallingPhase (); }

	@Override
	public AStartPhaseStep<IMarshallingPhaseStep> startPhaseStep() { return new StartMarhallingPhaseStep(this.game, this); }

	@Override
	public APhaseStep<IMarshallingPhaseStep> after(StartMarhallingPhaseStep step, AgotContext context) {
		return new CollectIncomeStep(this.game.getFirstPlayer (), this.game, this);
	}
	
	@Override
	public APhaseStep<IMarshallingPhaseStep> after(CollectIncomeStep step, AgotContext context) {
		return new MarshallingActionStep(step.getActivePlayer(), this.game, this);
	}
	
	@Override
	public APhaseStep<IMarshallingPhaseStep> after(MarshallingActionStep step, AgotContext context) {
		return new ActivateNextMarshallingStep(step.getActivePlayer(), this.game, this);
	}
	
	@Override
	public APhaseStep<IMarshallingPhaseStep> after(ActivateNextMarshallingStep step, AgotContext context) {
		AgotPlayer nextPlayer = step.getNextPlayer();
		if (nextPlayer == null) {
			return new EndMarshallingPhaseStep(this.game, this);
		} else {
			return new CollectIncomeStep(nextPlayer, this.game, this);
		}
	}
	
	@Override
	public APhaseStep<IMarshallingPhaseStep> after(EndMarshallingPhaseStep step, AgotContext context) {
		return null;
	}
	
}
