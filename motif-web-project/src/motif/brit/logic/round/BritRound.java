package motif.brit.logic.round;

import java.util.Iterator;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import motif.brit.endpoint.BritContext;
import motif.brit.flow.IBritAutoIO;
import motif.brit.flow.IBritAutoIOVisitor;
import motif.brit.flow.IBritIOVisitor;
import motif.brit.logic.nationTurn.BritNationTurn.ABritNationTurnIO;
import motif.brit.state.BritGame;
import motif.brit.state.BritNation;

public class BritRound {

	public static abstract class ABritRoundIO implements IBritAutoIO {
		// @Override public IBritIO start(BritContext context) { return new BritRound().start(this, context); }
		@Override public void accept(IBritAutoIOVisitor visitor) { visitor.visit(this); }
		public abstract int getRoundNumber();
		private Iterator<BritNation> nationIt;
		public abstract BritGame getGame();
	}
	
	@RequiredArgsConstructor
	public class BritNationTurnIO extends ABritNationTurnIO {
		// @Override public IBritIO getNext (BritContext context) { return BritRound.this.afterBritNationTurn (this, context); }
		@Override public void accept(IBritIOVisitor visitor) { visitor.visit(this); }
		@Getter private final BritNation nation;
		@Override public Iterator<BritNation> getNationIt () { return parent.nationIt; }
		@Getter private final ABritRoundIO parent;
		@Override public BritGame getGame () { return parent.getGame (); }
	}
	
	public ABritNationTurnIO start (ABritRoundIO IO, BritContext context) {
		String roundTitle = "Round " + IO.getRoundNumber ();
		IO.getGame ().setRound (roundTitle, context);
		IO.getGame ().log ().round (roundTitle, context);
		IO.nationIt = IO.getGame ().getNationIt ();
		BritNation firstNation = getNextNation (IO.nationIt);
		return firstNation == null ? null : new BritNationTurnIO (firstNation, IO);
	} // start

	public ABritNationTurnIO afterBritNationTurn (BritNationTurnIO prevIO, BritContext context) {
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
