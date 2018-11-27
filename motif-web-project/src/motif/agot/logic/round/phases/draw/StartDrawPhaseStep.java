package motif.agot.logic.round.phases.draw;

import motif.agot.ang.AgotText;
import motif.agot.ang.enums.AngPhase;
import motif.agot.endpoint.AgotContext;
import motif.agot.logic.round.phases.StartPhaseStep;
import motif.agot.state.AgotGame;

public class StartDrawPhaseStep extends StartPhaseStep<IDrawPhaseStep> {

	public StartDrawPhaseStep (AgotGame game) {
		super (AngPhase.DRAW, game);
	} // StartDrawPhaseStep

	@Override
	public String getStepTitle () { return AgotText.title ().startDrawPhaseStep (); }

	@Override
	public DrawCardsStep getNextTask (AgotContext context) {
		return new DrawCardsStep (game);
	} // getNextTask
	
} // StartDrawPhaseStep
