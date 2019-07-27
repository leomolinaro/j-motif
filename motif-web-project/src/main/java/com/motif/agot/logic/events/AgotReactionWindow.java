package com.motif.agot.logic.events;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import com.motif.agot.ang.text.AngReaction;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.act.ReactionAct;
import com.motif.agot.logic.act.ReactionAct.IHasReactionAct;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.logic.requests.SelectReactionToPerformRequest;
import com.motif.agot.logic.requests.SelectReactionToPerformRequest.IHasSelectReactionToPerformRequest;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AgotReactionWindow implements IHasSelectReactionToPerformRequest, IHasReactionAct {

	private final AgotEvent event;
	private final AgotGame game;
	private int nPasses = 0;
	private AgotPlayer player;
	
	private HashMap<Long, HashSet<AngReaction>> reactionsDoneByCard = new HashMap<Long, HashSet<AngReaction>>();
	
	public interface IAgotHasReactionWindow extends IAgotFlowProcess { public IAgotFlowStep after(AgotReactionWindow reactionWindow, AgotContext context); }
	@Getter private final IAgotHasReactionWindow parent;
	@Override public IAgotFlowStep next(AgotContext context) { return this.parent.after(this, context); }
	
	@Override
	public IAgotFlowStep start(AgotContext context) {
		this.player = this.game.firstPlayer();
		var availableReactions = getAvailableReactions();
		return new SelectReactionToPerformRequest(availableReactions, this.player, this);
	}

	private List<ReactionAct> getAvailableReactions() {
		return this.player.interactingCards()
		.filter(card -> card.hasReaction())
        .filter(card -> {
        	var reactionsDone = this.reactionsDoneByCard.get (card.id());
			var reaction = card.getReaction ();
			return reactionsDone == null || !reactionsDone.contains (reaction);
        })
        .map(card -> new ReactionAct(this.event, card.getReaction(), card, this.player, this.game, this))
        .filter(reactionAct -> reactionAct.canBeInitiated() && reactionAct.canBePaid())
        .collect(Collectors.toList());
	}
	
	@Override
	public IAgotFlowStep after(SelectReactionToPerformRequest decision, AgotContext context) {
		var hasPassed = decision.isHasPassed();
		if (hasPassed) {
			this.nPasses++;
			if (this.nPasses == this.game.getNumPlayers()) {
				return null;
			} else {
				this.player = this.player.getNextPlayer();
				var availableReactions = getAvailableReactions();
				return new SelectReactionToPerformRequest(availableReactions, this.player, this);
			}
		} else {
			var reactionAct = decision.getChoosenModel();
			var reactingCard = reactionAct.getTrigCard();
			var interrupt = reactionAct.getTrigAbility();
			var reactionsDone = this.reactionsDoneByCard.get(reactingCard.id());
			if (reactionsDone == null) {
				reactionsDone = new HashSet<AngReaction>();
				this.reactionsDoneByCard.put(reactingCard.id(), reactionsDone);
			}
			reactionsDone.add(interrupt);
			this.nPasses = 0;
			return reactionAct;
		}
	}
	
	@Override
	public IAgotFlowStep after(ReactionAct reactionAct, AgotContext context) {
		this.player = this.player.getNextPlayer();
		var availableReactions = getAvailableReactions();
		return new SelectReactionToPerformRequest(availableReactions, this.player, this);
	}

}
