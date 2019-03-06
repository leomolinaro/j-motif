package com.motif.agot.logic.round;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.flow.task.AgotComplexTask;
import com.motif.agot.logic.round.phases.plot.PlotPhase;
import com.motif.agot.state.AgotGame;
import com.motif.shared.util.MotifConsole;

public class Round extends AgotComplexTask {

	private AgotGame game;
	private int roundNumber;
	
	public Round (int roundNumber, AgotGame game) {
		super ();
		this.roundNumber = roundNumber;
		this.game = game;
	} // Round
	
	public String getRoundTitle () { return "Round " + roundNumber; }

	@Override 
	public Round getNextTask (AgotContext context) {
		if (roundNumber < 20) {
			return new Round (roundNumber + 1, game);
		} else {
			return null;
		} // if - else
	} // getNextTask

	@Override
	public PlotPhase getStart (AgotContext context) {
		resetRoundCounters ();
		String roundTitle = getRoundTitle ();
		MotifConsole.println ("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		MotifConsole.println (roundTitle);
		MotifConsole.println ("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		game.setRound (getRoundTitle (), context);
		game.log ().round (roundTitle, context);
		return new PlotPhase (game);
	} // getStart
	
	private void resetRoundCounters () {
		game.resetRoundAbilityCounter ();
		game.resetRoundEventCounter ();
		game.players ().forEach (p -> p.resetLimitedCounter ());
	} // initRoundCounters
	
} // Round
