package com.motif.agot.logic.phases.challenges.challenge;

import com.motif.agot.ang.AgotText;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.events.AgotEventProcess;
import com.motif.agot.logic.events.IAgotHasEventProcess;
import com.motif.agot.logic.events.list.ChallengeEndEvent;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.logic.phases.APhaseStep;
import com.motif.agot.logic.phases.challenges.IChallengesPhaseStep;
import com.motif.agot.logic.requests.ContinueRequest;
import com.motif.agot.logic.requests.ContinueRequest.IHasContinueRequest;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.Challenge;

import lombok.Getter;

public class EndChallengeStep extends APhaseStep<IChallengesPhaseStep> implements IAgotHasEventProcess, IHasContinueRequest {

	private final Challenge data;

	public interface IHasEndChallengeStep extends IAgotFlowProcess { public APhaseStep<IChallengesPhaseStep> after(EndChallengeStep step, AgotContext context); }
	@Getter private final IHasEndChallengeStep parent; 
	@Override public APhaseStep<IChallengesPhaseStep> next(AgotContext context) { return this.parent.after(this, context); }
	
	public EndChallengeStep (Challenge data, AgotGame game, IHasEndChallengeStep parent) {
		super (game);
		this.data = data;
		this.parent = parent;
	}

	@Override
	public String getStepTitle() { return AgotText.title().endChallengeStep(); }

	@Override
	public IAgotFlowStep stepStart (AgotContext context) {
		var event = new ChallengeEndEvent(this.game);
		return new AgotEventProcess(event, this.game, this);
	}
	
	@Override
	public IAgotFlowStep after(AgotEventProcess eventProcess, AgotContext context) {
		return new ContinueRequest(AgotText.request().endChallenge(this.data.attacker()), this.game.firstPlayer(), this);
	}

	@Override
	public IAgotFlowStep after(ContinueRequest continueDecision, AgotContext context) {
		this.game.setChallenge (null);
		return null;
	}
	
}
