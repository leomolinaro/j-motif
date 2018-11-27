package motif.agot.logic.round.phases.marshalling;

import motif.agot.ang.AgotText;
import motif.agot.ang.enums.AngPhase;
import motif.agot.endpoint.AgotContext;
import motif.agot.logic.round.phases.StartPhaseStep;
import motif.agot.state.AgotGame;

public class StartMarhallingPhaseStep extends StartPhaseStep<IMarshallingPhaseStep> {

	public StartMarhallingPhaseStep (AgotGame game) {
		super (AngPhase.MARSHALLING, game);
	} // StartMarhallingPhaseStep

	@Override
	public String getStepTitle () { return AgotText.title ().startMarshallingPhaseStep (); }

	@Override
	public CollectIncomeStep getNextTask (AgotContext context) {
		return new CollectIncomeStep (game.getFirstPlayer (), game);
	} // getNextTask
	
} // StartMarhallingPhaseStep
