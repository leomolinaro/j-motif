package motif.agot.logic.visitors;

import motif.agot.ang.text.costs.IAngCost;
import motif.agot.ang.text.costs.IAngCostVisitor;
import motif.agot.ang.text.instants.AngDiscardATokenFromThis;
import motif.agot.ang.text.instants.AngDiscardNCardsFromYourHand;
import motif.agot.ang.text.instants.AngInstants.AngKneelThis;
import motif.agot.ang.text.instants.AngKneelYourFactionCard;
import motif.agot.ang.text.instants.AngPayNGold;
import motif.agot.ang.text.instants.AngRemoveThisFromTheGame;
import motif.agot.ang.text.instants.AngReturnThisToYourHand;
import motif.agot.ang.text.instants.AngSacrificeThis;
import motif.agot.state.AgotGame;
import motif.agot.state.AgotPlayer;
import motif.agot.state.cards.MarshallCard;
import motif.agot.state.cards.TextCard;

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

	@Override public boolean visit (AngPayNGold cost) { return (you.getGold () >= cost.getNGold ()); }

	@Override public boolean visit (AngKneelThis cost) { return thisCard.isStanding (); }

	@Override public boolean visit (AngKneelYourFactionCard cost) { return you.factionCardIsStanding (); }

	@Override public boolean visit (AngRemoveThisFromTheGame cost) { return thisCard.isControlledBy (you); }

	@Override public boolean visit (AngSacrificeThis cost) { return thisCard.isControlledBy (you); }
	
	@Override
	public boolean visit (AngDiscardNCardsFromYourHand cost) {
		int handSize = you.handSize ();
		return handSize >= cost.getN ();
	} // visit

	@Override public boolean visit (AngDiscardATokenFromThis cost) { return ((MarshallCard<?>) thisCard).hasToken (cost.getToken ()); }

	@Override public boolean visit (AngReturnThisToYourHand cost) { return thisCard.isControlledBy (you); }

} // CheckCostPayer
