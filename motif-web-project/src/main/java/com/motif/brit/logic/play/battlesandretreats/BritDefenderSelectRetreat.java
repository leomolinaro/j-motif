package com.motif.brit.logic.play.battlesandretreats;

import java.util.HashMap;
import java.util.List;

import com.motif.brit.ang.enums.BritText;
import com.motif.brit.endpoint.BritContext;
import com.motif.brit.logic.flow.IBritFlowProcess;
import com.motif.brit.logic.flow.IBritFlowStep;
import com.motif.brit.logic.requests.BritSelectUnitAreaSvgRequests;
import com.motif.brit.state.BritLandArea;
import com.motif.brit.state.BritPlayer;
import com.motif.brit.state.BritUnit;

import lombok.Getter;

public class BritDefenderSelectRetreat extends BritSelectUnitAreaSvgRequests<BritUnit, BritLandArea> {

	public BritDefenderSelectRetreat(
			List<BritUnit> availableUnits,
			String selectUnitText,
	        BritPlayer player,
	        boolean canPass,
	        HashMap<String, List<BritLandArea>> availableAreasPerUnit,
	        IBritAfterDefenderSelectRetreat parent
	) {
		super(availableUnits, selectUnitText, player, canPass, availableAreasPerUnit);
		this.parent = parent;
	}
	
	public interface IBritAfterDefenderSelectRetreat extends IBritFlowProcess { public IBritFlowStep after(BritDefenderSelectRetreat attackerSelectRetreat, BritContext context); }
	@Getter private final IBritAfterDefenderSelectRetreat parent;
	@Override public IBritFlowStep next(BritContext context) { return this.parent.after(this, context); }
	
	@Override
	public String getSelectAreaText(BritUnit unit) {
		return BritText.request().selectAreaToRetreat(this.player, unit);
	}
	
}
