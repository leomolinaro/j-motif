package motif.brit.logic.battlesandretreats;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import motif.brit.ang.enums.BritText;
import motif.brit.endpoint.BritContext;
import motif.brit.flow.IBritAutoIO;
import motif.brit.flow.IBritAutoIOVisitor;
import motif.brit.flow.IBritIO;
import motif.brit.flow.IBritIOVisitor;
import motif.brit.logic.BritProcedures;
import motif.brit.logic.requests.BritSelectUnitRequest.ABritSelectUnitRequestIO;
import motif.brit.state.BritBuilding;
import motif.brit.state.BritDie;
import motif.brit.state.BritLandArea;
import motif.brit.state.BritNation;
import motif.brit.state.BritPlayer;
import motif.brit.state.BritUnit;

public class BritResolveAttackingDie {
	
	public static abstract class ABritResolveAttackingDieIO implements IBritAutoIO {
		// @Override public IBritIO start(BritContext context) { return new BritResolveAttackingDie().start(this, context); }
		@Override public void accept(IBritAutoIOVisitor visitor) { visitor.visit(this); }
		public abstract BritLandArea getBattleLand();
		public abstract BritDie getAttDie();
		public abstract BritPlayer getAttPlayer();
		public abstract BritPlayer getDefPlayer();
		public abstract BritNation getAttNation();
		public abstract BritNation getDefNation();
	}
	
	@RequiredArgsConstructor
	public class BritSelectAttackingUnitToEliminateRequestIO extends ABritSelectUnitRequestIO<BritUnit> {
		@Override public void accept(IBritIOVisitor visitor) { visitor.visit(this); }
		// @Override public IBritIO getNext(BritContext context) { return BritResolveAttackingDie.this.next(this, parent, context); }
		@Getter private final List<BritUnit> availableUnits;
		@Override public BritPlayer getPlayer() { return parent.getDefPlayer(); }
		@Override public boolean canPass() { return false; }
		@Override public String getText() { return BritText.request().selectUnitToEliminate(parent.getDefPlayer(), parent.getDefNation()); }
		@Getter private final ABritResolveAttackingDieIO parent;
		@Setter private BritUnit unit;
	}
	
	public IBritIO start(ABritResolveAttackingDieIO IO, BritContext context) {
		BritDie attDie = IO.getAttDie();
		BritUnit attUnit = attDie.getUnit();
		BritLandArea battleLand = IO.getBattleLand();
		BritNation attNation = IO.getAttNation();
		BritNation defNation = IO.getDefNation();
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
			return new BritSelectAttackingUnitToEliminateRequestIO(availableUnits, IO);
		}
	}

	public IBritIO next(BritSelectAttackingUnitToEliminateRequestIO prevIO, ABritResolveAttackingDieIO IO, BritContext context) {
		BritUnit unit = prevIO.unit;
		BritProcedures.removeUnit(unit, IO.getDefNation(), IO.getBattleLand(), context);
		return null;
	}

}
