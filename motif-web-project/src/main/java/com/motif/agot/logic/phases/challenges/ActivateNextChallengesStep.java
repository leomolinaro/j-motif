package com.motif.agot.logic.phases.challenges;

import com.motif.agot.ang.AgotText;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.phases.AActivateNextStep;
import com.motif.agot.logic.phases.APhaseStep;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;

import lombok.Getter;

public class ActivateNextChallengesStep extends AActivateNextStep<IChallengesPhaseStep> {

	public interface IHasActivateNextChallengesStep extends IAgotFlowProcess { public APhaseStep<IChallengesPhaseStep> after(ActivateNextChallengesStep step, AgotContext context); }
	@Getter private final IHasActivateNextChallengesStep parent; 
	@Override public APhaseStep<IChallengesPhaseStep> next(AgotContext context) { return this.parent.after(this, context); }
	
	public ActivateNextChallengesStep(AgotPlayer activePlayer, AgotGame game, IHasActivateNextChallengesStep parent) {
		super (activePlayer, game);
		this.parent = parent;
	}

	@Override
	public String getStepTitle() { return AgotText.title().activateNextChallengesStep(); }

}
