package com.motif.agot.logic.phases;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.state.AgotGame;
import com.motif.shared.util.MotifConsole;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class APhaseStep<S extends IStep> implements IAgotFlowProcess {

	protected final AgotGame game;

	public abstract String getStepTitle();

	@Override
	public final IAgotFlowStep start(AgotContext context) {
		String stepTitle = getStepTitle();
		MotifConsole.println("----------------------------------------------------------------------------------");
		MotifConsole.println(stepTitle);
		MotifConsole.println("----------------------------------------------------------------------------------");
		game.setStep(stepTitle, context);
		game.logManager().step(stepTitle, context);
		return stepStart(context);
	} // start

	protected abstract IAgotFlowStep stepStart(AgotContext context);

	@Override
	public abstract APhaseStep<S> next(AgotContext context);
	
}
