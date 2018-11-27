package motif.agot.ang.text.instants;

import lombok.Getter;
import motif.agot.ang.enums.AngToken;
import motif.agot.ang.text.costs.IAngCost;
import motif.agot.ang.text.costs.IAngCostVisitor;
import motif.agot.ang.text.effects.IAngEffect;
import motif.agot.ang.text.effects.IAngEffectVisitor;
import motif.agot.ang.text.filters.AngCardFilter;
import motif.agot.ang.text.filters.AngPlayerFilter;

public class AngInstants {

	public static abstract class AngEffectEachCard implements IAngEffect {
		@Getter private AngCardFilter filter;
		public AngEffectEachCard (AngCardFilter filter) { this.filter = filter; }
	} // AngEffectEachCard

	public static abstract class AngEffectN implements IAngEffect {
		@Getter private int n;
		public AngEffectN (int n) { this.n = n; }
	} // AngEffectN
	
	public static class AngStandThis implements IAngEffect { @Override public boolean accept (IAngEffectVisitor visitor) { return visitor.visit (this); } }
	public static class AngStandThat implements IAngEffect { @Override public boolean accept (IAngEffectVisitor visitor) { return visitor.visit (this); } }
	public static class AngStandAttached implements IAngEffect { @Override public boolean accept (IAngEffectVisitor visitor) { return visitor.visit (this); } }
	public static class AngStandEach extends AngEffectEachCard { public AngStandEach (AngCardFilter filter) { super (filter); } @Override public boolean accept (IAngEffectVisitor visitor) { return visitor.visit (this); } }
	
	public static class AngKneelThis implements IAngEffect, IAngCost {
		@Override public boolean accept (IAngEffectVisitor visitor) { return visitor.visit (this); }
		@Override public boolean accept (IAngCostVisitor visitor) { return visitor.visit (this); }
	} // AngKneelThis
	public static class AngKneelThat implements IAngEffect { @Override public boolean accept (IAngEffectVisitor visitor) { return visitor.visit (this); } }
	public static class AngKneelAttached implements IAngEffect { @Override public boolean accept (IAngEffectVisitor visitor) { return visitor.visit (this); } }
	public static class AngKneelEach extends AngEffectEachCard { public AngKneelEach (AngCardFilter filter) { super (filter); } @Override public boolean accept (IAngEffectVisitor visitor) { return visitor.visit (this); } }

	public static class AngDiscardFromPlayThat implements IAngEffect { @Override public boolean accept (IAngEffectVisitor visitor) { return visitor.visit (this); } }
	public static class AngDiscardFromPlayEach extends AngEffectEachCard { public AngDiscardFromPlayEach (AngCardFilter filter) { super (filter); } @Override public boolean accept (IAngEffectVisitor visitor) { return visitor.visit (this); } }
	
	public static class AngKillThat implements IAngEffect { @Override public boolean accept (IAngEffectVisitor visitor) { return visitor.visit (this); } }

	public static class AngDiscardNPowerFromThat extends AngEffectN { public AngDiscardNPowerFromThat (int n) { super (n); } @Override public boolean accept (IAngEffectVisitor visitor) { return visitor.visit (this); } }

	public static class AngGainNPowerOnYourFaction extends AngEffectN { public AngGainNPowerOnYourFaction (int n) { super (n); } @Override public boolean accept (IAngEffectVisitor visitor) { return visitor.visit (this); } }
	public static class AngGainNPowerOnThis extends AngEffectN { public AngGainNPowerOnThis (int n) { super (n); } @Override public boolean accept (IAngEffectVisitor visitor) { return visitor.visit (this); } }

	public static class AngSaveThis implements IAngEffect { @Override public boolean accept (IAngEffectVisitor visitor) { return visitor.visit (this); } }
	public static class AngSaveThat implements IAngEffect { @Override public boolean accept (IAngEffectVisitor visitor) { return visitor.visit (this); } }
	public static class AngSaveAttached implements IAngEffect { @Override public boolean accept (IAngEffectVisitor visitor) { return visitor.visit (this); } }
	
	public static class AngShuffleThatBackIntoYourDeck implements IAngEffect { @Override public boolean accept (IAngEffectVisitor visitor) { return visitor.visit (this); } }
	public static class AngTakeControlOfThat implements IAngEffect { @Override public boolean accept (IAngEffectVisitor visitor) { return visitor.visit (this); } }
	
	public static class AngDiscardNCardsAtRandomFromEachPlayerHand implements IAngEffect {
		@Getter private AngPlayerFilter playerFilter;
		@Getter private int n;
		public AngDiscardNCardsAtRandomFromEachPlayerHand (int n, AngPlayerFilter playerFilter) {
			this.n = n;
			this.playerFilter = playerFilter;
		} // AngDiscardNCardsAtRandomFromEachPlayerHand
		@Override public boolean accept (IAngEffectVisitor visitor) { return visitor.visit (this); }
	} // AngDiscardNCardsAtRandomFromEachPlayerHand
	
	public static class AngPlaceOneTokenOnThis implements IAngEffect {
		@Getter private AngToken token;
		public AngPlaceOneTokenOnThis (AngToken token) {
			this.token = token;
		} // AngPlaceOneTokenOnThis
		@Override public boolean accept (IAngEffectVisitor visitor) { return visitor.visit (this); }
	} // AngPlaceOneTokenOnThis
	
} // AngEffects
