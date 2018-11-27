package motif.agot.logic.visitors;

import motif.agot.ang.text.consconditions.AngAPlayerControls;
import motif.agot.ang.text.consconditions.AngAttachedIs;
import motif.agot.ang.text.consconditions.AngDuringAChallenge;
import motif.agot.ang.text.consconditions.AngThisHasADuplicate;
import motif.agot.ang.text.consconditions.AngYouAreTheFirstPlayer;
import motif.agot.ang.text.consconditions.IAngIfCondition;
import motif.agot.ang.text.consconditions.IAngIfConditionVisitor;
import motif.agot.ang.text.consconditions.IAngWhileCondition;
import motif.agot.ang.text.consconditions.IAngWhileConditionVisitor;
import motif.agot.ang.text.filters.AngCardFilter;
import motif.agot.logic.other.AbilityContext;
import motif.agot.logic.other.FilterMatcher;
import motif.agot.state.AgotGame;
import motif.agot.state.Challenge;
import motif.agot.state.AgotPlayer;
import motif.agot.state.cards.AttachmentCard;
import motif.agot.state.cards.MarshallCard;

public class ConsCondTester implements IAngWhileConditionVisitor, IAngIfConditionVisitor {

	public static boolean test (IAngWhileCondition whileCondition, AbilityContext ac, AgotGame game) {
		ConsCondTester tester = new ConsCondTester (ac, game);
		boolean test = whileCondition.accept (tester);
		return test;
	} // test

	public static boolean test (IAngIfCondition ifCondition, AbilityContext ac, AgotGame game) {
		ConsCondTester tester = new ConsCondTester (ac, game);
		boolean test = ifCondition.accept (tester);
		return test;
	} // test

	private AbilityContext ac;
	private AgotGame game;
	
	public ConsCondTester (AbilityContext ac, AgotGame game) {
		this.ac = ac;
		this.game = game;
	} // WhileTester

	@Override
	public boolean visit (AngAttachedIs whileCond) {
		AttachmentCard att = (AttachmentCard) ac.thisCard;
		AngCardFilter cardFilter = whileCond.getCardFilter ();
		MarshallCard<?> attachTo = att.getAttachTo ();
		boolean doesMatch = FilterMatcher.doesMatch (attachTo, att.getController (), cardFilter);
		return doesMatch;
	} // visit

	@Override
	public boolean visit (AngAPlayerControls whileCond) {
		AgotPlayer you = ac.thisCard.getController ();
		boolean test = game.players ().filter (player -> {
			if (whileCond.youControl ()) { return player == you; }
			if (whileCond.anOpponentControls ()) { return player != you; }
			return true;
		})
		.flatMap (player -> player.inPlayCards ())
		.anyMatch (card -> FilterMatcher.doesMatch (card, null, whileCond.getCardFilter ()));
		return test;
	} // visit

	@Override
	public boolean visit (AngDuringAChallenge whileCond) {
		Challenge challenge = game.getChallenge ();
		if (challenge == null) {
			return false;
		} else {
			if (!FilterMatcher.doesMatch (challenge, ac.you, null, ac.thisCard, whileCond.getChallFilter (), game)) { return false; }
			return true;
		} // if - else
	} // visit

	@Override
	public boolean visit (AngYouAreTheFirstPlayer whileCond) {
		return game.getFirstPlayer () == ac.you;
	} // visit

	@Override
	public boolean visit (AngThisHasADuplicate whileCond) {
		return ((MarshallCard<?>) ac.thisCard).duplicates ().findFirst ().isPresent ();
	} // visit
	
} // WhileChecker
