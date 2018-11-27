package motif.brit.logic.round;

import java.util.Iterator;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import motif.brit.endpoint.BritContext;
import motif.brit.flow.IBritAutoIO;
import motif.brit.flow.IBritIO;
import motif.brit.logic.nationTurn.BritNationTurnTask.ABritNationTurnIO;
import motif.brit.state.BritGame;
import motif.brit.state.BritNation;

public class BritRoundTask {

	public static abstract class ABritRoundIO implements IBritAutoIO {
		@Override public IBritIO start (BritContext context) { return new BritRoundTask ().start (this, context); }
		public abstract int getRoundNumber ();
		private Iterator<BritNation> nationIt;
		public abstract BritGame getGame ();
	} // ABritRoundIO
	
	@RequiredArgsConstructor
	private class BritNationTurnIO extends ABritNationTurnIO {
		@Override public IBritIO getNext (BritContext context) { return BritRoundTask.this.next (this, context); }
		@Getter private final BritNation nation;
		@Override public Iterator<BritNation> getNationIt () { return parent.nationIt; }
		@Getter private final ABritRoundIO parent;
		@Override public BritGame getGame () { return parent.getGame (); }
	} // BritNationTurnIO
	
	public ABritNationTurnIO start (ABritRoundIO IO, BritContext context) {
		String roundTitle = "Round " + IO.getRoundNumber ();
		IO.getGame ().setRound (roundTitle, context);
		IO.getGame ().log ().round (roundTitle, context);
		IO.nationIt = IO.getGame ().getNationIt ();
		BritNation firstNation = getNextNation (IO.nationIt);
		return firstNation == null ? null : new BritNationTurnIO (firstNation, IO);
	} // start

	public ABritNationTurnIO next (BritNationTurnIO prevIO, BritContext context) {
		BritNation nextNation = getNextNation (prevIO.getNationIt ());
		return nextNation == null ? null : new BritNationTurnIO (nextNation, prevIO.getParent ());
	} // getNextTask
	
	private BritNation getNextNation (Iterator<BritNation> nationIt) {
		BritNation nation = null;
		while (nationIt.hasNext () && nation == null) {
			BritNation currNation = nationIt.next ();
			if (currNation.isPopMarkerActive ()) { // FIXME
				nation = currNation;
			} // if
		} // while
		return nation;
	} // getNextNation
	
} // BritRound
