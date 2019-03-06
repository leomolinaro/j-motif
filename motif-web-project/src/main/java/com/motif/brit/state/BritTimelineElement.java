package com.motif.brit.state;

import lombok.Getter;

public class BritTimelineElement {
	
	@Getter private BritNation nation;
	@Getter private BritArea area;
	@Getter private int numInvaders;
	
	public BritTimelineElement (BritNation nation, BritArea area, int numInfantries) {
		this.nation = nation;
		this.area = area;
		this.numInvaders = numInfantries;
	} // BritTimelineElement
	
} // BritTimelineElement
