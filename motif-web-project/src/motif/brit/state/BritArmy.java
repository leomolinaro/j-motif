package motif.brit.state;

public abstract class BritArmy extends BritUnit {

	public BritArmy (String id, String label, BritNation controller, String imageSource) {
		super (id, label, controller, imageSource);
	}

	@Override public boolean isArmy () { return true; }
	@Override public boolean isBuilding() { return false; }
	@Override public boolean isLeader() { return false; }
	
}
