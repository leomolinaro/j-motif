package com.motif.agot.logic.round.phases.taxation.reserve;

import com.motif.agot.ang.AgotText;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.flow.request.AgotRequest;
import com.motif.agot.flow.request.AgotResponse;
import com.motif.agot.flow.request.AgotRequest.AgotChoice;
import com.motif.agot.flow.request.AgotRequest.AgotRequestCod;
import com.motif.agot.flow.task.AgotHumanTask;
import com.motif.agot.flow.task.IAgotTask;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;
import com.motif.agot.state.cards.DrawCard;

public class ReserveDiscardRequest extends AgotHumanTask {

	private int numToDiscard;
	private AgotPlayer player;
	private AgotGame game;
	private AgotRequest<DrawCard<?>> pendingRequest = null;
	
	public ReserveDiscardRequest (int numToDiscard, AgotPlayer player, AgotGame game) {
		this.numToDiscard = numToDiscard;
		this.player = player;
		this.game = game;
	} // ReserveDiscardRequest

	@Override
	public IAgotTask receiveResponse (AgotResponse response, AgotContext context) {
		AgotChoice<DrawCard<?>> choice = pendingRequest.getChoice (response);
		DrawCard<?> toDiscard = choice.getModel ();
		player.discardFromHand (toDiscard, context);
		game.log ().discards (player, toDiscard, context);
		numToDiscard--;
		if (numToDiscard > 0) {
			return new ReserveDiscardRequest (numToDiscard, player, game);
		} else {
			return null;			
		} // if - else
	} // receiveResponse

	@Override
	public AgotRequest<?> getRequest (AgotContext context) {
		pendingRequest = AgotRequest.createRequest (AgotRequestCod.SELECT_CARD_TO_DISCARD, player, player.hand (), AgotText.request ().selectCardToDiscard (player));
		return pendingRequest;
	} // getRequest

} // ReserveDiscardRequest
