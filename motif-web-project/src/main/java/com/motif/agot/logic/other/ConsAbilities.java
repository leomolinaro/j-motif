package com.motif.agot.logic.other;

import com.motif.agot.ang.text.AngConsAbility;
import com.motif.agot.logic.visitors.ConsCondTester;
import com.motif.agot.logic.visitors.ConsEffectAligner;
import com.motif.agot.logic.visitors.ConsEffectApplier;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.abilities.ConsAbility;
import com.motif.agot.state.cards.MarshallCard;

public class ConsAbilities {

	public static void subscribe (AngConsAbility angConsAbility, AbilityContext ac, AgotGame game) {
		ConsAbility consAbility = game.subscribe (angConsAbility, ac);
		boolean activate;
		if (angConsAbility.hasWhileCond ()) {
			activate = ConsCondTester.test (angConsAbility.getWhileCond (), ac, game);
		} else {
			activate = true;
		} // if
		if (activate) { activate (consAbility, game); }
	} // subscribe

	public static void unsubscribe (AngConsAbility angConsAbility, AbilityContext ac, AgotGame game) {
		ConsAbility consAbility = game.unsubscribe (angConsAbility, ac);
		if (consAbility.isActive ()) { deactivate (consAbility, game); }
	} // unsubscribe
	
	public static void refresh (AgotGame game) {
		game.consAbilities ().forEach (ca -> {
			boolean whileCondition = ca.hasWhileCond () ? ConsCondTester.test (ca.getWhileCond (), ca.getAbilityContext (), game) : true;
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
		.forEach (ca -> ConsEffectAligner.apply (ca, card, ca.getAbilityContext (), game));
	} // submitConsAbilities
	
	public static void unsubmitConsAbilities (MarshallCard<?> card, AgotGame game) {
		game.consAlignAbilities ()
		.filter (ca -> ca.isActive ())
		.forEach (ca -> ConsEffectAligner.unapply (ca, card, ca.getAbilityContext (), game));
	} // unsubmitConsAbilities
	
	private static void activate (ConsAbility consAbility, AgotGame game) {
		consAbility.activate ();
		ConsEffectApplier.applyAll (consAbility.getConsEffect (), consAbility.getAbilityContext (), game);
	} // activate

	private static void deactivate (ConsAbility consAbility, AgotGame game) {
		consAbility.deactivate ();
		ConsEffectApplier.unapplyAll (consAbility.getConsEffect (), consAbility.getAbilityContext (), game);
	} // deactivate

} // ConsAbilities
