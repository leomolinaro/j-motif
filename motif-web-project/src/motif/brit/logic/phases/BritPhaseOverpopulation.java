package motif.brit.logic.phases;

import motif.brit.ang.enums.AngPhase;
import motif.brit.endpoint.BritContext;
import motif.brit.flow.IBritIO;
import motif.brit.logic.nationTurn.BritNationTurnTask.ABritNationTurnIO;
import motif.brit.logic.phases.ABritPhase.ABritPhaseIO;

public class BritPhaseOverpopulation {
	
	public static abstract class ABritPhaseOverpopulationIO extends ABritPhaseIO {
		@Override public IBritIO start (BritContext context) { return new BritPhaseOverpopulation ().start (this, context); }
		public ABritPhaseOverpopulationIO (AngPhase phase, ABritNationTurnIO parent) { super (phase, parent); }
	} // ABritPhaseOverpopulationIO

	public IBritIO start (ABritPhaseOverpopulationIO aBritPhaseOverpopulationIO, BritContext context) {
		// TODO Auto-generated method stub
		return null;
	} // start
	
} // BritPhaseOverpopulation
