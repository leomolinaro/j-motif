package motif.brit.logic.play.battlesandretreats;

import java.util.HashMap;
import java.util.List;

import lombok.Getter;
import motif.brit.ang.enums.BritText;
import motif.brit.endpoint.BritContext;
import motif.brit.logic.flow.IBritFlowProcess;
import motif.brit.logic.flow.IBritFlowStep;
import motif.brit.logic.requests.BritSelectUnitAreaSvgRequests;
import motif.brit.state.BritArea;
import motif.brit.state.BritPlayer;
import motif.brit.state.BritUnit;

public class BritAttackerSelectRetreat extends BritSelectUnitAreaSvgRequests<BritUnit, BritArea> {

	public BritAttackerSelectRetreat(
			List<BritUnit> availableUnits,
			String selectUnitText,
	        BritPlayer player,
	        boolean canPass,
	        HashMap<String, List<BritArea>> availableAreasPerUnit,
	        IBritFlowWithAttackerSelectRetreat parent
	) {
		super(availableUnits, selectUnitText, player, canPass, availableAreasPerUnit);
		this.parent = parent;
	}
	
	public interface IBritFlowWithAttackerSelectRetreat extends IBritFlowProcess { public IBritFlowStep after(BritAttackerSelectRetreat attackerSelectRetreat, BritContext context); }
	@Getter private final IBritFlowWithAttackerSelectRetreat parent;
	@Override public IBritFlowStep next(BritContext context) { return this.parent.after(this, context); }
	
	@Override
	public String getSelectAreaText(BritUnit unit) {
		return BritText.request().selectAreaToRetreat(this.player, unit);
	}

}
