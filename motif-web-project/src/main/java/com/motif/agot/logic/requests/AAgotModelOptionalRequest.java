package com.motif.agot.logic.requests;

import java.util.List;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.AgotResponse;
import com.motif.agot.logic.flow.IAgotModel;
import com.motif.agot.state.AgotPlayer;

import lombok.Getter;

public abstract class AAgotModelOptionalRequest<M extends IAgotModel> extends AAgotModelRequest<M> {

	public final static String PASS_KEY = "p";
	
	public AAgotModelOptionalRequest(String type, List<M> modelChoices, AgotPlayer player, String instruction) {
		super(type, modelChoices, player, instruction);
		this.options.add(new AgotGenericOption(PASS_KEY, "Pass"));
	}

	@Getter private boolean hasPassed;
	
	@Override
	public boolean isValidResponse (AgotResponse response) {
		var key = response.getKey ();
		if (key == null) { return false; }
		if (key.equals(PASS_KEY)) { return true; }
		return super.isValidResponse(response);
	}
	
	@Override
	public void response(AgotResponse response, AgotContext context) {
		var key = response.getKey ();
		if (key.equals(PASS_KEY)) {
			this.hasPassed = true;
		} else {
			this.hasPassed = false;
			super.response(response, context);
		}
	}

}
