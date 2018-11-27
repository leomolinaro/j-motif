package motif.brit.logic.phases;

import motif.brit.ang.enums.AngPhase;
import motif.brit.endpoint.BritContext;
import motif.brit.flow.IBritIO;
import motif.brit.logic.nationTurn.BritNationTurnTask.ABritNationTurnIO;
import motif.brit.logic.phases.ABritPhase.ABritPhaseIO;

public class BritPhaseRaiderWithdrawal {
	
	public static abstract class ABritPhaseRaiderWithdrawalIO extends ABritPhaseIO {
		@Override public IBritIO start (BritContext context) { return new BritPhaseRaiderWithdrawal ().start (this, context); }
		public ABritPhaseRaiderWithdrawalIO (AngPhase phase, ABritNationTurnIO parent) { super (phase, parent); }
	} // ABritPhaseRaiderWithdrawalIO

	public IBritIO start (ABritPhaseRaiderWithdrawalIO aBritPhaseOverpopulationIO, BritContext context) {
		// TODO Auto-generated method stub
		return null;
	} // start
	
} // BritPhaseRaiderWithdrawal
