package motif.brit.state;

public class BritLeader extends BritUnit {

	public BritLeader(String id, String label, BritNation controller, String imageSource) {
		super (id, label, controller, imageSource);
	}

	@Override public boolean isInfantry() { return false; }
	@Override public boolean isCavalry() { return false; }
	@Override public boolean isArmy() { return false; }
	@Override public boolean isBuilding() { return false; }
	@Override public boolean isLeader() { return true; }

}
