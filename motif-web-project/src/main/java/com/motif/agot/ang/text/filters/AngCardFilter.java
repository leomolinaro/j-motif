package com.motif.agot.ang.text.filters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.motif.agot.ang.enums.AngArea;
import com.motif.agot.ang.enums.AngComparator;
import com.motif.agot.ang.enums.AngFaction;
import com.motif.agot.ang.enums.AngTrait;
import com.motif.agot.ang.enums.AngType;
import com.motif.agot.ang.text.consconditions.IAngIfCondition;

import lombok.Getter;

public class AngCardFilter {

	private List<AngType> inclusiveTypes;	
	public Stream<AngType> types () { return inclusiveTypes.stream (); }
	public boolean hasTypes () { return inclusiveTypes != null; }
	
	private AngFaction faction;
	public AngFaction getFaction () { return faction; }
	public boolean hasFaction () { return faction != null; }

	private String title;
	public String getTitle () { return title; }
	public boolean hasTitle () { return title != null; }

	private List<AngTrait> inclusiveTraits;
	public Stream<AngTrait> traits () { return inclusiveTraits.stream (); }
	public boolean hasTraits () { return inclusiveTraits != null; }
	
	private Boolean youControl = null;
	public Boolean getYouControl () { return youControl; }
	public boolean hasYouControl () { return youControl != null; }
	
	private Boolean targetControl = null;
	public boolean targetControl () { return targetControl != null && targetControl; }

	private boolean other = false;
	public boolean getOther () { return other; }

	private List<AngArea> areas = null;
	public List<AngArea> getAreas () { return areas; }
	public boolean hasAreas () { return areas != null; }

	private Boolean yourArea = null;
	public Boolean getYourArea () { return yourArea; }
	
	private AngComparator costComparator = null;
	public AngComparator getCostComparator () { return costComparator; }

	private boolean duringChallenge = false;
	public boolean duringChallenge () { return duringChallenge; }
	
	private Boolean losingOpponent = null;
	public boolean losingOpponent () { return losingOpponent != null && losingOpponent; }

	private Boolean attacking = null;
	public boolean attacking () { return attacking != null && attacking; }
	public boolean defending () { return attacking != null && !attacking; }

	@Getter private Boolean partecipating = null;
	
	@Getter private boolean plotRevealed;
	@Getter private boolean withoutAttachments;
	
	private Boolean unique;
	public boolean unique () { return unique != null && unique; }
	public boolean nonUnique () { return unique != null && !unique; }
	
	private Integer printedCost = null;
	public Integer getPrintedCost () { return printedCost; }
	public boolean hasPrintedCost () { return printedCost != null; }
	@Getter private Integer printedCostInstead;
	@Getter private IAngIfCondition printedCostIfInstead;
	
	@Getter private Integer strength;
	public boolean hasStrength () { return strength != null; }
	@Getter private AngComparator strengthComparator;
	@Getter private Integer strengthInstead;
	@Getter private IAngIfCondition strengthIfInstead;
	
	private AngCardFilter () {
	} // AngCardFilter
	
	public static class CFB {
		
		private AngCardFilter cf = new AngCardFilter ();
		
		private CFB () {}
		
		public CFB title (String title) { cf.title = title; return this; }
		
		private CFB addType (AngType type) {
			if (cf.inclusiveTypes == null) { cf.inclusiveTypes = new ArrayList<AngType> (); }
			cf.inclusiveTypes.add (type);
			return this;
		} // addType
		public CFB character () { return addType (AngType.CHARACTER); }
		public CFB location () { return addType (AngType.LOCATION); }
		public CFB attachment () { return addType (AngType.ATTACHMENT); }
		public CFB event () { return addType (AngType.EVENT); }
		public CFB faction () { return addType (AngType.FACTION); }
		public CFB plot () { return addType (AngType.PLOT); }
		
		public CFB faction (AngFaction faction) { cf.faction = faction; return this; }
		public CFB baratheon () { return faction (AngFaction.BARATHEON); }
		public CFB lannister () { return faction (AngFaction.LANNISTER); }
		public CFB stark () { return faction (AngFaction.STARK); }
		public CFB tyrell () { return faction (AngFaction.TYRELL); }
		public CFB martell () { return faction (AngFaction.MARTELL); }
		public CFB greyjoy () { return faction (AngFaction.GREYJOY); }
		public CFB targaryen () { return faction (AngFaction.TARGARYEN); }
		public CFB theNightsWatch () { return faction (AngFaction.THENIGHTSWATCH); }
		
		public CFB unique () { cf.unique = true; return this; }
		public CFB nonUnique () { cf.unique = false; return this; }
		
		public CFB youControl () { cf.youControl = true; return this; }
		public CFB opponent () { cf.youControl = false; return this; }
		public CFB targetControl () { cf.targetControl = true; return this; }
		
		public CFB controlledByTheLosingOpponent () { cf.duringChallenge = true; cf.losingOpponent = true; return this; }
		public CFB attacking () { cf.duringChallenge = true; cf.attacking = true; return this; }
		public CFB defending () { cf.duringChallenge = true; cf.attacking = false; return this; }
		public CFB partecipating () { cf.duringChallenge = true; cf.partecipating = true; return this; }
		
		public CFB withoutAttachments () { cf.withoutAttachments = true; return this; }
		
		public CFB traits (AngTrait...inclusiveTraits) { cf.inclusiveTraits = Arrays.asList (inclusiveTraits); return this; }
		
		public CFB revealed () { cf.plotRevealed = true; return this; }
		
		public CFB inYourArea (AngArea...areas) { cf.yourArea = true; cf.areas = Arrays.asList (areas); return this; }
		public CFB inOpponentArea (AngArea...areas) { cf.yourArea = false; cf.areas = Arrays.asList (areas); return this; }
		
		public CFB other () { cf.other = true; return this; }
		
		public CFB withPrintedCostOrLower (int printedCost) { return withPrintedCostOrLower (printedCost, null, null); }

		public CFB withPrintedCostOrLower (int printedCost, IAngIfCondition ifInstead, Integer insteadPrintedCost) {
			cf.printedCost = printedCost;
			cf.costComparator = AngComparator.EQUAL_OR_LOWER;
			cf.printedCostIfInstead = ifInstead;
			cf.printedCostInstead = insteadPrintedCost;
			return this;
		} // withPrintedCostOrLower
		
		public CFB withStrengthOrLower (int strength, IAngIfCondition ifInstead, Integer insteadStrength) {
			cf.strength = strength;
			cf.strengthComparator = AngComparator.EQUAL_OR_LOWER;
			cf.strengthIfInstead = ifInstead;
			cf.strengthInstead = insteadStrength;
			return this;
		} // withStrengthOrLower
		
		public AngCardFilter build () { return cf; }

		public static CFB i () {
			return new CFB ();
		} // i

	} // CFB
	
} // AngCardFilter
