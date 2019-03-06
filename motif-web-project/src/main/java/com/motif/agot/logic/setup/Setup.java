package com.motif.agot.logic.setup;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.state.AgotGame;

public class Setup {

	public void execute (AgotGame game, AgotContext context) {
		game.players ().forEach (player -> {
			player.shuffleDeck ();
			player.draw (7, context);			
		});
	} // execute

} // Setup