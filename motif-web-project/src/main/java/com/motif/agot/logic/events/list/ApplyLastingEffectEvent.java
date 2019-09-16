package com.motif.agot.logic.events.list;

import com.motif.agot.ang.text.instants.AngLastingEffect;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.events.AgotEvent;
import com.motif.agot.logic.events.IEventVisitor;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.logic.other.AbilityContext;
import com.motif.agot.logic.other.LastingAbilities;
import com.motif.agot.state.AgotGame;

public class ApplyLastingEffectEvent extends AgotEvent {

	private final AngLastingEffect effect;
	private final AbilityContext ac;

	public ApplyLastingEffectEvent (AngLastingEffect effect, AbilityContext ac, AgotGame game) {
		super (game);
		this.effect = effect;
		this.ac = ac;
	} // ApplyLastingEffectEvent

	@Override
	public boolean accept (IEventVisitor visitor) { return visitor.visit (this); }

	@Override
	public IAgotFlowStep start (AgotContext context) {
		LastingAbilities.subscribe (this.effect, this.ac, this.game);
		return null;
	} // start
	
} // ApplyLastingEffectEvent
