package com.motif.agot.ang.text.instants;

import com.motif.agot.ang.text.effects.IAngEffect;
import com.motif.agot.ang.text.effects.IAngEffectVisitor;
import com.motif.agot.ang.text.filters.AngPlayerFilter;

import lombok.Getter;

public class AngMovePowersFromAFactionToAFaction implements IAngEffect {

	@Getter private int n;
	@Getter private AngPlayerFilter fromPlayer;
	@Getter private AngPlayerFilter toPlayer;

	public AngMovePowersFromAFactionToAFaction (int n, AngPlayerFilter fromPlayer, AngPlayerFilter toPlayer) {
		this.n = n;
		this.fromPlayer = fromPlayer;
		this.toPlayer = toPlayer;
	} // AngMovePowersFromAFactionToAFaction

	@Override public boolean accept (IAngEffectVisitor visitor) { return visitor.visit (this); }

} // AngMovePowersFromAFactionToAFaction
