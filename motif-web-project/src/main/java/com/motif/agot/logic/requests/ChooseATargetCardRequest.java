package com.motif.agot.logic.requests;

import java.util.List;

import com.motif.agot.ang.AgotText;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.state.AgotPlayer;
import com.motif.agot.state.cards.Card;

import lombok.Getter;

public class ChooseATargetCardRequest extends AAgotModelRequest<Card<?>> {

	public ChooseATargetCardRequest(List<Card<?>> modelChoices, AgotPlayer player, IAgotHasChooseATargetCardRequest parent) {
		super(
				AAgotRequest.CHOOSE_CARD,
				modelChoices,
				player,
				AgotText.request().chooseACard(player)
		);
		this.parent = parent;
	}
	
	public interface IAgotHasChooseATargetCardRequest extends IAgotFlowProcess { public IAgotFlowStep after(ChooseATargetCardRequest chooseATargetCardDecision, AgotContext context); }
	@Getter private final IAgotHasChooseATargetCardRequest parent; 
	@Override public IAgotFlowStep next(AgotContext context) { return this.parent.after(this, context); }
	
	@Override
	protected AAgotOption modelToOption(String key, Card<?> model) {
		return new AgotCardOption(key, model.getId(), "Choose");
	}
	
}