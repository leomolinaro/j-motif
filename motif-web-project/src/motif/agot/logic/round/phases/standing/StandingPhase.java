package motif.agot.logic.round.phases.standing;

import motif.agot.ang.AgotText;
import motif.agot.ang.enums.AngPhase;
import motif.agot.endpoint.AgotContext;
import motif.agot.logic.round.phases.Phase;
import motif.agot.logic.round.phases.StartPhaseStep;
import motif.agot.logic.round.phases.taxation.TaxationPhase;
import motif.agot.state.AgotGame;

public class StandingPhase extends Phase<IStandingPhaseStep> {

	public StandingPhase (AgotGame game) {
		super (AngPhase.STANDING, game);
	} // StandingPhase
	
	@Override public String getPhaseTitle () { return AgotText.title ().standingPhase (); }

	@Override public StartPhaseStep<IStandingPhaseStep> getStartPhaseStep () { return new StartStandingPhaseStep (game); }

	@Override public TaxationPhase getNextTask (AgotContext context) { return new TaxationPhase (game); }

} // StandingPhase
