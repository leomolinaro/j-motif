package com.motif.agot.logic.round.phases.challenges.challenge;

import com.motif.agot.ang.AgotText;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.flow.task.IAgotTask;
import com.motif.agot.logic.round.phases.Step;
import com.motif.agot.logic.round.phases.challenges.IChallengesPhaseStep;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.Challenge;

public class KeywordsStep extends Step<IChallengesPhaseStep> {

	private Challenge challenge;

	public KeywordsStep (Challenge challenge, AgotGame game) {
		super (game);
		this.challenge = challenge;
	} // DeterminWinnderStep
	
	@Override
	public String getStepTitle () { return AgotText.title ().keywordsStep (); }

	@Override
	public IAgotTask getStartTask (AgotContext context) {
		resolveRenown (context);
		return null;
	} // getStartTask

	private void resolveRenown (AgotContext context) {
		if (challenge.attackWins ()) {
			challenge.attackers ()
			.filter (att -> att.hasRenown ())
			.forEach (att -> att.gainPower (context));
		} else if (challenge.defenseWins ()) {
			challenge.defenders ()
			.filter (def -> def.hasRenown ())
			.forEach (def -> def.gainPower (context));
		} // if - else
	} // resolveRenown
	
	@Override
	public Step<IChallengesPhaseStep> getNextTask (AgotContext context) {
		return new EndChallengeStep (challenge, game);
	} // getNextTask

} // KeywordsStep
