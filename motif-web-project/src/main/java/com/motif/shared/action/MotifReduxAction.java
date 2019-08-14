package com.motif.shared.action;

import com.google.gson.annotations.Expose;

public abstract class MotifReduxAction<T, D extends MotifReduxActionData> {
	
	@Expose
	protected T type;
	
	@Expose
	protected D payload;

	public MotifReduxAction (T type, D data) {
		super();
		this.type = type;
		this.payload = data;
	} // MotifReduxAction

} // MotifReduxAction
