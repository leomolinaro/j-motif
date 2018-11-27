package motif.brit.state;

import motif.brit.config.BritConfig;

public class BritInfantry extends BritArmy {

	private static int infantryIdSequence = 0;
	
	public BritInfantry (BritNation controller) {
		super (getInfantryId (controller), getInfantryLabel (controller), controller, getInfantryImageSource (controller));
	} // BritInfantry
	
	private static String getInfantryId (BritNation controller) {
		return controller.getId () + "_inf" + (++infantryIdSequence);
	} // getInfantryId

	private static String getInfantryLabel (BritNation nation) {
		return nation.getName () + " infantry";
	} // getInfantryImageSource

	private static String getInfantryImageSource (BritNation nation) {
		return BritConfig.INFANTRY_IMAGE_SOURCE.replace ("{nationId}", nation.getId ());
	} // getInfantryImageSource

	@Override public boolean isInfantry () { return true; }
	@Override public boolean isCavalry() { return false; }
	
}
