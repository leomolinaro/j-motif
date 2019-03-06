package com.motif.agot.ang.text.instants;

import com.motif.agot.ang.enums.AngToken;
import com.motif.agot.ang.text.costs.IAngCost;
import com.motif.agot.ang.text.costs.IAngCostVisitor;

import lombok.Getter;

public class AngDiscardATokenFromThis implements IAngCost {

	@Getter private AngToken token;

	public AngDiscardATokenFromThis (AngToken token) {
		this.token = token;
	} // AngDiscardATokenFromThis

	@Override public boolean accept (IAngCostVisitor visitor) { return visitor.visit (this); }
	
} // AngDiscardATokenFromThis
