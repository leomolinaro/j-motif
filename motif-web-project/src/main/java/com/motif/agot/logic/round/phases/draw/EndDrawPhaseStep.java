package com.motif.agot.logic.round.phases.draw;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.logic.round.phases.EndPhaseStep;
import com.motif.agot.state.AgotGame;

public class EndDrawPhaseStep extends EndPhaseStep<IDrawPhaseStep> {

	public EndDrawPhaseStep (AgotGame game) {
		super (AngPhase.DRAW, game);
	} // EndDrawPhaseStep

	@Override
	public String getStepTitle () { return AgotText.title ().endDrawPhaseStep (); }
	
} // EndDrawPhaseStep
