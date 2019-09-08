package com.motif.agot.logic.setup;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.AgotFlowParallelSteps;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.logic.setup.AgotSetupPlayer.IHasAgotSetupPlayer;
import com.motif.agot.state.AgotGame;
import com.motif.shared.util.MotifConsole;

import lombok.Getter;

public class AgotSetup implements IAgotFlowProcess, IHasAgotSetupPlayer {

	private final AgotGame game;

	public interface IHasAgotSetup extends IAgotFlowProcess { public IAgotFlowStep after (AgotSetup setup, AgotContext context); }
	@Getter private final IHasAgotSetup parent;
	@Override public IAgotFlowStep next (AgotContext context) { return this.parent.after (this, context); }
	
	public AgotSetup (AgotGame game, IHasAgotSetup parent) {
		this.game = game;
		this.parent = parent;
	} // AgotSetup
	
	@Override
	public AgotFlowParallelSteps start (AgotContext context) {
		MotifConsole.println ("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		MotifConsole.println ("Setup");
		MotifConsole.println ("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		this.game.setRound ("Setup", context);
		this.game.logManager ().round ("Setup", context);
		
		return AgotFlowParallelSteps.of (this.game.players ()
				.map (p -> new AgotSetupPlayer (p, this.game, this))
		);
	} // start

	private int completedParallelSteps = 0;
	
	@Override
	public IAgotFlowStep after (AgotSetupPlayer setupPlayer, AgotContext context) {
		this.completedParallelSteps++;
		if (this.completedParallelSteps == this.game.getNumPlayers ()) {
			return null;
		} else {
			return AgotFlowParallelSteps.getFlowWait ();
		} // if - else
	} // after

} // Setup
