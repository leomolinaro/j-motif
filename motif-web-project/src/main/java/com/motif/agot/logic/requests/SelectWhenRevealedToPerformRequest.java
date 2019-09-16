package com.motif.agot.logic.requests;

import java.util.List;

import com.motif.agot.ang.AgotText;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.act.WhenRevealedAct;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.state.AgotPlayer;

import lombok.Getter;

public class SelectWhenRevealedToPerformRequest extends AAgotModelRequest<WhenRevealedAct> {

	public SelectWhenRevealedToPerformRequest (List<WhenRevealedAct> models, AgotPlayer player, IHasSelectWhenRevealedToPerformRequest parent) {
		super(
				AgotRequestType.SELECT_REACTION_TO_PERFORM,
				models,
				player,
				AgotText.request ().selectWhenRevealedToPerform (player)
		);
		this.parent = parent;
	} // SelectWhenRevealedToPerformRequest
	
	public interface IHasSelectWhenRevealedToPerformRequest extends IAgotFlowProcess { public IAgotFlowStep after (SelectWhenRevealedToPerformRequest decision, AgotContext context); }
	@Getter private final IHasSelectWhenRevealedToPerformRequest parent; 
	@Override public IAgotFlowStep next (AgotContext context) { return this.parent.after (this, context); }
	
} // SelectWhenRevealedToPerformRequest