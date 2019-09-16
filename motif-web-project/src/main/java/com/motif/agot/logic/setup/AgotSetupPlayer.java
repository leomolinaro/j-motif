package com.motif.agot.logic.setup;

import java.util.stream.Collectors;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngType;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.act.SetupAct;
import com.motif.agot.logic.act.SetupAct.IHasSetupAct;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.logic.requests.DrawRequest;
import com.motif.agot.logic.requests.DrawRequest.IHasDrawRequest;
import com.motif.agot.logic.requests.SelectCardToSetupRequest;
import com.motif.agot.logic.requests.SelectCardToSetupRequest.IHasSelectCardToSetupRequest;
import com.motif.agot.logic.requests.YesNoRequest;
import com.motif.agot.logic.requests.YesNoRequest.IHasYesNoRequest;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;
import com.motif.agot.state.cards.MarshallCard;

import lombok.Getter;

public class AgotSetupPlayer implements IAgotFlowProcess, IHasYesNoRequest, IHasDrawRequest, IHasSetupAct, IHasSelectCardToSetupRequest {

	private final AgotPlayer player;
	private final AgotGame game;
	
	public interface IHasAgotSetupPlayer extends IAgotFlowStep { public IAgotFlowStep after (AgotSetupPlayer setupPlayer, AgotContext context); }
	@Getter private final IHasAgotSetupPlayer parent;
	@Override public IAgotFlowStep next (AgotContext context) { return this.parent.after (this, context); }
	
	public AgotSetupPlayer (AgotPlayer player, AgotGame game, IHasAgotSetupPlayer parent) {
		this.player = player;
		this.game = game;
		this.parent = parent;
	} // AgotSetupPlayer
	
	@Override
	public IAgotFlowStep start (AgotContext context) {
		this.player.shuffleDeck ();
		this.player.gainGold (8, context);
		return new DrawRequest (7, AgotText.request ().drawCards (7, this.player), this.player, this);
	} // start

	@Override
	public IAgotFlowStep after (DrawRequest drawDecision, AgotContext context) {
		var cardsToDraw = 7;
		if (drawDecision.getDrawCardIds () != null) {
			this.player.draw (drawDecision.getDrawCardIds (), context);
			cardsToDraw -= drawDecision.getDrawCardIds ().size ();
		} // if
		this.player.draw (cardsToDraw, context);
		if (mulliganDone) {
			return chooseSetupCard ();
		} else {
			return new YesNoRequest (AgotText.request ().askForMulligan (this.player), this.player, this);			
		} // if - else
	} // after
	
	private boolean mulliganDone = false;
	
	@Override
	public IAgotFlowStep after (YesNoRequest yesNoDecision, AgotContext context) {
		if (yesNoDecision.getChoosenAnswer ()) {
			this.mulliganDone = true;
			this.game.logManager ().choosesToMulligan (this.player, context);
			this.player.hand ()
				.collect (Collectors.toList ())
				.forEach (c -> this.player.returnToDeckFromHand (c, context));
			this.player.shuffleDeck ();
			return new DrawRequest (7, AgotText.request ().drawCards (7, this.player), this.player, this);
		} else {
			return chooseSetupCard ();
		} // if - else
	} // after
	
	private IAgotFlowStep chooseSetupCard () {
		var availableSetups = this.player.hand ().filter (card -> !card.isType (AngType.EVENT))
        .map (card -> new SetupAct ((MarshallCard<?>) card, this.player, this.game, this))
        .filter (act -> act.canBeSetup ())
        .collect (Collectors.toList ());
		return new SelectCardToSetupRequest (availableSetups, this.player, this);
	} // chooseSetupCard

	@Override
	public IAgotFlowStep after (SelectCardToSetupRequest decision, AgotContext context) {
		if (decision.isHasPassed ()) {
			this.player.resetGold (context);
			return null;
		} else {
			var setupAct = decision.getChoosenModel ();
			return setupAct;			
		} // if - else
	} // after

	@Override
	public IAgotFlowStep after (SetupAct setupAct, AgotContext context) {
		return chooseSetupCard ();
	} // chooseSetupCard
	
} // AgotSetupPlayer
