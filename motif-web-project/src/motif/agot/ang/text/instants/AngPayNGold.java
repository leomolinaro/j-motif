package motif.agot.ang.text.instants;

import motif.agot.ang.text.costs.IAngCost;
import motif.agot.ang.text.costs.IAngCostVisitor;

public class AngPayNGold implements IAngCost {

	private int nGold;
	public int getNGold () { return nGold; }

	public AngPayNGold (int nGold) {
		this.nGold = nGold;
	} // AngPayNGold
	
	@Override public boolean accept (IAngCostVisitor visitor) { return visitor.visit (this); }
	
} // AngPayNGold
