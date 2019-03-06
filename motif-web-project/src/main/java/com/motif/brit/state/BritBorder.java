package com.motif.brit.state;

import lombok.Getter;

public class BritBorder {

	public enum BritBorderType {
		NORMAL_BORDER, STRAIT 
	} // BritBorderType
	
	@Getter private BritArea to;
	
	@Getter private BritBorderType borderType;

	public BritBorder (BritArea to, BritBorderType borderType) {
		this.to = to;
		this.borderType = borderType;
	} // BritBorder
	
} // BritBorder
