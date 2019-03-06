package com.motif.agot.ang.enums;

import com.motif.agot.flow.request.IAgotModel;
import com.motif.agot.flow.request.IAgotModelVisitor;

public enum AngIcon implements IAgotModel {
	MILITARY ("Military"),
	POWER ("Power"),
	INTRIGUE ("Intrigue");

	private String label;
	
	private AngIcon (String label) {
		this.label = label;
	} // AngIcon
	
	@Override
	public String getLabel () { return label; }

	@Override public void accept (IAgotModelVisitor visitor) { visitor.visit (this); }
	
} // AngIcon
