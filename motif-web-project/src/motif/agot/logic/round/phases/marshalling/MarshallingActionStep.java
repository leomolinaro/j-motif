package motif.agot.logic.round.phases.marshalling;

import java.util.stream.Stream;

import motif.agot.ang.AgotText;
import motif.agot.ang.enums.AngPhase;
import motif.agot.ang.enums.AngType;
import motif.agot.endpoint.AgotContext;
import motif.agot.flow.task.IAgotTask;
import motif.agot.logic.act.Act;
import motif.agot.logic.act.ActionAct;
import motif.agot.logic.act.MarshallingAct;
import motif.agot.logic.round.phases.ActionWindowStep;
import motif.agot.state.AgotGame;
import motif.agot.state.AgotPlayer;
import motif.agot.state.cards.MarshallCard;
import motif.shared.util.StreamUtil;

public class MarshallingActionStep extends ActionWindowStep<IMarshallingPhaseStep, Act> {

	private AgotPlayer activePlayer;
	
	public MarshallingActionStep (AgotPlayer activePlayer, AgotGame game) {
		super (AngPhase.MARSHALLING, game);
		this.activePlayer = activePlayer;
	} // MarshallingActionStep

	@Override
	public String getStepTitle () { return AgotText.title ().marshallingActionStep (activePlayer); }
	
	@Override
	protected MarshallingActionPlayerStep getPlayerStep (AgotGame game, AgotPlayer player) {
		return new MarshallingActionPlayerStep (game, player);
	} // getPlayerStep

	@Override
	public ActivateNextMarshallingStep getNextTask (AgotContext context) {
		return new ActivateNextMarshallingStep (activePlayer, game);
	} // getNextTask
	
	private class MarshallingActionPlayerStep extends ActionWindowPlayerStep {

		public MarshallingActionPlayerStep (AgotGame game, AgotPlayer player) {
			super (game, player);
		} // MarshallingActionPlayerStep

		@Override
		public IAgotTask getStart (AgotContext context) {
			Stream<Act> availableActs = player.interactingCards ()
			.filter (card -> card.hasAction ())
			.map (card -> (Act) new ActionAct (phase, card.getAction (), card, player, game))
			.filter (actionStep -> actionStep.canBeInitiated () && actionStep.canBePaid ());
			if (player == activePlayer) {
				availableActs = StreamUtil.concat (availableActs, activePlayer.hand ()
				.filter (card -> !card.isType (AngType.EVENT))
				.map (card -> new MarshallingAct ((MarshallCard<?>) card, player, game))
				.filter (act -> act.canBeInitiated () && act.canBePaid ()));
			} else {
				availableActs = Stream.empty ();
			} // if - else
			return new PlayerActionRequest (availableActs);			
		} // getStart
		
	} // MarshallingActionPlayerStep
	
} // MarshallingActionStep
