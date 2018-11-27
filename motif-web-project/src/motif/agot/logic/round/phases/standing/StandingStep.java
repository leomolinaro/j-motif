package motif.agot.logic.round.phases.standing;

import java.util.ArrayList;

import motif.agot.ang.AgotText;
import motif.agot.endpoint.AgotContext;
import motif.agot.flow.task.IAgotTask;
import motif.agot.logic.round.phases.Step;
import motif.agot.state.AgotGame;
import motif.agot.state.cards.Card;

public class StandingStep extends Step<IStandingPhaseStep> {

	public StandingStep (AgotGame game) {
		super (game);
	} // StandingStep

	@Override
	public String getStepTitle () { return AgotText.title ().standingCardsStep (); }

	@Override
	public IAgotTask getStartTask (AgotContext context) {
		ArrayList<Card<?>> standingCards = new ArrayList<Card<?>> ();
		game.forEachPlayer (player -> {
			player.inPlayCards ().forEach (card -> {
				if (card.isKneeling ()) {
					card.stand (context);
					standingCards.add (card);
				} // if
			});
		});
		for (Card<?> standingCard : standingCards) {
			game.log ().standingStandsCard (standingCard.getController (), standingCard, context);
		} // for
		return null;
	} // getStartTask

	@Override
	public EndStandingPhaseStep getNextTask (AgotContext context) {
		return new EndStandingPhaseStep (game) ;
	} // getNextTask

} // StandingStep
