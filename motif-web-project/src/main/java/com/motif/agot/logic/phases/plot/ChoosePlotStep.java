package com.motif.agot.logic.phases.plot;

import java.util.stream.Collectors;

import com.motif.agot.ang.AgotText;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.AgotFlowParallelSteps;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.logic.other.ExitGameProcedure;
import com.motif.agot.logic.phases.APhaseStep;
import com.motif.agot.logic.requests.ChoosePlotRequest;
import com.motif.agot.logic.requests.ChoosePlotRequest.IHasChoosePlotRequest;
import com.motif.agot.state.AgotGame;

import lombok.Getter;

public class ChoosePlotStep extends APhaseStep<IPlotPhaseStep> implements IHasChoosePlotRequest {

	public interface IAgotHasChoosePlotStep extends IAgotFlowProcess { public APhaseStep<IPlotPhaseStep> after(ChoosePlotStep choosePlotStep, AgotContext context); }
	@Getter private final IAgotHasChoosePlotStep parent; 
	@Override public APhaseStep<IPlotPhaseStep> next(AgotContext context) { return this.parent.after(this, context); }
	
	public ChoosePlotStep (AgotGame game, IAgotHasChoosePlotStep parent) {
		super (game);
		this.parent = parent;
	} // ChoosePlotStep

	@Override
	public String getStepTitle () { return AgotText.title ().choosePlotStep (); }

	@Override
	public IAgotFlowStep stepStart(AgotContext context) {
		return AgotFlowParallelSteps.of (this.game.players ()
				.map (p -> new ChoosePlotRequest (p.plotDeck().collect (Collectors.toList()), p, this))
		);
	}

	private int completedParallelSteps = 0;
	
	@Override
	public IAgotFlowStep after (ChoosePlotRequest choosePlotRequest, AgotContext context) {
		var player = choosePlotRequest.getPlayer ();
		
		var prevPlot = player.revealedPlot ();
		prevPlot.ifPresent (p -> ExitGameProcedure.discardPlot (p, player, game, context));
		player.choosePlot (choosePlotRequest.getChoosenModel(), context);
		
		this.completedParallelSteps++;
		if (this.completedParallelSteps == this.game.getNumPlayers ()) {
			return null;
		} else {
			return AgotFlowParallelSteps.getFlowWait ();
		} // if - else
	}

}
