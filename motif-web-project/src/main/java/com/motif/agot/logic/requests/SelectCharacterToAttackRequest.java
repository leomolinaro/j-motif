package com.motif.agot.logic.requests;

import java.util.List;

import com.motif.agot.ang.AgotText;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.state.AgotPlayer;
import com.motif.agot.state.cards.CharacterCard;

import lombok.Getter;

public class SelectCharacterToAttackRequest extends AAgotModelRequest<CharacterCard> {

	public SelectCharacterToAttackRequest(List<CharacterCard> modelChoices, AgotPlayer player, IHasSelectCharacterToAttackRequest parent) {
		super(
				AAgotRequest.SELECT_CHARACTER_TO_ATTACK,
				modelChoices,
				player,
				AgotText.request ().selectCharacterToAttack(player)
		);
		this.parent = parent;
	}
		
	public interface IHasSelectCharacterToAttackRequest extends IAgotFlowProcess { public IAgotFlowStep after(SelectCharacterToAttackRequest decision, AgotContext context); }
	@Getter private final IHasSelectCharacterToAttackRequest parent;
	@Override public IAgotFlowStep next(AgotContext context) { return this.parent.after(this, context); }
	
	@Override
	protected AAgotOption modelToOption(String key, CharacterCard model) {
		return new AgotCardOption(key, model.getId(), "Attack");
	}
	
}
