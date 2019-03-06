package com.motif.agot.logic;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.flow.task.AgotComplexTask;
import com.motif.agot.flow.task.IAgotTask;
import com.motif.agot.logic.round.Round;
import com.motif.agot.logic.setup.Setup;
import com.motif.agot.state.AgotGame;
import com.motif.shared.util.MotifConsole;

public class GameFlow extends AgotComplexTask {

	private AgotGame game;
	
	public GameFlow (AgotGame game) {
		this.game = game;
	} // GameFlow

	@Override
	public Round getStart (AgotContext context) {
		Setup setup = new Setup ();
		MotifConsole.println ("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		MotifConsole.println ("Setup");
		MotifConsole.println ("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		game.setRound ("Setup", context);
		setup.execute (game, context);
		game.prepare (context);
		return new Round (1, game);
	} // getStart

	@Override public IAgotTask getNextTask (AgotContext context) { return null; }
	
} // GameFlow
