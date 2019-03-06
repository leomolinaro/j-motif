package com.motif.agot.logic.events;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.flow.task.AgotComplexTask;
import com.motif.agot.flow.task.IAgotTask;
import com.motif.agot.logic.other.ConsAbilities;
import com.motif.agot.logic.other.LastingAbilities;
import com.motif.agot.state.AgotGame;

public class EffectWindow extends AgotComplexTask {
	
	private AgotGame game;
	private Event event;
	
	public EffectWindow (Event event, AgotGame game) {
		this.game = game;
		this.event = event;
	} // EffectResolver
	
	@Override
	public IAgotTask getStart (AgotContext context) {
		return event.resolveEffect (context);				
	} // getStart

	@Override
	public final IAgotTask getNextTask (AgotContext context) {
		LastingAbilities.refresh (event, game);
		ConsAbilities.refresh (game);
		return new ReactionWindow (event, game);
	} // getNextTask
	
} // EffectResolverStep