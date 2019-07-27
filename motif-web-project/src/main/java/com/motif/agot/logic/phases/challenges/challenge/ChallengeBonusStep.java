package com.motif.agot.logic.phases.challenges.challenge;

import com.motif.agot.ang.AgotText;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.logic.phases.APhaseStep;
import com.motif.agot.logic.phases.challenges.IChallengesPhaseStep;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.Challenge;

import lombok.Getter;

public class ChallengeBonusStep extends APhaseStep<IChallengesPhaseStep> {

	private final Challenge data;

	public interface IHasChallengeBonusStep extends IAgotFlowProcess { public APhaseStep<IChallengesPhaseStep> after(ChallengeBonusStep step, AgotContext context); }
	@Getter private final IHasChallengeBonusStep parent; 
	@Override public APhaseStep<IChallengesPhaseStep> next(AgotContext context) { return this.parent.after(this, context); }
	
	public ChallengeBonusStep(Challenge data, AgotGame game, IHasChallengeBonusStep parent) {
		super (game);
		this.data = data;
		this.parent = parent;
	}
	
	@Override
	public String getStepTitle() { return AgotText.title().gainChallengeBonus(); }

	@Override
	public IAgotFlowStep stepStart(AgotContext context) {
		if (this.data.attackWins() && this.data.unopposed()) {
			this.data.attacker().gainPowerOnTheFactionCard(context);
			this.game.logManager().gainsPowerForUnopposed(this.data.attacker(), context);
		}
		return null;
	}

}
