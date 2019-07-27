package com.motif.agot.logic.act;

import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.ang.text.AngAction;
import com.motif.agot.ang.text.AngAction.AngActionType;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.logic.other.AbilityContext;
import com.motif.agot.logic.requests.AgotChoice;
import com.motif.agot.logic.requests.AgotChoice.AgotChoiceCardAction;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;
import com.motif.agot.state.cards.TextCard;
import com.motif.shared.util.MotifConsole;

import lombok.Getter;

public final class ActionAct extends TrigAbilityAct<AngAction> implements IPhaseAct {

	private final AngPhase phase;
	private final AngActionType actionType;
	
	@Getter private final IHasPhaseAct parent;
	@Override public IAgotFlowStep next(AgotContext context) { return this.parent.after(this, context); }
	
	public ActionAct(AngPhase phase, AngAction action, TextCard<?> actingCard, AgotPlayer actingPlayer, AgotGame game,
			IHasPhaseAct parent) {
		super(action, new AbilityContext(actingCard, actingPlayer), game);
		this.phase = phase;
		this.actionType = action.getType();
		this.parent = parent;
	}

	@Override
	public String toString() { return MotifConsole.format ("Action {0}", ac.thisCard.getTitle ()); }

	@Override
	public boolean canBeInitiated () {
		boolean canBeInitiated = super.canBeInitiated ();
		if (!canBeInitiated) { return false; }
		if (!actionType.equals (AngActionType.ACTION)) {
			switch (phase) {
				case CHALLENGES: if (!actionType.equals (AngActionType.CHALLENGES_ACTION)) { return false; }
				case DOMINANCE: if (!actionType.equals (AngActionType.DOMINANCE_ACTION)) { return false; }
				case DRAW: if (!actionType.equals (AngActionType.DRAW_ACTION)) { return false; }
				case MARSHALLING: if (!actionType.equals (AngActionType.MARSHALLING_ACTION)) { return false; }
				case PLOT: if (!actionType.equals (AngActionType.PLOT_ACTION)) { return false; }
				case STANDING: if (!actionType.equals (AngActionType.STANDING_ACTION)) { return false; }
				case TAXATION: if (!actionType.equals (AngActionType.TAXATION_ACTION)) { return false; }
			}
		}
		return true;
	}

	@Override
	public long getCardId() {
		return this.getTrigCard().id();
	}

	@Override
	public AgotChoice getChoice() {
		return AgotChoice.selectCardActionChoice(this.getTrigCard(), AgotChoiceCardAction.ACTION);
	}

}
