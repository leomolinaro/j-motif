package motif.brit.logic.play.battlesandretreats;

import java.util.HashMap;
import java.util.List;

import lombok.Getter;
import motif.brit.ang.enums.BritText;
import motif.brit.endpoint.BritContext;
import motif.brit.logic.flow.IBritFlowProcess;
import motif.brit.logic.flow.IBritFlowStep;
import motif.brit.logic.requests.BritSelectUnitAreaSvgRequests;
import motif.brit.state.BritLandArea;
import motif.brit.state.BritPlayer;
import motif.brit.state.BritUnit;

public class BritDefenderSelectRetreat extends BritSelectUnitAreaSvgRequests<BritUnit, BritLandArea> {

	public BritDefenderSelectRetreat(
			List<BritUnit> availableUnits,
			String selectUnitText,
	        BritPlayer player,
	        boolean canPass,
	        HashMap<String, List<BritLandArea>> availableAreasPerUnit,
	        IBritFlowWithDefenderSelectRetreat parent
	) {
		super(availableUnits, selectUnitText, player, canPass, availableAreasPerUnit);
		this.parent = parent;
	}
	
	public interface IBritFlowWithDefenderSelectRetreat extends IBritFlowProcess { public IBritFlowStep after(BritDefenderSelectRetreat attackerSelectRetreat, BritContext context); }
	@Getter private final IBritFlowWithDefenderSelectRetreat parent;
	@Override public IBritFlowStep next(BritContext context) { return this.parent.after(this, context); }
	
	@Override
	public String getSelectAreaText(BritUnit unit) {
		return BritText.request().selectAreaToRetreat(this.player, unit);
	}
	
}
