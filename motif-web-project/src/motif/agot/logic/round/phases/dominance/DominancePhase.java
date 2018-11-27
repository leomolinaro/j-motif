package motif.agot.logic.round.phases.dominance;

import motif.agot.ang.AgotText;
import motif.agot.ang.enums.AngPhase;
import motif.agot.endpoint.AgotContext;
import motif.agot.logic.round.phases.Phase;
import motif.agot.logic.round.phases.StartPhaseStep;
import motif.agot.logic.round.phases.standing.StandingPhase;
import motif.agot.state.AgotGame;

public class DominancePhase extends Phase<IDominancePhaseStep> {
	
	public DominancePhase (AgotGame game) {
		super (AngPhase.DOMINANCE, game);
	} // DominancePhase
	
	@Override public String getPhaseTitle () { return AgotText.title ().dominancePhase (); }

	@Override public StartPhaseStep<IDominancePhaseStep> getStartPhaseStep () { return new StartDominancePhaseStep (game); }

	@Override public StandingPhase getNextTask (AgotContext context) { return new StandingPhase (game); }
	
} // DominancePhase
