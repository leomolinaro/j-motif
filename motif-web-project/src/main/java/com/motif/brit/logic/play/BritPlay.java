package com.motif.brit.logic.play;

import com.motif.brit.endpoint.BritContext;
import com.motif.brit.logic.BritSetup;
import com.motif.brit.logic.flow.IBritFlowProcess;
import com.motif.brit.logic.flow.IBritFlowStep;
import com.motif.brit.logic.play.BritRound.IBritAfterRound;
import com.motif.brit.state.BritGame;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BritPlay implements IBritAfterRound {

	private final BritGame game;
	
	@Override
	public BritRound start(BritContext context) {
		BritSetup setup = new BritSetup();
		game.setRound("Setup", context);
		setup.execute(game, context);
		game.firstRoundNumber();
		return new BritRound(game, this);
	}
	
	public BritRound after(BritRound round, BritContext context) {
		int roundNumber = game.getRoundNumber();
		if (roundNumber < 16) {
			game.nextRoundNumber();
			return new BritRound(game, this);
		} else {
			return null;
		}
	}

	@Override
	public IBritFlowProcess getParent() { return null; }

	@Override
	public IBritFlowStep next(BritContext context) { return null; }
	
}
