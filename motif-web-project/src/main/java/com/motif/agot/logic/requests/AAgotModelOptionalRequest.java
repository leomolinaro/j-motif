package com.motif.agot.logic.requests;

import java.util.List;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotModelChoice;
import com.motif.agot.state.AgotPlayer;

import lombok.Getter;

public abstract class AAgotModelOptionalRequest<M extends IAgotModelChoice> extends AAgotModelRequest<M> {

	public AAgotModelOptionalRequest(AgotRequestType type, List<M> modelChoices, AgotPlayer player, String instruction) {
		super(type, modelChoices, player, instruction);
		this.addChoice(AgotChoice.passChoice());
	}

	@Getter private boolean hasPassed;
	
	@Override
	public boolean accept(AgotChoice choice, AgotContext context) {
		if (choice.equals(AgotChoice.passChoice())) {
			this.hasPassed = true;
		} else {
			super.accept(choice, context);
		}
		return true;
	}

}
