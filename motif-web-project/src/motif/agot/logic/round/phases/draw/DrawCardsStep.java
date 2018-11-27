package motif.agot.logic.round.phases.draw;

import motif.agot.ang.AgotText;
import motif.agot.endpoint.AgotContext;
import motif.agot.flow.task.IAgotTask;
import motif.agot.logic.round.phases.Step;
import motif.agot.state.AgotGame;

public class DrawCardsStep extends Step<IDrawPhaseStep> {

	public DrawCardsStep (AgotGame game) {
		super (game);
	} // DrawCardsStep

	@Override
	public String getStepTitle () { return AgotText.title ().drawCardsStep (); }

	@Override
	public IAgotTask getStartTask (AgotContext context) {
		game.forEachPlayer (player -> {
			int nCards = Math.min (player.drawDeckSize (), 2);
			for (int i = 0; i < nCards; i++) { player.draw (context); }
			game.log ().drawDrawsCards (player, nCards, context);			
		});
		return null;
	} // getStartTask

	@Override
	public DrawActionStep getNextTask (AgotContext context) {
		return new DrawActionStep (game);
	} // getNextTask
	
} // DrawCardsStep
