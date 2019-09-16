package com.motif.agot.logic.phases.marshalling;

import java.util.stream.Collectors;

import com.motif.agot.ang.AgotText;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.logic.phases.APhaseStep;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;

import lombok.Getter;

public class CollectIncomeStep extends APhaseStep<IMarshallingPhaseStep> {

	@Getter private final AgotPlayer activePlayer;
	
	public interface IHasCollectIncomeStep extends IAgotFlowProcess { public APhaseStep<IMarshallingPhaseStep> after(CollectIncomeStep collectIncomeStep, AgotContext context); }
	@Getter private final IHasCollectIncomeStep parent; 
	@Override public APhaseStep<IMarshallingPhaseStep> next(AgotContext context) { return this.parent.after(this, context); }
	
	public CollectIncomeStep(AgotPlayer activePlayer, AgotGame game, IHasCollectIncomeStep parent) {
		super(game);
		this.activePlayer = activePlayer;
		this.parent = parent;
	} // CollectIncomeStep

	@Override
	public String getStepTitle () { return AgotText.title ().collectIncomeStep (activePlayer); }

	@Override
	protected IAgotFlowStep stepStart (AgotContext context) {
		int income = this.activePlayer.getIncome ();
		income += this.activePlayer.inPlayTextCards ()
				.collect (Collectors.summingInt (card -> card.getGoldModifier ()));
		this.activePlayer.gainGold (income, context);
		this.game.logManager ().collectsGold (this.activePlayer, income, context);
		return null;
	} // stepStart

} // CollectIncomeStep
