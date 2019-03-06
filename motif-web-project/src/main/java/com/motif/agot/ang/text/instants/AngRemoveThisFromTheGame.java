package com.motif.agot.ang.text.instants;

import com.motif.agot.ang.text.costs.IAngCost;
import com.motif.agot.ang.text.costs.IAngCostVisitor;

public class AngRemoveThisFromTheGame implements IAngCost {

	@Override public boolean accept (IAngCostVisitor visitor) { return visitor.visit (this); }
	
} // AngRemoveThisFromTheGame
