package com.motif.agot.logic.round.phases.marshalling;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.round.phases.Phase;
import com.motif.agot.logic.round.phases.StartPhaseStep;
import com.motif.agot.logic.round.phases.challenges.ChallengesPhase;
import com.motif.agot.state.AgotGame;

public class MarshallingPhase extends Phase<IMarshallingPhaseStep> {
	
	public MarshallingPhase (AgotGame game) {
		super (AngPhase.MARSHALLING, game);
	} // MarshallingPhase
	
	@Override public String getPhaseTitle () { return AgotText.title ().marshallingPhase (); }

	@Override public StartPhaseStep<IMarshallingPhaseStep> getStartPhaseStep () { return new StartMarhallingPhaseStep (game); }

	@Override public ChallengesPhase getNextTask (AgotContext context) { return new ChallengesPhase (game); }

} // MarshallingPhase
