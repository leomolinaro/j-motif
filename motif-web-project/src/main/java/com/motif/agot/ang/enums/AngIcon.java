package com.motif.agot.ang.enums;

import com.motif.agot.logic.flow.IAgotModelChoice;
import com.motif.agot.logic.requests.AgotChoice;

import lombok.Getter;

public enum AngIcon implements IAgotModelChoice {
	MILITARY("military"),
	POWER("power"),
	INTRIGUE("intrigue");

	@Getter private final String label;
	
	private AngIcon(String label) {
		this.label = label;
	}
	
	@Override
	public AgotChoice getChoice() {
		return AgotChoice.selectIconChoice(this);
	}

}
