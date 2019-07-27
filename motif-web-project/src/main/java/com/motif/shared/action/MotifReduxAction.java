package com.motif.shared.action;

import com.google.gson.annotations.Expose;

public abstract class MotifReduxAction<D extends MotifReduxActionData> {
	
	@Expose
	private String type;
	@Expose
	private D payload;

	public MotifReduxAction(String type, D data) {
		super();
		this.type = type;
		this.payload = data;
	}

}
