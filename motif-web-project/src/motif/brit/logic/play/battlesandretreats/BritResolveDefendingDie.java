package motif.brit.logic.play.battlesandretreats;

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
import motif.brit.state.BritDie;
import motif.brit.state.BritLandArea;
import motif.brit.state.BritNation;
import motif.brit.state.BritUnit;

@RequiredArgsConstructor
public class BritResolveDefendingDie implements IBritFlowProcess, IBritFlowWithSelectUnit<BritUnit> {
	
	private final BritDie defDie;
	private final BritLandArea battleLand;
	private final BritNation attNation;
	private final BritNation defNation;
	
	public interface IBritAfterResolveDefendingDie extends IBritFlowProcess { public IBritFlowStep after(BritResolveDefendingDie resolveDefendingDie, BritContext context); }
	@Getter private final IBritAfterResolveDefendingDie parent;
	@Override public IBritFlowStep next(BritContext context) { return this.parent.after(this, context); }
	
	public IBritFlowStep start(BritContext context) {
		BritUnit defUnit = defDie.getUnit();
		boolean defLeaderInBattle = battleLand.leadersOfNation(defNation).findAny().isPresent();
		int dieRoll = defDie.getResult() + (defLeaderInBattle ? 1 : 0);
		boolean attCavalriesInBattle = battleLand.cavalriesOfNation(attNation).findAny().isPresent();
		boolean attInfantriesInBattle = battleLand.infantriesOfNation(attNation).findAny().isPresent();
		
		List<BritUnit> availableUnits = null;
		switch (dieRoll) {
			case 7:
			case 6: {
				boolean killAttCavalry = false;
				if (attCavalriesInBattle) {
					if (attInfantriesInBattle) {
						// TODO opposing player decide which to eliminate
					} else {
						killAttCavalry = true;
					}
				}
				if (killAttCavalry) {
					availableUnits = battleLand.cavalriesOfNation(attNation).collect(Collectors.toList());
				} else {
					availableUnits = battleLand.infantriesOfNation(attNation).collect(Collectors.toList());
				}
			} break;
			case 5: {
				if (!attNation.isRoman()) {
					availableUnits = battleLand.infantriesOfNation(attNation).collect(Collectors.toList());
				}
			} break;
			case 4: {
				if (defUnit.isCavalry() || defUnit.isRoman()) {
					availableUnits = battleLand.infantriesOfNation(attNation).collect(Collectors.toList());
				}
			} break;
		}
		
		if (availableUnits == null || availableUnits.isEmpty()) {
			return null;
		} else {
			return new BritSelectUnitRequest<BritUnit>(
					availableUnits,
					BritText.request().selectUnitToEliminate(this.attNation.getController(), this.attNation),
					this.attNation.getController(),
					false,
					this
			);
		}
	}
	
	@Override
	public IBritFlowStep after(BritSelectUnitRequest<BritUnit> selectUnit, BritContext context) {
		BritUnit unit = selectUnit.getUnit();
		BritProcedures.removeUnit(unit, this.attNation, this.battleLand, context);
		return null;
	}

}
