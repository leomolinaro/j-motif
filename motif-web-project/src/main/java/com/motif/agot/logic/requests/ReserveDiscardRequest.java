package com.motif.agot.logic.requests;

import java.util.List;

import com.motif.agot.ang.AgotText;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.state.AgotPlayer;
import com.motif.agot.state.cards.DrawCard;

import lombok.Getter;

public class ReserveDiscardRequest extends AAgotModelRequest<DrawCard<?>> {

	public ReserveDiscardRequest(List<DrawCard<?>> modelChoices, AgotPlayer player, IHasReserveDiscardRequest parent) {
		super(
				AAgotRequest.SELECT_CARD_TO_DISCARD,
				modelChoices,
				player,
				AgotText.request().selectCardToDiscard(player)
		);
		this.parent = parent;
	}
		
	public interface IHasReserveDiscardRequest extends IAgotFlowProcess { public IAgotFlowStep after(ReserveDiscardRequest decision, AgotContext context); }
	@Getter private final IHasReserveDiscardRequest parent; 
	@Override public IAgotFlowStep next(AgotContext context) { return this.parent.after(this, context); }
	
	@Override
	protected AAgotOption modelToOption(String key, DrawCard<?> model) {
		return new AgotCardOption(key, model.getId(), "Select");
	}
	
}
