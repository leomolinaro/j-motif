package com.motif.agot.ang.enums;

import com.motif.agot.logic.flow.IAgotModel;

public enum AngIcon implements IAgotModel {
	MILITARY ("Military"),
	POWER ("Power"),
	INTRIGUE ("Intrigue");

	private String label;
	
	private AngIcon (String label) {
		this.label = label;
	}
	
	@Override
	public String getLabel () { return label; }

}
