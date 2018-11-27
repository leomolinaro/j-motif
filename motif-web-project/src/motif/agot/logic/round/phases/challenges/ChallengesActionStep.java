package motif.agot.logic.round.phases.challenges;

import motif.agot.ang.AgotText;
import motif.agot.ang.enums.AngPhase;
import motif.agot.endpoint.AgotContext;
import motif.agot.logic.round.phases.StandardActionWindowStep;
import motif.agot.state.AgotGame;
import motif.agot.state.AgotPlayer;

public class ChallengesActionStep extends StandardActionWindowStep<IChallengesPhaseStep> {

	private AgotPlayer activePlayer;
	
	public ChallengesActionStep (AgotPlayer activePlayer, AgotGame game) {
		super (AngPhase.CHALLENGES, game);
		this.activePlayer = activePlayer;
	} // ChallengesActionStep

	@Override
	public String getStepTitle () { return AgotText.title ().actionWindow (); }

	@Override
	public InitiateChallengeStep getNextTask (AgotContext context) {
		return new InitiateChallengeStep (activePlayer, game);
	} // getNextTask
	
} // ChallengesActionStep
