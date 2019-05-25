package com.motif.agot.logic.requests;

import java.util.List;

import com.motif.agot.ang.AgotText;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.state.AgotPlayer;

import lombok.Getter;

public class ChooseDefenderRequest extends AAgotModelRequest<AgotPlayer> {

	public ChooseDefenderRequest(List<AgotPlayer> modelChoices, AgotPlayer player, IHasChooseDefenderRequest parent) {
		super(
				AgotRequestType.SELECT_DEFENDER,
				modelChoices,
				player,
				AgotText.request ().selectDefender(player)
		);
		this.parent = parent;
	}
		
	public interface IHasChooseDefenderRequest extends IAgotFlowProcess { public IAgotFlowStep after(ChooseDefenderRequest decision, AgotContext context); }
	@Getter private final IHasChooseDefenderRequest parent;
	@Override public IAgotFlowStep next(AgotContext context) { return this.parent.after(this, context); }
	
}
