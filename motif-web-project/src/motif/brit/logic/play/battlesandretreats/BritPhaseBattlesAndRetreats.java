package motif.brit.logic.play.battlesandretreats;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.Getter;
import motif.brit.ang.enums.AngPhase;
import motif.brit.ang.enums.BritText;
import motif.brit.endpoint.BritContext;
import motif.brit.logic.BritProcedures;
import motif.brit.logic.BritRules;
import motif.brit.logic.flow.IBritFlowProcess;
import motif.brit.logic.flow.IBritFlowStep;
import motif.brit.logic.play.ABritPhase;
import motif.brit.logic.play.battlesandretreats.BritAttackerSelectRetreat.IBritFlowWithAttackerSelectRetreat;
import motif.brit.logic.play.battlesandretreats.BritDefenderSelectRetreat.IBritFlowWithDefenderSelectRetreat;
import motif.brit.logic.play.battlesandretreats.BritResolveAttackingDie.IBritAfterResolveAttackingDie;
import motif.brit.logic.play.battlesandretreats.BritResolveDefendingDie.IBritAfterResolveDefendingDie;
import motif.brit.logic.play.battlesandretreats.BritThrowAttackingDiceRequest.IBritAfterThrowAttackingDice;
import motif.brit.logic.play.battlesandretreats.BritThrowDefendingDiceRequest.IBritAfterThrowDefendingDice;
import motif.brit.logic.requests.BritSelectAreaRequest;
import motif.brit.logic.requests.BritSelectAreaRequest.IBritAfterSelectArea;
import motif.brit.state.BritArea;
import motif.brit.state.BritDie;
import motif.brit.state.BritGame;
import motif.brit.state.BritLandArea;
import motif.brit.state.BritNation;
import motif.brit.state.BritUnit;

public class BritPhaseBattlesAndRetreats extends ABritPhase implements 
		IBritAfterSelectArea<BritLandArea>,
		IBritAfterThrowAttackingDice,
		IBritAfterThrowDefendingDice,
		IBritAfterResolveAttackingDie,
		IBritAfterResolveDefendingDie,
		IBritFlowWithAttackerSelectRetreat,
		IBritFlowWithDefenderSelectRetreat {
	
	public BritPhaseBattlesAndRetreats(AngPhase phase, BritNation nation, BritGame game, IBritFlowWithBattlesAndRetreats parent) {
		super(phase, nation, game);
		this.parent = parent;
	}

	public interface IBritFlowWithBattlesAndRetreats extends IBritFlowProcess { public IBritFlowStep after(BritPhaseBattlesAndRetreats battlesAndRetreats, BritContext context); }
	@Getter private final IBritFlowWithBattlesAndRetreats parent;
	@Override public IBritFlowStep next(BritContext context) { return this.parent.after(this, context); }

	private Iterator<BritDie> attDiceIt;
	private Iterator<BritDie> defDiceIt;
	
	private List<BritLandArea> landsToRetreatDef() {
		return BritRules.landsToRetreatDef(this.game.getBattleLand(), this.game.getDefNation(), this.game.getAttNation())
				.collect(Collectors.toList());
	}
	
	private BritArea areasToRetreatAtt(BritUnit unit) {
		return BritRules.areaToRetreatAtt(this.game.getBattleLand(), unit);
	}
	
	@Override
	public IBritFlowStep start(BritContext context) {
		return selectBattle(context);
	}
	
	private IBritFlowStep selectBattle(BritContext context) {
		// Compute all the battles to be resolved.
		Set<BritLandArea> battleLands = this.nation.inPlayUnits()
		.map(unit -> unit.getArea())
		.filter(area -> area.isLand())
		.map(area -> (BritLandArea) area)
		.filter(land -> land.isControlled() && !land.isControlledBy(this.nation))
		.collect(Collectors.toSet());
		if (battleLands.isEmpty()) {
			// No battle to fight. The phase ends.
			return null;
		} else {
			// Request the battle to resolve.
			return new BritSelectAreaRequest<BritLandArea>(
					new ArrayList<BritLandArea>(battleLands),
					BritText.request().selectAreaToResolveBattle(this.player),
					this.player,
					false,
					this
			);
		}
	}
	
	@Override
	public IBritFlowStep after(BritSelectAreaRequest<BritLandArea> selectArea, BritContext context) {
		return startBattle(selectArea.getArea(), context);
	}
	
	private IBritFlowStep startBattle(BritLandArea battleLand, BritContext context) {
		// Create the new battle.
		BritNation attNation = this.nation;
		BritNation defNation = battleLand.getNation();
		game.newBattle(attNation, defNation, battleLand, context);
		return prepareDiceRolls(context);
	}
	
	private IBritFlowStep prepareDiceRolls(BritContext context) {
		BritLandArea battleLand = game.getBattleLand();
		BritNation attNation = this.nation;
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
		return new BritThrowAttackingDiceRequest(
				BritText.request().throwAttackingDice(this.player, game.getNAttDice()),
				this.player,
				this
		);
	}
	
	@Override
	public IBritFlowStep after(BritThrowAttackingDiceRequest throwAttackingDice, BritContext context) {
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
		return new BritThrowDefendingDiceRequest(
				BritText.request ().throwDefendingDice (game.getDefPlayer(), game.getNDefDice()),
				game.getDefPlayer(),
				this
		);
	}
	
	@Override
	public IBritFlowStep after(BritThrowDefendingDiceRequest throwDefendingDice, BritContext context) {
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
		this.attDiceIt = game.attDice().iterator();
		BritDie attDie = attDiceIt.next();
		return new BritResolveAttackingDie(
				attDie,
				game.getBattleLand(),
				game.getAttNation(),
				game.getDefNation(),
				this
		);
	}
	
	@Override
	public IBritFlowStep after(BritResolveAttackingDie resolveAttackingDie, BritContext context) {
		if (this.attDiceIt.hasNext()) {
			// Resolve the next attacking die.
			BritDie attDie = this.attDiceIt.next();
			return new BritResolveAttackingDie(
					attDie,
					this.game.getBattleLand(),
					this.game.getAttNation(),
					this.game.getDefNation(),
					this
			);			
		} else {
			// Resolve the defending dice.
			this.defDiceIt = this.game.defDice().iterator();
			BritDie defDie = this.defDiceIt.next();
			return new BritResolveDefendingDie(
					defDie,
					this.game.getBattleLand(),
					this.game.getAttNation(),
					this.game.getDefNation(),
					this
			);
		}
	}
	
	@Override
	public IBritFlowStep after(BritResolveDefendingDie resolveDefendingDie, BritContext context) {
		if (this.defDiceIt.hasNext()) {
			// Resolve the next defending die.
			BritDie defDie = this.defDiceIt.next();
			return new BritResolveDefendingDie(
					defDie,
					this.game.getBattleLand(),
					this.game.getAttNation(),
					this.game.getDefNation(),
					this
			);
		} else {
			return afterAllDiceHaveBeenResolved(context);
		}
	}

	private IBritFlowStep afterAllDiceHaveBeenResolved(BritContext context) {
		BritLandArea battleLand = this.game.getBattleLand();
		BritNation attNation = this.game.getAttNation();
		BritNation defNation = this.game.getDefNation();
		if (battleLand.hasUnitsOfNation(attNation)) {
			return defenderChoosesRetreat(context);
		} else {
			if (battleLand.hasUnitsOfNation(defNation)) {
				// Defender wins.
				return defenderWins(context);
			} else {
				// All units died; the land is left empty.
				battleLand.setNation(null, context);
				game.log().noUnitRemainsInTheBattle(battleLand, context);
				return endBattle(context);
			}
		}
	}
	
	private IBritFlowStep defenderChoosesRetreat(BritContext context) {
		BritLandArea battleLand = this.game.getBattleLand();
		BritNation defNation = this.game.getDefNation();
		if (battleLand.hasUnitsOfNation(defNation)) {
			// The defender may choose to retreat.
			List<BritUnit> defUnits = battleLand.movingUnitsOfNation(defNation).collect(Collectors.toList());
			HashMap<String, List<BritLandArea>> availableAreasPerUnit = new HashMap<String, List<BritLandArea>>();
			List<BritLandArea> availableAreas = this.landsToRetreatDef();
			defUnits.forEach(unit -> {
				availableAreasPerUnit.put(unit.getId(), availableAreas);
			});
			return new BritDefenderSelectRetreat(
					defUnits,
					BritText.request().selectUnitToRetreat(this.game.getDefPlayer()),
					this.game.getDefPlayer(),
					true,
					availableAreasPerUnit,
					this
			);
		} else {
			// Attacker won. He takes control of the land.
			return attackerWins(context);
		}
	}
	
	private IBritFlowStep attackerChoosesRetreat(BritContext context) {
		var battleLand = this.game.getBattleLand();
		var attNation = this.game.getAttNation();
		if (battleLand.hasUnitsOfNation(attNation)) {
			// The attacker may choose to retreat.
			var attUnits = battleLand.unitsOfNation(attNation).collect(Collectors.toList());
			var availableAreasPerUnit = new HashMap<String, List<BritArea>>();
			attUnits.forEach(unit -> {
				var availableArea = this.areasToRetreatAtt(unit);
				availableAreasPerUnit.put(unit.getId(), Collections.singletonList(availableArea));
			});
			return new BritAttackerSelectRetreat(
					attUnits,
					BritText.request().selectUnitToRetreat(this.game.getAttPlayer()),
					this.game.getAttPlayer(),
					true,
					availableAreasPerUnit,
					this
			);
		} else {
			// Defender won.
			return defenderWins(context);
		}
	}
	
	private IBritFlowStep attackerWins(BritContext context) {
		BritLandArea battleLand = this.game.getBattleLand();
		BritNation attNation = this.game.getAttNation();
		battleLand.setNation(attNation, context);
		game.log().attackerWinsTheBattle(attNation, battleLand, context);
		return endBattle(context);
	}
	
	private IBritFlowStep defenderWins(BritContext context) {
		BritLandArea battleLand = this.game.getBattleLand();
		BritNation defNation = this.game.getDefNation();
		game.log().defenderWinsTheBattle(defNation, battleLand, context);
		return endBattle(context);
	}
	
	@Override
	public IBritFlowStep after(BritDefenderSelectRetreat defenderSelectRetreat, BritContext context) {
		if (defenderSelectRetreat.getUnit() == null || defenderSelectRetreat.getArea() == null) {
			return attackerChoosesRetreat(context);
		} else {
			BritUnit unit = defenderSelectRetreat.getUnit();
			BritArea fromArea = unit.getArea();
			BritProcedures.moveUnit(unit, fromArea, defenderSelectRetreat.getArea(), defenderSelectRetreat.getSvgX(), defenderSelectRetreat.getSvgY(), context);
			this.game.log().unitRetreats(unit, fromArea, defenderSelectRetreat.getArea(), this.game.getDefPlayer(), context);
			return defenderChoosesRetreat(context);
		}
	}

	@Override
	public IBritFlowStep after(BritAttackerSelectRetreat attackerSelectRetreat, BritContext context) {
		if (attackerSelectRetreat.getUnit() == null || attackerSelectRetreat.getArea() == null) {
			endBattleRound(context);
			prepareDiceRolls(context);
		} else {
			BritUnit unit = attackerSelectRetreat.getUnit();
			BritArea fromArea = unit.getArea();
			BritProcedures.moveUnit(unit, fromArea, attackerSelectRetreat.getArea(), attackerSelectRetreat.getSvgX(), attackerSelectRetreat.getSvgY(), context);
			this.game.log().unitRetreats(unit, fromArea, attackerSelectRetreat.getArea(), this.game.getAttPlayer(), context);
			return attackerChoosesRetreat(context);
		}
		return null;
	}
	
	private void endBattleRound(BritContext context) {
		this.attDiceIt = null;
		this.defDiceIt = null;
		this.game.resetBattleRound(context);
	}
	
	private IBritFlowStep endBattle(BritContext context) {
		endBattleRound(context);
		game.endBattle(context);
		return selectBattle(context);
	}

}
