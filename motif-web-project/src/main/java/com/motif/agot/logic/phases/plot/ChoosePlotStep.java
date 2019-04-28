package com.motif.agot.logic.phases.plot;

import java.util.Iterator;
import java.util.stream.Collectors;

import com.motif.agot.ang.AgotText;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.logic.phases.APhaseStep;
import com.motif.agot.logic.requests.ChoosePlotRequest;
import com.motif.agot.logic.requests.ChoosePlotRequest.IHasChoosePlotRequest;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;

import lombok.Getter;

public class ChoosePlotStep extends APhaseStep<IPlotPhaseStep> implements IHasChoosePlotRequest {

	public interface IAgotHasChoosePlotStep extends IAgotFlowProcess { public APhaseStep<IPlotPhaseStep> after(ChoosePlotStep choosePlotStep, AgotContext context); }
	@Getter private final IAgotHasChoosePlotStep parent; 
	@Override public APhaseStep<IPlotPhaseStep> next(AgotContext context) { return this.parent.after(this, context); }
	
	private Iterator<AgotPlayer> playerIt = null;
	private AgotPlayer currPlayer = null;
	
	public ChoosePlotStep(AgotGame game, IAgotHasChoosePlotStep parent) {
		super(game);
		this.parent = parent;
	}

	@Override
	public String getStepTitle () { return AgotText.title ().choosePlotStep (); }

	@Override
	public IAgotFlowStep stepStart(AgotContext context) {
		this.playerIt = game.players().iterator();
		this.currPlayer = playerIt.next();
		return new ChoosePlotRequest(this.currPlayer.plotDeck().collect(Collectors.toList()), this.currPlayer, this);
	}

	@Override
	public IAgotFlowStep after(ChoosePlotRequest choosePlotRequest, AgotContext context) {
		this.currPlayer.choosePlot(choosePlotRequest.getChoosenModel(), context);
		if (this.playerIt.hasNext()) {
			this.currPlayer = playerIt.next();
			return new ChoosePlotRequest(this.currPlayer.plotDeck().collect(Collectors.toList()), this.currPlayer, this);
		}
		return null;
	}

}
