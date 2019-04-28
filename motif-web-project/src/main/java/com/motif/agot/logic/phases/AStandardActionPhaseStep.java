package com.motif.agot.logic.phases;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.logic.act.ActionAct;
import com.motif.agot.state.AgotGame;

public abstract class AStandardActionPhaseStep<S extends IStep> extends AActionPhaseStep<S, ActionAct> {

	public AStandardActionPhaseStep(AngPhase phase, AgotGame game) {
		super(phase, game);
	}

	@Override
	protected List<ActionAct> getAvailableActions() {
		Stream<ActionAct> availableActions = this.player.interactingCards()
		.filter(card -> card.hasAction())
		.map(card -> new ActionAct(phase, card.getAction(), card, player, game, this))
        .filter(actionStep -> actionStep.canBeInitiated () && actionStep.canBePaid ());
		return availableActions.collect(Collectors.toList());
	}

}
