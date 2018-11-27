package motif.agot.logic.round.phases.plot;

import java.util.ArrayList;
import java.util.Comparator;

import motif.agot.ang.AgotText;
import motif.agot.endpoint.AgotContext;
import motif.agot.flow.request.AgotRequest;
import motif.agot.flow.request.AgotRequest.AgotChoice;
import motif.agot.flow.request.AgotRequest.AgotRequestCod;
import motif.agot.flow.request.AgotResponse;
import motif.agot.flow.task.AgotHumanTask;
import motif.agot.flow.task.IAgotTask;
import motif.agot.logic.round.phases.Step;
import motif.agot.state.AgotGame;
import motif.agot.state.AgotPlayer;
import motif.shared.util.ComparatorUtil;
import motif.shared.util.RandomUtil;

public class RevealPlotStep extends Step<IPlotPhaseStep> {
	
	public RevealPlotStep (AgotGame game) {
		super (game);
	} // RevealPlotStep

	@Override
	public String getStepTitle () { return AgotText.title ().revealPlotStep (); }

	@Override
	public IAgotTask getStartTask (AgotContext context) {
		game.forEachPlayer (player -> {
			player.revealedPlot ().reveal (context);
			if (player.emptyPlotDeck ()) {
				player.resetPlotDeck (context);
			} // if
		}); // forEachPlayer
		
		ArrayList<AgotPlayer> initiativeWinners = ComparatorUtil.getMax (game.players (), new Comparator<AgotPlayer>() {
			@Override
			public int compare (AgotPlayer p1, AgotPlayer p2) {
				int comparison = Integer.compare (p1.getInitiative (), p2.getInitiative ());
				if (comparison < 0) {
					game.log ().hasMoreInitiativeThan (p2, p1, context);
				} else if (comparison > 0) {
					game.log ().hasMoreInitiativeThan (p1, p2, context);					
				} else {
					comparison = -1 * Integer.compare (p1.getPower (), p2.getPower ());
					if (comparison < 0) {
						game.log ().hasTheSameInitiativeButLessPowerThan (p2, p1, context);
					} else if (comparison > 0) {
						game.log ().hasTheSameInitiativeButLessPowerThan (p1, p2, context);
					} else {
						game.log ().hasTheSameInitiativeAndTheSamePowerOf (p1, p2, context);					
					} // if - else
				} // if- else
				return comparison;
			} // comparator
		}); // getMax
		
		AgotPlayer initiativeWinner;
		if (initiativeWinners.size () > 1) {
			initiativeWinner = RandomUtil.getFrom (initiativeWinners);
			game.log ().initiativeTieBrokenByRandomlySelect (initiativeWinner, context);
		} else {
			initiativeWinner = initiativeWinners.get (0);
		} // if - else
		
		game.log ().winsInitiative (initiativeWinner, context);
				
		return new FirstPlayerRequest (initiativeWinner);
	} // getStartTask

	@Override
	public Step<IPlotPhaseStep> getNextTask (AgotContext context) {
		return new PlotActionStep (game);
	} // getNextTask

	private class FirstPlayerRequest extends AgotHumanTask {

		private AgotPlayer initiativeWinner;
		private AgotRequest<AgotPlayer> pendingRequest = null;
		
		public FirstPlayerRequest (AgotPlayer initiativeWinner) {
			this.initiativeWinner = initiativeWinner;
		} // ChoosePlotRequest

		@Override
		public AgotRequest<?> getRequest (AgotContext context) {
			pendingRequest = AgotRequest.createRequest (AgotRequestCod.SELECT_FIRST_PLAYER, initiativeWinner, game.players (), AgotText.request ().selectFirstPlayer (initiativeWinner));
			return pendingRequest;
		} // getRequest

		@Override
		public IAgotTask receiveResponse (AgotResponse response, AgotContext context) {
			AgotChoice<AgotPlayer> choice = pendingRequest.getChoice (response);
			AgotPlayer firstPlayer = choice.getModel ();
			game.setFirstPlayer (firstPlayer, context);
			game.log ().becomesFirstPlayer (firstPlayer, context);
			return null;
		} // receiveResponse

	} // FirstPlayerRequest
	
} // RevealPlotStep
