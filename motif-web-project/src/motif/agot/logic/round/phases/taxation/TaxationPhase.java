package motif.agot.logic.round.phases.taxation;

import motif.agot.ang.AgotText;
import motif.agot.ang.enums.AngPhase;
import motif.agot.endpoint.AgotContext;
import motif.agot.logic.round.phases.Phase;
import motif.agot.logic.round.phases.StartPhaseStep;
import motif.agot.state.AgotGame;

public class TaxationPhase extends Phase<ITaxationPhaseStep> {

	public TaxationPhase (AgotGame game) {
		super (AngPhase.TAXATION, game);
	} // TaxationPhase
	
	@Override public String getPhaseTitle () { return AgotText.title ().taxationPhase (); }

	@Override public StartPhaseStep<ITaxationPhaseStep> getStartPhaseStep () { return new StartTaxationPhaseStep (game); }

	@Override public Phase<?> getNextTask (AgotContext context) { return null; }

} // TaxationPhase
