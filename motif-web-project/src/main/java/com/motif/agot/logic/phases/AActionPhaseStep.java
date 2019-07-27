package com.motif.agot.logic.phases;

import java.util.List;

import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.act.IPhaseAct;
import com.motif.agot.logic.act.IPhaseAct.IHasPhaseAct;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.logic.requests.SelectActionToPerformRequest;
import com.motif.agot.logic.requests.SelectActionToPerformRequest.IHasSelectActionToPerformRequest;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;

public abstract class AActionPhaseStep<S extends IStep, A extends IPhaseAct> extends APhaseStep<S>
        implements IHasSelectActionToPerformRequest<A>, IHasPhaseAct {
	
	protected final AngPhase phase;

	private int nPasses = 0;
	protected AgotPlayer player;
	
	public AActionPhaseStep(AngPhase phase, AgotGame game) {
		super(game);
		this.phase = phase;
	}

	@Override
	public final SelectActionToPerformRequest<A> stepStart(AgotContext context) {
		this.player = this.game.firstPlayer();
		var availableActions = this.getAvailableActions();
		return new SelectActionToPerformRequest<A>(availableActions, this.player, this);
	}
	
	protected abstract List<A> getAvailableActions();
	
	@Override
	public IAgotFlowStep after(SelectActionToPerformRequest<A> actionDecision, AgotContext context) {
		var hasPassed = actionDecision.isHasPassed();
		if (hasPassed) {
			this.nPasses++;
			if (this.nPasses == this.game.getNumPlayers()) {
				return null;
			} else {
				this.player = this.player.getNextPlayer();
				var availableActions = this.getAvailableActions();
				return new SelectActionToPerformRequest<A>(availableActions, this.player, this);
			}
		} else {
			var actionAct = actionDecision.getChoosenModel();
			this.nPasses = 0;
			return actionAct;
		}
	}
	
	@Override
	public IAgotFlowStep after(IPhaseAct phaseAct, AgotContext context) {
		this.player = this.player.getNextPlayer();
		var availableActions = this.getAvailableActions();
		return new SelectActionToPerformRequest<A>(availableActions, this.player, this);
	}
	
}
