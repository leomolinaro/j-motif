package com.motif.agot.logic.round.phases.draw;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.round.phases.StandardActionWindowStep;
import com.motif.agot.state.AgotGame;

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
