package motif.agot.logic.round.phases.dominance;

import motif.agot.ang.AgotText;
import motif.agot.ang.enums.AngPhase;
import motif.agot.logic.round.phases.EndPhaseStep;
import motif.agot.state.AgotGame;

public class EndDominancePhaseStep extends EndPhaseStep<IDominancePhaseStep> {

	public EndDominancePhaseStep (AgotGame game) {
		super (AngPhase.DOMINANCE, game);
	} // EndDominancePhaseStep

	@Override
	public String getStepTitle () { return AgotText.title ().endDominancePhaseStep (); }
	
} // EndMarshallingPhaseStep
