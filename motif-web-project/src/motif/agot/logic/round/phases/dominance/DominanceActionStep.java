package motif.agot.logic.round.phases.dominance;

import motif.agot.ang.AgotText;
import motif.agot.ang.enums.AngPhase;
import motif.agot.endpoint.AgotContext;
import motif.agot.logic.round.phases.StandardActionWindowStep;
import motif.agot.state.AgotGame;

public class DominanceActionStep extends StandardActionWindowStep<IDominancePhaseStep> {

	public DominanceActionStep (AgotGame game) {
		super (AngPhase.DOMINANCE, game);
	} // DominanceActionStep

	@Override
	public String getStepTitle () { return AgotText.title ().actionWindow (); }

	@Override
	public EndDominancePhaseStep getNextTask (AgotContext context) {
		return new EndDominancePhaseStep (game);
	} // getNextTask
	
} // DominanceActionStep
