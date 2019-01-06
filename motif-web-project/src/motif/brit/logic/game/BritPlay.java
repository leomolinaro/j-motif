package motif.brit.logic.game;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import motif.brit.endpoint.BritContext;
import motif.brit.flow.IBritIOVisitor;
import motif.brit.logic.BritSetup;
import motif.brit.logic.round.BritRound.ABritRoundIO;
import motif.brit.state.BritGame;

public class BritPlay {

	@RequiredArgsConstructor
	public class BritRoundIO extends ABritRoundIO {
		@Getter private final int roundNumber;
		@Getter private final ABritPlayIO parent;
		@Override public BritGame getGame() { return parent.getGame(); }
		@Override public void accept(IBritIOVisitor visitor) { visitor.visit(this); }
	}
	
	public ABritRoundIO start (ABritPlayIO IO, BritContext context) {
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
