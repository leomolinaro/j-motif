package com.motif.agot.logic.requests;

import java.util.List;

import com.motif.agot.ang.AgotText;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.act.SetupAct;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.state.AgotPlayer;

import lombok.Getter;

public class SelectCardToSetupRequest extends AAgotModelOptionalRequest<SetupAct> {

	public SelectCardToSetupRequest (List<SetupAct> modelChoices, AgotPlayer player, IHasSelectCardToSetupRequest parent) {
		super(
				AgotRequestType.SELECT_CARD_TO_SETUP,
				modelChoices,
				player,
				AgotText.request ().selectCardToSetup (player)
		);
		this.parent = parent;
	} // SelectCardToSetupRequest

	public interface IHasSelectCardToSetupRequest extends IAgotFlowProcess { public IAgotFlowStep after (SelectCardToSetupRequest decision, AgotContext context); }
	@Getter private final IHasSelectCardToSetupRequest parent; 
	@Override public IAgotFlowStep next(AgotContext context) { return this.parent.after(this, context); }
	
} // SelectCardToSetupRequest
