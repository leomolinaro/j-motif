package motif.agot.logic.round.phases.draw;

import motif.agot.ang.AgotText;
import motif.agot.ang.enums.AngPhase;
import motif.agot.endpoint.AgotContext;
import motif.agot.logic.round.phases.Phase;
import motif.agot.logic.round.phases.StartPhaseStep;
import motif.agot.logic.round.phases.marshalling.MarshallingPhase;
import motif.agot.state.AgotGame;

public class DrawPhase extends Phase<IDrawPhaseStep> {

	public DrawPhase (AgotGame game) {
		super (AngPhase.DRAW, game);
	} // DrawPhase
	
	@Override public String getPhaseTitle () { return AgotText.title ().drawPhase (); }

	@Override public StartPhaseStep<IDrawPhaseStep> getStartPhaseStep () { return new StartDrawPhaseStep (game); }

	@Override public MarshallingPhase getNextTask (AgotContext context) { return new MarshallingPhase (game); }

} // DrawPhase
