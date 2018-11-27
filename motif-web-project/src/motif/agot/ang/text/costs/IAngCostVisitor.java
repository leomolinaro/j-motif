package motif.agot.ang.text.costs;

import motif.agot.ang.text.instants.AngDiscardATokenFromThis;
import motif.agot.ang.text.instants.AngDiscardNCardsFromYourHand;
import motif.agot.ang.text.instants.AngInstants.AngKneelThis;
import motif.agot.ang.text.instants.AngKneelYourFactionCard;
import motif.agot.ang.text.instants.AngPayNGold;
import motif.agot.ang.text.instants.AngRemoveThisFromTheGame;
import motif.agot.ang.text.instants.AngReturnThisToYourHand;
import motif.agot.ang.text.instants.AngSacrificeThis;

public interface IAngCostVisitor {

	public boolean visit (AngPayNGold cost);
	public boolean visit (AngKneelThis cost);
	public boolean visit (AngKneelYourFactionCard cost);
	public boolean visit (AngRemoveThisFromTheGame cost);
	public boolean visit (AngSacrificeThis cost);
	public boolean visit (AngDiscardNCardsFromYourHand cost);
	public boolean visit (AngDiscardATokenFromThis cost);
	public boolean visit (AngReturnThisToYourHand cost);
	
} // IAngCostVisitor
