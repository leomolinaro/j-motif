package motif.brit.logic.game;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import motif.brit.endpoint.BritContext;
import motif.brit.flow.IBritAutoIO;
import motif.brit.flow.IBritIO;
import motif.brit.logic.BritSetup;
import motif.brit.logic.round.BritRoundTask.ABritRoundIO;
import motif.brit.state.BritGame;

public class BritGameTask {

	public static abstract class ABritGameIO implements IBritAutoIO {
		@Override public IBritIO start (BritContext context) { return new BritGameTask ().start (this, context); }
		public abstract BritGame getGame ();
	} // ABritGameIO
	
	@RequiredArgsConstructor
	private class BritRoundIO extends ABritRoundIO {
		@Override public IBritIO getNext (BritContext context) { return BritGameTask.this.next (this, context); }
		@Getter private final int roundNumber;
		@Getter private final ABritGameIO parent;
		@Override public BritGame getGame () { return parent.getGame (); }
	} // BritRoundIO
	
	public ABritRoundIO start (ABritGameIO IO, BritContext context) {
		BritSetup setup = new BritSetup ();
		IO.getGame ().setRound ("Setup", context);
		setup.execute (IO.getGame (), context);
		return new BritRoundIO (1, IO);
	} // start
	
	public ABritRoundIO next (BritRoundIO prevIO, BritContext context) {
		int roundNumber = prevIO.getRoundNumber ();
		if (roundNumber < 16) {
			return new BritRoundIO (roundNumber + 1, prevIO.getParent ());
		} else {
			return null;
		} // if - else
	} // next
	
} // GameFlow
