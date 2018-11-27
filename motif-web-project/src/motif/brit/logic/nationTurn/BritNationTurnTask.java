package motif.brit.logic.nationTurn;

import java.util.Iterator;

import motif.brit.ang.enums.AngPhase;
import motif.brit.endpoint.BritContext;
import motif.brit.flow.IBritAutoIO;
import motif.brit.flow.IBritIO;
import motif.brit.logic.phases.BritPhaseMovement.ABritPhaseMovementIO;
import motif.brit.logic.phases.BritPhaseOverpopulation.ABritPhaseOverpopulationIO;
import motif.brit.logic.phases.BritPhasePopulationIncrease.ABritPhasePopulationIncreaseIO;
import motif.brit.logic.phases.BritPhaseRaiderWithdrawal.ABritPhaseRaiderWithdrawalIO;
import motif.brit.logic.phases.battlesandretreats.BritPhaseBattlesAndRetreats.ABritPhaseBattlesAndRetreatsIO;
import motif.brit.state.BritGame;
import motif.brit.state.BritNation;
import motif.brit.state.BritPlayer;

public class BritNationTurnTask {

	public static abstract class ABritNationTurnIO implements IBritAutoIO {
		@Override public IBritIO start (BritContext context) { return new BritNationTurnTask ().start (this, context); }
		public abstract Iterator<BritNation> getNationIt ();
		public abstract BritNation getNation ();
		public String getNationId () { return getNation ().getId (); }
		public BritPlayer getPlayer () { return getNation ().getController (); }
		public abstract BritGame getGame ();
	} // ABritNationTurnIO
	
	private class BritPhasePopulationIncreaseIO extends ABritPhasePopulationIncreaseIO {
		public BritPhasePopulationIncreaseIO (ABritNationTurnIO parent) { super (AngPhase.POPULATION_INCREASE, parent); }
		@Override public IBritIO getNext (BritContext context) { return BritNationTurnTask.this.next (this, context); }
	} // BritPhasePopulationIncreaseIO
	
	private class BritPhaseMovementIO extends ABritPhaseMovementIO {
		public BritPhaseMovementIO (ABritNationTurnIO parent) { super (AngPhase.MOVEMENT, parent); }
		@Override public IBritIO getNext (BritContext context) { return BritNationTurnTask.this.next (this, context); }
	} // BritPhasePopulationIncreaseIO
	
	private class BritPhaseBattlesAndRetreatsIO extends ABritPhaseBattlesAndRetreatsIO {
		public BritPhaseBattlesAndRetreatsIO (ABritNationTurnIO parent) { super (AngPhase.BATTLES_AND_RETREATS, parent); }
		@Override public IBritIO getNext (BritContext context) { return BritNationTurnTask.this.next (this, context); }
	} // BritPhasePopulationIncreaseIO
	
	private class BritPhaseRaiderWithdrawalIO extends ABritPhaseRaiderWithdrawalIO {
		public BritPhaseRaiderWithdrawalIO (ABritNationTurnIO parent) { super (AngPhase.RAIDER_WITHDRAWAL, parent); }
		@Override public IBritIO getNext (BritContext context) { return BritNationTurnTask.this.next (this, context); }
	} // BritPhasePopulationIncreaseIO
	
	private class BritPhaseOverpopulationIO extends ABritPhaseOverpopulationIO {
		public BritPhaseOverpopulationIO (ABritNationTurnIO parent) { super (AngPhase.OVERPOPULATION, parent); }
		@Override public IBritIO getNext (BritContext context) { return BritNationTurnTask.this.next (this, getParent(), context); }
	}
	
	public IBritIO start (ABritNationTurnIO IO, BritContext context) {
		IO.getGame ().setNationId (IO.getNationId (), context);
		IO.getGame ().log ().nationTurn (IO.getNation (), context);
		return new BritPhasePopulationIncreaseIO (IO);
	} // getStart
	
	public IBritIO next (BritPhasePopulationIncreaseIO prevIO, BritContext context) { return new BritPhaseMovementIO (prevIO.getParent ()); }
	public IBritIO next (BritPhaseMovementIO prevIO, BritContext context) { return new BritPhaseBattlesAndRetreatsIO (prevIO.getParent ()); }
	public IBritIO next (BritPhaseBattlesAndRetreatsIO prevIO, BritContext context) { return new BritPhaseRaiderWithdrawalIO (prevIO.getParent ()); }
	public IBritIO next (BritPhaseRaiderWithdrawalIO prevIO, BritContext context) { return new BritPhaseOverpopulationIO (prevIO.getParent ()); }
	
	public IBritIO next(BritPhaseOverpopulationIO prevIO, ABritNationTurnIO IO, BritContext context) {
		IO.getNation().clearPaths();
		return null;
	}
	
}
