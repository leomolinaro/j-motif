package com.motif.agot.logic.round.phases.marshalling;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.logic.round.phases.EndPhaseStep;
import com.motif.agot.state.AgotGame;

public class EndMarshallingPhaseStep extends EndPhaseStep<IMarshallingPhaseStep> {

	public EndMarshallingPhaseStep (AgotGame game) {
		super (AngPhase.MARSHALLING, game);
	} // EndMarshallingPhaseStep

	@Override
	public String getStepTitle () { return AgotText.title ().endMarshallingPhaseStep (); }
	
} // EndMarshallingPhaseStep
