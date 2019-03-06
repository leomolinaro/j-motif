package com.motif.agot.logic.round.phases.dominance;

import java.util.ArrayList;
import java.util.Comparator;

import com.motif.agot.ang.AgotText;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.flow.task.IAgotTask;
import com.motif.agot.logic.events.Event;
import com.motif.agot.logic.events.EventTrigger;
import com.motif.agot.logic.events.list.WinDominanceEvent;
import com.motif.agot.logic.round.phases.Step;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;
import com.motif.shared.util.ComparatorUtil;

public class DetermineDominanceStep extends Step<IDominancePhaseStep> {
	
	public DetermineDominanceStep (AgotGame game) {
		super (game);
	} // DetermineDominanceStep
	
	@Override
	public String getStepTitle () { return AgotText.title ().determineDominanceStep (); }
	
	@Override
	public IAgotTask getStartTask (AgotContext context) {		
		ArrayList<AgotPlayer> dominanceWinners = ComparatorUtil.getMax (game.players (), new Comparator<AgotPlayer>() {
			@Override
			public int compare (AgotPlayer p1, AgotPlayer p2) {				
				int comparison = Integer.compare (p1.getDominance (), p2.getDominance ());
				if (comparison < 0) {
					game.log ().hasMoreDominanceThan (p2, p1, context);
				} else if (comparison > 0) {
					game.log ().hasMoreDominanceThan (p1, p2, context);					
				} else {
					game.log ().haveTheSameDominance (p1, p2, context);
				} // if- else
				return comparison;
			} // comparator
		}); // getMax
		
		if (dominanceWinners.size () > 1) {
			game.log ().dominanceTie (context);
			return null;
		} else {
			AgotPlayer dominanceWinner = dominanceWinners.get (0);
			Event event = new WinDominanceEvent (dominanceWinner, game);
			return EventTrigger.execute (event, game);
		} // if - else
	} // getStartTask

	@Override
	public DominanceActionStep getNextTask (AgotContext context) {
		return new DominanceActionStep (game);
	} // getNextTask

} // DetermineDominanceStep
