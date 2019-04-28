package com.motif.agot.logic.phases.challenges;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.logic.phases.APhase;
import com.motif.agot.logic.phases.APhaseStep;
import com.motif.agot.logic.phases.AStartPhaseStep;
import com.motif.agot.logic.phases.challenges.ActivateNextChallengesStep.IHasActivateNextChallengesStep;
import com.motif.agot.logic.phases.challenges.ChallengesActionStep.IHasChallengesActionStep;
import com.motif.agot.logic.phases.challenges.EndChallengesPhaseStep.IHasEndChallengesPhaseStep;
import com.motif.agot.logic.phases.challenges.InitiateChallengeStep.IHasInitiateChallengeStep;
import com.motif.agot.logic.phases.challenges.StartChallengesPhaseStep.IHasStartChallengesPhaseStep;
import com.motif.agot.logic.phases.challenges.challenge.ChallengeBonusStep;
import com.motif.agot.logic.phases.challenges.challenge.ChallengeBonusStep.IHasChallengeBonusStep;
import com.motif.agot.logic.phases.challenges.challenge.ChallengeFirstActionStep;
import com.motif.agot.logic.phases.challenges.challenge.ChallengeSecondActionStep;
import com.motif.agot.logic.phases.challenges.challenge.ClaimStep;
import com.motif.agot.logic.phases.challenges.challenge.ClaimStep.IHasClaimStep;
import com.motif.agot.logic.phases.challenges.challenge.ChallengeSecondActionStep.IHasChallengeSecondActionStep;
import com.motif.agot.logic.phases.challenges.challenge.DefendingChallengeStep;
import com.motif.agot.logic.phases.challenges.challenge.DetermineWinnerStep;
import com.motif.agot.logic.phases.challenges.challenge.EndChallengeStep;
import com.motif.agot.logic.phases.challenges.challenge.EndChallengeStep.IHasEndChallengeStep;
import com.motif.agot.logic.phases.challenges.challenge.KeywordsStep;
import com.motif.agot.logic.phases.challenges.challenge.KeywordsStep.IHasKeywordsStep;
import com.motif.agot.logic.phases.challenges.challenge.DetermineWinnerStep.IHasDetermineWinnerStep;
import com.motif.agot.logic.phases.challenges.challenge.DefendingChallengeStep.IHasDefendingChallengeStep;
import com.motif.agot.logic.phases.challenges.challenge.ChallengeFirstActionStep.IHasChallengeFirstActionStep;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;
import com.motif.agot.state.Challenge;

import lombok.Getter;

public class ChallengesPhase extends APhase<IChallengesPhaseStep> implements 
		IHasStartChallengesPhaseStep,
		IHasChallengesActionStep,
		IHasInitiateChallengeStep,
		IHasChallengeFirstActionStep,
		IHasDefendingChallengeStep,
		IHasChallengeSecondActionStep,
		IHasDetermineWinnerStep,
		IHasChallengeBonusStep,
		IHasClaimStep,
		IHasKeywordsStep,
		IHasEndChallengeStep,
		IHasActivateNextChallengesStep,
		IHasEndChallengesPhaseStep {

	public interface IAgotHasChallengesPhase extends IAgotFlowProcess { public IAgotFlowStep after(ChallengesPhase phase, AgotContext context); }
	@Getter private final IAgotHasChallengesPhase parent;
	@Override public IAgotFlowStep next(AgotContext context) { return this.parent.after(this, context); }
	
	public ChallengesPhase(AgotGame game, IAgotHasChallengesPhase parent) {
		super(AngPhase.CHALLENGES, game);
		this.parent = parent;
	}
	
	private AgotPlayer activePlayer;
	private Challenge challenge;
	
	@Override public String getPhaseTitle() { return AgotText.title().challengesPhase(); }

	@Override
	public AStartPhaseStep<IChallengesPhaseStep> startPhaseStep() {
		return new StartChallengesPhaseStep(this.game, this);
	}

	@Override
	public APhaseStep<IChallengesPhaseStep> after(StartChallengesPhaseStep step, AgotContext context) {
		game.setRemainingChallenges (null);
		this.activePlayer = this.game.getFirstPlayer();
		return new ChallengesActionStep(this.game, this);
	}

	@Override
	public APhaseStep<IChallengesPhaseStep> after(ChallengesActionStep step, AgotContext context) {
		return new InitiateChallengeStep(this.activePlayer, this.game, this);
	}

	@Override
	public APhaseStep<IChallengesPhaseStep> after(InitiateChallengeStep step, AgotContext context) {
		this.challenge = step.getChallenge();
		if (this.challenge == null) {
			return new ActivateNextChallengesStep(this.activePlayer, this.game, this);			
		} else {
			return new ChallengeFirstActionStep(this.challenge, this.game, this);
		}
	}
	
	@Override
	public APhaseStep<IChallengesPhaseStep> after(ChallengeFirstActionStep step, AgotContext context) {
		return new DefendingChallengeStep(this.challenge, this.game, this);
	}
	
	@Override
	public APhaseStep<IChallengesPhaseStep> after(DefendingChallengeStep step, AgotContext context) {
		return new ChallengeSecondActionStep(this.game, this);
	}
	
	@Override
	public APhaseStep<IChallengesPhaseStep> after(ChallengeSecondActionStep step, AgotContext context) {
		return new DetermineWinnerStep(this.challenge, this.game, this);
	}
	
	@Override
	public APhaseStep<IChallengesPhaseStep> after(DetermineWinnerStep step, AgotContext context) {
		return new ChallengeBonusStep(this.challenge, this.game, this);
	}

	@Override
	public APhaseStep<IChallengesPhaseStep> after(ChallengeBonusStep step, AgotContext context) {
		return new ClaimStep(this.challenge, this.game, this);
	}

	@Override
	public APhaseStep<IChallengesPhaseStep> after(ClaimStep step, AgotContext context) {
		return new KeywordsStep(this.challenge, this.game, this);
	}
	
	@Override
	public APhaseStep<IChallengesPhaseStep> after(KeywordsStep step, AgotContext context) {
		return new EndChallengeStep(this.challenge, this.game, this);
	}
	
	@Override
	public APhaseStep<IChallengesPhaseStep> after(EndChallengeStep step, AgotContext context) {
		this.challenge = null;
		return new ChallengesActionStep(this.game, this);
	}
	
	@Override
	public APhaseStep<IChallengesPhaseStep> after(ActivateNextChallengesStep step, AgotContext context) {
		var nextPlayer = step.getNextPlayer();
		if (nextPlayer == null) {
			return new EndChallengesPhaseStep(this.game, this);
		} else {
			this.game.setRemainingChallenges(null);
			this.activePlayer = nextPlayer;
			return new ChallengesActionStep(this.game, this);
		}
	}

	@Override
	public APhaseStep<IChallengesPhaseStep> after(EndChallengesPhaseStep step, AgotContext context) {
		return null;
	}

}
