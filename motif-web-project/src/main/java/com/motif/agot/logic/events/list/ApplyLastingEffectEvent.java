package com.motif.agot.logic.events.list;

import com.motif.agot.ang.text.instants.AngLastingEffect;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.flow.task.IAgotTask;
import com.motif.agot.logic.events.Event;
import com.motif.agot.logic.events.IEventVisitor;
import com.motif.agot.logic.other.AbilityContext;
import com.motif.agot.logic.other.LastingAbilities;
import com.motif.agot.state.AgotGame;

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
