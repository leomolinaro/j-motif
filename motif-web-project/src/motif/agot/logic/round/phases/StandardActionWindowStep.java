package motif.agot.logic.round.phases;

import java.util.stream.Stream;

import motif.agot.ang.enums.AngPhase;
import motif.agot.endpoint.AgotContext;
import motif.agot.flow.task.IAgotTask;
import motif.agot.logic.act.ActionAct;
import motif.agot.state.AgotGame;
import motif.agot.state.AgotPlayer;

public abstract class StandardActionWindowStep<S extends IStep> extends ActionWindowStep<S, ActionAct> {

	public StandardActionWindowStep (AngPhase phase, AgotGame game) {
		super (phase, game);
	} // StandardActionWindowStep

	@Override protected final ActionWindowPlayerStep getPlayerStep (AgotGame game, AgotPlayer player) {
		return new StandardActionWindowPlayerStep (game, player);
	} // getPlayerStep
	
	public final class StandardActionWindowPlayerStep extends ActionWindowPlayerStep {

		public StandardActionWindowPlayerStep (AgotGame game, AgotPlayer player) {
			super (game, player);
		} // StandardActionWindowPlayerStep
		
		@Override
		public final IAgotTask getStart (AgotContext context) {
			Stream<ActionAct> availableActions = player.interactingCards ()
			.filter (card -> card.hasAction ())
			.map (card -> new ActionAct (phase, card.getAction (), card, player, game))
			.filter (actionStep -> actionStep.canBeInitiated () && actionStep.canBePaid ());
			return new PlayerActionRequest (availableActions);
		} // getStart
		
	} // StandardActionWindowPlayerStep

} // ActionWindowStep
