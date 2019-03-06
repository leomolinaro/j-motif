package com.motif.agot.logic.round.phases.marshalling;

import java.util.stream.Collectors;

import com.motif.agot.ang.AgotText;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.flow.task.IAgotTask;
import com.motif.agot.logic.round.phases.Step;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;

public class CollectIncomeStep extends Step<IMarshallingPhaseStep> {

	private AgotPlayer activePlayer;
		
	public CollectIncomeStep (AgotPlayer activePlayer, AgotGame game) {
		super (game);
		this.activePlayer = activePlayer;
	} // CollectIncome

	@Override
	public String getStepTitle () { return AgotText.title ().collectIncomeStep (activePlayer); }

	@Override
	public IAgotTask getStartTask (AgotContext context) {
		int income = activePlayer.getIncome ();
		income += activePlayer.inPlayTextCards ().collect (Collectors.summingInt (card -> card.getGoldModifier ()));
		activePlayer.gainGold (income, context);
		game.log ().collectsGold (activePlayer, income, context);
		return null;
	} // getStartTask

	@Override
	public MarshallingActionStep getNextTask (AgotContext context) {
		return new MarshallingActionStep (activePlayer, game);
	} // getNextTask

} // CollectIncomeStep
