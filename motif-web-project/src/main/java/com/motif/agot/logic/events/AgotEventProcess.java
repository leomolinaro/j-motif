package com.motif.agot.logic.events;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.events.AgotInterruptWindow.IAgotHasInterruptWindow;
import com.motif.agot.logic.events.AgotReactionWindow.IAgotHasReactionWindow;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.logic.other.ConsAbilities;
import com.motif.agot.logic.other.LastingAbilities;
import com.motif.agot.state.AgotGame;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AgotEventProcess implements IAgotHasInterruptWindow, IAgotHasEvent, IAgotHasReactionWindow {

	private final AgotEvent event;
	private final AgotGame game;

	@Getter private final IAgotHasEventProcess parent;
	@Override public IAgotFlowStep next(AgotContext context) { return this.parent.after(this, context); }
	
	@Override
	public IAgotFlowStep start (AgotContext context) {
		return new AgotInterruptWindow (event, game, this); // new WouldInterruptWindow (event, game);
	} // start

	@Override
	public IAgotFlowStep after (AgotInterruptWindow interruptWindow, AgotContext context) {
		this.event.setParent (this);
		return this.event;
	} // after
	
	@Override
	public IAgotFlowStep after (AgotEvent event, AgotContext context) {
		LastingAbilities.refresh (event, this.game);
		ConsAbilities.refresh (this.game);
		return new AgotReactionWindow (event, this.game, this);
	} // after

	@Override
	public IAgotFlowStep after (AgotReactionWindow reactionWindow, AgotContext context) {
		// TODO Auto-generated method stub
		return null;
	} // after

} // AgotEventProcess
