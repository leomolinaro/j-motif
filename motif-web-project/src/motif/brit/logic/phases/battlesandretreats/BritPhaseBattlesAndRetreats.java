package motif.brit.logic.phases.battlesandretreats;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import motif.brit.ang.enums.AngPhase;
import motif.brit.ang.enums.BritText;
import motif.brit.endpoint.BritContext;
import motif.brit.flow.IBritIO;
import motif.brit.logic.BritProcedures;
import motif.brit.logic.BritRules;
import motif.brit.logic.nationTurn.BritNationTurnTask.ABritNationTurnIO;
import motif.brit.logic.phases.ABritPhase.ABritPhaseIO;
import motif.brit.logic.phases.battlesandretreats.BritResolveAttackingDie.ABritResolveAttackingDieIO;
import motif.brit.logic.phases.battlesandretreats.BritResolveDefendingDie.ABritResolveDefendingDieIO;
import motif.brit.logic.requests.BritContinueRequest.ABritContinueRequestIO;
import motif.brit.logic.requests.BritSelectAreaRequest.ABritSelectAreaRequestIO;
import motif.brit.logic.requests.BritSelectUnitAreaSvgRequests.ABritSelectUnitAreaSvgRequestsIO;
import motif.brit.state.BritArea;
import motif.brit.state.BritDie;
import motif.brit.state.BritGame;
import motif.brit.state.BritLandArea;
import motif.brit.state.BritNation;
import motif.brit.state.BritPlayer;
import motif.brit.state.BritUnit;

public class BritPhaseBattlesAndRetreats {
	
	public static abstract class ABritPhaseBattlesAndRetreatsIO extends ABritPhaseIO {
		@Override public IBritIO start (BritContext context) { return new BritPhaseBattlesAndRetreats().start(this, context); }
		public ABritPhaseBattlesAndRetreatsIO(AngPhase phase, ABritNationTurnIO parent) { super(phase, parent); }
		public int getNAttDice() { return getGame().getNAttDice(); }
		public int getNDefDice() { return getGame().getNDefDice(); }
		public BritLandArea getBattleLand() { return getGame().getBattleLand(); }
		public BritNation getAttNation() { return getGame().getAttNation(); }
		public BritNation getDefNation() { return getGame().getDefNation(); }
		public BritPlayer getAttPlayer() { return getGame().getAttPlayer(); }
		public BritPlayer getDefPlayer() { return getGame().getDefPlayer(); }
		private Iterator<BritDie> attDiceIt;
		private Iterator<BritDie> defDiceIt;
	}
	
	@RequiredArgsConstructor
	private class BritSelectAreaToResolveBattleRequestIO extends ABritSelectAreaRequestIO<BritLandArea> {
		@Getter private final List<BritLandArea> availableAreas;
		@Getter private final ABritPhaseBattlesAndRetreatsIO parent;
		@Setter private BritLandArea area;
		@Override public BritPlayer getPlayer () { return parent.getPlayer(); }
		@Override public IBritIO getNext (BritContext context) { return BritPhaseBattlesAndRetreats.this.afterBattleAreaHasBeenSelected(area, parent, context); }
		@Override public String getText() { return BritText.request ().selectAreaToResolveBattle (parent.getPlayer()); }
		@Override public boolean canPass() { return false; }
	}

	@RequiredArgsConstructor
	private class BritThrowAttackingDiceRequestIO extends ABritContinueRequestIO {
		@Getter private final ABritPhaseBattlesAndRetreatsIO parent;
		@Override public IBritIO getNext(BritContext context) { return BritPhaseBattlesAndRetreats.this.afterAttackingDiceHaveBeenThrown(parent, context); }
		@Override public String getText() { return BritText.request ().throwAttackingDice (parent.getAttPlayer(), parent.getNAttDice()); }
		@Override public BritPlayer getPlayer() { return parent.getAttPlayer(); }
	}
	
	@RequiredArgsConstructor
	private class BritThrowDefendingDiceRequestIO extends ABritContinueRequestIO {
		@Getter private final ABritPhaseBattlesAndRetreatsIO parent;
		@Override public IBritIO getNext(BritContext context) { return BritPhaseBattlesAndRetreats.this.afterDefendingDiceHaveBeenThrown(parent, context); }
		@Override public String getText() { return BritText.request ().throwDefendingDice (parent.getDefPlayer(), parent.getNDefDice()); }
		@Override public BritPlayer getPlayer() { return parent.getDefPlayer(); }
	}
	
	@RequiredArgsConstructor
	private class BritResolveAttackingDieIO extends ABritResolveAttackingDieIO {
		@Getter private final BritDie attDie;
		@Getter private final ABritPhaseBattlesAndRetreatsIO parent;
		@Override public BritLandArea getBattleLand() { return parent.getBattleLand(); }
		@Override public BritPlayer getAttPlayer() { return parent.getAttPlayer(); }
		@Override public BritPlayer getDefPlayer() { return parent.getDefPlayer(); }
		@Override public BritNation getAttNation() { return parent.getAttNation(); }
		@Override public BritNation getDefNation() { return parent.getDefNation(); }
		@Override public IBritIO getNext (BritContext context) { return BritPhaseBattlesAndRetreats.this.afterAttackingDieHasBeenResolved(parent, context); }
	}
	
	@RequiredArgsConstructor
	private class BritResolveDefendingDieIO extends ABritResolveDefendingDieIO {
		@Getter private final BritDie defDie;
		@Getter private final ABritPhaseBattlesAndRetreatsIO parent;
		@Override public BritLandArea getBattleLand() { return parent.getBattleLand(); }
		@Override public BritPlayer getAttPlayer() { return parent.getAttPlayer(); }
		@Override public BritPlayer getDefPlayer() { return parent.getDefPlayer(); }
		@Override public BritNation getAttNation() { return parent.getAttNation(); }
		@Override public BritNation getDefNation() { return parent.getDefNation(); }
		@Override public IBritIO getNext(BritContext context) { return BritPhaseBattlesAndRetreats.this.afterDefendingDieHasBeenResolved(parent, context); }
	}
	
	@RequiredArgsConstructor
	private class BritAttackerSelectRetreatIO extends ABritSelectUnitAreaSvgRequestsIO<BritUnit, BritArea> {
		@Setter private BritUnit unit;
		@Setter private BritArea area;
		@Setter private double svgX;
		@Setter private double svgY;
		@Getter private final List<BritUnit> availableUnits;
		@Getter private final ABritPhaseBattlesAndRetreatsIO parent;
		@Override public BritPlayer getPlayer() { return parent.getAttPlayer(); }
		@Override public boolean canPass() { return true; }
		@Override public String getSelectUnitText() { return BritText.request().selectUnitToRetreat(getPlayer()); }
		@Override public String getSelectAreaText() { return BritText.request().selectAreaToRetreat(getPlayer(), unit); }
		@Override public List<BritArea> getAvailableAreas() { return Collections.singletonList(areasToRetreatAtt(unit, parent)); }
		@Override public IBritIO getNext(BritContext context) { return BritPhaseBattlesAndRetreats.this.afterAttackerHasSelectedRetreat(unit, area, svgX, svgY, parent, context); }
	}
	
	@RequiredArgsConstructor
	private class BritDefenderSelectRetreatIO extends ABritSelectUnitAreaSvgRequestsIO<BritUnit, BritLandArea> {
		@Setter private BritUnit unit;
		@Setter private BritLandArea area;
		@Setter private double svgX;
		@Setter private double svgY;
		@Getter private final List<BritUnit> availableUnits;
		@Getter private final ABritPhaseBattlesAndRetreatsIO parent;
		@Override public BritPlayer getPlayer() { return parent.getAttPlayer(); }
		@Override public boolean canPass() { return true; }
		@Override public String getSelectUnitText() { return BritText.request().selectUnitToRetreat(getPlayer()); }
		@Override public String getSelectAreaText() { return BritText.request().selectAreaToRetreat(getPlayer(), unit); }
		@Override public List<BritLandArea> getAvailableAreas() { return landsToRetreatDef(parent); }
		@Override public IBritIO getNext(BritContext context) { return BritPhaseBattlesAndRetreats.this.afterDefenderHasSelectedRetreat(unit, area, svgX, svgY, parent, context); }
	}
	
	private List<BritLandArea> landsToRetreatDef(ABritPhaseBattlesAndRetreatsIO IO) {
		return BritRules.landsToRetreatDef(IO.getBattleLand(), IO.getDefNation(), IO.getAttNation())
				.collect(Collectors.toList());
	}
	
	private BritArea areasToRetreatAtt(BritUnit unit, ABritPhaseBattlesAndRetreatsIO IO) {
		return BritRules.areaToRetreatAtt(IO.getBattleLand(), unit);
	}
	
	public IBritIO start(ABritPhaseBattlesAndRetreatsIO IO, BritContext context) {
		return selectBattle(IO, context);
	}
	
	private IBritIO selectBattle(ABritPhaseBattlesAndRetreatsIO IO, BritContext context) {
		BritNation nation = IO.getNation();
		// Compute all the battles to be resolved.
		Set<BritLandArea> battleLands = nation.inPlayUnits()
		.map(unit -> unit.getArea())
		.filter(area -> area.isLand())
		.map(area -> (BritLandArea) area)
		.filter(land -> land.isControlled() && !land.isControlledBy(nation))
		.collect(Collectors.toSet());
		if (battleLands.isEmpty()) {
			// No battle to fight. The phase ends.
			return null;
		} else {
			// Request the battle to resolve.
			return new BritSelectAreaToResolveBattleRequestIO(new ArrayList<BritLandArea>(battleLands), IO);
		}
	}

	public IBritIO afterBattleAreaHasBeenSelected(BritLandArea battleLand, ABritPhaseBattlesAndRetreatsIO IO, BritContext context) {
		return startBattle(battleLand, IO, context);
	}
	
	private IBritIO startBattle(BritLandArea battleLand, ABritPhaseBattlesAndRetreatsIO IO, BritContext context) {
		BritGame game = IO.getGame();
		// Create the new battle.
		BritNation attNation = IO.getNation();
		BritNation defNation = battleLand.getNation();
		game.newBattle(attNation, defNation, battleLand, context);
		return prepareDiceRolls(IO, context);
	}
	
	private IBritIO prepareDiceRolls(ABritPhaseBattlesAndRetreatsIO IO, BritContext context) {
		BritGame game = IO.getGame();
		BritLandArea battleLand = game.getBattleLand();
		BritNation attNation = IO.getNation();
		BritNation defNation = battleLand.getNation();
		// Prepare the attacking dice.
		battleLand.armiesOfNation(attNation)
		.forEach(army -> game.addAttDie(army, context));
		// Prepare the defending dice.
		battleLand.armiesOfNation(defNation)
		.forEach(army -> game.addDefDie(army, context));
		battleLand.buildings()
		.forEach(building -> game.addDefDie(building, context));
		// Request the attacking dice roll.
		return new BritThrowAttackingDiceRequestIO(IO);
	}
	
	public IBritIO afterAttackingDiceHaveBeenThrown(ABritPhaseBattlesAndRetreatsIO IO, BritContext context) {
		BritGame game = IO.getGame();
		// Roll the attacking dice.
		List<Integer> attResult = new ArrayList<>();
		game.attDice()
		.forEach(die -> {
			int result = BritRules.throwDie();
			attResult.add(result);
			game.setDieResult(result, die, context);
		});
		game.log ().playerRollsDice(attResult, game.getNAttDice(), game.getAttPlayer (), context);
		// Request the defending dice roll.
		return new BritThrowDefendingDiceRequestIO(IO);
	}
	
	public IBritIO afterDefendingDiceHaveBeenThrown(ABritPhaseBattlesAndRetreatsIO IO, BritContext context) {
		BritGame game = IO.getGame();
		// Roll the defending dice.
		List<Integer> defResult = new ArrayList<>();
		game.defDice()
		.forEach(die -> {
			int result = BritRules.throwDie();
			defResult.add(result);
			game.setDieResult(result, die, context);
		});
		game.log().playerRollsDice(defResult, game.getNDefDice(), game.getDefPlayer(), context);
		// Resolve the attacking dice.
		IO.attDiceIt = game.attDice().iterator();
		BritDie attDie = IO.attDiceIt.next();
		return new BritResolveAttackingDieIO(attDie, IO);
	}
	
	public IBritIO afterAttackingDieHasBeenResolved(ABritPhaseBattlesAndRetreatsIO IO, BritContext context) {
		BritGame game = IO.getGame();
		if (IO.attDiceIt.hasNext()) {
			// Resolve the next attacking die.
			BritDie attDie = IO.attDiceIt.next();
			return new BritResolveAttackingDieIO(attDie, IO);			
		} else {
			// Resolve the defending dice.
			IO.defDiceIt = game.defDice().iterator();
			BritDie defDie = IO.defDiceIt.next();
			return new BritResolveDefendingDieIO(defDie, IO);
		}
	}
	
	public IBritIO afterDefendingDieHasBeenResolved(ABritPhaseBattlesAndRetreatsIO IO, BritContext context) {
		if (IO.defDiceIt.hasNext()) {
			// Resolve the next defending die.
			BritDie defDie = IO.defDiceIt.next();
			return new BritResolveDefendingDieIO(defDie, IO);
		} else {
			return afterAllDiceHaveBeenResolved(IO, context);
		}
	}

	private IBritIO afterAllDiceHaveBeenResolved(ABritPhaseBattlesAndRetreatsIO IO, BritContext context) {
		BritLandArea battleLand = IO.getBattleLand();
		BritNation attNation = IO.getAttNation();
		BritNation defNation = IO.getDefNation();
		BritGame game = IO.getGame();
		if (battleLand.hasUnitsOfNation(attNation)) {
			return defenderChoosesRetreat(IO, context);
		} else {
			if (battleLand.hasUnitsOfNation(defNation)) {
				// Defender wins.
				return defenderWins(IO, context);
			} else {
				// All units died; the land is left empty.
				battleLand.setNation(null, context);
				game.log().noUnitRemainsInTheBattle(battleLand, context);
				return endBattle(IO, context);
			}
		}
	}
	
	private IBritIO defenderChoosesRetreat(ABritPhaseBattlesAndRetreatsIO IO, BritContext context) {
		BritLandArea battleLand = IO.getBattleLand();
		BritNation defNation = IO.getDefNation();
		if (battleLand.hasUnitsOfNation(defNation)) {
			// The defender may choose to retreat.
			List<BritUnit> defUnits = battleLand.movingUnitsOfNation(defNation).collect(Collectors.toList());
			return new BritDefenderSelectRetreatIO(defUnits, IO);
		} else {
			// Attacker won. He takes control of the land.
			return attackerWins(IO, context);
		}
	}
	
	private IBritIO attackerChoosesRetreat(ABritPhaseBattlesAndRetreatsIO IO, BritContext context) {
		BritLandArea battleLand = IO.getBattleLand();
		BritNation attNation = IO.getAttNation();
		if (battleLand.hasUnitsOfNation(attNation)) {
			// The attacker may choose to retreat.
			List<BritUnit> attUnits = battleLand.unitsOfNation(attNation).collect(Collectors.toList());
			return new BritAttackerSelectRetreatIO(attUnits, IO);
		} else {
			// Defender won.
			return defenderWins(IO, context);
		}
	}
	
	private IBritIO attackerWins(ABritPhaseBattlesAndRetreatsIO IO, BritContext context) {
		BritLandArea battleLand = IO.getBattleLand();
		BritNation attNation = IO.getAttNation();
		BritGame game = IO.getGame();
		battleLand.setNation(attNation, context);
		game.log().attackerWinsTheBattle(attNation, battleLand, context);
		return endBattle(IO, context);
	}
	
	private IBritIO defenderWins(ABritPhaseBattlesAndRetreatsIO IO, BritContext context) {
		BritLandArea battleLand = IO.getBattleLand();
		BritNation defNation = IO.getDefNation();
		BritGame game = IO.getGame();
		game.log().defenderWinsTheBattle(defNation, battleLand, context);
		return endBattle(IO, context);
	}
	
	public IBritIO afterDefenderHasSelectedRetreat(BritUnit unit, BritLandArea area, double svgX, double svgY, 
			ABritPhaseBattlesAndRetreatsIO IO, BritContext context) {
		if (unit == null || area == null) {
			BritLandArea battleLand = IO.getBattleLand();
			BritNation attNation = IO.getAttNation();
			List<BritUnit> attUnits = battleLand.movingUnitsOfNation(attNation).collect(Collectors.toList());
			return new BritAttackerSelectRetreatIO(attUnits, IO);
		} else {
			BritArea fromArea = unit.getArea();
			BritProcedures.moveUnit(unit, fromArea, area, svgX, svgY, context);
			IO.getGame().log().unitRetreats(unit, fromArea, area, IO.getDefPlayer(), context);
			return defenderChoosesRetreat(IO, context);
		}
	}
	
	public IBritIO afterAttackerHasSelectedRetreat(BritUnit unit, BritArea area, double svgX, double svgY, 
			ABritPhaseBattlesAndRetreatsIO IO, BritContext context) {
		if (unit == null || area == null) {
			endBattleRound(IO, context);
			prepareDiceRolls(IO, context);
		} else {
			BritArea fromArea = unit.getArea();
			BritProcedures.moveUnit(unit, fromArea, area, svgX, svgY, context);
			IO.getGame().log().unitRetreats(unit, fromArea, area, IO.getAttPlayer(), context);
			return attackerChoosesRetreat(IO, context);
		}
		return null;
	}

	private void endBattleRound(ABritPhaseBattlesAndRetreatsIO IO, BritContext context) {
		IO.attDiceIt = null;
		IO.defDiceIt = null;
		IO.getGame().resetBattleRound(context);
	}
	
	private IBritIO endBattle(ABritPhaseBattlesAndRetreatsIO IO, BritContext context) {
		endBattleRound(IO, context);
		BritGame game = IO.getGame();
		game.endBattle(context);
		return selectBattle(IO, context);
	}
	
}
