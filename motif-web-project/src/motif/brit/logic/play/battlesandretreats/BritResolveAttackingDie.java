package motif.brit.logic.play.battlesandretreats;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import motif.brit.ang.enums.BritText;
import motif.brit.endpoint.BritContext;
import motif.brit.logic.BritProcedures;
import motif.brit.logic.flow.IBritFlowProcess;
import motif.brit.logic.flow.IBritFlowStep;
import motif.brit.logic.requests.BritSelectUnitRequest;
import motif.brit.logic.requests.BritSelectUnitRequest.IBritFlowWithSelectUnit;
import motif.brit.state.BritBuilding;
import motif.brit.state.BritDie;
import motif.brit.state.BritLandArea;
import motif.brit.state.BritNation;
import motif.brit.state.BritUnit;

@RequiredArgsConstructor
public class BritResolveAttackingDie implements IBritFlowProcess, IBritFlowWithSelectUnit<BritUnit> {
	
	private final BritDie attDie;
	private final BritLandArea battleLand;
	private final BritNation attNation;
	private final BritNation defNation;
	
	public interface IBritAfterResolveAttackingDie extends IBritFlowProcess { public IBritFlowStep after(BritResolveAttackingDie resolveAttackingDie, BritContext context); }
	@Getter private final IBritAfterResolveAttackingDie parent;
	@Override public IBritFlowStep next(BritContext context) { return this.parent.after(this, context); }
	
	public IBritFlowStep start(BritContext context) {
		BritUnit attUnit = this.attDie.getUnit();
		boolean attLeaderInBattle = battleLand.leadersOfNation(attNation).findAny().isPresent();
		int dieRoll = attDie.getResult() + (attLeaderInBattle ? 1 : 0);
		BritBuilding defBuilding = battleLand.getBuilding();
		boolean defCavalriesInBattle = battleLand.cavalriesOfNation(defNation).findAny().isPresent();
		boolean defInfantriesInBattle = battleLand.infantriesOfNation(defNation).findAny().isPresent();
		boolean difficultLand = battleLand.isDifficultLand();
		
		List<BritUnit> availableUnits = null;
		switch (dieRoll) {
			case 7:
			case 6: {
				boolean killDefCavalry = false;
				if (defCavalriesInBattle) {
					if (defInfantriesInBattle) {
						// TODO opposing player decide which to eliminate
					} else {
						killDefCavalry = true;
					}
				}
				if (killDefCavalry) {
					availableUnits = battleLand.cavalriesOfNation(defNation).collect(Collectors.toList());
				} else {
					if (defNation.isSaxon() && defBuilding != null) {
						availableUnits = Collections.singletonList(defBuilding);
					} else if (defNation.isRoman() && !defInfantriesInBattle) {
						availableUnits = Collections.singletonList(defBuilding);
					} else {
						availableUnits = battleLand.infantriesOfNation(defNation).collect(Collectors.toList());
					}
				}
			} break;
			case 5: {
				if (!difficultLand) {
					if (defNation.isRoman()) {
						if (defBuilding != null) {
							availableUnits = Collections.singletonList(defBuilding);
						}
					} else {
						if (defNation.isSaxon() && defBuilding != null) {
							availableUnits = Collections.singletonList(defBuilding);
						} else {
							availableUnits = battleLand.infantriesOfNation(defNation).collect(Collectors.toList());
						}
					}
				}
			} break;
			case 4: {
				if (!difficultLand) {
					if (attUnit.isCavalry() || attUnit.isRoman()) {
						if (defNation.isSaxon() && defBuilding != null) {
							availableUnits = Collections.singletonList(defBuilding);
						} else {
							availableUnits = battleLand.infantriesOfNation(defNation).collect(Collectors.toList());
						}
					}
				}
			} break;
		}
		
		if (availableUnits == null || availableUnits.isEmpty()) {
			return null;
		} else {
			return new BritSelectUnitRequest<BritUnit>(
					availableUnits,
					BritText.request().selectUnitToEliminate(this.defNation.getController(), this.defNation),
					this.defNation.getController(),
					false,
					this
			);
		}
	}
	
	@Override
	public IBritFlowStep after(BritSelectUnitRequest<BritUnit> selectUnit, BritContext context) {
		BritUnit unit = selectUnit.getUnit();
		BritProcedures.removeUnit(unit, this.defNation, this.battleLand, context);
		return null;
	}

}
