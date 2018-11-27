package motif.brit.state;

import motif.brit.config.BritConfig;

public class BritCavalry extends BritArmy {

	private static int cavalryIdSequence = 0;
	
	public BritCavalry(BritNation controller) {
		super(getCavalryId (controller), getCavalryLabel(controller), controller, getCavalryImageSource (controller));
	}
	
	private static String getCavalryId(BritNation controller) {
		return controller.getId () + "_cav" + (++cavalryIdSequence);
	}

	private static String getCavalryLabel(BritNation nation) {
		return nation.getName () + " cavalry";
	}

	private static String getCavalryImageSource(BritNation nation) {
		return BritConfig.CAVALRY_IMAGE_SOURCE.replace ("{nationId}", nation.getId ());
	}

	@Override public boolean isInfantry () { return false; }
	@Override public boolean isCavalry() { return true; }
	
}
