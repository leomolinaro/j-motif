package motif.agot.logic.round.phases.taxation.reserve;

import motif.agot.endpoint.AgotContext;
import motif.agot.flow.task.AgotComplexTask;
import motif.agot.flow.task.IAgotTask;
import motif.agot.state.AgotGame;
import motif.agot.state.AgotPlayer;

public class CheckPlayerReserve extends AgotComplexTask {

	private AgotPlayer player;
	private AgotGame game;
	
	public CheckPlayerReserve (AgotPlayer player, AgotGame game) {
		this.player = player;
		this.game = game;
	} // CheckPlayerReserve
	
	@Override
	public IAgotTask getStart (AgotContext context) {
		int handSize = player.handSize ();
		int reserve = player.getReserve ();
		if (handSize > reserve) {
			return new ReserveDiscardRequest (handSize - reserve, player, game);
		} else {
			return null;			
		} // if - else
	} // getStart

	@Override
	public IAgotTask getNextTask (AgotContext context) {
		AgotPlayer nextPlayer = player.getNextPlayer ();
		if (nextPlayer == game.getFirstPlayer ()) {
			return null;
		} else {
			return new CheckPlayerReserve (nextPlayer, game);
		} // if - else
	} // getNextTask

} // CheckPlayerReserve
