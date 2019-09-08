package com.motif.agot.logic.requests;

import java.util.List;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotModelChoice;
import com.motif.agot.state.AgotPlayer;

import lombok.Getter;

public abstract class AAgotModelOptionalRequest<M extends IAgotModelChoice> extends AAgotModelRequest<M> {

	public AAgotModelOptionalRequest (AgotRequestType type, List<M> modelChoices, AgotPlayer player, String instruction) {
		super (type, modelChoices, player, instruction);
		var passChoice = AgotChoice.passChoice (type);
		this.autoChoice = modelChoices.isEmpty () ? passChoice : null;
		this.addChoice (passChoice);
	} // AAgotModelOptionalRequest

	private final AgotChoice autoChoice;
	
	@Getter private boolean hasPassed;
	
	@Override
	public boolean acceptChoice (AgotChoice choice, AgotContext context) {
		if (choice.equals (AgotChoice.passChoice (this.getType ()))) {
			this.hasPassed = true;
		} else {
			super.acceptChoice (choice, context);
		}
		return true;
	} // acceptChoice
	
	@Override
	public AgotChoice getAutoChoice () {
		return this.autoChoice;
	} // getAutoChoice

} // AAgotModelOptionalRequest
