package motif.agot.logic.round.phases;

import motif.agot.ang.enums.AngPhase;
import motif.agot.endpoint.AgotContext;
import motif.agot.flow.task.IAgotTask;
import motif.agot.logic.events.Event;
import motif.agot.logic.events.EventTrigger;
import motif.agot.logic.events.list.PhaseBeginsEvent;
import motif.agot.state.AgotGame;

public abstract class StartPhaseStep<S extends IStep> extends Step<S> {

	private AngPhase phase;
	
	public StartPhaseStep (AngPhase phase, AgotGame game) {
		super (game);
		this.phase = phase;
	} // StartPhaseStep

	@Override
	public final IAgotTask getStartTask (AgotContext context) {
		Event event = new PhaseBeginsEvent (phase, game);
		return EventTrigger.execute (event, game);
	} // getStartTask
	
} // StartPhaseStep
