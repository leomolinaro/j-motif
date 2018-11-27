package motif.brit.logic;

import motif.brit.endpoint.BritContext;
import motif.brit.state.BritArea;
import motif.brit.state.BritLandArea;
import motif.brit.state.BritNation;
import motif.brit.state.BritUnit;

public class BritProcedures {

	private static void controlLand(BritNation nation, BritLandArea land, BritContext context) {
		BritNation prevNation = land.getNation();
		if (prevNation != nation) {
			if (prevNation != null) prevNation.removeLand(land);
			land.setNation(nation, context);
			if (nation != null) { nation.addLand(land); }
		}
	}
	
	public static void placeUnit(BritUnit unit, BritArea area, double svgX, double svgY, BritContext context) {
		BritNation nation = unit.getNation();
		nation.removeReinforcement(unit, context);
		area.addUnit(unit, svgX, svgY, context);
		unit.setArea(area);
		if (area instanceof BritLandArea) {
			controlLand(nation, (BritLandArea) area, context);
		}
	}

	public static void moveUnit(BritUnit unit, BritArea fromArea, BritArea toArea, double svgX, double svgY, BritContext context) {
		fromArea.removeUnit(unit, context);
		unit.addPath(fromArea);
		if (fromArea instanceof BritLandArea) {
			BritLandArea fromLand = (BritLandArea) fromArea;
			if (!fromLand.units().findAny().isPresent()) {
				controlLand(null, fromLand, context);
			}			
		}
		toArea.addUnit(unit, svgX, svgY, context);
		if (toArea instanceof BritLandArea) {
			BritLandArea toLand = (BritLandArea) toArea;
			if (!toLand.isControlled()) {
				controlLand(unit.getNation(), toLand, context);
			}			
		}
		unit.setArea(toArea);
	}
	
	public static void removeUnit(BritUnit unit, BritNation nation, BritArea area, BritContext context) {
		nation.addReinforcement(unit, context);
		area.removeUnit(unit, context);
		unit.setArea(null);
		if (area instanceof BritLandArea) {
			BritLandArea land = (BritLandArea) area;
			if (!land.units().findAny().isPresent()) {
				controlLand(null, land, context);
			}			
		}
	}

}
