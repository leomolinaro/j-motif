package com.motif.agot.logic.requests;

import java.util.List;

import com.motif.agot.ang.AgotText;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.act.IPhaseAct;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.state.AgotPlayer;

import lombok.Getter;

public class SelectActionToPerformRequest<A extends IPhaseAct> extends AAgotModelOptionalRequest<A> {

	public SelectActionToPerformRequest(List<A> modelChoices, AgotPlayer player, IHasSelectActionToPerformRequest<A> parent) {
		super(
				AAgotRequest.SELECT_ACTION_TO_PERFORM,
				modelChoices,
				player,
				AgotText.request().selectActionToPerform(player)
		);
		this.parent = parent;
	}

	public interface IHasSelectActionToPerformRequest<A extends IPhaseAct> extends IAgotFlowProcess { public IAgotFlowStep after(SelectActionToPerformRequest<A> decision, AgotContext context); }
	@Getter private final IHasSelectActionToPerformRequest<A> parent; 
	@Override public IAgotFlowStep next(AgotContext context) { return this.parent.after(this, context); }
	
	@Override
	protected AAgotOption modelToOption(String key, A model) {
		return new AgotCardOption(key, model.getCardId(), model.getLabel());
	}
	
}