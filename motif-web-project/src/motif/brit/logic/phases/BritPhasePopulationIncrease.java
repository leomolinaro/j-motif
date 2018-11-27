package motif.brit.logic.phases;

import java.util.ArrayList;
import java.util.HashSet;
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
import motif.brit.logic.requests.BritSelectAreaSvgRequest.ABritSelectAreaSvgRequestIO;
import motif.brit.state.BritGame;
import motif.brit.state.BritInfantry;
import motif.brit.state.BritLandArea;
import motif.brit.state.BritNation;
import motif.brit.state.BritPlayer;
import motif.brit.state.BritUnit;

public class BritPhasePopulationIncrease extends ABritPhase {
	
	public static abstract class ABritPhasePopulationIncreaseIO extends ABritPhaseIO {
		@Override public IBritIO start (BritContext context) { return new BritPhasePopulationIncrease ().start (this, context); }
		public ABritPhasePopulationIncreaseIO (AngPhase phase, ABritNationTurnIO parent) { super (phase, parent); }
		private List<BritLandArea> controlledLands;
		private HashSet<String> placedAreaIds = new HashSet<String> ();
		private int nInfantriesToPlace;
	} // ABritPhasePopulationIncreaseIO
	
	@RequiredArgsConstructor
	private class BritSelectAreaToPlaceUnitRequestIO extends ABritSelectAreaSvgRequestIO<BritLandArea> {
		@Override public IBritIO getNext (BritContext context) { return BritPhasePopulationIncrease.this.next (this, context); }
		@Getter private final BritUnit unit;
		@Getter private final List<BritLandArea> availableAreas;
		@Override public BritPlayer getPlayer () { return parent.getPlayer (); }
		public BritGame getGame() { return parent.getGame (); }
		@Getter private final ABritPhasePopulationIncreaseIO parent;
		@Setter private BritLandArea area;
		@Setter private double svgX;
		@Setter private double svgY;
		@Override public String getText() { return BritText.request ().selectAreaToPlaceUnit(parent.getPlayer (), unit); }
		@Override public boolean canPass() { return false; }
	}
	
	protected IBritIO start (ABritPhasePopulationIncreaseIO IO, BritContext context) {
		super.start (IO, context);
		BritNation nation = IO.getNation ();
		if (nation.isRoman ()) {
			// TODO
			return null;
		} else {
			BritGame game = IO.getGame ();
			IO.controlledLands = game.landAreas ()
					.filter (area -> area.isControlledBy (nation))
					.collect (Collectors.toList ());
			int populationPoints = computePopulationPoints (nation, IO.controlledLands);
			game.log ().nationHasPopulationPoints (nation, populationPoints, context);
			IO.nInfantriesToPlace = populationPoints / 6;
			int availableInfantries = (int) nation.reinforcementInfantries ().count ();
			int residualPopulationPoints;
			if (IO.nInfantriesToPlace > availableInfantries) {
				IO.nInfantriesToPlace = availableInfantries;
				residualPopulationPoints = 5;
			} else {
				residualPopulationPoints = populationPoints % 6;
			} // if - else
			nation.setPopulationMarker (residualPopulationPoints, context);
			
			if (IO.nInfantriesToPlace > 0) {
				return placeUnitRequest (IO, context);
			} else {
				return null;
			} // if - else
		} // if - else
	} // execute
	
	private IBritIO placeUnitRequest (ABritPhasePopulationIncreaseIO IO, BritContext context) {
		BritGame game = IO.getGame ();
		BritNation nation = IO.getNation ();
		List<BritLandArea> availableLands = BritRules.goodStackingLands(nation).collect(Collectors.toList());
		if (availableLands.isEmpty ()) {
			game.log ().noAvailableLandsForPlacingUnits (nation, context);
			nation.setPopulationMarker (5, context);
			return null;
		} else {
			List<BritLandArea> notAlreadyChoosen = new ArrayList<BritLandArea> ();
			for (BritLandArea availableLand : availableLands) {
				if (!IO.placedAreaIds.contains (availableLand.getId ())) {
					notAlreadyChoosen.add (availableLand);
				} // if
			} // for
			if (!notAlreadyChoosen.isEmpty ()) { availableLands = notAlreadyChoosen; }
			BritInfantry infantry = nation.getInfantry ();
			return new BritSelectAreaToPlaceUnitRequestIO (infantry, availableLands, IO);
		} // if - else
	} // BritPlaceUnitRequest
	
	public IBritIO next (BritSelectAreaToPlaceUnitRequestIO IO, BritContext context) {
		IO.parent.nInfantriesToPlace--;
		
		BritLandArea land = IO.area;
		BritUnit infantry = IO.unit;
		double svgX = IO.svgX;
		double svgY = IO.svgY;
		IO.parent.placedAreaIds.add (land.getId ());
		BritProcedures.placeUnit (infantry, land, svgX, svgY, context);
		IO.getGame ().log ().playerPlacesUnit (infantry, land, IO.getPlayer (), context);
		
		if (IO.parent.nInfantriesToPlace > 0) {
			return placeUnitRequest (IO.parent, context);
		} else {
			return null;
		} // if - else
	} // next
	
	private static int computePopulationPoints (BritNation nation, List<BritLandArea> controlledLands) {
		int populationPoints = nation.getPopMarker ();
		for (BritLandArea land : controlledLands) {
			populationPoints += land.isNormalLand () ? 2 : 1;
		} // for
		return populationPoints;
	} // computePopulationPoints
	
} // BritPhasePopulationIncrease
