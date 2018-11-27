package motif.agot.logic.round.phases;

import motif.agot.ang.enums.AngPhase;
import motif.agot.endpoint.AgotContext;
import motif.agot.flow.task.AgotComplexTask;
import motif.agot.state.AgotGame;
import motif.shared.util.MotifConsole;

public abstract class Phase<S extends IStep> extends AgotComplexTask {

	private AngPhase phase;
	public AngPhase getPhase () { return phase; }

	protected AgotGame game;
	
	public Phase (AngPhase phase, AgotGame game) {
		super ();
		this.phase = phase;
		this.game = game;
	} // Phase

	public abstract String getPhaseTitle ();
	public abstract StartPhaseStep<S> getStartPhaseStep ();

	@Override
	public StartPhaseStep<S> getStart (AgotContext context) {
		String phaseTitle = getPhaseTitle ();
		MotifConsole.println ("==================================================================================");
		MotifConsole.println (phaseTitle);
		MotifConsole.println ("==================================================================================");
		game.setPhase (phase, context);
		game.log ().phase (phaseTitle, context);
		return getStartPhaseStep ();
	} // getStart

	@Override public abstract Phase<?> getNextTask (AgotContext context);
		
} // Phase
