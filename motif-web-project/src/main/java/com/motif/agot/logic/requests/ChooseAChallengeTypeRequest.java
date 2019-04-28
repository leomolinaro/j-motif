package com.motif.agot.logic.requests;

import java.util.List;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngIcon;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.state.AgotPlayer;

import lombok.Getter;

public class ChooseAChallengeTypeRequest extends AAgotModelOptionalRequest<AngIcon> {

	public ChooseAChallengeTypeRequest(List<AngIcon> modelChoices, AgotPlayer player, IHasChooseAChallengeTypeRequest parent) {
		super(
				AAgotRequest.SELECT_CHALLENGE_TO_INITIATE,
				modelChoices,
				player,
				AgotText.request().selectChallengeToInitiate(player)
		);
		this.parent = parent;
	}
	
	public interface IHasChooseAChallengeTypeRequest extends IAgotFlowProcess { public IAgotFlowStep after(ChooseAChallengeTypeRequest decision, AgotContext context); }
	@Getter private final IHasChooseAChallengeTypeRequest parent; 
	@Override public IAgotFlowStep next(AgotContext context) { return this.parent.after(this, context); }
	
	@Override
	protected AAgotOption modelToOption(String key, AngIcon icon) {
		return new AgotGenericOption(key, icon.getLabel());
	}
	
}
