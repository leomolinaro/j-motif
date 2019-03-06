package com.motif.agot.logic.other;

import com.motif.agot.ang.text.AngConsAbility;
import com.motif.agot.logic.visitors.ConsCondTester;
import com.motif.agot.logic.visitors.ConsEffectAligner;
import com.motif.agot.logic.visitors.ConsEffectApplier;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.ConsAbility;
import com.motif.agot.state.cards.MarshallCard;
import com.motif.agot.state.cards.TextCard;

public class ConsAbilities {

	public static void subscribe (AngConsAbility angConsAbility, AbilityContext ac, AgotGame game) {
		ConsAbility consAbility = game.subscribe (angConsAbility, ac.thisCard);
		boolean activate;
		if (angConsAbility.hasWhileCond ()) {
			activate = ConsCondTester.test (angConsAbility.getWhileCond (), ac, game);
		} else {
			activate = true;
		} // if
		if (activate) { activate (consAbility, game); }
	} // subscribe

	public static void unsubscribe (AngConsAbility angConsAbility, TextCard<?> card, AgotGame game) {
		ConsAbility consAbility = game.unsubscribe (angConsAbility, card);
		if (consAbility.isActive ()) { deactivate (consAbility, game); }
	} // unsubscribe
	
	public static void refresh (AgotGame game) {
		game.consAbilities ().forEach (ca -> {
			AbilityContext ac = new AbilityContext (ca.getCard (), ca.getCardController ());
			boolean whileCondition = ca.hasWhileCond () ? ConsCondTester.test (ca.getWhileCond (), ac, game) : true;
			if (whileCondition && !ca.isActive ()) {
				activate (ca, game);
			} else if (!whileCondition && ca.isActive ()) {
				deactivate (ca, game);
			} // if - else
		}); // forEach
	} // refresh
	
	public static void submitConsAbilities (MarshallCard<?> card, AgotGame game) {
		game.consAlignAbilities ()
		.filter (ca -> ca.isActive ())
		.forEach (ca -> ConsEffectAligner.apply (ca, card, ca.getCard ().getController (), game));
	} // alignPlayedCard
	
	public static void unsubmitConsAbilities (MarshallCard<?> card, AgotGame game) {
		game.consAlignAbilities ()
		.filter (ca -> ca.isActive ())
		.forEach (ca -> ConsEffectAligner.unapply (ca, card, ca.getCard ().getController (), game));
	} // alignUnplayedCard
	
	private static void activate (ConsAbility consAbility, AgotGame game) {
		consAbility.activate ();
		AbilityContext ac = new AbilityContext (consAbility.getCard (), consAbility.getCardController ());
		ConsEffectApplier.applyAll (consAbility.getConsEffect (), ac, game);
	} // activate

	private static void deactivate (ConsAbility consAbility, AgotGame game) {
		consAbility.deactivate ();
		AbilityContext ac = new AbilityContext (consAbility.getCard (), consAbility.getCardController ());
		ConsEffectApplier.unapplyAll (consAbility.getConsEffect (), ac, game);
	} // deactivate

} // ConsAbilities
