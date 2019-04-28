package com.motif.agot.endpoint.clientstate;

import java.util.ArrayList;

import com.google.gson.annotations.Expose;
import com.motif.agot.ang.enums.AngArea;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowRequest;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;
import com.motif.agot.state.GameLog.GameLogRow;
import com.motif.agot.state.cards.Card;

public class AgotReduxActionList {

	@Expose private ArrayList<AgotReduxAction<?>> actions = new ArrayList<AgotReduxAction<?>> ();
	
	public void addAttachment (Card<?> card, Card<?> attachTo) { actions.add (AgotReduxAction.addAttachment (card, attachTo)); }
	public void addCard (Card<?> card, AgotPlayer toPlayer, AngArea toArea) { addCard (card, toPlayer, toArea, AngArea.END_LIST); }
	public void addCard (Card<?> card, AgotPlayer toPlayer, AngArea toArea, int index) { actions.add (AgotReduxAction.addCard (card, toPlayer, toArea, index)); }
	public void addDuplicate (Card<?> card, Card<?> duplicateTo) { actions.add (AgotReduxAction.addDuplicate (card, duplicateTo)); }
	public void addLog (GameLogRow logRow) { actions.add (AgotReduxAction.addLog (logRow)); }
	public void emptyDrawDeck (AgotPlayer player) { actions.add (AgotReduxAction.emptyDrawDeck (player)); }
	public void initState (AgotGame game, AgotContext context, IAgotFlowRequest request) { actions.add (AgotReduxAction.initState (game, context, request)); }
	public void removeAttachment (Card<?> card, Card<?> fromCard) { actions.add (AgotReduxAction.removeAttachment (card, fromCard)); }
	public void removeCard (Card<?> card, AgotPlayer fromPlayer, AngArea fromArea) { actions.add (AgotReduxAction.removeCard (card, fromPlayer, fromArea)); }
	public void removeDuplicate (Card<?> card, Card<?> fromCard) { actions.add (AgotReduxAction.removeDuplicate (card, fromCard)); }
	public void request (IAgotFlowRequest request) { actions.add (AgotReduxAction.request (request)); }
	public void setCardKneeling (boolean kneeling, Card<?> card) { actions.add (AgotReduxAction.setCardKneeling (kneeling, card)); }
	public void setCardPower (int power, Card<?> card) { actions.add (AgotReduxAction.setCardPower (power, card)); }
	public void setCardRevealed (boolean revealed, Card<?> card) { actions.add (AgotReduxAction.setCardRevealed (revealed, card)); }
	public void setFirstPlayer (AgotPlayer firstPlayer) { actions.add (AgotReduxAction.setFirstPlayer (firstPlayer)); }
	public void setGold (int gold, AgotPlayer player) { actions.add (AgotReduxAction.setGold (gold, player)); }
	public void setPhase (String round, AngPhase phase, String step) { actions.add (AgotReduxAction.setPhase (round, phase, step)); }
	
	public void removeLast () {
		actions.remove (actions.size () - 1);
	} // removeLast
	
} // AgotReduxAction
