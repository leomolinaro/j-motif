package com.motif.agot.logic.requests;

import java.util.List;
import java.util.stream.Stream;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotModelChoice;
import com.motif.agot.state.AgotPlayer;

import lombok.Getter;

public abstract class AAgotModelRequest<M extends IAgotModelChoice> extends AAgotRequest {

	private final List<M> models;
	public Stream<M> models() { return this.models.stream(); }
	public <T extends M> String getKeyByModel (T model) { return this.models.indexOf (model) + ""; }
	
	public AAgotModelRequest (AgotRequestType type, List<M> models, AgotPlayer player, String instruction) {
		super (type, player, instruction);
		this.models = models;
		for (var model : models) {
			this.addChoice (model.getChoice (type));
		} // for
	} // AAgotModelRequest
	
	@Getter protected M choosenModel;
	
	@Override
	protected boolean acceptChoice (AgotChoice choice, AgotContext context) {
		this.choosenModel = this.models.stream ()
		.filter (model -> model.getChoice (this.getType ()).equals(choice))
		.findFirst ()
		.get ();
		return true;
	} // acceptChoice
	
	@Override
	public AgotChoice getAutoChoice () {
		return null;
	} // getAutoChoice
	
} // AAgotModelRequest
