package com.motif.brit.state;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.google.gson.annotations.Expose;
import com.motif.brit.endpoint.BritContext;
import com.motif.brit.logic.flow.IBritModel;

import lombok.Getter;
import lombok.Setter;

public abstract class BritUnit implements IBritModel {
	
	public BritUnit (String id, String label, BritNation controller, String imageSource) {
		this.id = id;
		this.nation = controller;
		this.imageSource = imageSource;
		this.label = label;
	} // BritUnit
	
	@Expose @Getter String id;
	@Expose String imageSource;
	@Expose private double svgX;
	@Expose private double svgY;
	@Expose @Getter private String label;
	
	@Expose @Getter private int movementPoints;
	public void setMovementPoints (int movementPoints, BritContext context) {
		this.movementPoints = movementPoints;
		context.actions ().updateUnit (this);
	}
	
	@Expose @Getter private boolean moving;
	public void setMoving(boolean moving, BritContext context) {
		this.moving = moving;
		context.actions ().updateUnit (this);
	}
	
	@Getter @Setter private BritArea area;
	public boolean isInPlay () { return area != null; }
	public boolean isInArea(BritArea area) { return this.area == area; }
	
	@Getter private BritNation nation;
	public boolean isControlledBy (BritNation nation) { return this.nation == nation; }
	public boolean isRoman () { return this.nation.isRoman (); }
	
	private List<BritArea> path;
	public Stream<BritArea> path() { return path == null ? Stream.empty() : path.stream(); }
	public void addPath(BritArea area) {
		if (path == null) { path = new ArrayList<BritArea>(); }
		path.add(area);
	}
	public void clearPath() { this.path = null; }
	public BritArea getLastPathStep() { return path.get(path.size() - 1); }
	public BritArea getFirstPathStep() { return path.get(0); }
	
	public abstract boolean isInfantry();
	public abstract boolean isArmy();
	public abstract boolean isBuilding();
	public abstract boolean isCavalry();
	public abstract boolean isLeader();
	
	public void setSvg (double svgX, double svgY, BritContext context) {
		this.svgX = svgX;
		this.svgY = svgY;
		context.actions ().updateUnit (this);
	}
	
}
