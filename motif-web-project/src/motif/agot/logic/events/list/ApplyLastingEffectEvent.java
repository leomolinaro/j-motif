package motif.agot.logic.events.list;

import motif.agot.ang.text.instants.AngLastingEffect;
import motif.agot.endpoint.AgotContext;
import motif.agot.flow.task.IAgotTask;
import motif.agot.logic.events.Event;
import motif.agot.logic.events.IEventVisitor;
import motif.agot.logic.other.AbilityContext;
import motif.agot.logic.other.LastingAbilities;
import motif.agot.state.AgotGame;

public class ApplyLastingEffectEvent extends Event {

	private AngLastingEffect effect;
	private AbilityContext ac;
	
	public ApplyLastingEffectEvent (AngLastingEffect effect, AbilityContext ac, AgotGame game) {
		super (game);
		this.ac = ac;
		this.effect = effect;
	} // ApplyLastingEffectEvent

	@Override public boolean accept (IEventVisitor visitor) { return visitor.visit (this); }

	@Override
	public IAgotTask resolveEffect (AgotContext context) {
		LastingAbilities.subscribe (effect, ac, game);
		return null;
	} // resolveEffect
	
} // ApplyLastingEffectEvent
