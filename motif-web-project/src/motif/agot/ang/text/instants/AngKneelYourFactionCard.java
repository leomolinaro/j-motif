package motif.agot.ang.text.instants;

import motif.agot.ang.text.costs.IAngCost;
import motif.agot.ang.text.costs.IAngCostVisitor;

public class AngKneelYourFactionCard implements IAngCost {

	@Override public boolean accept (IAngCostVisitor visitor) { return visitor.visit (this); }
	
} // AngKneelYourFactionCard
