package com.motif.agot.logic.phases.challenges;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.phases.APhaseStep;
import com.motif.agot.logic.phases.AStandardActionPhaseStep;
import com.motif.agot.state.AgotGame;

import lombok.Getter;

public class ChallengesActionStep extends AStandardActionPhaseStep<IChallengesPhaseStep> {

	public interface IHasChallengesActionStep extends IAgotFlowProcess { public APhaseStep<IChallengesPhaseStep> after(ChallengesActionStep step, AgotContext context); }
	@Getter private final IHasChallengesActionStep parent; 
	@Override public APhaseStep<IChallengesPhaseStep> next(AgotContext context) { return this.parent.after(this, context); }
	
	public ChallengesActionStep (AgotGame game, IHasChallengesActionStep parent) {
		super (AngPhase.CHALLENGES, game);
		this.parent = parent;
	}

	@Override
	public String getStepTitle () { return AgotText.title ().actionWindow (); }

}
