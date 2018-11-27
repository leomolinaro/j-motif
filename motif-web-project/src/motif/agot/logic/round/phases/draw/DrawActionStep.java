package motif.agot.logic.round.phases.draw;

import motif.agot.ang.AgotText;
import motif.agot.ang.enums.AngPhase;
import motif.agot.endpoint.AgotContext;
import motif.agot.logic.round.phases.StandardActionWindowStep;
import motif.agot.state.AgotGame;

public class DrawActionStep extends StandardActionWindowStep<IDrawPhaseStep> {

	public DrawActionStep (AgotGame game) {
		super (AngPhase.DRAW, game);
	} // DrawActionStep

	@Override
	public String getStepTitle () { return AgotText.title ().actionWindow (); }

	@Override
	public EndDrawPhaseStep getNextTask (AgotContext context) {
		return new EndDrawPhaseStep (game);
	} // getNextTask
	
} // DrawActionStep
