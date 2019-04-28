package com.motif.agot.logic.act;

import com.motif.agot.ang.text.costs.IAngCost;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.events.AgotEvent;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.logic.other.AbilityContext;
import com.motif.agot.logic.visitors.CardEventCreator;
import com.motif.agot.state.AgotGame;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TrigAbilityPayCostStep implements IAgotFlowProcess {

	private final IAngCost cost;
	private final AbilityContext ac;
	private final AgotGame game;
	
	public interface IAgotHasTrigAbilityPayCostStep extends IAgotFlowProcess { public IAgotFlowStep after(TrigAbilityPayCostStep actPayCostStep, AgotContext context); }
	@Getter private final IAgotHasTrigAbilityPayCostStep parent;
	@Override public IAgotFlowStep next(AgotContext context) { return this.parent.after(this, context); }

	@Override
	public IAgotFlowStep start(AgotContext context) {
		AgotEvent event = CardEventCreator.getEvent(this.cost, this.ac, this.game);
		return event.start(context);
	}

}