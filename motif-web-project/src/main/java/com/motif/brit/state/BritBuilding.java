package com.motif.brit.state;

public abstract class BritBuilding extends BritUnit {

	public BritBuilding (String id, String label, BritNation controller, String imageSource) {
		super (id, label, controller, imageSource);
	} // BritBuilding

	@Override public boolean isBuilding () { return true; }

} // BritBuilding
