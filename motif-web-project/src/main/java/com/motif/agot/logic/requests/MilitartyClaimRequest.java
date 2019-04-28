package com.motif.agot.logic.requests;

import java.util.List;

import com.motif.agot.ang.AgotText;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.state.AgotPlayer;
import com.motif.agot.state.cards.CharacterCard;

import lombok.Getter;

public class MilitartyClaimRequest extends AAgotModelRequest<CharacterCard> {

	public MilitartyClaimRequest(List<CharacterCard> modelChoices, AgotPlayer player, IHasMilitartyClaimRequest parent) {
		super(
				AAgotRequest.SELECT_CHARACTER_TO_KILL,
				modelChoices,
				player,
				AgotText.request().selectCharacterToKill(player)
		);
		this.parent = parent;
	}
		
	public interface IHasMilitartyClaimRequest extends IAgotFlowProcess { public IAgotFlowStep after(MilitartyClaimRequest decision, AgotContext context); }
	@Getter private final IHasMilitartyClaimRequest parent;
	@Override public IAgotFlowStep next(AgotContext context) { return this.parent.after(this, context); }
	
	@Override
	protected AAgotOption modelToOption(String key, CharacterCard model) {
		return new AgotCardOption(key, model.getId(), "Select");
	}
	
}
