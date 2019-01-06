package motif.brit.logic.phase;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import motif.brit.ang.enums.AngPhase;
import motif.brit.endpoint.BritContext;
import motif.brit.flow.IBritAutoIO;
import motif.brit.logic.nationTurn.BritNationTurn.ABritNationTurnIO;
import motif.brit.state.BritGame;
import motif.brit.state.BritNation;
import motif.brit.state.BritPlayer;

public abstract class ABritPhase {
	
	@RequiredArgsConstructor
	public static abstract class ABritPhaseIO implements IBritAutoIO {
		public BritNation getNation() { return parent.getNation(); }
		public BritPlayer getPlayer() { return parent.getPlayer(); }
		@Getter public final AngPhase phase;
		@Getter private final ABritNationTurnIO parent;
		public BritGame getGame() { return parent.getGame(); }
	}
	
	protected void start(ABritPhaseIO IO, BritContext context) {
		IO.getGame().setPhase(IO.phase, context);
		IO.getGame().log().phase(IO.phase, context);
	}

}
