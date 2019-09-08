package com.motif.agot.logic.act;

import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.ang.text.AngAction;
import com.motif.agot.ang.text.AngAction.AngActionType;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.logic.other.AbilityContext;
import com.motif.agot.logic.requests.AgotChoice;
import com.motif.agot.logic.requests.AAgotRequest.AgotRequestType;
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
				case CHALLENGES: return actionType.equals (AngActionType.CHALLENGES_ACTION);
				case DOMINANCE: return actionType.equals (AngActionType.DOMINANCE_ACTION);
				case DRAW: return actionType.equals (AngActionType.DRAW_ACTION);
				case MARSHALLING: return actionType.equals (AngActionType.MARSHALLING_ACTION);
				case PLOT: return actionType.equals (AngActionType.PLOT_ACTION);
				case STANDING: return actionType.equals (AngActionType.STANDING_ACTION);
				case TAXATION: return actionType.equals (AngActionType.TAXATION_ACTION);
			} // switch
		} // if
		return true;
	} // canBeInitiated

	@Override
	public long getCardId() {
		return this.getTrigCard().id();
	}

	@Override
	public AgotChoice getChoice (AgotRequestType requestType) {
		return AgotChoice.selectCardActionChoice (requestType, this.getTrigCard(), AgotChoiceCardAction.ACTION);
	}

}
