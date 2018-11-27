package motif.brit.state;

import com.google.gson.annotations.Expose;

import lombok.Getter;
import motif.brit.endpoint.BritContext;

public class BritLandArea extends BritArea {

	public BritLandArea(String id, String name, boolean difficultTerrain, String svgD) {
		super(id, name, difficultTerrain ? BritAreaType.DIFFICUL_LAND : BritAreaType.NORMAL_LAND, svgD);
	}

	@Getter private BritNation nation;
	@Expose private String nationId;
	public void setNation(BritNation controller, BritContext context) {
		this.nation = controller;
		this.nationId = controller == null ? null : controller.getId();
		context.actions().updateArea(this);
	}
	public boolean isControlledBy(BritNation nation) { return this.nation == nation; }
	public boolean isControlled() { return this.nation != null; }
	
}
