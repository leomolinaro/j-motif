package com.motif.agot.logic.requests;

import java.util.List;

import com.motif.agot.ang.AgotText;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.state.AgotPlayer;
import com.motif.agot.state.cards.CharacterCard;

import lombok.Getter;

public class ChooseDefenderCharacterRequest extends AAgotModelOptionalRequest<CharacterCard> {

	public ChooseDefenderCharacterRequest(List<CharacterCard> modelChoices, AgotPlayer player, IHasChooseDefenderCharacterRequest parent) {
		super(
				AgotRequestType.SELECT_CHARACTER_TO_DEFEND,
				modelChoices,
				player,
				 AgotText.request().selectCharacterToDefend(player)
		);
		this.parent = parent;
	}
		
	public interface IHasChooseDefenderCharacterRequest extends IAgotFlowProcess { public IAgotFlowStep after(ChooseDefenderCharacterRequest decision, AgotContext context); }
	@Getter private final IHasChooseDefenderCharacterRequest parent;
	@Override public IAgotFlowStep next(AgotContext context) { return this.parent.after(this, context); }
	
}
