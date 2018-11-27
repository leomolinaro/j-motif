package motif.agot.logic.round.phases.marshalling;

import motif.agot.ang.AgotText;
import motif.agot.ang.enums.AngPhase;
import motif.agot.endpoint.AgotContext;
import motif.agot.logic.round.phases.Phase;
import motif.agot.logic.round.phases.StartPhaseStep;
import motif.agot.logic.round.phases.challenges.ChallengesPhase;
import motif.agot.state.AgotGame;

public class MarshallingPhase extends Phase<IMarshallingPhaseStep> {
	
	public MarshallingPhase (AgotGame game) {
		super (AngPhase.MARSHALLING, game);
	} // MarshallingPhase
	
	@Override public String getPhaseTitle () { return AgotText.title ().marshallingPhase (); }

	@Override public StartPhaseStep<IMarshallingPhaseStep> getStartPhaseStep () { return new StartMarhallingPhaseStep (game); }

	@Override public ChallengesPhase getNextTask (AgotContext context) { return new ChallengesPhase (game); }

} // MarshallingPhase
