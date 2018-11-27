package motif.brit.logic.phases;

import java.util.List;
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
import motif.brit.logic.requests.BritSelectAreaSvgRequest.ABritSelectAreaSvgRequestIO;
import motif.brit.logic.requests.BritSelectUnitRequest.ABritSelectUnitRequestIO;
import motif.brit.state.BritArea;
import motif.brit.state.BritLandArea;
import motif.brit.state.BritNation;
import motif.brit.state.BritPlayer;
import motif.brit.state.BritUnit;

public class BritPhaseMovement {
	
	public static abstract class ABritPhaseMovementIO extends ABritPhaseIO {
		@Override public IBritIO start (BritContext context) { return new BritPhaseMovement ().start (this, context); }
		public ABritPhaseMovementIO (AngPhase phase, ABritNationTurnIO parent) { super (phase, parent); }
		private BritUnit movingUnit;
	}
	
	@RequiredArgsConstructor
	private class BritSelectAreaToMoveUnitRequestIO extends ABritSelectAreaSvgRequestIO<BritLandArea> {
		@Override public IBritIO getNext(BritContext context) { return BritPhaseMovement.this.afterBritSelectAreaToMoveUnitRequest(area, svgX, svgY, parent, context); }
		@Getter private final BritUnit unit;
		@Getter private final List<BritLandArea> availableAreas;
		@Getter private final ABritPhaseMovementIO parent;
		@Setter private BritLandArea area;
		@Setter private double svgX;
		@Setter private double svgY;
		@Override public BritPlayer getPlayer () { return parent.getPlayer (); }
		@Override public String getText() { return BritText.request ().selectAreaToMoveUnit (getPlayer (), unit); }
		@Override public boolean canPass() { return true; }
	}
	
	@RequiredArgsConstructor
	private class BritSelectUnitToMoveRequestIO extends ABritSelectUnitRequestIO<BritUnit> {
		@Override public IBritIO getNext (BritContext context) { return BritPhaseMovement.this.afterSelectUnitToMoveRequest(parent, context); }
		@Getter private final List<BritUnit> availableUnits;
		@Getter private final ABritPhaseMovementIO parent;
		@Override public BritPlayer getPlayer () { return parent.getPlayer (); }
		@Override public void setUnit(BritUnit unit) { this.parent.movingUnit = unit; }
		@Override public String getText() { return BritText.request ().selectUnitToMove (parent.getPlayer (), parent.getNation ()); }
		@Override public boolean canPass() { return true; }
	}
	
	public IBritIO start(ABritPhaseMovementIO IO, BritContext context) {
		IO.getNation().inPlayUnits ().forEach (unit -> {
			int movementPoints = BritRules.getMovementPoints (unit);
			unit.setMovementPoints (movementPoints, context);
		});
		return selectUnitToMove (IO);
	}

	public IBritIO afterSelectUnitToMoveRequest(ABritPhaseMovementIO IO, BritContext context) {
		BritUnit unit = IO.movingUnit;
		if (unit == null) {
			endMovement(IO.getNation(), context);
			return null;
		} else {
			unit.setMoving(true, context);
			BritArea fromArea = unit.getArea();
			List<BritLandArea> availableAreas = fromArea.adjacentLands().collect(Collectors.toList());
			return new BritSelectAreaToMoveUnitRequestIO(unit, availableAreas, IO);
		}
	}
	
	public IBritIO afterBritSelectAreaToMoveUnitRequest(BritLandArea toArea, double svgX, double svgY, ABritPhaseMovementIO IO, BritContext context) {
		BritUnit unit = IO.movingUnit;
		if (toArea == null) {
			unit.setMoving(false, context);
			IO.movingUnit = null;
			endMovement(IO.getNation(), context);
			return null;
		} else {
			BritArea fromArea = unit.getArea();
			BritProcedures.moveUnit(unit, fromArea, toArea, svgX, svgY, context);
			unit.setMovementPoints(unit.getMovementPoints() - 1, context);
			IO.getGame().log().playerMovesUnit(unit, fromArea, toArea, IO.getPlayer(), context);
			unit.setMoving(false, context);
			IO.movingUnit = null;
			return selectUnitToMove(IO);
		}
	}

	private IBritIO selectUnitToMove(ABritPhaseMovementIO IO) {
		List<BritUnit> availableUnits = IO.getNation().inPlayUnits()
		.filter (unit -> {
			int leftMovementPoints = unit.getMovementPoints();
			return leftMovementPoints > 0;
		})
		.collect (Collectors.toList ());
		return new BritSelectUnitToMoveRequestIO (availableUnits, IO);
	}

	private void endMovement(BritNation nation, BritContext context) {
		nation.inPlayUnits().forEach(unit -> {
			unit.setMovementPoints(0, context);
		});
	}
	
}
