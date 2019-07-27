package com.motif.agot.logic.events.list;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.events.AgotEvent;
import com.motif.agot.logic.events.IEventVisitor;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;

import lombok.Getter;

public class WinDominanceEvent extends AgotEvent {

	@Getter private final AgotPlayer winner;

	public WinDominanceEvent(AgotPlayer winner, AgotGame game) {
		super(game);
		this.winner = winner;
	}

	@Override
	public IAgotFlowStep start(AgotContext context) {
		this.game.logManager().winsDominance(this.winner, context);
		this.winner.gainPowerOnTheFactionCard(context);
		this.game.logManager().dominanceGainPower(this.winner, context);
		return null;
	}

	@Override public boolean accept(IEventVisitor visitor) { return visitor.visit(this); }

}
