package motif.agot.logic.events.list;

import motif.agot.ang.enums.AngPhase;
import motif.agot.endpoint.AgotContext;
import motif.agot.flow.task.IAgotTask;
import motif.agot.logic.events.Event;
import motif.agot.logic.events.IEventVisitor;
import motif.agot.state.AgotGame;

public class PhaseEndsEvent extends Event {

	private AngPhase phase;
	public AngPhase getPhase () { return phase; }
	
	public PhaseEndsEvent (AngPhase phase, AgotGame game) {
		super (game);
		this.phase = phase;
	} // PhaseBeginsEvent

	@Override
	public IAgotTask resolveEffect (AgotContext context) {
		game.removeDelayedEffects ();
		return null;
	} // resolveEffect
	
	@Override public boolean accept (IEventVisitor visitor) { return visitor.visit (this); }

} // PhaseBeginsEvent
