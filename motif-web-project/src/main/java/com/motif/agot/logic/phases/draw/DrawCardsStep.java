package com.motif.agot.logic.phases.draw;

import com.motif.agot.ang.AgotText;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.logic.phases.APhaseStep;
import com.motif.agot.state.AgotGame;

import lombok.Getter;

public class DrawCardsStep extends APhaseStep<IDrawPhaseStep> {

	public interface IHasDrawCardsPhaseStep extends IAgotFlowProcess { public APhaseStep<IDrawPhaseStep> after(DrawCardsStep drawCardsStep, AgotContext context); }
	@Getter private final IHasDrawCardsPhaseStep parent; 
	@Override public APhaseStep<IDrawPhaseStep> next(AgotContext context) { return this.parent.after(this, context); }
	
	public DrawCardsStep (AgotGame game, IHasDrawCardsPhaseStep parent) {
		super (game);
		this.parent = parent;
	}
	
	@Override
	public String getStepTitle () { return AgotText.title ().drawCardsStep (); }

	@Override
	protected IAgotFlowStep stepStart(AgotContext context) {
		game.forEachPlayer (player -> {
			int nCards = Math.min (player.drawDeckSize (), 2);
			for (int i = 0; i < nCards; i++) { player.draw (context); }
			game.log ().drawDrawsCards (player, nCards, context);			
		});
		return null;
	}
	
}
