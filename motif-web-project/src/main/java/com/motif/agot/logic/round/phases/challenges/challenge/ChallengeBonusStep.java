package com.motif.agot.logic.round.phases.challenges.challenge;

import com.motif.agot.ang.AgotText;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.flow.task.IAgotTask;
import com.motif.agot.logic.round.phases.Step;
import com.motif.agot.logic.round.phases.challenges.IChallengesPhaseStep;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.Challenge;

public class ChallengeBonusStep extends Step<IChallengesPhaseStep> {

	private Challenge data;

	public ChallengeBonusStep (Challenge data, AgotGame game) {
		super (game);
		this.data = data;
	} // ChallengeBonusStep
	
	@Override
	public String getStepTitle () { return AgotText.title ().gainChallengeBonus (); }

	@Override
	public IAgotTask getStartTask (AgotContext context) {
		if (data.attackWins () && data.unopposed ()) {
			data.attacker ().gainPowerOnTheFactionCard (context);
			game.log ().gainsPowerForUnopposed (data.attacker (), context);
		} // if
		return null;
	} // getStartTask

	@Override
	public Step<IChallengesPhaseStep> getNextTask (AgotContext context) {
		return new ClaimStep (data, game);
	} // getNextTask

} // DeterminWinnderStep
