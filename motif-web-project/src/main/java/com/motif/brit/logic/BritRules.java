package com.motif.brit.logic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.motif.brit.state.BritArea;
import com.motif.brit.state.BritLandArea;
import com.motif.brit.state.BritNation;
import com.motif.brit.state.BritUnit;
import com.motif.shared.util.RandomUtil;

public class BritRules {

	public static int throwDie() {
		return RandomUtil.getInt(1, 6);
	}
	
	public static Integer getStackLimit(BritLandArea land, BritNation nation) {
		if (nation.isRoman()) {
			if (land.isDifficultLand()) {
				return 4;
			} else {
				return null; 
			}
		} else {
			return land.isDifficultLand ()? 2 : 3;
		}
	}
	
	public static Integer getOverstackLimit (BritLandArea land, BritNation nation) {
		if (nation.isRoman ()) {
			return getStackLimit (land, nation);
		} else {
			return land.isDifficultLand () ? 4 : null;
		}
	}
	
	public static int getMovementPoints(BritUnit unit) {
		if (unit.isInfantry()) {
			return unit.isRoman() ? 3 : 2;
		} else {
			return 0; // TODO getMovementPoints
		}
	}
	
	public static Stream<BritLandArea> goodStackingLands(BritNation nation) {
		List<BritLandArea> understackLands = new ArrayList<BritLandArea>();
		List<BritLandArea> onstackLands = new ArrayList<BritLandArea>();
		BritLandArea overstackLand = null;
		for (BritLandArea land : nation.landsIt()) {
			Integer nArmies = land.getNumArmiesOfNation(nation);
			Integer stackLimit = BritRules.getStackLimit(land, nation);
			if (stackLimit == null || stackLimit > nArmies) {
				understackLands.add(land);
			} else if (stackLimit == nArmies) {
				onstackLands.add(land);
			} else {
				overstackLand = land;
			}
		}
		List<BritLandArea> toReturn = new ArrayList<BritLandArea>();
		if (overstackLand == null) {
			if (understackLands.isEmpty()) {
				if (!onstackLands.isEmpty() && !nation.isRoman()) {
					toReturn.addAll(onstackLands);
				}
			} else {
				toReturn.addAll(understackLands);
				if (!nation.isRoman()) {
					toReturn.addAll(onstackLands);
				}
			}
		} else {
			toReturn.addAll(understackLands);
			Integer overstackLimit = BritRules.getOverstackLimit (overstackLand, nation);
			if (overstackLimit != null) {
				Integer nArmies = overstackLand.getNumArmiesOfNation (nation);
				if (overstackLimit < nArmies) {
					toReturn.add (overstackLand);
			 	}
			}
		}
		return toReturn.stream();
	}
	
	public static Stream<BritLandArea> landsToRetreatDef(BritLandArea battleLand, BritNation defNation, BritNation attNation) {
		Set<String> goodStackingLandsIds = goodStackingLands(defNation).map(land -> land.getId()).collect(Collectors.toSet());
		return battleLand.adjacentLands()
			.filter(land -> goodStackingLandsIds.contains(land.getId()))
			.filter(land -> {
				boolean adjacentToLandOccupiedOnlyByAtt = land.adjacentLands()
				.filter(l -> l.isControlledBy(attNation))
				.findAny().isPresent();
				
				Set<String> fromWhichAttEnteredIds = new HashSet<String>();
				attNation.inPlayUnits()
				.map(unit -> {
					Iterator<BritArea> pathIt = unit.path().iterator();
					if (pathIt.hasNext()) {
						BritArea from = pathIt.next();
						while (pathIt.hasNext()) {
							BritArea to = pathIt.next();
							if (to == battleLand) return from;
							from = to;
						}
						if (unit.isInArea(battleLand)) return from;
					}
					return null;
				})
				.filter(area -> area != null)
				.map(area -> area.getId())
				.collect(Collectors.toSet());
				
				return (((land.isControlledBy(defNation) &&
						!land.hasUnitsOfOtherNations(defNation)) ||
						!land.hasUnits() && !adjacentToLandOccupiedOnlyByAtt) &&
						!fromWhichAttEnteredIds.contains(land.getId()));
		});
	}
	
	public static BritArea areaToRetreatAtt(BritLandArea battleArea, BritUnit unit) {
		BritNation nation = unit.getNation();
		BritArea fromWhichArea = unit.getLastPathStep();
		if (fromWhichArea.isLand()) {
			BritLandArea fromWhichLand = (BritLandArea) fromWhichArea;
			if (!fromWhichLand.hasUnitsOfOtherNations(nation)) {
				boolean isGoodStackingLand = goodStackingLands(nation).anyMatch(land -> land == fromWhichLand);
				if (isGoodStackingLand) return fromWhichLand;
			}
			return null;
		} else {
			return unit.getFirstPathStep();
		}
	}
	
}
