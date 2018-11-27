package motif.brit.logic;

import motif.brit.endpoint.BritContext;
import motif.brit.state.BritArea;
import motif.brit.state.BritGame;
import motif.brit.state.BritInfantry;
import motif.brit.state.BritLandArea;
import motif.brit.state.BritNation;

public class BritSetup {

	public void execute(BritGame game, BritContext context) {
		BritNation belgae = game.getNation("belgae");
		BritNation welsh = game.getNation("welsh");
		BritNation brigantes = game.getNation("brigantes");
		BritNation caledonians = game.getNation("caledonians");
		BritNation picts = game.getNation("picts");
		
	    belgae.setPopulationMarker(0, context);
	    welsh.setPopulationMarker(0, context);
	    brigantes.setPopulationMarker(0, context);
	    caledonians.setPopulationMarker(0, context);
	    picts.setPopulationMarker(0, context);
	    
	    placeInfantry(belgae, BritArea.DOWNLANDS, 445, 1018, game, context);
	    placeInfantry(belgae, BritArea.ESSEX, 555, 994, game, context);
	    placeInfantry(belgae, BritArea.KENT, 618, 1035, game, context);
	    placeInfantry(belgae, BritArea.LINDSEY, 549, 811, game, context);
	    placeInfantry(belgae, BritArea.NORTH_MERCIA, 485, 875, game, context);
	    placeInfantry(belgae, BritArea.SOUTH_MERCIA, 487, 970, game, context);
	    placeInfantry(belgae, BritArea.NORFOLK, 638, 847, game, context);
	    placeInfantry(belgae, BritArea.SUFFOLK, 580, 922, game, context);
	    placeInfantry(belgae, BritArea.SUSSEX, 547, 1063, game, context);
	    placeInfantry(belgae, BritArea.WESSEX, 416, 1065, game, context);
	    placeInfantry(welsh, BritArea.AVALON, 356, 1036, game, context);
	    placeInfantry(welsh, BritArea.CLWYD, 321, 799, game, context);
	    placeInfantry(welsh, BritArea.CORNWALL, 184, 1128, game, context);
	    placeInfantry(welsh, BritArea.DEVON, 277, 1059, game, context);
	    placeInfantry(welsh, BritArea.DYFED, 236, 934, game, context);
	    placeInfantry(welsh, BritArea.GWENT, 312, 966, game, context);
	    placeInfantry(welsh, BritArea.GWYNEDD, 262, 808, game, context);
	    placeInfantry(welsh, BritArea.HWICCE, 392, 935, game, context);
	    placeInfantry(welsh, BritArea.POWYS, 320, 881, game, context);
	    placeInfantry(brigantes, BritArea.BERNICIA, 471, 650, game, context);
	    placeInfantry(brigantes, BritArea.CHESHIRE, 392, 776, game, context);
	    placeInfantry(brigantes, BritArea.CUMBRIA, 350, 650, game, context);
	    placeInfantry(brigantes, BritArea.GALLOWAY, 281, 574, game, context);
	    placeInfantry(brigantes, BritArea.LOTHIAN, 395, 534, game, context);
	    placeInfantry(brigantes, BritArea.MARCH, 398, 855, game, context);
	    placeInfantry(brigantes, BritArea.PENNINES, 419, 678, game, context);
	    placeInfantry(brigantes, BritArea.STRATHCLYDE, 272, 505, game, context);
	    placeInfantry(brigantes, BritArea.YORK, 497, 751, game, context);
	    placeInfantry(picts, BritArea.ALBAN, 302, 360, game, context);
	    placeInfantry(picts, BritArea.DALRIADA, 208, 425, game, context);
	    placeInfantry(picts, BritArea.DUNEDIN, 322, 434, game, context);
	    placeInfantry(picts, BritArea.MAR, 381, 301, game, context);
	    placeInfantry(picts, BritArea.MORAY, 282, 296, game, context);
	    placeInfantry(picts, BritArea.SKYE, 188, 298, game, context);
	    placeInfantry(caledonians, BritArea.CAITHNESS, 262, 193, game, context);
	    placeInfantry(caledonians, BritArea.ORKNEYS, 337, 90, game, context);
	    placeInfantry(caledonians, BritArea.HEBRIDES, 121, 189, game, context);
	}

	private void placeInfantry(BritNation nation, String areaId, int svgX, int svgY, BritGame game, BritContext context) {
		BritInfantry infantry = nation.reinforcementInfantries().findAny().get();
		BritLandArea area = game.getLandArea(areaId);
		BritProcedures.placeUnit(infantry, area, svgX, svgY, context);
	}

}
