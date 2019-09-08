package com.motif.agot.ang.enums;

import com.motif.agot.logic.flow.IAgotModelChoice;
import com.motif.agot.logic.requests.AgotChoice;
import com.motif.agot.logic.requests.AAgotRequest.AgotRequestType;

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
	public AgotChoice getChoice (AgotRequestType requestType) {
		return AgotChoice.selectIconChoice (requestType, this);
	}

}
