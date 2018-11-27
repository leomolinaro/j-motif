package motif.agot.logic.round.phases.plot;

import java.util.Iterator;

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
import motif.agot.state.cards.PlotCard;

public class ChoosePlotStep extends Step<IPlotPhaseStep> {

	public ChoosePlotStep (AgotGame game) {
		super (game);
	} // ChoosePlotStep

	@Override
	public String getStepTitle () { return AgotText.title ().choosePlotStep (); }

	@Override
	public Step<IPlotPhaseStep> getNextTask (AgotContext context) {
		return new RevealPlotStep (game);
	} // getNextTask

	@Override
	public IAgotTask getStartTask (AgotContext context) {
		return new ChoosePlotRequest (game.players ().iterator ());
	} // getStartTask

	private class ChoosePlotRequest extends AgotHumanTask {

		private Iterator<AgotPlayer> playerIt;
		private AgotPlayer player;
		private AgotRequest<PlotCard> pendingRequest = null;
		
		public ChoosePlotRequest (Iterator<AgotPlayer> playerIt) {
			this.playerIt = playerIt;
			this.player = playerIt.next ();
		} // ChoosePlotRequest

		@Override
		public AgotRequest<?> getRequest (AgotContext context) {
			pendingRequest = AgotRequest.createRequest (AgotRequestCod.SELECT_PLOT_TO_REVEAL, player, player.plotDeck (), AgotText.request ().selectPlotToReveal (player));
			return pendingRequest;
		} // getRequest

		@Override
		public IAgotTask receiveResponse (AgotResponse response, AgotContext context) {
			AgotChoice<PlotCard> choice = pendingRequest.getChoice (response);
			PlotCard plot = choice.getModel ();
			player.choosePlot (plot, context);
			return playerIt.hasNext () ? new ChoosePlotRequest (playerIt) : null;
		} // receiveResponse

	} // ChoosePlotRequest
	
} // ChoosePlotStep
