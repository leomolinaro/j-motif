package com.motif.agot.logic.phases.challenges.challenge;

import java.util.stream.Collectors;

import com.motif.agot.ang.AgotText;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.events.AgotEventProcess;
import com.motif.agot.logic.events.IAgotHasEventProcess;
import com.motif.agot.logic.events.list.DetermineAChallengeEvent;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.logic.phases.APhaseStep;
import com.motif.agot.logic.phases.challenges.IChallengesPhaseStep;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.Challenge;

import lombok.Getter;

public class DetermineWinnerStep extends APhaseStep<IChallengesPhaseStep> implements IAgotHasEventProcess {

	private final Challenge data;

	public interface IHasDetermineWinnerStep extends IAgotFlowProcess { public APhaseStep<IChallengesPhaseStep> after(DetermineWinnerStep step, AgotContext context); }
	@Getter private final IHasDetermineWinnerStep parent; 
	@Override public APhaseStep<IChallengesPhaseStep> next(AgotContext context) { return this.parent.after(this, context); }
	
	public DetermineWinnerStep(Challenge data, AgotGame game, IHasDetermineWinnerStep parent) {
		super(game);
		this.data = data;
		this.parent = parent;
	}
	
	@Override
	public String getStepTitle() { return AgotText.title().determineWinner(); }

	@Override
	public IAgotFlowStep stepStart(AgotContext context) {
		int attStr = this.data.attackers().collect(Collectors.summingInt(att -> att.getStrength()));
		int defStr = this.data.defenders().collect(Collectors.summingInt(def -> def.getStrength()));
		this.data.attStr = attStr;
		this.data.defStr = defStr;
		if (attStr >= defStr && attStr > 0 && this.data.attackers().findAny().isPresent()) {
			this.data.setAttackWins();
			this.data.setDefenseLoses();
			if (this.data.defStr == 0 && this.data.attStr > 0) {
				this.data.setUnopposed();
				this.game.logManager().winsTheChallengeUnopposed(this.data.attacker(), context);				
			} else {
				this.game.logManager().winsTheChallenge(this.data.attacker(), context);				
			}
		} else if (attStr < defStr && defStr > 0 && this.data.defenders().findAny().isPresent()) {
			this.data.setDefenseWins();
			this.data.setAttackLoses();
			this.game.logManager().winsTheChallenge(this.data.defender, context);
		}
		var event = new DetermineAChallengeEvent(this.data, this.game);
		return new AgotEventProcess(event, this.game, this);
	}

	@Override
	public IAgotFlowStep after(AgotEventProcess eventProcess, AgotContext context) {
		return null;
	}

}
