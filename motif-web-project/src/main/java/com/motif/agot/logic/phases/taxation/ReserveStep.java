package com.motif.agot.logic.phases.taxation;

import java.util.stream.Collectors;

import com.motif.agot.ang.AgotText;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.logic.phases.APhaseStep;
import com.motif.agot.logic.requests.ReserveDiscardRequest;
import com.motif.agot.logic.requests.ReserveDiscardRequest.IHasReserveDiscardRequest;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;

import lombok.Getter;

public class ReserveStep extends APhaseStep<ITaxationPhaseStep> implements IHasReserveDiscardRequest {

	public interface IHasReserveStep extends IAgotFlowProcess { public APhaseStep<ITaxationPhaseStep> after(ReserveStep step, AgotContext context); }
	@Getter private final IHasReserveStep parent;
	@Override public APhaseStep<ITaxationPhaseStep> next(AgotContext context) { return this.parent.after(this, context); }
	
	public ReserveStep(AgotGame game, IHasReserveStep parent) {
		super(game);
		this.parent = parent;
	}

	private AgotPlayer player;
	private int numToDiscard;
	
	@Override
	public String getStepTitle() { return AgotText.title().reserveStep(); }

	@Override
	protected IAgotFlowStep stepStart(AgotContext context) {
		this.player = this.game.getFirstPlayer();
		var handSize = this.player.handSize();
		var reserve = this.player.getReserve();
		this.numToDiscard = Integer.max(handSize - reserve, 0);
		return this.next();
	}
	
	private IAgotFlowStep next() {
		if (this.numToDiscard > 0) {
			return new ReserveDiscardRequest(this.player.hand().collect(Collectors.toList()), this.player, this);
		} else {
			this.player = this.player.getNextPlayer();
			if (this.player == this.game.getFirstPlayer()) {
				return null;							
			} else {
				var handSize = this.player.handSize();
				var reserve = this.player.getReserve();
				this.numToDiscard = Integer.max(handSize - reserve, 0);
				return this.next();
			}			
		}
	}

	@Override
	public IAgotFlowStep after(ReserveDiscardRequest decision, AgotContext context) {
		var toDiscard = decision.getChoosenModel();
		this.player.discardFromHand(toDiscard, context);
		this.game.log().discards(this.player, toDiscard, context);
		this.numToDiscard--;
		return this.next();
	}

}
