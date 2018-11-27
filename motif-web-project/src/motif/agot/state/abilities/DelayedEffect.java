package motif.agot.state.abilities;

import motif.agot.ang.text.delayedeffects.IAngDelayedEffect;
import motif.agot.ang.text.delayedeffects.IAngDelayedEffectVisitor;
import motif.agot.state.AgotPlayer;

public class DelayedEffect {

	private IAngDelayedEffect effect;
	@SuppressWarnings("unused")
	private AgotPlayer player;

	public DelayedEffect (IAngDelayedEffect effect, AgotPlayer player) {
		this.effect = effect;
		this.player = player;
	} // DelayedEffect

	public IAngDelayedEffect getAng () { return effect; }

	public void accept (IAngDelayedEffectVisitor visitor) { this.effect.accept (visitor); }

} // DelayedEffect
