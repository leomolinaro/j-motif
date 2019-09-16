package com.motif.agot.logic.other;

import java.util.List;
import java.util.stream.Collectors;

import com.motif.agot.ang.text.instants.AngLastingEffect;
import com.motif.agot.logic.events.AgotEvent;
import com.motif.agot.logic.visitors.ConsEffectApplier;
import com.motif.agot.logic.visitors.UntilChecker;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.abilities.LastingEffect;

public class LastingAbilities {

	public static void subscribe (AngLastingEffect effect, AbilityContext ac, AgotGame game) {
		ConsEffectApplier.applyAll (effect.getConsEffect (), ac, game);
		game.subscribe (effect, ac);
	} // subscribe

	public static void refresh (AgotEvent event, AgotGame game) {
		List<LastingEffect> toRemove = game.lastingEffects ()
		.filter (le -> UntilChecker.check (event, le.getUntil (), game))
		.collect (Collectors.toList ());
		toRemove.forEach (le -> {
			ConsEffectApplier.unapplyAll (le.getConsEffect (), le.getAbilityContext (), game); // TODO !!!!!
			game.unsubscribe (le);
		});
	} // refresh

} // LastingAbilities
