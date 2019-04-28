package com.motif.agot.logic.requests;

import java.util.List;

import com.motif.agot.ang.AgotText;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.state.AgotPlayer;

import lombok.Getter;

public class FirstPlayerRequest extends AAgotModelRequest<AgotPlayer> {

	public FirstPlayerRequest(List<AgotPlayer> modelChoices, AgotPlayer player, IHasFirstPlayerRequest parent) {
		super(
				AAgotRequest.SELECT_FIRST_PLAYER,
				modelChoices,
				player,
				AgotText.request().selectFirstPlayer(player)
		);
		this.parent = parent;
	}
	
	public interface IHasFirstPlayerRequest extends IAgotFlowProcess { public IAgotFlowStep after(FirstPlayerRequest decision, AgotContext context); }
	@Getter private final IHasFirstPlayerRequest parent; 
	@Override public IAgotFlowStep next(AgotContext context) { return this.parent.after(this, context); }
	
	@Override
	protected AAgotOption modelToOption(String key, AgotPlayer player) {
		return new AgotGenericOption(key, player.getLabel());
	}
	
}
