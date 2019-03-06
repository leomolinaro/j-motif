package com.motif.brit.logic.play.battlesandretreats;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.motif.brit.ang.enums.BritText;
import com.motif.brit.endpoint.BritContext;
import com.motif.brit.logic.BritProcedures;
import com.motif.brit.logic.BritRules;
import com.motif.brit.logic.flow.IBritFlowProcess;
import com.motif.brit.logic.flow.IBritFlowStep;
import com.motif.brit.logic.play.battlesandretreats.BritAttackerSelectRetreat.IBritAfterAttackerSelectRetreat;
import com.motif.brit.logic.play.battlesandretreats.BritDefenderSelectRetreat.IBritAfterDefenderSelectRetreat;
import com.motif.brit.logic.play.battlesandretreats.BritResolveAttackingDie.IBritAfterResolveAttackingDie;
import com.motif.brit.logic.play.battlesandretreats.BritResolveDefendingDie.IBritAfterResolveDefendingDie;
import com.motif.brit.logic.play.battlesandretreats.BritThrowAttackingDiceRequest.IBritAfterThrowAttackingDice;
import com.motif.brit.logic.play.battlesandretreats.BritThrowDefendingDiceRequest.IBritAfterThrowDefendingDice;
import com.motif.brit.state.BritArea;
import com.motif.brit.state.BritDie;
import com.motif.brit.state.BritGame;
import com.motif.brit.state.BritLandArea;
import com.motif.brit.state.BritNation;
import com.motif.brit.state.BritPlayer;
import com.motif.brit.state.BritUnit;

import lombok.Getter;

public class BritBattleAndRetreats implements 
		IBritAfterThrowAttackingDice,
		IBritAfterThrowDefendingDice,
		IBritAfterResolveAttackingDie,
		IBritAfterResolveDefendingDie,
		IBritAfterAttackerSelectRetreat,
		IBritAfterDefenderSelectRetreat {

	private final BritLandArea battleLand;
	private final BritNation defNation;
	private final BritPlayer defPlayer;
	private final BritNation attNation;
	private final BritPlayer attPlayer;
	private final BritGame game;
	
	public BritBattleAndRetreats(BritLandArea battleLand, BritNation attNation, BritGame game, IBritAfterBattleAndRetreats parent) {
		super();
		this.battleLand = battleLand;
		this.defNation = this.battleLand.getNation();
		this.defPlayer = this.defNation.getController();
		this.attNation = attNation;
		this.attPlayer = this.attNation.getController();
		this.game = game;
		this.parent = parent;
	}

	public interface IBritAfterBattleAndRetreats extends IBritFlowProcess { public IBritFlowStep after(BritBattleAndRetreats battleAndRetreats, BritContext context); }
	@Getter private final IBritAfterBattleAndRetreats parent;
	@Override public IBritFlowStep next(BritContext context) { return this.parent.after(this, context); }

	private Iterator<BritDie> attDiceIt;
	private Iterator<BritDie> defDiceIt;
	
	private List<BritLandArea> landsToRetreatDef() {
		return BritRules.landsToRetreatDef(this.battleLand, this.defNation, this.attNation)
				.collect(Collectors.toList());
	}
	
	private BritArea areasToRetreatAtt(BritUnit unit) {
		return BritRules.areaToRetreatAtt(this.battleLand, unit);
	}
	
	@Override
	public IBritFlowStep start(BritContext context) {
		// Create the new battle.
		this.game.newBattle(this.attNation, this.defNation, this.battleLand, context);
		return prepareDiceRolls(context);
	}
	
	private IBritFlowStep prepareDiceRolls(BritContext context) {
		// Prepare the attacking dice.
		this.battleLand.armiesOfNation(this.attNation)
		.forEach(army -> this.game.addAttDie(army, context));
		// Prepare the defending dice.
		this.battleLand.armiesOfNation(this.defNation)
		.forEach(army -> this.game.addDefDie(army, context));
		this.battleLand.buildings()
		.forEach(building -> this.game.addDefDie(building, context));
		// Request the attacking dice roll.
		return new BritThrowAttackingDiceRequest(
				BritText.request().throwAttackingDice(this.attPlayer, this.game.getNAttDice()),
				this.attPlayer,
				this
		);
	}
	
	@Override
	public IBritFlowStep after(BritThrowAttackingDiceRequest throwAttackingDice, BritContext context) {
		// Roll the attacking dice.
		var attResult = new ArrayList<Integer>();
		this.game.attDice()
		.forEach(die -> {
			int result = BritRules.throwDie();
			attResult.add(result);
			this.game.setDieResult(result, die, context);
		});
		this.game.log ().playerRollsDice(attResult, this.game.getNAttDice(), this.attPlayer, context);
		// Request the defending dice roll.
		return new BritThrowDefendingDiceRequest(
				BritText.request ().throwDefendingDice (this.defPlayer, this.game.getNDefDice()),
				this.defPlayer,
				this
		);
	}
	
	@Override
	public IBritFlowStep after(BritThrowDefendingDiceRequest throwDefendingDice, BritContext context) {
		// Roll the defending dice.
		var defResult = new ArrayList<Integer>();
		this.game.defDice()
		.forEach(die -> {
			int result = BritRules.throwDie();
			defResult.add(result);
			this.game.setDieResult(result, die, context);
		});
		this.game.log().playerRollsDice(defResult, this.game.getNDefDice(), this.game.getDefPlayer(), context);
		// Resolve the attacking dice.
		this.attDiceIt = game.attDice().iterator();
		var attDie = this.attDiceIt.next();
		return new BritResolveAttackingDie(
				attDie,
				this.battleLand,
				this.attNation,
				this.defNation,
				this
		);
	}
	
	@Override
	public IBritFlowStep after(BritResolveAttackingDie resolveAttackingDie, BritContext context) {
		if (this.attDiceIt.hasNext()) {
			// Resolve the next attacking die.
			var attDie = this.attDiceIt.next();
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
			var defDie = this.defDiceIt.next();
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
			var defDie = this.defDiceIt.next();
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
		if (this.battleLand.hasUnitsOfNation(this.attNation)) {
			return defenderChoosesRetreat(context);
		} else {
			if (this.battleLand.hasUnitsOfNation(this.defNation)) {
				// Defender wins.
				return defenderWins(context);
			} else {
				// All units died; the land is left empty.
				this.battleLand.setNation(null, context);
				this.game.log().noUnitRemainsInTheBattle(this.battleLand, context);
				return endBattle(context);
			}
		}
	}
	
	private IBritFlowStep defenderChoosesRetreat(BritContext context) {
		if (this.battleLand.hasUnitsOfNation(this.defNation)) {
			// The defender may choose to retreat.
			var defUnits = this.battleLand.movingUnitsOfNation(this.defNation).collect(Collectors.toList());
			var availableAreasPerUnit = new HashMap<String, List<BritLandArea>>();
			var availableAreas = this.landsToRetreatDef();
			defUnits.forEach(unit -> {
				availableAreasPerUnit.put(unit.getId(), availableAreas);
			});
			return new BritDefenderSelectRetreat(
					defUnits,
					BritText.request().selectUnitToRetreat(this.defPlayer),
					this.defPlayer,
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
					BritText.request().selectUnitToRetreat(this.attPlayer),
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
		this.battleLand.setNation(this.attNation, context);
		this.game.log().attackerWinsTheBattle(this.attNation, this.battleLand, context);
		return endBattle(context);
	}
	
	private IBritFlowStep defenderWins(BritContext context) {
		this.game.log().defenderWinsTheBattle(this.defNation, this.battleLand, context);
		return endBattle(context);
	}
	
	@Override
	public IBritFlowStep after(BritDefenderSelectRetreat defenderSelectRetreat, BritContext context) {
		if (defenderSelectRetreat.getUnit() == null || defenderSelectRetreat.getArea() == null) {
			return attackerChoosesRetreat(context);
		} else {
			var unit = defenderSelectRetreat.getUnit();
			var fromArea = unit.getArea();
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
			var unit = attackerSelectRetreat.getUnit();
			var fromArea = unit.getArea();
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
		this.game.endBattle(context);
		return null;
	}
	
}
