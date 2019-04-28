package com.motif.agot.logic.requests;

import java.util.List;

import com.motif.agot.ang.AgotText;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.state.AgotPlayer;
import com.motif.agot.state.cards.CharacterCard;

import lombok.Getter;

public class ResolveStealthRequest extends AAgotModelOptionalRequest<CharacterCard> {

	public ResolveStealthRequest(List<CharacterCard> modelChoices, AgotPlayer player, IHasResolveStealthRequest parent) {
		super(
				AAgotRequest.SELECT_CHARACTER_TO_BYPASS,
				modelChoices,
				player,
				AgotText.request().selectCharacterToBypass(player)
		);
		this.parent = parent;
	}
		
	public interface IHasResolveStealthRequest extends IAgotFlowProcess { public IAgotFlowStep after(ResolveStealthRequest decision, AgotContext context); }
	@Getter private final IHasResolveStealthRequest parent;
	@Override public IAgotFlowStep next(AgotContext context) { return this.parent.after(this, context); }
	
	@Override
	protected AAgotOption modelToOption(String key, CharacterCard model) {
		return new AgotCardOption(key, model.getId(), "Select");
	}
	
}
