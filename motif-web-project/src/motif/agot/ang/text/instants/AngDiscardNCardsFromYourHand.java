package motif.agot.ang.text.instants;

import motif.agot.ang.text.costs.IAngCost;
import motif.agot.ang.text.costs.IAngCostVisitor;

public class AngDiscardNCardsFromYourHand implements IAngCost {

	private int n;
	public int getN () { return n; }

	public AngDiscardNCardsFromYourHand (int n) {
		this.n = n;
	} // AngDiscardNCardsFromYourHand

	@Override public boolean accept (IAngCostVisitor visitor) { return visitor.visit (this); }

} // AngDiscardNCardsFromYourHand
