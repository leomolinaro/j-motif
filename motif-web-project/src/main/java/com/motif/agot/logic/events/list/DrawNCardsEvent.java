package com.motif.agot.logic.events.list;

import com.motif.agot.ang.AgotText;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.events.AgotEvent;
import com.motif.agot.logic.events.IEventVisitor;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.logic.requests.DrawRequest;
import com.motif.agot.logic.requests.DrawRequest.IHasDrawRequest;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;

public class DrawNCardsEvent extends AgotEvent implements IHasDrawRequest {

	private final int n;
	private final AgotPlayer player;

	public DrawNCardsEvent(int n, AgotPlayer player, AgotGame game) {
		super(game);
		this.n = n;
		this.player = player;
	}

	private int nCards;
	
	@Override
	public IAgotFlowStep start (AgotContext context) {
		this.nCards = Math.min (this.player.drawDeckSize (), this.n);
		return new DrawRequest (this.nCards, AgotText.request ().drawCards (this.nCards, this.player), this.player, this);
	} // start

	@Override
	public IAgotFlowStep after (DrawRequest drawDecision, AgotContext context) {
		var cardsToDraw = n;
		if (drawDecision.getDrawCardIds () != null) {
			this.player.draw (drawDecision.getDrawCardIds (), context);
			cardsToDraw -= drawDecision.getDrawCardIds ().size ();
		} // if
		this.player.draw (cardsToDraw, context);
		this.game.logManager ().drawsNCards (this.player, this.nCards, context);
		return null;
	} // after
	
	@Override public boolean accept (IEventVisitor visitor) { return visitor.visit (this); }

} // DrawNCardsEvent
