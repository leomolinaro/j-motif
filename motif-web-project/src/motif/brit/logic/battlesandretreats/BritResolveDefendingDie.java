package motif.brit.logic.battlesandretreats;

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
import motif.brit.state.BritDie;
import motif.brit.state.BritLandArea;
import motif.brit.state.BritNation;
import motif.brit.state.BritPlayer;
import motif.brit.state.BritUnit;

public class BritResolveDefendingDie {
	
	public static abstract class ABritResolveDefendingDieIO implements IBritAutoIO {
		// @Override public IBritIO start(BritContext context) { return new BritResolveDefendingDie().start(this, context); }
		@Override public void accept(IBritAutoIOVisitor visitor) { visitor.visit(this); }
		public abstract BritLandArea getBattleLand();
		public abstract BritDie getDefDie();
		public abstract BritPlayer getAttPlayer();
		public abstract BritPlayer getDefPlayer();
		public abstract BritNation getAttNation();
		public abstract BritNation getDefNation();
	}
	
	@RequiredArgsConstructor
	public class BritSelectDefendingUnitToEliminateRequestIO extends ABritSelectUnitRequestIO<BritUnit> {
		@Override public void accept(IBritIOVisitor visitor) { visitor.visit(this); }
		// @Override public IBritIO getNext(BritContext context) { return BritResolveDefendingDie.this.next(this, parent, context); }
		@Getter private final List<BritUnit> availableUnits;
		@Override public BritPlayer getPlayer() { return parent.getAttPlayer(); }
		@Override public boolean canPass() { return false; }
		@Override public String getText() { return BritText.request().selectUnitToEliminate(parent.getAttPlayer(), parent.getAttNation()); }
		@Getter private final ABritResolveDefendingDieIO parent;
		@Setter private BritUnit unit;
	}

	public IBritIO start(ABritResolveDefendingDieIO IO, BritContext context) {
		BritDie defDie = IO.getDefDie();
		BritUnit defUnit = defDie.getUnit();
		BritLandArea battleLand = IO.getBattleLand();
		BritNation defNation = IO.getDefNation();
		BritNation attNation = IO.getAttNation();
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
			return new BritSelectDefendingUnitToEliminateRequestIO(availableUnits, IO);
		}
	}

	public IBritIO next(BritSelectDefendingUnitToEliminateRequestIO prevIO, ABritResolveDefendingDieIO IO, BritContext context) {
		BritUnit unit = prevIO.unit;
		BritProcedures.removeUnit(unit, IO.getDefNation(), IO.getBattleLand(), context);
		return null;
	}

}
