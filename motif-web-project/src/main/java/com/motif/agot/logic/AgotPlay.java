package com.motif.agot.logic;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.AgotRound.IAgotAfterRound;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.logic.setup.Setup;
import com.motif.agot.state.AgotGame;
import com.motif.shared.util.MotifConsole;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AgotPlay implements IAgotAfterRound {

	private final AgotGame game;

	@Override
	public AgotRound start(AgotContext context) {
		Setup setup = new Setup();
		MotifConsole.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		MotifConsole.println("Setup");
		MotifConsole.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		game.setRound("Setup", context);
		setup.execute(game, context);
		game.prepare(context);
		return new AgotRound(1, game, this);
	}

	@Override
	public IAgotFlowStep after(AgotRound round, AgotContext context) {
		if (round.getRoundNumber() < 20) {
			resetRoundCounters ();
			return new AgotRound(round.getRoundNumber() + 1, game, this);
		} else {
			return null;
		}
	}
	
	private void resetRoundCounters () {
		game.resetRoundAbilityCounter ();
		game.resetRoundEventCounter ();
		game.players ().forEach (p -> p.resetLimitedCounter ());
	}

	@Override
	public IAgotFlowProcess getParent() {
		return null;
	}

	@Override
	public IAgotFlowStep next(AgotContext context) {
		return null;
	}

}
