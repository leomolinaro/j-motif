package motif.brit.logic.requests;

import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import motif.brit.endpoint.BritContext;
import motif.brit.flow.IBritAutoIO;
import motif.brit.flow.IBritIO;
import motif.brit.logic.requests.BritSelectAreaSvgRequest.ABritSelectAreaSvgRequestIO;
import motif.brit.logic.requests.BritSelectUnitRequest.ABritSelectUnitRequestIO;
import motif.brit.state.BritArea;
import motif.brit.state.BritPlayer;
import motif.brit.state.BritUnit;

public class BritSelectUnitAreaSvgRequests<U extends BritUnit, A extends BritArea> {
	
	public static abstract class ABritSelectUnitAreaSvgRequestsIO<U extends BritUnit, A extends BritArea> implements IBritAutoIO {
		@Override public IBritIO start(BritContext context) { return new BritSelectUnitAreaSvgRequests<U, A>().start(this, context); }
		public abstract List<U> getAvailableUnits();
		public abstract String getSelectUnitText();
		public abstract BritPlayer getPlayer();
		public abstract boolean canPass();
		public abstract void setUnit(U unit);
		public abstract String getSelectAreaText();
		public abstract void setArea(A area);
		public abstract List<A> getAvailableAreas();
		public abstract void setSvgX(double svgX);
		public abstract void setSvgY(double svgY);
	}
	
	@RequiredArgsConstructor
	private class BritSelectUnitRequestIO extends ABritSelectUnitRequestIO<U> {
		@Override public IBritIO getNext(BritContext context) { return BritSelectUnitAreaSvgRequests.this.afterUnitIsSelected(unit, parent, context); }
		@Getter private final ABritSelectUnitAreaSvgRequestsIO<U, A> parent;
		@Override public List<U> getAvailableUnits() { return parent.getAvailableUnits(); }
		@Override public String getText() { return parent.getSelectUnitText(); }
		@Override public BritPlayer getPlayer() { return parent.getPlayer(); }
		@Override public boolean canPass() { return parent.canPass(); }
		@Setter private U unit;
	}
	
	@RequiredArgsConstructor
	private class BritSelectAreaSvgRequestIO extends ABritSelectAreaSvgRequestIO<A> {
		@Override public IBritIO getNext(BritContext context) { return BritSelectUnitAreaSvgRequests.this.afterAreaIsSelected(area, svgX, svgY, parent, context); }
		@Getter private final ABritSelectUnitAreaSvgRequestsIO<U, A> parent;
		@Override public List<A> getAvailableAreas() { return parent.getAvailableAreas(); }
		@Override public String getText() { return parent.getSelectAreaText(); }
		@Override public BritPlayer getPlayer() { return parent.getPlayer(); }
		@Override public boolean canPass() { return parent.canPass(); }
		@Setter private A area;
		@Setter private double svgX;
		@Setter private double svgY;
	}

	public IBritIO start(ABritSelectUnitAreaSvgRequestsIO<U, A> IO, BritContext context) {
		return new BritSelectUnitRequestIO(IO);
	}

	public IBritIO afterAreaIsSelected(A area, double svgX, double svgY, ABritSelectUnitAreaSvgRequestsIO<U, A> IO, BritContext context) {
		IO.setArea(area);
		IO.setSvgX(svgX);
		IO.setSvgY(svgY);
		return null;
	}

	public IBritIO afterUnitIsSelected(U unit, ABritSelectUnitAreaSvgRequestsIO<U, A> IO, BritContext context) {
		if (unit == null) {
			return null;
		} else {
			IO.setUnit(unit);
			return new BritSelectAreaSvgRequestIO(IO);
		}
	}

}
