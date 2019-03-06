package com.motif.agot.logic.round.phases.draw;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.round.phases.StartPhaseStep;
import com.motif.agot.state.AgotGame;

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