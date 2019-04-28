package com.motif.agot.logic.phases;

import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.state.AgotGame;
import com.motif.shared.util.MotifConsole;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class APhase<S extends IStep> implements IAgotFlowProcess {

	@Getter private final AngPhase phase;
	protected final AgotGame game;

	public abstract String getPhaseTitle();

	public abstract AStartPhaseStep<S> startPhaseStep();

	@Override
	public AStartPhaseStep<S> start(AgotContext context) {
		String phaseTitle = getPhaseTitle();
		MotifConsole.println("==================================================================================");
		MotifConsole.println(phaseTitle);
		MotifConsole.println("==================================================================================");
		game.setPhase(phase, context);
		game.log().phase(phaseTitle, context);
		return startPhaseStep();
	} // start

} // AAgotPhase
