package motif.agot.logic.round.phases.marshalling;

import motif.agot.ang.AgotText;
import motif.agot.ang.enums.AngPhase;
import motif.agot.logic.round.phases.EndPhaseStep;
import motif.agot.state.AgotGame;

public class EndMarshallingPhaseStep extends EndPhaseStep<IMarshallingPhaseStep> {

	public EndMarshallingPhaseStep (AgotGame game) {
		super (AngPhase.MARSHALLING, game);
	} // EndMarshallingPhaseStep

	@Override
	public String getStepTitle () { return AgotText.title ().endMarshallingPhaseStep (); }
	
} // EndMarshallingPhaseStep
