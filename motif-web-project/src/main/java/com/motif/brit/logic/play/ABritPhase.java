package com.motif.brit.logic.play;

import com.motif.brit.ang.enums.AngPhase;
import com.motif.brit.endpoint.BritContext;
import com.motif.brit.logic.flow.IBritFlowProcess;
import com.motif.brit.state.BritGame;
import com.motif.brit.state.BritNation;
import com.motif.brit.state.BritPlayer;

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
