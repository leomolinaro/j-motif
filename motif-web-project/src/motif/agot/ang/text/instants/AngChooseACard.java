package motif.agot.ang.text.instants;

import motif.agot.ang.text.effects.IAngEffect;
import motif.agot.ang.text.effects.IAngEffectVisitor;
import motif.agot.ang.text.filters.AngCardFilter;

public class AngChooseACard implements IAngEffect {

	private AngCardFilter cardFilter;
	public AngCardFilter getCardFilter () { return cardFilter; }
	
	private IAngEffect targetEffect;
	public IAngEffect getTargetEffect () { return targetEffect; }

	public AngChooseACard (AngCardFilter cardFilter, IAngEffect targetEffect) {
		this.cardFilter = cardFilter;
		this.targetEffect = targetEffect;
	} // AngChooseACard

	@Override public boolean accept (IAngEffectVisitor visitor) { return visitor.visit (this); }
	
} // AngChooseACard
