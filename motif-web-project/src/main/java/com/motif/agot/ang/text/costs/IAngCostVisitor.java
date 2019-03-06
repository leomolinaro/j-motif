package com.motif.agot.ang.text.costs;

import com.motif.agot.ang.text.instants.AngDiscardATokenFromThis;
import com.motif.agot.ang.text.instants.AngDiscardNCardsFromYourHand;
import com.motif.agot.ang.text.instants.AngKneelYourFactionCard;
import com.motif.agot.ang.text.instants.AngPayNGold;
import com.motif.agot.ang.text.instants.AngRemoveThisFromTheGame;
import com.motif.agot.ang.text.instants.AngReturnThisToYourHand;
import com.motif.agot.ang.text.instants.AngSacrificeThis;
import com.motif.agot.ang.text.instants.AngInstants.AngKneelThis;

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
