package com.motif.agot.logic.requests;

import java.util.List;

import com.motif.agot.ang.AgotText;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.state.AgotPlayer;
import com.motif.agot.state.cards.PlotCard;

import lombok.Getter;

public class ChoosePlotRequest extends AAgotModelRequest<PlotCard> {

	public ChoosePlotRequest(List<PlotCard> modelChoices, AgotPlayer player, IHasChoosePlotRequest parent) {
		super(
				AAgotRequest.SELECT_PLOT_TO_REVEAL,
				modelChoices,
				player,
				AgotText.request().selectPlotToReveal(player)
		);
		this.parent = parent;
	}
		
	public interface IHasChoosePlotRequest extends IAgotFlowProcess { public IAgotFlowStep after(ChoosePlotRequest choosePlotRequest, AgotContext context); }
	@Getter private final IHasChoosePlotRequest parent;
	@Override public IAgotFlowStep next(AgotContext context) { return this.parent.after(this, context); }
	
	@Override
	protected AAgotOption modelToOption(String key, PlotCard model) {
		return new AgotCardOption(key, model.getId(), "Select");
	}
	
}
