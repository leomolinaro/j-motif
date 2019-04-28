package com.motif.agot.logic.act;

import com.motif.agot.ang.text.instants.AngPayNGold;
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
public class MarshallingPayCostStep implements IAgotFlowProcess {

	private final AngPayNGold cost;
	private final AbilityContext ac;
	private final AgotGame game;
	
	public interface IAgotHasMarshallingPayCostStep extends IAgotFlowProcess { public IAgotFlowStep after(MarshallingPayCostStep actPayCostStep, AgotContext context); }
	@Getter private final IAgotHasMarshallingPayCostStep parent;
	@Override public IAgotFlowStep next(AgotContext context) { return this.parent.after(this, context); }
	
	@Override
	public IAgotFlowStep start(AgotContext context) {
		AgotEvent event = CardEventCreator.getEvent (this.cost, ac, game);
		return event.start (context);
		// if (mCost.appliedModifiers != null) {
		// 	 for (DelayedEffect delEff : mCost.appliedModifiers) {
		// 	   game.removeDelayedEffect (delEff);
		// 	   DebugUtil.todo ("print used modifiers");
		// 	 } // for			
		// } // if
	}

}