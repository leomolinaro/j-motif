package motif.brit.logic.play;

import java.util.ArrayList;
import java.util.HashSet;
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
import motif.brit.state.BritGame;
import motif.brit.state.BritLandArea;
import motif.brit.state.BritNation;
import motif.brit.state.BritUnit;

public class BritPhasePopulationIncrease extends ABritPhase implements IBritFlowWithSelectAreaSvg<BritLandArea> {
	
	public BritPhasePopulationIncrease(AngPhase phase, BritNation nation, BritGame game, IBritFlowWithPopulationIncrease parent) {
		super(phase, nation, game);
		this.parent = parent;
	}

	public interface IBritFlowWithPopulationIncrease extends IBritFlowProcess { public IBritFlowStep after(BritPhasePopulationIncrease populationIncrease, BritContext context); }
	@Getter private final IBritFlowWithPopulationIncrease parent;
	@Override public IBritFlowStep next(BritContext context) { return this.parent.after(this, context); }
	
	private List<BritLandArea> controlledLands;
	private HashSet<String> placedAreaIds = new HashSet<String>();
	private int nInfantriesToPlace;
	private BritUnit placingUnit;
	
	public IBritFlowStep start(BritContext context) {
		super.initPhase(context);
		if (this.nation.isRoman()) {
			// TODO
			return null;
		} else {
			this.controlledLands = this.game.landAreas()
					.filter(area -> area.isControlledBy(this.nation))
					.collect(Collectors.toList());
			int populationPoints = computePopulationPoints(this.nation, this.controlledLands);
			this.game.log().nationHasPopulationPoints (this.nation, populationPoints, context);
			this.nInfantriesToPlace = populationPoints / 6;
			int availableInfantries = (int) this.nation.reinforcementInfantries().count();
			int residualPopulationPoints;
			if (this.nInfantriesToPlace > availableInfantries) {
				this.nInfantriesToPlace = availableInfantries;
				residualPopulationPoints = 5;
			} else {
				residualPopulationPoints = populationPoints % 6;
			}
			this.nation.setPopulationMarker(residualPopulationPoints, context);
			
			if (this.nInfantriesToPlace > 0) {
				return placeUnitRequest(context);
			} else {
				return null;
			}
		}
	}
	
	private IBritFlowStep placeUnitRequest(BritContext context) {
		List<BritLandArea> availableLands = BritRules.goodStackingLands(nation).collect(Collectors.toList());
		if (availableLands.isEmpty()) {
			this.game.log().noAvailableLandsForPlacingUnits(nation, context);
			this.nation.setPopulationMarker(5, context);
			return null;
		} else {
			List<BritLandArea> notAlreadyChoosen = new ArrayList<BritLandArea>();
			for (BritLandArea availableLand : availableLands) {
				if (!placedAreaIds.contains(availableLand.getId())) {
					notAlreadyChoosen.add(availableLand);
				}
			}
			if (!notAlreadyChoosen.isEmpty()) { availableLands = notAlreadyChoosen; }
			this.placingUnit = nation.getInfantry();
			return new BritSelectAreaSvgRequest<BritLandArea>(
					availableLands,
					BritText.request().selectAreaToPlaceUnit(this.player, this.placingUnit),
					this.player,
					false,
					this
			);
		}
	}
	
	public IBritFlowStep after(BritSelectAreaSvgRequest<BritLandArea> selectAreaSvg, BritContext context) {
		this.nInfantriesToPlace--;
		
		var land = selectAreaSvg.getArea();
		var infantry = this.placingUnit;
		this.placingUnit = null;
		double svgX = selectAreaSvg.getSvgX();
		double svgY = selectAreaSvg.getSvgY();
		this.placedAreaIds.add (land.getId());
		BritProcedures.placeUnit(infantry, land, svgX, svgY, context);
		this.game.log ().playerPlacesUnit(infantry, land, this.player, context);
		
		if (this.nInfantriesToPlace > 0) {
			return placeUnitRequest(context);
		} else {
			return null;
		}
	}
	
	private static int computePopulationPoints(BritNation nation, List<BritLandArea> controlledLands) {
		int populationPoints = nation.getPopMarker();
		for (BritLandArea land : controlledLands) {
			populationPoints += land.isNormalLand() ? 2 : 1;
		}
		return populationPoints;
	}

}
