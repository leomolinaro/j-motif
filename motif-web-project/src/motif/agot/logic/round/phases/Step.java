package motif.agot.logic.round.phases;

import motif.agot.endpoint.AgotContext;
import motif.agot.flow.task.AgotComplexTask;
import motif.agot.flow.task.IAgotTask;
import motif.agot.state.AgotGame;
import motif.shared.util.MotifConsole;

public abstract class Step<S extends IStep> extends AgotComplexTask {

	protected AgotGame game;

	public Step (AgotGame game) {
		super ();
		this.game = game;
	} // Step

	public abstract String getStepTitle ();
	
	@Override
	public final IAgotTask getStart (AgotContext context) {
		String stepTitle = getStepTitle ();
		MotifConsole.println ("----------------------------------------------------------------------------------");
		MotifConsole.println (stepTitle);
		MotifConsole.println ("----------------------------------------------------------------------------------");
		game.setStep (stepTitle, context);
		game.log ().step (stepTitle, context);
		return getStartTask (context);
	} // getStart

	public abstract IAgotTask getStartTask (AgotContext context);
	
	@Override public abstract Step<S> getNextTask (AgotContext context);
	
} // Step
