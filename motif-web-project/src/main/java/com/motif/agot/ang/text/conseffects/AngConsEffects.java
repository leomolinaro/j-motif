package com.motif.agot.ang.text.conseffects;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.motif.agot.ang.enums.AngIcon;
import com.motif.agot.ang.text.AngTextKeyword;
import com.motif.agot.ang.text.consconditions.IAngIfCondition;
import com.motif.agot.ang.text.filters.AngCardFilter;
import com.motif.agot.ang.text.filters.AngPlayerFilter;

import lombok.Getter;

public class AngConsEffects {

	private static abstract class AngConsEffectIcon implements IAngConsEffect { @Getter private AngIcon icon; protected AngConsEffectIcon (AngIcon icon) { this.icon = icon; } }
	private static abstract class AngConsEffectKeyword implements IAngConsEffect { @Getter private AngTextKeyword keyword; protected AngConsEffectKeyword (AngTextKeyword keyword) { this.keyword = keyword; } }
	private static abstract class AngConsEffectStrength implements IAngConsEffect { @Getter private int strength; protected AngConsEffectStrength (int strength) { this.strength = strength; } }
	private static abstract class AngConsEffectCardFilter implements IAngConsEffect { @Getter private AngCardFilter cardFilter; protected AngConsEffectCardFilter (AngCardFilter cardFilter) { this.cardFilter = cardFilter; } }
	private static abstract class AngConsEffectPlayerFilter implements IAngConsEffect { @Getter private AngPlayerFilter playerFilter; protected AngConsEffectPlayerFilter (AngPlayerFilter playerFilter) { this.playerFilter = playerFilter; } }
	
	public static class AngAttachedGainsAnIcon extends AngConsEffectIcon { public AngAttachedGainsAnIcon (AngIcon icon) { super (icon); } @Override public boolean accept (IAngConsEffectVisitor visitor) { return visitor.visit (this); } }
	public static class AngThisGainsAnIcon extends AngConsEffectIcon { public AngThisGainsAnIcon (AngIcon icon) { super (icon); } @Override public boolean accept (IAngConsEffectVisitor visitor) { return visitor.visit (this); } }
	public static class AngThatGainsAnIcon extends AngConsEffectIcon { public AngThatGainsAnIcon (AngIcon icon) { super (icon); } @Override public boolean accept (IAngConsEffectVisitor visitor) { return visitor.visit (this); } }
	
	public static class AngAttachedGainsAKeyword extends AngConsEffectKeyword { public AngAttachedGainsAKeyword (AngTextKeyword keyword) { super (keyword); } @Override public boolean accept (IAngConsEffectVisitor visitor) { return visitor.visit (this); } }
	public static class AngThisGainsAKeyword extends AngConsEffectKeyword { public AngThisGainsAKeyword (AngTextKeyword keyword) { super (keyword); } @Override public boolean accept (IAngConsEffectVisitor visitor) { return visitor.visit (this); } }
	public static class AngThatGainsAKeyword extends AngConsEffectKeyword { public AngThatGainsAKeyword (AngTextKeyword keyword) { super (keyword); } @Override public boolean accept (IAngConsEffectVisitor visitor) { return visitor.visit (this); } }
	public static class AngEachCardGainsAKeyword extends AngConsEffectKeyword implements IAngConsAlignEffect {
		@Getter private AngCardFilter filter;
		public AngEachCardGainsAKeyword (AngTextKeyword keyword, AngCardFilter filter) { super (keyword); this.filter = filter; }
		@Override public boolean accept (IAngConsEffectVisitor visitor) { return visitor.visit (this); }
		@Override public boolean accept (IAngConsAlignEffectVisitor visitor) { return visitor.visit (this); }
	}
	
	public static class AngAttachedGetsStrength extends AngConsEffectStrength { public AngAttachedGetsStrength (int strength) { super (strength); } @Override public boolean accept (IAngConsEffectVisitor visitor) { return visitor.visit (this); } }
	public static class AngThisGetsStrength extends AngConsEffectStrength { public AngThisGetsStrength (int strength) { super (strength); } @Override public boolean accept (IAngConsEffectVisitor visitor) { return visitor.visit (this); } }
	public static class AngThatGetsStrength extends AngConsEffectStrength {
		@Getter private Integer strengthInstead;
		@Getter private IAngIfCondition ifInstead;
		public AngThatGetsStrength (int strength, Integer strengthInstead, IAngIfCondition ifInstead) { super (strength); this.strengthInstead = strengthInstead; this.ifInstead = ifInstead; }
		@Override public boolean accept (IAngConsEffectVisitor visitor) { return visitor.visit (this); }
	}
	public static class AngEachCardGetsStrength extends AngConsEffectStrength implements IAngConsAlignEffect {
		@Getter private AngCardFilter filter;
		public AngEachCardGetsStrength (int strength, AngCardFilter filter) { super (strength); this.filter = filter; }
		@Override public boolean accept (IAngConsEffectVisitor visitor) { return visitor.visit (this); }
		@Override public boolean accept (IAngConsAlignEffectVisitor visitor) { return visitor.visit (this); }
	}

	public static class AngAddStrengthToYourTotalForDominance extends AngConsEffectStrength { public AngAddStrengthToYourTotalForDominance (int strength) { super (strength); } @Override public boolean accept (IAngConsEffectVisitor visitor) { return visitor.visit (this); } }
	
	public static class AngThisDoesNotKneelWhenDeclared implements IAngConsEffect {
		private Boolean asAttacker;
		public boolean asAttacker () { return asAttacker == null || asAttacker; }
		public boolean asDefender () { return asAttacker == null || !asAttacker; }
		public AngThisDoesNotKneelWhenDeclared (Boolean asAttacker) { this.asAttacker = asAttacker; }
		@Override public boolean accept (IAngConsEffectVisitor visitor) { return visitor.visit (this); }
	} // AngThisDoesNotKneelWhenDeclared
	
	public static class AngTreatEachCardAsIfItsPrintedTextBoxWereBlackExceptForTrait extends AngConsEffectCardFilter implements IAngConsAlignEffect {
		public AngTreatEachCardAsIfItsPrintedTextBoxWereBlackExceptForTrait (AngCardFilter cardFilter) { super (cardFilter); }
		@Override public boolean accept (IAngConsEffectVisitor visitor) { return visitor.visit (this); }
		@Override public boolean accept (IAngConsAlignEffectVisitor visitor) { return visitor.visit (this); }
	}
	public static class AngEachCardCannotBeBypassedByStealth extends AngConsEffectCardFilter implements IAngConsAlignEffect {
		public AngEachCardCannotBeBypassedByStealth (AngCardFilter angCardFilter) { super (angCardFilter); }
		@Override public boolean accept (IAngConsEffectVisitor visitor) { return visitor.visit (this); }
		@Override public boolean accept (IAngConsAlignEffectVisitor visitor) { return visitor.visit (this); }
	}
	public static class AngTreatTheBaseGoldValueOfEachCardAsIfItWereN extends AngConsEffectCardFilter implements IAngConsAlignEffect {
		@Getter private int n;
		public AngTreatTheBaseGoldValueOfEachCardAsIfItWereN (int n, AngCardFilter cardFilter) { super (cardFilter); this.n = n; }
		@Override public boolean accept (IAngConsEffectVisitor visitor) { return visitor.visit (this); }
		@Override public boolean accept (IAngConsAlignEffectVisitor visitor) { return visitor.visit (this); }
	}
	public static class AngYouMayInitiateAnAdditionalChallengeDuringTheChallengePhase implements IAngConsEffect {
		@Getter private AngIcon icon;
		public AngYouMayInitiateAnAdditionalChallengeDuringTheChallengePhase (AngIcon icon) { this.icon = icon; }
		@Override public boolean accept (IAngConsEffectVisitor visitor) { return visitor.visit (this); }
	}
	public static class AngEachPlayerCannotStandMoreThanNCardsDuringTheStandingPhase extends AngConsEffectCardFilter {
		@Getter private int n;
		public AngEachPlayerCannotStandMoreThanNCardsDuringTheStandingPhase (int n, AngCardFilter cardFilter) { super (cardFilter); this.n = n; }
		@Override public boolean accept (IAngConsEffectVisitor visitor) { return visitor.visit (this); }
	}
	public static class AngYouCannotMarshallOrPlay extends AngConsEffectCardFilter {
		public AngYouCannotMarshallOrPlay (AngCardFilter cardFilter) { super (cardFilter); }
		@Override public boolean accept (IAngConsEffectVisitor visitor) { return visitor.visit (this); }
	}
	public static class AngEachPlayerCannotInitiateMoreThanNChallengesDuringTheChallengePhase extends AngConsEffectPlayerFilter {
		@Getter private int n;
		public AngEachPlayerCannotInitiateMoreThanNChallengesDuringTheChallengePhase (int n, AngPlayerFilter playerFilter) { super (playerFilter); this.n = n; }
		@Override public boolean accept (IAngConsEffectVisitor visitor) { return visitor.visit (this); }
	}
	public static class AngEachPlayerCannotTriggerCardAbilities extends AngConsEffectPlayerFilter {
		public AngEachPlayerCannotTriggerCardAbilities (AngPlayerFilter playerFilter) { super (playerFilter); }
		@Override public boolean accept (IAngConsEffectVisitor visitor) { return visitor.visit (this); }
	}
	public static class AngEachPlayerCannotDeclareMoreThanNCharacters extends AngConsEffectPlayerFilter {
		@Getter private int n;
		private Boolean asAttacker;
		public boolean asAttacker () { return asAttacker != null && asAttacker; }
		public boolean asDefender () { return asAttacker != null && !asAttacker; }
		public AngEachPlayerCannotDeclareMoreThanNCharacters (int n, Boolean asAttacker, AngPlayerFilter playerFilter) { super (playerFilter); this.n = n; this.asAttacker = asAttacker; }
		@Override public boolean accept (IAngConsEffectVisitor visitor) { return visitor.visit (this); }
	}
	public static class AngMultiConsEffect implements IAngConsEffect {
		private List<IAngConsEffect> effects;
		public Stream<IAngConsEffect> effects () { return effects.stream (); }
		public AngMultiConsEffect (IAngConsEffect...effects) { this.effects = Arrays.asList (effects); }
		@Override public boolean accept (IAngConsEffectVisitor visitor) { return visitor.visit (this); }
	}
	
} // AngConsEffects