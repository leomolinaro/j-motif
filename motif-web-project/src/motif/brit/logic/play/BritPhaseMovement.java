package motif.brit.logic.play;

import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;
import motif.brit.ang.enums.AngPhase;
import motif.brit.ang.enums.BritText;
import motif.brit.endpoint.BritContext;
import motif.brit.logic.BritProcedures;
import motif.brit.logic.BritRules;
import motif.brit.logic.flow.IBritFlowProcess;
import motif.brit.logic.flow.IBritFlowStep;
import motif.brit.logic.requests.BritSelectAreaSvgRequest;
import motif.brit.logic.requests.BritSelectAreaSvgRequest.IBritFlowWithSelectAreaSvg;
import motif.brit.logic.requests.BritSelectUnitRequest;
import motif.brit.logic.requests.BritSelectUnitRequest.IBritFlowWithSelectUnit;
import motif.brit.state.BritArea;
import motif.brit.state.BritGame;
import motif.brit.state.BritLandArea;
import motif.brit.state.BritNation;
import motif.brit.state.BritUnit;

public class BritPhaseMovement extends ABritPhase implements IBritFlowWithSelectUnit<BritUnit>, IBritFlowWithSelectAreaSvg<BritLandArea> {
	
	public BritPhaseMovement(AngPhase phase, BritNation nation, BritGame game, IBritFlowWithMovement parent) {
		super(phase, nation, game);
		this.parent = parent;
	}

	public interface IBritFlowWithMovement extends IBritFlowProcess { public IBritFlowStep after(BritPhaseMovement movement, BritContext context); }
	@Getter private final IBritFlowWithMovement parent;
	@Override public IBritFlowStep next(BritContext context) { return this.parent.after(this, context); }
	
	private BritUnit movingUnit;
	
	@Override
	public IBritFlowStep start(BritContext context) {
		this.nation.inPlayUnits().forEach(unit -> {
			int movementPoints = BritRules.getMovementPoints(unit);
			unit.setMovementPoints(movementPoints, context);
		});
		return selectUnitToMove();
	}

	@Override
	public IBritFlowStep after(BritSelectUnitRequest<BritUnit> selectUnit, BritContext context) {
		BritUnit unit = selectUnit.getUnit();
		if (unit == null) {
			endMovement(this.nation, context);
			return null;
		} else {
			this.movingUnit = unit;
			unit.setMoving(true, context);
			BritArea fromArea = unit.getArea();
			List<BritLandArea> availableAreas = fromArea.adjacentLands().collect(Collectors.toList());
			return new BritSelectAreaSvgRequest<BritLandArea>(
					availableAreas,
					BritText.request().selectAreaToMoveUnit(this.player, unit),
					this.player,
					true,
					this
			);
		}
	}
	
	@Override
	public IBritFlowStep after(BritSelectAreaSvgRequest<BritLandArea> selectAreaSvg, BritContext context) {
		BritUnit unit = this.movingUnit;
		if (selectAreaSvg.getArea() == null) {
			unit.setMoving(false, context);
			this.movingUnit = null;
			endMovement(this.nation, context);
			return null;
		} else {
			BritArea fromArea = unit.getArea();
			BritProcedures.moveUnit(unit, fromArea, selectAreaSvg.getArea(), selectAreaSvg.getSvgX(), selectAreaSvg.getSvgY(), context);
			unit.setMovementPoints(unit.getMovementPoints() - 1, context);
			this.game.log().playerMovesUnit(unit, fromArea, selectAreaSvg.getArea(), this.player, context);
			unit.setMoving(false, context);
			this.movingUnit = null;
			return selectUnitToMove();
		}
	}
	
	private IBritFlowStep selectUnitToMove() {
		List<BritUnit> availableUnits = this.nation.inPlayUnits()
		.filter (unit -> {
			int leftMovementPoints = unit.getMovementPoints();
			return leftMovementPoints > 0;
		})
		.collect(Collectors.toList ());
		return new BritSelectUnitRequest<BritUnit>(
				availableUnits,
				BritText.request().selectUnitToMove(this.player, this.nation),
				this.player,
				true,
				this
		);
	}
	
	private void endMovement(BritNation nation, BritContext context) {
		nation.inPlayUnits().forEach(unit -> {
			unit.setMovementPoints(0, context);
		});
	}



}
