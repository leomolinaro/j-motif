package com.motif.agot.logic.events.list;

import java.util.Iterator;
import java.util.List;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.flow.task.AgotComplexTask;
import com.motif.agot.flow.task.IAgotTask;
import com.motif.agot.logic.events.Event;
import com.motif.agot.logic.events.IEventVisitor;
import com.motif.agot.state.AgotGame;

import lombok.Getter;

public class MultiEvent extends Event {

	@Getter private List<? extends Event> events;

	public MultiEvent (List<? extends Event> events, AgotGame game) {
		super (game);
		this.events = events;
	} // MultiEvent

	@Override
	public IAgotTask resolveEffect (AgotContext context) {
		Iterator<? extends Event> eventIt = events.iterator ();
		SubEventResolver subResolver = new SubEventResolver (eventIt);
		return subResolver.getStart (context);
	} // resolveEffect
	
	@Override public boolean accept (IEventVisitor visitor) { return visitor.visit (this); }
	
	private class SubEventResolver extends AgotComplexTask {

		private Iterator<? extends Event> eventIt;

		private SubEventResolver (Iterator<? extends Event> eventIt) {
			this.eventIt = eventIt;
		} // SubEventResolver

		@Override
		public IAgotTask getStart (AgotContext context) {
			Event event = eventIt.next ();
			return event.resolveEffect (context);
		} // getStart

		@Override
		public IAgotTask getNextTask (AgotContext context) {
			if (eventIt.hasNext ()) {
				return new SubEventResolver (eventIt);
			} else {
				return null;
			} // if - else
		} // getNextTask
		
	} // SubEventResolver

} // MultiEvent
