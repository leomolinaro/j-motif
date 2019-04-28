package com.motif.agot.logic.requests;

import java.util.List;
import java.util.stream.Stream;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.AgotResponse;
import com.motif.agot.logic.flow.IAgotModel;
import com.motif.agot.state.AgotPlayer;

import lombok.Getter;

public abstract class AAgotModelRequest<M extends IAgotModel> extends AAgotRequest {

	private final List<M> models;
	public Stream<M> models() { return this.models.stream(); }
	public <T extends M> String getKeyByModel (T model) { return this.models.indexOf (model) + ""; }
	
	public AAgotModelRequest(String type, List<M> models, AgotPlayer player, String instruction) {
		super(type, player, instruction);
		this.models = models;
		int index = 0;
		for (M model : models) {
			this.options.add(modelToOption(index + "", model));
			index++;
		}
	}
	
	protected abstract AAgotOption modelToOption(String key, M model);

	@Getter protected M choosenModel;
	
	@Override
	public boolean isValidResponse (AgotResponse response) {
		String key = response.getKey ();
		if (key == null) { return false; }
		if (this.models != null && key.matches ("\\d+")) {
			int index = Integer.parseInt (key);
			if (index >= 0 && index < this.models.size ()) { return true; }
		}
		return false;
	}
	
	@Override
	public void response(AgotResponse response, AgotContext context) {
		String key = response.getKey ();
		M choice = null;
		if (this.models != null && key.matches ("\\d+")) { choice = this.models.get(Integer.parseInt (key)); }
		this.choosenModel = choice;
	}
	
}
