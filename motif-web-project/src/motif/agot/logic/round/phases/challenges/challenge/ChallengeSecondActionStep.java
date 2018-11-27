package motif.agot.logic.round.phases.challenges.challenge;

import motif.agot.ang.AgotText;
import motif.agot.ang.enums.AngPhase;
import motif.agot.endpoint.AgotContext;
import motif.agot.logic.round.phases.StandardActionWindowStep;
import motif.agot.logic.round.phases.challenges.IChallengesPhaseStep;
import motif.agot.state.Challenge;
import motif.agot.state.AgotGame;

public class ChallengeSecondActionStep extends StandardActionWindowStep<IChallengesPhaseStep> {

	private Challenge data;
	
	public ChallengeSecondActionStep (Challenge data, AgotGame game) {
		super (AngPhase.CHALLENGES, game);
		this.data = data;
	} // ChallengeFirstActionStep

	@Override
	public String getStepTitle () { return AgotText.title ().actionWindow (); }

	@Override
	public DetermineWinnerStep getNextTask (AgotContext context) {
		return new DetermineWinnerStep (data, game);
	} // getNextTask
	
} // ChallengeSecondActionStep
