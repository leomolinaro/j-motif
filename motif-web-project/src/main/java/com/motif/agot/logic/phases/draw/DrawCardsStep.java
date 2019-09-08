package com.motif.agot.logic.phases.draw;

import com.motif.agot.ang.AgotText;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.AgotFlowParallelSteps;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.logic.phases.APhaseStep;
import com.motif.agot.logic.requests.DrawRequest;
import com.motif.agot.logic.requests.DrawRequest.IHasDrawRequest;
import com.motif.agot.state.AgotGame;

import lombok.Getter;

public class DrawCardsStep extends APhaseStep<IDrawPhaseStep> implements IHasDrawRequest {

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
	protected IAgotFlowStep stepStart (AgotContext context) {
		return AgotFlowParallelSteps.of (this.game.players ()
				.map (p -> new DrawRequest (2, AgotText.request ().drawCards (2, p), p, this))
		); // of
	} // stepStart

	private int completeDraws = 0;
	
	@Override
	public IAgotFlowStep after (DrawRequest drawDecision, AgotContext context) {
		var player = drawDecision.getPlayer ();
		var cardsToDraw = 2;
		if (drawDecision.getDrawCardIds () != null) {
			player.draw (drawDecision.getDrawCardIds (), context);
			cardsToDraw -= drawDecision.getDrawCardIds ().size ();
		} // if
		player.draw (cardsToDraw, context);
		this.game.logManager ().drawDrawsCards (player, 2, context);	
		this.completeDraws++;
		if (this.completeDraws == this.game.getNumPlayers ()) {
			return null;
		} else {
			return AgotFlowParallelSteps.getFlowWait ();
		} // if - else
	} // after
	
} // DrawCardsStep
