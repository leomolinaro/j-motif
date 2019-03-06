package com.motif.agot.logic.act;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.flow.request.IAgotModel;
import com.motif.agot.flow.task.AgotComplexTask;
import com.motif.agot.flow.task.IAgotTask;
import com.motif.agot.logic.events.Event;
import com.motif.agot.logic.events.EventTrigger;
import com.motif.agot.state.AgotGame;

public abstract class Act extends AgotComplexTask implements IAgotModel  {

	protected AgotGame game;
	
	public Act (AgotGame game) {
		this.game = game;
	} // Act
	
	public abstract boolean canBeInitiated ();
	public abstract boolean canBePaid ();
	protected abstract ActPayCostStep getPayCostStep (AgotContext context);
	protected abstract ActChooseTargetStep getChooseTargetStep (AgotContext context);
	protected abstract Event getEvent ();
	protected ActEventStep getActEventStep (AgotContext context) { return new ActEventStep (); }
	
	@Override
	public final IAgotTask getStart (AgotContext context) {
		ActPayCostStep payCostStep = getPayCostStep (context);
		if (payCostStep == null) {
			ActChooseTargetStep chooseTargetStep = getChooseTargetStep (context);
			if (chooseTargetStep == null) {
				return getActEventStep (context);
			} else {
				return chooseTargetStep;
			} // if - else
		} else {
			return payCostStep;
		} // if - else
	} // getStart
	
	protected abstract class ActPayCostStep extends AgotComplexTask {

		@Override
		public final IAgotTask getNextTask (AgotContext context) {
			ActChooseTargetStep chooseTargetStep = getChooseTargetStep (context);
			if (chooseTargetStep == null) {
				return getActEventStep (context);
			} else {
				return chooseTargetStep;
			} // if - else
		} // getNextTask
		
	} // ActPayCostStep
	
	protected abstract class ActChooseTargetStep extends AgotComplexTask {
		
		@Override
		public final IAgotTask getNextTask (AgotContext context) {
			return getActEventStep (context);
		} // getNextTask
		
	} // ActChooseTargetStep
	
	protected class ActEventStep extends AgotComplexTask {

		@Override
		public final IAgotTask getStart (AgotContext context) {
			Event event = getEvent ();
			return EventTrigger.execute (event, game);
		} // getStart

		@Override
		public IAgotTask getNextTask (AgotContext context) {
			return null;
		} // getNextTask

	} // ActEventStep
	
	@Override
	public final IAgotTask getNextTask (AgotContext context) {
		return null;
	} // getNextTask
	
} // Act
