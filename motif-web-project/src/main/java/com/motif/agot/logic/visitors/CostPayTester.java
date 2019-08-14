package com.motif.agot.logic.visitors;

import com.motif.agot.ang.text.costs.IAngCost;
import com.motif.agot.ang.text.costs.IAngCostVisitor;
import com.motif.agot.ang.text.instants.AngDiscardATokenFromThis;
import com.motif.agot.ang.text.instants.AngDiscardNCardsFromYourHand;
import com.motif.agot.ang.text.instants.AngInstants.AngKneelThis;
import com.motif.agot.ang.text.instants.AngKneelYourFactionCard;
import com.motif.agot.ang.text.instants.AngPayNGold;
import com.motif.agot.ang.text.instants.AngRemoveThisFromTheGame;
import com.motif.agot.ang.text.instants.AngReturnThisToYourHand;
import com.motif.agot.ang.text.instants.AngSacrificeThis;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;
import com.motif.agot.state.cards.DeckCard;
import com.motif.agot.state.cards.TextCard;

public class CostPayTester implements IAngCostVisitor {

	public static boolean canBePaid (IAngCost cost, TextCard<?> card, AgotPlayer player, AgotGame game) {
		CostPayTester costChecker = new CostPayTester (card, player, game);
		boolean canBePaid = cost.accept (costChecker);
		return canBePaid;
	} // canBePaid
	
	@SuppressWarnings("unused")
	private AgotGame game;
	private AgotPlayer you;
	private TextCard<?> thisCard;

	private CostPayTester (TextCard<?> thisCard, AgotPlayer you, AgotGame game) {
		this.thisCard = thisCard;
		this.you = you;
		this.game = game;
	} // CheckCostPayer

	@Override public boolean visit (AngPayNGold cost) { return (you.gold () >= cost.getNGold ()); }

	@Override public boolean visit (AngKneelThis cost) { return thisCard.isStanding (); }

	@Override public boolean visit (AngKneelYourFactionCard cost) { return you.factionCardIsStanding (); }

	@Override public boolean visit (AngRemoveThisFromTheGame cost) { return thisCard.isControlledBy (you); }

	@Override public boolean visit (AngSacrificeThis cost) { return thisCard.isControlledBy (you); }
	
	@Override
	public boolean visit (AngDiscardNCardsFromYourHand cost) {
		int handSize = you.handSize ();
		return handSize >= cost.getN ();
	} // visit

	@Override public boolean visit (AngDiscardATokenFromThis cost) { return ((DeckCard<?>) thisCard).hasToken (cost.getToken ()); }

	@Override public boolean visit (AngReturnThisToYourHand cost) { return thisCard.isControlledBy (you); }

} // CheckCostPayer
