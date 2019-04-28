package com.motif.agot.logic.phases.standing;

import java.util.ArrayList;

import com.motif.agot.ang.AgotText;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.logic.phases.APhaseStep;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.cards.Card;

import lombok.Getter;

public class StandingStep extends APhaseStep<IStandingPhaseStep> {

	public interface IHasStandingStep extends IAgotFlowProcess { public APhaseStep<IStandingPhaseStep> after(StandingStep step, AgotContext context); }
	@Getter private final IHasStandingStep parent; 
	@Override public APhaseStep<IStandingPhaseStep> next(AgotContext context) { return this.parent.after(this, context); }
	
	public StandingStep (AgotGame game, IHasStandingStep parent) {
		super (game);
		this.parent = parent;
	}

	@Override
	public String getStepTitle () { return AgotText.title ().standingCardsStep (); }

	@Override
	protected IAgotFlowStep stepStart(AgotContext context) {
		ArrayList<Card<?>> standingCards = new ArrayList<Card<?>> ();
		this.game.forEachPlayer (player -> {
			player.inPlayCards ().forEach (card -> {
				if (card.isKneeling ()) {
					card.stand (context);
					standingCards.add (card);
				}
			});
		});
		for (Card<?> standingCard : standingCards) {
			this.game.log ().standingStandsCard (standingCard.getController (), standingCard, context);
		}
		return null;
	}

}
