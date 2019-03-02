package motif.brit.logic.requests;

import java.util.HashMap;
import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import motif.brit.endpoint.BritContext;
import motif.brit.logic.flow.IBritFlowProcess;
import motif.brit.logic.flow.IBritFlowStep;
import motif.brit.logic.requests.BritSelectAreaSvgRequest.IBritFlowWithSelectAreaSvg;
import motif.brit.logic.requests.BritSelectUnitRequest.IBritFlowWithSelectUnit;
import motif.brit.state.BritArea;
import motif.brit.state.BritPlayer;
import motif.brit.state.BritUnit;

@RequiredArgsConstructor
public abstract class BritSelectUnitAreaSvgRequests<U extends BritUnit, A extends BritArea> implements
		IBritFlowProcess,
		IBritFlowWithSelectAreaSvg<A>,
		IBritFlowWithSelectUnit<U> {
	
	public abstract String getSelectAreaText(U unit);
	
	private final List<U> availableUnits;
	private final String selectUnitText;
	protected final BritPlayer player;
	private final boolean canPass;
	private final HashMap<String, List<A>> availableAreasPerUnit;
	
	@Getter private U unit;
	@Getter private A area;
	@Getter private double svgX;
	@Getter private double svgY;

	@Override
	public IBritFlowStep start(BritContext context) {
		return new BritSelectUnitRequest<U>(
				this.availableUnits, 
				this.selectUnitText,
				this.player, 
				this.canPass,
				this
		);
	}
	
	@Override
	public IBritFlowStep after(BritSelectUnitRequest<U> selectUnit, BritContext context) {
		if (selectUnit.getUnit() == null) {
			return null;
		} else {
			this.unit = selectUnit.getUnit();
			return new BritSelectAreaSvgRequest<A>(
					this.availableAreasPerUnit.get(unit.getId()),
					this.getSelectAreaText(this.unit),
					this.player,
					this.canPass,
					this);
		}
	}

	@Override
	public IBritFlowStep after(BritSelectAreaSvgRequest<A> selectAreaSvg, BritContext context) {
		this.area = selectAreaSvg.getArea();
		this.svgX = selectAreaSvg.getSvgX();
		this.svgY = selectAreaSvg.getSvgY();
		return null;
	}
	
}
