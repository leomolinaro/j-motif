package motif.brit.logic.play;

import java.util.Iterator;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import motif.brit.endpoint.BritContext;
import motif.brit.logic.flow.IBritFlowProcess;
import motif.brit.logic.flow.IBritFlowStep;
import motif.brit.logic.play.BritNationTurn.IBritAfterNationTurn;
import motif.brit.state.BritGame;
import motif.brit.state.BritNation;

@RequiredArgsConstructor
public class BritRound implements IBritAfterNationTurn {

	private final BritGame game;
	
	public interface IBritAfterRound extends IBritFlowProcess { public IBritFlowStep after(BritRound round, BritContext context); }
	@Getter private final IBritAfterRound parent;
	@Override public IBritFlowStep next(BritContext context) { return this.parent.after(this, context); }
	
	private Iterator<BritNation> nationIt;
	
	public BritNationTurn start(BritContext context) {
		String roundTitle = "Round " + game.getRoundNumber();
		game.setRound(roundTitle, context);
		game.log().round(roundTitle, context);
		this.nationIt = game.getNationIt();
		BritNation firstNation = getNextNation();
		return firstNation == null ? null : new BritNationTurn(firstNation, game, this);
	}

	@Override
	public BritNationTurn after(BritNationTurn nationTurn, BritContext context) {
		BritNation nextNation = getNextNation();
		return nextNation == null ? null : new BritNationTurn(nextNation, game, this);
	}
	
	private BritNation getNextNation() {
		BritNation nation = null;
		while (nationIt.hasNext() && nation == null) {
			BritNation currNation = nationIt.next();
			if (currNation.isPopMarkerActive()) { // FIXME
				nation = currNation;
			}
		}
		return nation;
	}

}
