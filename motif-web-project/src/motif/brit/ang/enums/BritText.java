package motif.brit.ang.enums;

import motif.brit.state.BritNation;
import motif.brit.state.BritPlayer;
import motif.brit.state.BritUnit;
import motif.shared.util.MotifConsole;

public class BritText {
	
	public static BritTitle title () { return new BritTitle (); }
	
	public static class BritTitle {
		public String actionWindow () { return "Action window"; }

		public String plotPhase () { return "1 Plot phase"; }
		public String startPlotPhaseStep () { return "1.1 Plot phase begins"; }

	}
	
	public static BritRequestMessage request () { return new BritRequestMessage (); }

	public static class BritRequestMessage {

		public String selectAreaToPlaceUnit (BritPlayer player, BritUnit unit) { return  MotifConsole.format ("{0}, select an area to place the unit {1}.", player.getName (), unit.getLabel ()); }
		public String selectAreaToMoveUnit (BritPlayer player, BritUnit unit) { return  MotifConsole.format ("{0}, select an area to move the unit {1} to.", player.getName (), unit.getLabel ()); }
		public String selectAreaToResolveBattle (BritPlayer player) { return  MotifConsole.format ("{0}, select a battle to resolve.", player.getName ()); }
		public String selectAreaToRetreat (BritPlayer player, BritUnit unit) { return  MotifConsole.format ("{0}, select an area to retreat the unit {1}.", player.getName (), unit.getLabel()); }
		public String selectUnitToRetreat (BritPlayer player) { return  MotifConsole.format ("{0}, select a unit to retreat.", player.getName ()); }
		public String selectUnitToMove (BritPlayer player, BritNation nation) { return  MotifConsole.format ("{0}, select a {1} unit to move.", player.getName (), nation.getName ()); }
		public String selectUnitToEliminate (BritPlayer player, BritNation nation) { return  MotifConsole.format ("{0}, select a {1} unit to eliminate.", player.getName (), nation.getName ()); }
		public String throwAttackingDice (BritPlayer player, int nDice) { return  MotifConsole.format ("{0}, throw {1} attacking dice.", player.getName (), nDice); }
		public String throwDefendingDice (BritPlayer player, int nDice) { return  MotifConsole.format ("{0}, throw {1} defending dice.", player.getName (), nDice); }

	}
	
}
