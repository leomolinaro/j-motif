package com.motif.agot.logic.requests;

import java.util.List;

import com.motif.agot.ang.AgotText;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.act.ReactionAct;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.state.AgotPlayer;

import lombok.Getter;

public class SelectReactionToPerformRequest extends AAgotModelOptionalRequest<ReactionAct> {

	public SelectReactionToPerformRequest(List<ReactionAct> models, AgotPlayer player, IHasSelectReactionToPerformRequest parent) {
		super(
				AAgotRequest.SELECT_REACTION_TO_PERFORM,
				models,
				player,
				AgotText.request().selectReactionToPerform(player)
		);
		this.parent = parent;
	}
	
	public interface IHasSelectReactionToPerformRequest extends IAgotFlowProcess { public IAgotFlowStep after(SelectReactionToPerformRequest decision, AgotContext context); }
	@Getter private final IHasSelectReactionToPerformRequest parent; 
	@Override public IAgotFlowStep next(AgotContext context) { return this.parent.after(this, context); }
	
	@Override
	protected AAgotOption modelToOption(String key, ReactionAct model) {
		return new AgotCardOption(key, model.getTrigCard().getId(), "React");
	}
	
}