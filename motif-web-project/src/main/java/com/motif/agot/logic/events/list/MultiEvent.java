package com.motif.agot.logic.events.list;

import java.util.Iterator;
import java.util.List;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.events.AgotEvent;
import com.motif.agot.logic.events.IAgotHasEvent;
import com.motif.agot.logic.events.IEventVisitor;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.state.AgotGame;

import lombok.Getter;

public class MultiEvent extends AgotEvent implements IAgotHasEvent {

	@Getter private final List<? extends AgotEvent> events;
	private Iterator<? extends AgotEvent> eventIt;
	
	public MultiEvent(List<? extends AgotEvent> events, AgotGame game) {
		super(game);
		this.events = events;
	}

	@Override
	public IAgotFlowStep start(AgotContext context) {
		this.eventIt = events.iterator();
		var firstEvent = this.eventIt.next();
		firstEvent.setParent(this);
		return firstEvent;
	}
	
	@Override
	public IAgotFlowStep after(AgotEvent event, AgotContext context) {
		if (this.eventIt.hasNext()) {
			var nextEvent = this.eventIt.next();
			nextEvent.setParent(this);
			return nextEvent;
		} else {
			return null;
		}
	}
	
	@Override public boolean accept (IEventVisitor visitor) { return visitor.visit (this); }

}
