package com.motif.agot.logic.round.phases.draw;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.round.phases.Phase;
import com.motif.agot.logic.round.phases.StartPhaseStep;
import com.motif.agot.logic.round.phases.marshalling.MarshallingPhase;
import com.motif.agot.state.AgotGame;

public class DrawPhase extends Phase<IDrawPhaseStep> {

	public DrawPhase (AgotGame game) {
		super (AngPhase.DRAW, game);
	} // DrawPhase
	
	@Override public String getPhaseTitle () { return AgotText.title ().drawPhase (); }

	@Override public StartPhaseStep<IDrawPhaseStep> getStartPhaseStep () { return new StartDrawPhaseStep (game); }

	@Override public MarshallingPhase getNextTask (AgotContext context) { return new MarshallingPhase (game); }

} // DrawPhase
