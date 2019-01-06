package motif.brit.logic.phase;

import motif.brit.ang.enums.AngPhase;
import motif.brit.endpoint.BritContext;
import motif.brit.flow.IBritAutoIOVisitor;
import motif.brit.flow.IBritIO;
import motif.brit.logic.nationTurn.BritNationTurn.ABritNationTurnIO;
import motif.brit.logic.phase.ABritPhase.ABritPhaseIO;

public class BritPhaseRaiderWithdrawal {
	
	public static abstract class ABritPhaseRaiderWithdrawalIO extends ABritPhaseIO {
		// @Override public IBritIO start (BritContext context) { return new BritPhaseRaiderWithdrawal ().start (this, context); }
		@Override public void accept(IBritAutoIOVisitor visitor) { visitor.visit(this); }
		public ABritPhaseRaiderWithdrawalIO (AngPhase phase, ABritNationTurnIO parent) { super (phase, parent); }
	}

	public IBritIO start (ABritPhaseRaiderWithdrawalIO aBritPhaseOverpopulationIO, BritContext context) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
