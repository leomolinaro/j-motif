package com.motif.agot.logic.phases.taxation;

import com.motif.agot.ang.AgotText;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.logic.phases.APhaseStep;
import com.motif.agot.state.AgotGame;

import lombok.Getter;

public class TributeStep extends APhaseStep<ITaxationPhaseStep> {

	public interface IHasTributeStep extends IAgotFlowProcess { public APhaseStep<ITaxationPhaseStep> after(TributeStep step, AgotContext context); }
	@Getter private final IHasTributeStep parent; 
	@Override public APhaseStep<ITaxationPhaseStep> next(AgotContext context) { return this.parent.after(this, context); }
	
	public TributeStep (AgotGame game, IHasTributeStep parent) {
		super (game);
		this.parent = parent;
	}

	@Override
	public String getStepTitle() { return AgotText.title().tributeStep(); }

	@Override
	protected IAgotFlowStep stepStart(AgotContext context) {
		this.game.forEachPlayer (player -> {
			int unspent = player.resetGold (context);
			this.game.log ().tributeDiscardGold (player, unspent, context);			
		});
		return null;
	}

}
