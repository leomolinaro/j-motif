package motif.agot.logic.round.phases.draw;

import motif.agot.ang.AgotText;
import motif.agot.ang.enums.AngPhase;
import motif.agot.logic.round.phases.EndPhaseStep;
import motif.agot.state.AgotGame;

public class EndDrawPhaseStep extends EndPhaseStep<IDrawPhaseStep> {

	public EndDrawPhaseStep (AgotGame game) {
		super (AngPhase.DRAW, game);
	} // EndDrawPhaseStep

	@Override
	public String getStepTitle () { return AgotText.title ().endDrawPhaseStep (); }
	
} // EndDrawPhaseStep
