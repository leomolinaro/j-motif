package com.motif.agot.logic.round.phases.marshalling;

import java.util.stream.Stream;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.ang.enums.AngType;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.flow.task.IAgotTask;
import com.motif.agot.logic.act.Act;
import com.motif.agot.logic.act.ActionAct;
import com.motif.agot.logic.act.MarshallingAct;
import com.motif.agot.logic.round.phases.ActionWindowStep;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;
import com.motif.agot.state.cards.MarshallCard;
import com.motif.shared.util.StreamUtil;

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
