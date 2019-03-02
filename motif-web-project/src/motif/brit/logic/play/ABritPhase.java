package motif.brit.logic.play;

import motif.brit.ang.enums.AngPhase;
import motif.brit.endpoint.BritContext;
import motif.brit.logic.flow.IBritFlowProcess;
import motif.brit.state.BritGame;
import motif.brit.state.BritNation;
import motif.brit.state.BritPlayer;

public abstract class ABritPhase implements IBritFlowProcess {
	
	protected final AngPhase phase;
	protected final BritNation nation;
	protected final BritPlayer player;
	protected final BritGame game;
	
	public ABritPhase(AngPhase phase, BritNation nation, BritGame game) {
		super();
		this.phase = phase;
		this.nation = nation;
		this.player = nation.getController();
		this.game = game;
	}

	protected void initPhase(BritContext context) {
		game.setPhase(phase, context);
		game.log().phase(phase, context);
	}

}
